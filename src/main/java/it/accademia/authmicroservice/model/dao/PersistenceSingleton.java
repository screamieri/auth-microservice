/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.accademia.authmicroservice.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Andrea
 */
public class PersistenceSingleton {
    private static PersistenceSingleton persistenceSingletonInstance;
    private EntityManager entityMgr;
    
    private static final String PERSISTENCE_UNIT_NAME = "springAuthentication";  
    private static EntityManagerFactory emFactoryObj;
 
    private PersistenceSingleton() {} 
    
    public 
    static 
    synchronized
    PersistenceSingleton getPersistenceSingletonInstance() {
        
        
        if (persistenceSingletonInstance == null) {

 

            persistenceSingletonInstance = new PersistenceSingleton();
            
            try {
                PersistenceSingleton.emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                persistenceSingletonInstance.entityMgr = PersistenceSingleton.emFactoryObj.createEntityManager();
            }
            catch (Exception oEx) {
                persistenceSingletonInstance = null;  
            }
        }
        
        return persistenceSingletonInstance;
    }    
    
    public EntityManager getPersistenceConnection() {
        return persistenceSingletonInstance.entityMgr;
    }

 

    public static void evictPersistenceCache() {
        if (persistenceSingletonInstance != null) {
            persistenceSingletonInstance.getPersistenceConnection().getEntityManagerFactory().getCache().evictAll();
        }
    }
}
