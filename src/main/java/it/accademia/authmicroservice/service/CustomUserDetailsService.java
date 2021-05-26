/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.accademia.authmicroservice.service;

import it.accademia.authmicroservice.model.Utente;
import it.accademia.authmicroservice.model.dao.UtenteDao;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Andrea
 */
@Component
public class CustomUserDetailsService implements UserDetailsService{
    
    @Autowired
    UtenteDao userDao;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utente utente = userDao.findByEmail(email);
        if(utente == null){
            throw new UsernameNotFoundException("Non è stato trovato alcun utente con le credenziali inserite");
        }
        
        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(utente.getEmail(), utente.getPassword(), new ArrayList<>());
        
        return userDetails;
    }
    
}
