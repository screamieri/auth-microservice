/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.accademia.authmicroservice.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrea
 */
@Entity
@Table(name = "utente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u"),
    @NamedQuery(name = "Utente.findById", query = "SELECT u FROM Utente u WHERE u.id = :id"),
    @NamedQuery(name = "Utente.findByUsername", query = "SELECT u FROM Utente u WHERE u.username = :username"),
    @NamedQuery(name = "Utente.findByEmail", query = "SELECT u FROM Utente u WHERE u.email = :email"),
    @NamedQuery(name = "Utente.findByPassword", query = "SELECT u FROM Utente u WHERE u.password = :password"),
    @NamedQuery(name = "Utente.findByEmailAndApplicazione", query = "SELECT u FROM Utente u WHERE u.email = :email AND u.idApplicazione.id = :idApplicazione"),
    @NamedQuery(name = "Utente.findByEmailAndApplicazioneAndRuolo", query = "SELECT u FROM Utente u WHERE u.email = :email AND u.idApplicazione.id = :idApplicazione AND u.ruolo.ruolo = :ruolo"),
    @NamedQuery(name = "Utente.findByToken", query = "SELECT u FROM Utente u WHERE u.idAttivazione = :idAttivazione and u.stato = FALSE"),
    @NamedQuery(name = "Utente.findByEmailAndPassword", query = "SELECT u FROM Utente u WHERE u.email = :email AND u.password = :password"), 
    @NamedQuery(name = "Utente.findByEmailAndStatoAttivo", query = "SELECT u FROM Utente u WHERE u.email = :email AND u.stato = TRUE"),
    @NamedQuery(name = "Utente.findByStato", query = "SELECT u FROM Utente u WHERE u.stato = :stato")})
public class Utente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nominativo")
    private String nominativo;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "id_attivazione")
    private String idAttivazione;
    @Basic(optional = false)
    @Column(name = "stato")
    private boolean stato;
    @JoinColumn(name = "id_applicazione", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Applicazione idApplicazione;
    @JoinColumn(name = "ruolo", referencedColumnName = "ruolo")
    @ManyToOne(optional = false)
    private Ruolo ruolo;
    @Basic(optional = false)
    @Column(name = "data_iscrizione")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataIscrizione;

    public Utente() {
    }

    public Utente(Integer id) {
        this.id = id;
    }

    public Utente(Integer id, String nominativo, String username, String email, String password, String linkAttivazione, boolean stato, Applicazione applicazione, Ruolo ruolo, Date dataIscrizione) {
        this.id = id;
        this.nominativo = nominativo;
        this.username = username;
        this.email = email;
        this.password = password;
        this.idAttivazione = linkAttivazione;
        this.stato = stato;
        this.idApplicazione = applicazione;
        this.ruolo = ruolo;
        this.dataIscrizione = dataIscrizione;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
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

    public String getIdAttivazione() {
        return idAttivazione;
    }

    public void setIdAttivazione(String idAttivazione) {
        this.idAttivazione = idAttivazione;
    }

    public boolean getStato() {
        return stato;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }

    public Applicazione getIdApplicazione() {
        return idApplicazione;
    }

    public void setIdApplicazione(Applicazione idApplicazione) {
        this.idApplicazione = idApplicazione;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public Date getDataIscrizione() {
        return dataIscrizione;
    }

    public void setDataIscrizione(Date dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
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
        if (!(object instanceof Utente)) {
            return false;
        }
        Utente other = (Utente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.accademia.jwtsession.model.Utente[ id=" + id + " ]";
    }
    
}
