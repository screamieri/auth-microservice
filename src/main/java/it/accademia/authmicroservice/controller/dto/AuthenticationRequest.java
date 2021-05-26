/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.accademia.authmicroservice.controller.dto;

/**
 *
 * @author Andrea
 */
public class AuthenticationRequest {
    
    private String username;
    private String password;
    private Integer idApplicazione;
    private String ruolo;
    
     public AuthenticationRequest(String username, String password, Integer idApplicazione, String ruolo) {
        //super();
        this.username = username;
        this.password = password;
        this.idApplicazione = idApplicazione;
        this.ruolo = ruolo;
    }

    public AuthenticationRequest()
    {

    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdApplicazione() {
        return idApplicazione;
    }

    public void setIdApplicazione(Integer idApplicazione) {
        this.idApplicazione = idApplicazione;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }
    
    
    
    

}
