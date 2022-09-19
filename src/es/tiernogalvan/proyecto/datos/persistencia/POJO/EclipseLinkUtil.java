/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.POJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vekto
 */
public class EclipseLinkUtil {
    
    public static final String PROVEE_JPA="TFGEclipseLinkPU";
    
    //Devuelve un objeto de EntityManager
    public static EntityManager createEManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PROVEE_JPA);
        EntityManager em=emf.createEntityManager();
        return em;
    
    
    }
    
}
