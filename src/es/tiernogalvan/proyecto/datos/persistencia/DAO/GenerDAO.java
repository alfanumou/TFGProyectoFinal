/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.DAO;

import java.util.List;

/**
 *
 * @author vsanc
 */
public interface GenerDAO<T,S> {
    public final static String MED_DAO="medico";
    public final static String HOS_DAO="hospital";
    public final static String PAC_DAO="paciente";
    public final static String UNI_DAO="unidad";
    public final static String SOL_DAO="solicitud";
    
    
    public List<T> selectAllHospi(int num);

    public T select(S s );

    public void insert(Object o);

    public void update(Object o);

    public void delete(S s);
    
}
