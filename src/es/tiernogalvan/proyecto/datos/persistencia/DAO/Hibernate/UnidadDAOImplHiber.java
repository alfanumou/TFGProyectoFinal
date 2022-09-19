/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.DAO.Hibernate;

import es.tiernogalvan.proyecto.datos.persistencia.DAO.UnidadDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.HibernateUtil;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Unidad;
import es.tiernogalvan.proyecto.utilidades.Constantes;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author vekto
 */
public class UnidadDAOImplHiber implements UnidadDAO {

    
    
    //select * from unidad where idhosp=?
    @Override
    public List<Unidad> selectAllHospi(int num) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        List<Unidad> listaU;
        try (Session sesion = sesionF.openSession()) {
            Transaction transac = sesion.beginTransaction();
            Query query = sesion.createQuery(Constantes.FROM_UNIDAD_HOSP + num);
            listaU = query.list();
            transac.commit();
            sesion.close();
        }

        return listaU;
    }
    //select * from unidad where coduni=?
    @Override
    public Unidad select(Integer num) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Object objeto;
        try (Session sesion = sesionF.openSession()) {
            objeto = sesion.find(Unidad.class, num);
            sesion.close();
        }
        Unidad hospital = (Unidad) objeto;
        return hospital;
    }
    //delete from unidad where coduni=?
    @Override
    public void delete(Integer num) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        try (Session sesion = sesionF.openSession()) {
            Transaction transac = sesion.beginTransaction();
            Query query = sesion.createQuery(Constantes.DEL_UNIDAD + num);
            query.executeUpdate();
            transac.commit();
            sesion.close();
        }

    }


    //insert into (tabla) (objeto de la tabla)
    @Override
    public void insert(Object o) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        try (Session sesion = sesionF.openSession()) {
            sesion.save(o);
            Transaction tran = sesion.beginTransaction();
            tran.commit();
            sesion.close();
        }
    }

    //update (tabla) set(objeto)=(objeto modificado)
    @Override
    public void update(Object o) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        try (Session sesion = sesionF.openSession()) {
            Transaction transac = sesion.beginTransaction();
            sesion.update(o);
            transac.commit();
            sesion.close();
        }
    }
    

}
