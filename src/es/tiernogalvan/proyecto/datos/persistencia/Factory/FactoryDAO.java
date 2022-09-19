/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.Factory;

import es.tiernogalvan.proyecto.datos.persistencia.DAO.GenerDAO;

/**
 *
 * @author vsanc
 */
public abstract class FactoryDAO {

    public static char HIBERNATE = 'H';
    public static char ECLIPSE_LINK = 'E';

    public static char tipo;
    
    //devuelve un DAO introducido como parámetro (implementado en las clases hijas)
    
    public abstract GenerDAO getDAO(String tipo);
    
    //devuelve un objeto FactoryDAO 
    
    public static FactoryDAO getFactoryDAO() {

        FactoryDAO dao = tipo == HIBERNATE ? new FactoryDAOHiber() : tipo == ECLIPSE_LINK ? new FactoryDAOEclipse() : null;
        return dao;
    }
    
    //Asigna el tipo de Factory que se va a usar a través de un caracter
    
    public static void setTipo(char tipo) {
        FactoryDAO.tipo = tipo;
    }

}
