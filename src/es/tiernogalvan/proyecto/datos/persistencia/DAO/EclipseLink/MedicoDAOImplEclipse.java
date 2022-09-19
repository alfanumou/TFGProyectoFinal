/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.DAO.EclipseLink;

import es.tiernogalvan.proyecto.datos.persistencia.DAO.MedicoDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.EclipseLinkUtil;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Hospital;



import es.tiernogalvan.proyecto.datos.persistencia.POJO.Medico;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Paciente;
import es.tiernogalvan.proyecto.utilidades.Constantes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


/**
 *
 * @author vekto
 */
public class MedicoDAOImplEclipse implements MedicoDAO  {
    

    //select * from medico where idhosp=?
    @Override
    public List<Medico> selectAllHospi(int idhosp) {
        List<Medico> listam;
        EntityManager em=EclipseLinkUtil.createEManager();
        CriteriaBuilder criteriaQuery = em.getCriteriaBuilder();
        CriteriaQuery<Medico> cmm=criteriaQuery.createQuery(Medico.class);
        Root<Medico> medicos=cmm.from(Medico.class);
        Predicate filtro=criteriaQuery.equal(medicos.get(Constantes.ATT_HOSPITAL),em.find(Hospital.class,idhosp));
        cmm.select(medicos).where(filtro);
        listam=em.createQuery(cmm).getResultList();
        em.close();

        return listam;
    }
    //select * from Medico where codmed=?
    @Override
    public Medico select(Integer num) {
        Medico medico;
        EntityManager em=EclipseLinkUtil.createEManager();
        CriteriaBuilder criteriaQuery = em.getCriteriaBuilder();
        CriteriaQuery<Medico> cmm=criteriaQuery.createQuery(Medico.class);
        Root<Medico> medicos=cmm.from(Medico.class);
        Predicate filtro=criteriaQuery.equal(medicos.get(Constantes.ATT_CODMED),num);
        cmm.select(medicos).where(filtro);
        medico=em.createQuery(cmm).getSingleResult();
        em.close();
        return medico;

    }
    
    //insert into (tabla) (objeto de la tabla)
    @Override
    public void insert(Object o) {
        EntityManager sesion = EclipseLinkUtil.createEManager();
        sesion.getTransaction().begin();
        sesion.persist(o);
        sesion.getTransaction().commit();
        sesion.close();
    }

    //update (tabla) set(objeto)=(objeto modificado)
    @Override
    public void update(Object o) {
        EntityManager sesion = EclipseLinkUtil.createEManager();
        sesion.getTransaction().begin();
        sesion.merge(o);
        sesion.getTransaction().commit();
        sesion.close();
    }
    //delete from Medico where codmed=?
    @Override
    public void delete(Integer num) {

        EntityManager em=EclipseLinkUtil.createEManager();
        em.getTransaction().begin();
        CriteriaBuilder criteriaQuery = em.getCriteriaBuilder();
        CriteriaDelete<Medico> del=criteriaQuery.createCriteriaDelete(Medico.class);
        Root<Medico> medicos=del.from(Medico.class);
        Predicate filtro=criteriaQuery.equal(medicos.get(Constantes.ATT_CODMED),num);
        del.where(filtro);
        em.createQuery(del).executeUpdate();
        em.getTransaction().commit();
        em.close();
        
    }
    //update Medico set codmedjefe=? where codmed=?
    @Override
    public void updateAllForMedico(int num, int newMed) {
        EntityManager em=EclipseLinkUtil.createEManager();
        em.getTransaction().begin();
        CriteriaBuilder criteriaQuery = em.getCriteriaBuilder();
        CriteriaUpdate cu=criteriaQuery.createCriteriaUpdate(Medico.class);
        Root<Medico> medicos=cu.from(Medico.class);
        Predicate filtro=criteriaQuery.equal(medicos.get(Constantes.ATT_MEDICO),select(num));
        cu.set(medicos.get(Constantes.ATT_MEDICO), select(newMed));
        cu.where(filtro);
        em.createQuery(cu).executeUpdate();
        em.getTransaction().commit();
        em.close();

    }
    
    //updateAllForMedico + update Paciente set codmed=? where codmed=?
    @Override
    public void updateAllForMedicoPaciente(int num, int newMed, int newPac) {
        updateAllForMedico(num, newMed);
        EntityManager em=EclipseLinkUtil.createEManager();
        em.getTransaction().begin();
        CriteriaBuilder criteriaQuery = em.getCriteriaBuilder();
        CriteriaUpdate cu=criteriaQuery.createCriteriaUpdate(Paciente.class);
        Root<Paciente> pacientes=cu.from(Paciente.class);
        Predicate filtro=criteriaQuery.equal(pacientes.get(Constantes.ATT_MEDICO), select(num));
        cu.set(pacientes.get(Constantes.ATT_MEDICO), select(newPac));
        cu.where(filtro);
        em.createQuery(cu).executeUpdate();
        em.getTransaction().commit();
        em.close();
        }





    

}
