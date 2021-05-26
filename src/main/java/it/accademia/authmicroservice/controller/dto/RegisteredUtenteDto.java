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
public class RegisteredUtenteDto {
    private String nominativo;
    private Integer id;
    private String email;
    private String username;

    public RegisteredUtenteDto(String nominativo, Integer idUtehteAuth, String email, String username) {
        this.nominativo = nominativo;
        this.id = idUtehteAuth;
        this.email = email;
        this.username = username;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
