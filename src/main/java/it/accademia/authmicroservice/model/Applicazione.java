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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "applicazione")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Applicazione.findAll", query = "SELECT a FROM Applicazione a"),
    @NamedQuery(name = "Applicazione.findById", query = "SELECT a FROM Applicazione a WHERE a.id = :id"),
    @NamedQuery(name = "Applicazione.findByNome", query = "SELECT a FROM Applicazione a WHERE a.nome = :nome")})
public class Applicazione implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "url_applicazione")
    private String urlApplicazione;
    @Basic(optional = false)
    @Column(name = "path_attivazione")
    private String pathAttivazione;
    @Basic(optional = false)
    @Column(name = "path_add_user")
    private String pathAddUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idApplicazione")
    private Collection<Utente> utenteCollection;

    public Applicazione() {
    }

    public Applicazione(Integer id) {
        this.id = id;
    }

    public Applicazione(Integer id, String nome, String urlApplicazione, String pathAttivazione, String pathAddUser) {
        this.id = id;
        this.nome = nome;
        this.urlApplicazione = urlApplicazione;
        this.pathAttivazione = pathAttivazione;
        this.pathAddUser = pathAddUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlApplicazione() {
        return urlApplicazione;
    }

    public void setUrlApplicazione(String urlApplicazione) {
        this.urlApplicazione = urlApplicazione;
    }

    public String getPathAttivazione() {
        return pathAttivazione;
    }

    public void setPathAttivazione(String pathAttivazione) {
        this.pathAttivazione = pathAttivazione;
    }

    public String getPathAddUser() {
        return pathAddUser;
    }

    public void setPathAddUser(String pathAddUser) {
        this.pathAddUser = pathAddUser;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Applicazione)) {
            return false;
        }
        Applicazione other = (Applicazione) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.accademia.jwtsession.model.Applicazione[ id=" + id + " ]";
    }
    
}
