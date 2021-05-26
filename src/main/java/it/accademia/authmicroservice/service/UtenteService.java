/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.accademia.authmicroservice.service;

import it.accademia.authmicroservice.controller.dto.NewUtenteDto;
import it.accademia.authmicroservice.controller.dto.UtenteDto;
import it.accademia.authmicroservice.model.Applicazione;
import it.accademia.authmicroservice.model.Utente;
import it.accademia.authmicroservice.model.dao.ApplicazioneDao;
import it.accademia.authmicroservice.model.dao.UtenteDao;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Andrea
 */
@Service
public class UtenteService {
    
    @Autowired
    UtenteDao utenteDao;
    
    @Autowired
    ApplicazioneDao applicazioneDao;
    
    @Autowired
    EmailService emailService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UtenteService() {
    }
    
    

    public UtenteDto signUp(NewUtenteDto newUtenteDto) throws Exception {

        Utente utente = utenteDao.findByEmailAndIdApplicazione(newUtenteDto.getEmail(), newUtenteDto.getIdApplicazione());
        UtenteDto utenteDto = null;

        if (utente == null) {

            Applicazione app = applicazioneDao.findAppById(newUtenteDto.getIdApplicazione());

            Utente newUtente = NewUtenteDto.convertToEntity(newUtenteDto, app);            
            UUID uniqueActivationId = UUID.randomUUID();            
            newUtente.setPassword(passwordEncoder.encode(newUtente.getPassword()));
            newUtente.setIdAttivazione(uniqueActivationId.toString());  
            
            boolean esito = utenteDao.addUser(newUtente);
            
            if (esito){
                emailService.sendEmail(newUtente);              
            }

            utenteDto = esito ? UtenteDto.convertToDto(newUtente) : utenteDto;

        } else {
            throw new Exception("L'utente con questo indirizzo email è già presente nel database");
        }

        return utenteDto;

    }
    
    public boolean updateAttivazioneUtente(String token) throws Exception{
        
        Utente utente = utenteDao.findByTokenAttivazione(token);
        
        if (utente == null){
            throw new Exception("Non è stato trovato utente da attivare con questo token");
        }
        
        utente.setStato(true);
        boolean esito = utenteDao.updateUser(utente);
        
        return esito;
    }
    
    public Utente findUtenteAttivato(String username) throws Exception{
        Utente utente = utenteDao.findByUsernameAndPasswordAttivato(username);
        
        if(utente == null){
            throw new Exception("L'account dell'utente non è ancora stato attivato");
        }
        
        return utente;
    }
    
    public Utente findByApplicazione(String username, Integer idApplicazione, String ruolo) throws Exception{
        Utente utente = utenteDao.findByEmailAndIdApplicazioneAndRuolo(username, idApplicazione, ruolo);
        
        if(utente == null){
            throw new Exception("Non è stato trovato un utente registrato per l'applicazione");
        }
        
        return utente;
    }
    
    public Applicazione findApplicazioneByIdApp(int idApplicazione){
        return applicazioneDao.findAppById(idApplicazione);
    }

}
