/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.DAO.Hibernate;

import es.tiernogalvan.proyecto.datos.persistencia.DAO.MedicoDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.HibernateUtil;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Medico;
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
public class MedicoDAOImplHiber implements MedicoDAO {

    //select * from Medico
    public List<Medico> selectAll() {

        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        List<Medico> listam;
        try (Session sesion = sesionF.openSession()) {
            Transaction transac = sesion.beginTransaction();
            Query query = sesion.createQuery(Constantes.FROM_MEDICO);
            listam = query.list();
            transac.commit();
            sesion.close();
        }

        return listam;
    }

    //select * from medico where idhosp=?
    @Override
    public List<Medico> selectAllHospi(int idhosp) {

        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        List<Medico> lista;
        try (Session sesion = sesionF.openSession()) {
            Transaction transac = sesion.beginTransaction();
            Query query = sesion.createQuery(Constantes.FROM_MEDICO_HOSPITAL + idhosp);
            lista = query.list();
            transac.commit();
            sesion.close();
        }

        return lista;
    }

    //select * from Medico where codmed=?
    @Override
    public Medico select(Integer num) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Medico objeto;
        try (Session sesion = sesionF.openSession()) {
            objeto = sesion.find(Medico.class, num.intValue());
            sesion.close();
        }

        return objeto;

    }

    //delete from Medico where codmed=?
    @Override
    public void delete(Integer num) {

        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        try (Session sesion = sesionF.openSession()) {
            Transaction transac = sesion.beginTransaction();
            Query query = sesion.createQuery(Constantes.DEL_MEDICO + num.intValue());
            query.executeUpdate();
            transac.commit();
            sesion.close();
        }
    }

    //update Medico set codmedjefe=? where codmed=?
    @Override
    public void updateAllForMedico(int num, int newMed) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        try (Session sesion = sesionF.openSession()) {
            Transaction transac = sesion.beginTransaction();
            Query query = sesion.createQuery(Constantes.UPD_ALL_MED_JEFE + newMed + Constantes.UPD_ALL_MED_WHERE + num);
            query.executeUpdate();
            transac.commit();
            sesion.close();
        }

    }

    //updateAllForMedico + update Paciente set codmed=? where codmed=?
    @Override
    public void updateAllForMedicoPaciente(int num, int newMed, int newPac) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        try (Session sesion = sesionF.openSession()) {
            Transaction transac = sesion.beginTransaction();
            Query query = sesion.createQuery(Constantes.UPD_ALL_MED_JEFE + newMed + Constantes.UPD_ALL_MED_WHERE + num);
            query.executeUpdate();
            Query query2 = sesion.createQuery(Constantes.UPD_ALL_MED_PAC + newPac + Constantes.UPD_ALL_MED_PAC_WHERE + num);
            query2.executeUpdate();
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
