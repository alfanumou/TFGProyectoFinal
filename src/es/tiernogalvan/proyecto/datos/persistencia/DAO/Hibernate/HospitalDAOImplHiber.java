/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.DAO.Hibernate;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.HospitalDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.HibernateUtil;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Hospital;
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
public class HospitalDAOImplHiber implements HospitalDAO {

    
    
   //select * from Hospital
    @Override
    public List<Hospital> selectAllHospi(int num) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        List<Hospital> listah;
        try (Session sesion = sesionF.openSession()) {
            Transaction transac = sesion.beginTransaction();
            Query query = sesion.createQuery(Constantes.FROM_HOSPITAL);
            listah = query.list();
            transac.commit();
            sesion.close();
        }
        
        return listah;
    }

   //select * from Hospital where idhosp=?
    @Override
    public  Hospital select(Integer num) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Object objeto;
        try (Session sesion = sesionF.openSession()) {
            objeto=sesion.find(Hospital.class, num);
            sesion.close();
        }
        Hospital hospital=(Hospital)objeto;
        return hospital;
    }


    

    @Override
    public void insert(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Integer s) {

    }


}
