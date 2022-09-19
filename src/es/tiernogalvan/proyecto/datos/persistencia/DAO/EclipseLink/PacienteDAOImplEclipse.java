/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.DAO.EclipseLink;



import es.tiernogalvan.proyecto.datos.persistencia.DAO.PacienteDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.EclipseLinkUtil;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Medico;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Paciente;
import es.tiernogalvan.proyecto.utilidades.Constantes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;



/**
 *
 * @author vekto
 */
public class PacienteDAOImplEclipse implements PacienteDAO {

    //SELECT * from Paciente p, Medico m where m.idhosp=? and p.cod_med in (m.cod_med) 
    @Override
    public List<Paciente> selectAllHospi(int num) {
        EntityManager em=EclipseLinkUtil.createEManager();
        List<Paciente> listaP;
        CriteriaBuilder cBuild=em.getCriteriaBuilder();
        CriteriaQuery<Paciente> cQuery=cBuild.createQuery(Paciente.class);
        Root<Paciente> pacientes=cQuery.from(Paciente.class);
        MedicoDAOImplEclipse am=new MedicoDAOImplEclipse();
        List<Medico> medicos=am.selectAllHospi(num);
        if(medicos.isEmpty()){
            medicos.add(null);
        }
        Expression<Medico> expresionMed=pacientes.get(Constantes.ATT_MEDICO);
        Predicate filtro=expresionMed.in(medicos);
        cQuery.select(pacientes).where(filtro);
        listaP=em.createQuery(cQuery).getResultList();

 
        em.close();
        return listaP;
    }
    
    //select * from Paciente where numpa=?
    @Override
    public Paciente select(Integer num) {
        EntityManager em=EclipseLinkUtil.createEManager();
        CriteriaBuilder cBuild=em.getCriteriaBuilder();
        CriteriaQuery<Paciente> cQuery=cBuild.createQuery(Paciente.class);
        Root<Paciente> pacientes=cQuery.from(Paciente.class);
        Predicate filtro =cBuild.equal(pacientes.get(Constantes.ATT_NUMPA), num);
        cQuery.select(pacientes).where(filtro);
        Paciente paciente=em.createQuery(cQuery).getSingleResult();
        return paciente;
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
    //delete from paciente where numpa=?
    @Override
    public void delete(Integer num) {
        EntityManager em=EclipseLinkUtil.createEManager();
        em.getTransaction().begin();
        CriteriaBuilder criteriaQuery = em.getCriteriaBuilder();
        CriteriaDelete<Paciente> del=criteriaQuery.createCriteriaDelete(Paciente.class);
        Root<Paciente> pacientes=del.from(Paciente.class);
        Predicate filtro=criteriaQuery.equal(pacientes.get(Constantes.ATT_NUMPA),num);
        del.where(filtro);
        em.createQuery(del).executeUpdate();
        em.getTransaction().commit();
        em.close();

    }
}
