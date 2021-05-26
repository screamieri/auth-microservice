/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.accademia.authmicroservice.controller.dto;

import it.accademia.authmicroservice.model.Utente;

/**
 *
 * @author Andrea
 */
public class UtenteDto {
    private int id;
    private String email;

    public UtenteDto() {
    }

    public UtenteDto(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public static UtenteDto convertToDto(Utente utente){
        return new UtenteDto(utente.getId(), utente.getEmail());
    }
    
    
}
