/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.accademia.authmicroservice.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author Andrea
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    
    
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        String message;
        // Check if the request as any exception that we have stored in Request
        final Exception exception = (Exception) request.getAttribute("exception");

        // If yes then use it to create the response message else use the authException
        if (exception != null) {

            byte[] body = new ObjectMapper().writeValueAsBytes(Collections.singletonMap("cause", exception.toString()));
            response.getOutputStream().write(body);
        } else {
            if (authException.getCause() != null) {
                message = authException.getCause().toString() + " " + authException.getMessage();
            } else {
                message = authException.getMessage();
            }

            byte[] body = new ObjectMapper().writeValueAsBytes(Collections.singletonMap("error", message));

            response.getOutputStream().write(body);
        }
    }
    
}
