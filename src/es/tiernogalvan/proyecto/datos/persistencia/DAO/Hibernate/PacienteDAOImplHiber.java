/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.DAO.Hibernate;

import es.tiernogalvan.proyecto.datos.persistencia.DAO.PacienteDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.HibernateUtil;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Paciente;
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
public class PacienteDAOImplHiber implements PacienteDAO {
    


    
    //SELECT * from Paciente p, Medico m where m.idhosp=? and p.cod_med in (m.cod_med)
    @Override
    public List<Paciente> selectAllHospi(int num) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        List<Paciente> listaP;
        try (Session sesion = sesionF.openSession()) {
            Transaction transac = sesion.beginTransaction();
            Query query = sesion.createQuery(Constantes.FROM_PACIENTE_HOSP + num);
            listaP = query.list();
            transac.commit();
            sesion.close();
        }

        return listaP;
    }
    
    //select * from Paciente where numpa=?
    @Override
    public Paciente select(Integer num) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Object objeto;
        try (Session sesion = sesionF.openSession()) {
            objeto = sesion.find(Paciente.class, num);
            sesion.close();
        }
        Paciente paciente = (Paciente) objeto;
        return paciente;
    }
    
    //delete from paciente where numpa=?
    @Override
    public void delete(Integer num) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        try (Session sesion = sesionF.openSession()) {
            Transaction transac = sesion.beginTransaction();
            Query query = sesion.createQuery(Constantes.DEL_PACIENTE + num);
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
