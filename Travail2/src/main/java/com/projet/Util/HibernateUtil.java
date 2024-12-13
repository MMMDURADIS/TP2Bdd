//Ludovic Hébert et Enrik Bernier
package com.projet.Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import jakarta.persistence.EntityManager;

public class HibernateUtil {
 
    private static SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;
    private static EntityManager entityManager;
    
    private static SessionFactory buildSessionFactory() {

    	Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        
        try {
            System.out.println("Hibernate Configuration loaded");
                       			
            serviceRegistry = new StandardServiceRegistryBuilder().
            		applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate serviceRegistry created");
             
            sessionFactory = configuration.buildSessionFactory();
            
            System.out.println("Hibernate sesionFactory created");

            return sessionFactory;
            
        } catch (Throwable ex) {
        	StandardServiceRegistryBuilder.destroy(serviceRegistry);
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
    	if(sessionFactory == null) 
    		sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
    
    public static EntityManager getEntityManager() {
    	if(entityManager == null) 
    		entityManager = getSessionFactory().createEntityManager();
    	return entityManager;
    }
    
    public void close() throws Exception{
        if(serviceRegistry!= null) {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }

	public static void shutdown() {
		if (entityManager != null)
			entityManager.close();
		getSessionFactory().close();
		
	}
}

