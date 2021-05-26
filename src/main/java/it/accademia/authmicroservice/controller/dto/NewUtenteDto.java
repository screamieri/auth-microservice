/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.accademia.authmicroservice.controller.dto;

import it.accademia.authmicroservice.model.Applicazione;
import it.accademia.authmicroservice.model.Ruolo;
import it.accademia.authmicroservice.model.Utente;
import java.util.Date;

/**
 *
 * @author Andrea
 */
public class NewUtenteDto {
    String nominativo;
    String username;
    String email;
    String password;
    int idApplicazione;

    public NewUtenteDto() {
    }

    public NewUtenteDto(String nominativo, String username, String email, String password, int idApplicazione) {
        this.nominativo = nominativo;
        this.username = username;
        this.email = email;
        this.password = password;
        this.idApplicazione = idApplicazione;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public int getIdApplicazione() {
        return idApplicazione;
    }

    public void setIdApplicazione(int idApplicazione) {
        this.idApplicazione = idApplicazione;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public static Utente convertToEntity(NewUtenteDto utenteDto, Applicazione applicazione){
        return new Utente(
                0, 
                utenteDto.getNominativo(), 
                utenteDto.getUsername(), 
                utenteDto.getEmail(), 
                utenteDto.getPassword(), 
                "http://localhost:8080/attivazione",
                false,
                applicazione,
                new Ruolo("USER"),
                new Date()
        );
    }
    
}
