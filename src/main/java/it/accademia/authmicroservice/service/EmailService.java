/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.accademia.authmicroservice.service;

import it.accademia.authmicroservice.model.Applicazione;
import it.accademia.authmicroservice.model.Utente;
import it.accademia.authmicroservice.model.dao.ApplicazioneDao;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

/**
 *
 * @author Andrea
 */
@Service
public class EmailService {
    
    @Autowired
    ApplicazioneDao applicazioneDao;    

    @Autowired
    private JavaMailSender mailSender;
    
    public void sendEmail(Utente utente) {
        
        Applicazione app = applicazioneDao.findAppById(utente.getIdApplicazione().getId());
        String uriAttivazione = app.getUrlApplicazione() + app.getPathAttivazione() + utente.getIdAttivazione();        
        
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("authentication.accademia@gmail.com");
        message.setTo(utente.getEmail()); 
        message.setSubject("Attiva il tuo account"); 
        
        message.setText("Clicca sul seguente link per attivare il tuo account = " + uriAttivazione);
        mailSender.send(message);

    }
    
}
