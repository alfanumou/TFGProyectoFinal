/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.DAO.EclipseLink;





import es.tiernogalvan.proyecto.datos.persistencia.DAO.SolicitudDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.EclipseLinkUtil;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Medico;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.SolicitudAnalitica;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.SolicitudAnaliticaId;
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
public class SolicitudDAOImplEclipse implements SolicitudDAO {

    //select * from solicitud_analitica s, Medico m where m.idhosp=? and s.codmed in (m.codmed)
    @Override
    public List<SolicitudAnalitica> selectAllHospi(int num) {
        EntityManager em=EclipseLinkUtil.createEManager();
        List<SolicitudAnalitica> listaU;
        CriteriaBuilder cBuild=em.getCriteriaBuilder();
        CriteriaQuery<SolicitudAnalitica> cQuery=cBuild.createQuery(SolicitudAnalitica.class);
        Root<SolicitudAnalitica> solicitudes=cQuery.from(SolicitudAnalitica.class);
        MedicoDAOImplEclipse ap=new MedicoDAOImplEclipse();
        List<Medico> medicos=ap.selectAllHospi(num);
        if(medicos.isEmpty()){
            medicos.add(null);
        }
        Predicate filtro=solicitudes.get(Constantes.ATT_MEDICO).in(medicos);
        cQuery.select(solicitudes).where(filtro);
        listaU=em.createQuery(cQuery).getResultList();
        em.close();
        return listaU;
    }
    
    //select * from solicitud_analitica s where s.codmed=? and s.numpa=? and s.coduni=?
    @Override
    public SolicitudAnalitica select(SolicitudAnaliticaId num) {
        EntityManager em=EclipseLinkUtil.createEManager();
        SolicitudAnalitica solicitud;
        
        CriteriaBuilder cBuild=em.getCriteriaBuilder();
        CriteriaQuery<SolicitudAnalitica> cQuery=cBuild.createQuery(SolicitudAnalitica.class);
        Root<SolicitudAnalitica> solicitudes=cQuery.from(SolicitudAnalitica.class);
        Predicate filtro=cBuild.equal(solicitudes.get(Constantes.ATT_ID),num );
        cQuery.select(solicitudes).where(filtro);
        try{
        solicitud=em.createQuery(cQuery).getSingleResult();
        }catch(javax.persistence.NoResultException e){
        solicitud=null;
        }
        em.close();
        return solicitud;
    }
    

    //delete from solicitud_analitica s where s.codmed=? and s.numpa=? and s.coduni=?
    @Override
    public void delete(SolicitudAnaliticaId num) {
        EntityManager em=EclipseLinkUtil.createEManager();
        em.getTransaction().begin();
        CriteriaBuilder cBuild=em.getCriteriaBuilder();
        CriteriaDelete cDel=cBuild.createCriteriaDelete(SolicitudAnalitica.class);
        Root<SolicitudAnalitica> solicitudes=cDel.from(SolicitudAnalitica.class);
        Predicate filtro=cBuild.equal(solicitudes.get(Constantes.ATT_ID),num);
        cDel.where(filtro);
        em.createQuery(cDel).executeUpdate();
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
