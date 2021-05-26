/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.accademia.authmicroservice.controller;

import it.accademia.authmicroservice.controller.dto.NewUtenteDto;
import it.accademia.authmicroservice.controller.dto.RegisteredUtenteDto;
import it.accademia.authmicroservice.controller.dto.ResponseDto;
import it.accademia.authmicroservice.controller.dto.UtenteDto;
import it.accademia.authmicroservice.model.Applicazione;
import it.accademia.authmicroservice.service.UtenteService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Andrea
 */
@RestController
@CrossOrigin("http://localhost:4200")
public class RegistrationController {

    @Autowired
    UtenteService utenteService;   
    
    RestTemplate restTemplate = new RestTemplate();
  

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> signup(@RequestBody NewUtenteDto utenteDto) {

        UtenteDto newUtenteDto = null;

        try {
            newUtenteDto = utenteService.signUp(utenteDto);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
        RegisteredUtenteDto registeredUtente = new RegisteredUtenteDto(utenteDto.getNominativo(), newUtenteDto.getId(), newUtenteDto.getEmail(), utenteDto.getEmail());
        ResponseDto response = null;
        
        Applicazione app = utenteService.findApplicazioneByIdApp(utenteDto.getIdApplicazione());
        String urlAddUser = app.getUrlApplicazione() + app.getPathAddUser();
        
        try {
            response = restTemplate.postForObject(urlAddUser, registeredUtente, ResponseDto.class);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("BAD CREDENTIALS");
        }

        return new ResponseEntity<>(newUtenteDto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/attivazione", method = RequestMethod.GET)
    public ResponseEntity<?> activation(@RequestParam(required = true) String token){

        try {
            boolean esito = utenteService.updateAttivazioneUtente(token);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
