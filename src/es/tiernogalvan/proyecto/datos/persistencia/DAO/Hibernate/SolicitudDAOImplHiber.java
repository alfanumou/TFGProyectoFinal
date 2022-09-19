/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.DAO.Hibernate;

import es.tiernogalvan.proyecto.datos.persistencia.DAO.SolicitudDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.HibernateUtil;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.SolicitudAnalitica;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.SolicitudAnaliticaId;
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
public class SolicitudDAOImplHiber implements SolicitudDAO {
    
    
    //select * from solicitud_analitica s, Medico m where m.idhosp=? and s.codmed in (m.codmed)
    @Override
    public List<SolicitudAnalitica> selectAllHospi(int num) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        List<SolicitudAnalitica> listaU;
        try (Session sesion = sesionF.openSession()) {
            Transaction transac = sesion.beginTransaction();
            Query query = sesion.createQuery(Constantes.FROM_SOLICITUD_HOSP + num);
            listaU = query.list();
            transac.commit();
            sesion.close();
        }

        return listaU;
    }


    //select * from solicitud_analitica s where s.codmed=? and s.numpa=? and s.coduni=?
    @Override
    public SolicitudAnalitica select(SolicitudAnaliticaId num) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Object objeto;
        try (Session sesion = sesionF.openSession()) {
            objeto = sesion.find(SolicitudAnalitica.class, num);
            sesion.close();
        }
        SolicitudAnalitica hospital = (SolicitudAnalitica) objeto;
        return hospital;
    }
    //delete from solicitud_analitica s where s.codmed=? and s.numpa=? and s.coduni=?
    @Override
    public void delete(SolicitudAnaliticaId num) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        try (Session sesion = sesionF.openSession()) {
            Transaction transac = sesion.beginTransaction();
            Query query = sesion.createQuery(Constantes.DEL_SOLICITUD_1 + num.getCodUni()+Constantes.DEL_SOLICITUD_2+num.getNumPa()+Constantes.DEL_SOLICITUD_3+num.getCodMed());
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
