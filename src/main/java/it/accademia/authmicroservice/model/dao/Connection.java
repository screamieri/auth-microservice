/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.accademia.authmicroservice.model.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author giamp
 */
public class Connection {

   private static final Logger logger = LogManager.getLogger(Connection.class);

    private static final EntityManagerFactory emFactoryObj;
    private static final String PERSISTENCE_UNIT_NAME = "springAuthentication";

    static {
        emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManager getEntityManager() {
        EntityManager em = null;

        try {
            em = emFactoryObj.createEntityManager();
            em.getEntityManagerFactory().getCache().evictAll();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return em;
    }

}