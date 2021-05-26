/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.accademia.authmicroservice.model.dao;

import it.accademia.authmicroservice.model.Applicazione;
import javax.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author Andrea
 */
@Component
public class ApplicazioneDao {
     
   
    
    private static final Logger logger = LogManager.getLogger(ApplicazioneDao.class);    
    
    
    public ApplicazioneDao(){
        
    }    
   
    
    public Applicazione findAppById(int id){
        Applicazione applicazione = null;        
        EntityManager em = Connection.getEntityManager();
        
        try{             
            applicazione = em.find(Applicazione.class, id);
        } catch (Exception ex){
            logger.error(ex.getMessage());
        } finally{
            em.clear();
            em.close();
        }
        
        return applicazione; 
    }
    
}
