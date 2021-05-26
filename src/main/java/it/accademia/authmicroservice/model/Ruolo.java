/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.accademia.authmicroservice.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea
 */
@Entity
@Table(name = "ruolo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruolo.findAll", query = "SELECT r FROM Ruolo r"),
    @NamedQuery(name = "Ruolo.findByRuolo", query = "SELECT r FROM Ruolo r WHERE r.ruolo = :ruolo")})
public class Ruolo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ruolo")
    private String ruolo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ruolo")
    private Collection<Utente> utenteCollection;

    public Ruolo() {
    }

    public Ruolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    @XmlTransient
    public Collection<Utente> getUtenteCollection() {
        return utenteCollection;
    }

    public void setUtenteCollection(Collection<Utente> utenteCollection) {
        this.utenteCollection = utenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruolo != null ? ruolo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruolo)) {
            return false;
        }
        Ruolo other = (Ruolo) object;
        if ((this.ruolo == null && other.ruolo != null) || (this.ruolo != null && !this.ruolo.equals(other.ruolo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.accademia.jwtsession.model.Ruolo[ ruolo=" + ruolo + " ]";
    }
    
}
