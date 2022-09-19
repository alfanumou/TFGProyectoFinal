/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.POJO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 *
 * @author vekto
 */

public class HibernateUtil {
  
public static final String RUTA_H="META-INF/hibernate.cfg.xml";    

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new Configuration().configure(RUTA_H).buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
