/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.DAO.EclipseLink;




import es.tiernogalvan.proyecto.datos.persistencia.DAO.UnidadDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.EclipseLinkUtil;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Hospital;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Unidad;
import es.tiernogalvan.proyecto.utilidades.Constantes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author vekto
 */
public class UnidadDAOImplEclipse implements UnidadDAO{

    //select * from unidad where idhosp=?
    @Override
    public List<Unidad> selectAllHospi(int num) {
        EntityManager em=EclipseLinkUtil.createEManager();
        CriteriaBuilder cBuild=em.getCriteriaBuilder();
        CriteriaQuery cQuery=cBuild.createQuery(Unidad.class);
        Root<Unidad> unidades=cQuery.from(Unidad.class);
        Predicate filtro=cBuild.equal(unidades.get(Constantes.ATT_HOSPITAL),em.find(Hospital.class,num));
        cQuery.select(unidades).where(filtro);
        List<Unidad> listaU=em.createQuery(cQuery).getResultList();
        em.close();
        return listaU;
    }
    
    //select * from unidad where coduni=?
    @Override
    public Unidad select(Integer num) {
        EntityManager em=EclipseLinkUtil.createEManager();
        Unidad unidad;
        CriteriaBuilder cBuild=em.getCriteriaBuilder();
        CriteriaQuery<Unidad> cQuery=cBuild.createQuery(Unidad.class);
        Root<Unidad> unidades=cQuery.from(Unidad.class);
        Predicate filtro=cBuild.equal(unidades.get(Constantes.ATT_CODUNI), num);
        cQuery.select(unidades).where(filtro);
        unidad=em.createQuery(cQuery).getSingleResult();
        return unidad;
        
    }
    //delete from unidad where coduni=?
    @Override
    public void delete(Integer num) {

        EntityManager em=EclipseLinkUtil.createEManager();
        em.getTransaction().begin();
        CriteriaBuilder criteriaQuery = em.getCriteriaBuilder();
        CriteriaDelete<Unidad> del=criteriaQuery.createCriteriaDelete(Unidad.class);
        Root<Unidad> pacientes=del.from(Unidad.class);
        Predicate filtro=criteriaQuery.equal(pacientes.get(Constantes.ATT_CODUNI),num);
        del.where(filtro);
        em.createQuery(del).executeUpdate();
        em.getTransaction().commit();
        em.close();
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

}
