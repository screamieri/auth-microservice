/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.accademia.authmicroservice.model.dao;

import it.accademia.authmicroservice.model.Utente;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author Andrea
 */
@Component
public class UtenteDao {
     
   
    
    private static final Logger logger = LogManager.getLogger(UtenteDao.class);
  
    public UtenteDao(){
       
    }
    
    
    public Utente findByUsernameAndPassword(String username, String password){
        
        Utente utente = null;        
        EntityManager em = Connection.getPersistenceSingletonInstance().getEntityManager();
        
        try{       
            Query query = em.createNamedQuery("Utente.findByEmailAndPassword");
            query.setParameter("email", username);
            query.setParameter("password", password);            
            utente = (Utente) query.getSingleResult();
        } catch (Exception ex){
            logger.error(ex.getMessage());
        } finally{
            em.clear();
        }
        
        return utente;    
        
        
    }
    
    public Utente findByUsernameAndPasswordAttivato(String username){
        
        Utente utente = null;        
        EntityManager em = Connection.getPersistenceSingletonInstance().getEntityManager();
        
        try{       
            Query query = em.createNamedQuery("Utente.findByEmailAndStatoAttivo");
            query.setParameter("email", username);  
            utente = (Utente) query.getSingleResult();
        } catch (Exception ex){
            logger.error(ex.getMessage());
        } finally{
            em.clear();
        }
        
        return utente;    
        
        
    }
    
    
    public Utente findByEmailAndIdApplicazioneAndRuolo(String username, Integer idApplicazione, String ruolo){
        
        Utente utente = null;        
        EntityManager em = Connection.getPersistenceSingletonInstance().getEntityManager();
        
        try{       
            Query query = em.createNamedQuery("Utente.findByEmailAndApplicazioneAndRuolo");
            query.setParameter("email", username);   
            query.setParameter("idApplicazione", idApplicazione);
            query.setParameter("ruolo", ruolo);
            utente = (Utente) query.getSingleResult();
        } catch (Exception ex){
            logger.error(ex.getMessage());
        } finally{
            em.clear();
        }
        
        return utente;    
        
        
    }
    
    public Utente findByEmailAndIdApplicazione(String username, Integer idApplicazione){
        
        Utente utente = null;        
        EntityManager em = Connection.getPersistenceSingletonInstance().getEntityManager();
        
        try{       
            Query query = em.createNamedQuery("Utente.findByEmailAndApplicazione");
            query.setParameter("email", username);   
            query.setParameter("idApplicazione", idApplicazione);
            utente = (Utente) query.getSingleResult();
        } catch (Exception ex){
            logger.error(ex.getMessage());
        } finally{
            em.clear();
        }
        
        return utente;            
        
    }
    
  
    public boolean addUser(Utente utente){
        boolean esito = true;
        EntityManager em = Connection.getPersistenceSingletonInstance().getEntityManager();      
        try{       
            em.getTransaction().begin();
            em.persist(utente);            
            em.getTransaction().commit();
        } catch (Exception ex){
            esito = false;
            logger.error(ex.getMessage());
        } finally{
            em.clear();
        }
        return esito;
        
    }
    
    public boolean updateUser(Utente utente){
        boolean esito = true;
        EntityManager em = Connection.getPersistenceSingletonInstance().getEntityManager();       
        try{                   
            em.getTransaction().begin();
            em.merge(utente);            
            em.getTransaction().commit();
        } catch (Exception ex){
            esito = false;
            logger.error(ex.getMessage());
        } finally{
            em.clear();
        }
        return esito;        
    }
    
    public Utente findByEmail(String username){
        Utente utente = null;        
        EntityManager em = Connection.getPersistenceSingletonInstance().getEntityManager();
        
        try{       
            Query query = em.createNamedQuery("Utente.findByEmail");
            query.setParameter("email", username);           
            utente = (Utente) query.getSingleResult();
        } catch (Exception ex){
            logger.error(ex.getMessage());
        } finally{
            em.clear();
        }
        
        return utente; 
    }
    
    public Utente findByTokenAttivazione(String token){
        Utente utente = null;        
        EntityManager em = Connection.getPersistenceSingletonInstance().getEntityManager();
        
        try{       
            Query query = em.createNamedQuery("Utente.findByToken");
            query.setParameter("idAttivazione", token);           
            utente = (Utente) query.getSingleResult();
        } catch (Exception ex){
            logger.error(ex.getMessage());
        } finally{
            em.clear();
        }
        
        return utente; 
    }
    
}
