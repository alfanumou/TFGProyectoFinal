/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.DAO.EclipseLink;

import es.tiernogalvan.proyecto.datos.persistencia.DAO.HospitalDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.EclipseLinkUtil;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Hospital;
import es.tiernogalvan.proyecto.utilidades.Constantes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author vekto
 */
public class HospitalDAOImplEclipse implements HospitalDAO {

    //select * from Hospital
    @Override
    public List<Hospital> selectAllHospi(int a) {
        EntityManager em = EclipseLinkUtil.createEManager();
        List<Hospital> listah;
        CriteriaBuilder cBuild = em.getCriteriaBuilder();
        CriteriaQuery<Hospital> cQuery = cBuild.createQuery(Hospital.class);
        Root<Hospital> hospitales = cQuery.from(Hospital.class);
        cQuery.select(hospitales);
        listah = em.createQuery(cQuery).getResultList();
        em.close();
        return listah;
    }
    

    //select * from Hospital where idhosp=?
    @Override
    public Hospital select(Integer num) {
        EntityManager em = EclipseLinkUtil.createEManager();
        CriteriaBuilder cBuild = em.getCriteriaBuilder();
        CriteriaQuery<Hospital> cQuery = cBuild.createQuery(Hospital.class);
        Root<Hospital> hospitales = cQuery.from(Hospital.class);
        Predicate filtro = cBuild.equal(hospitales.get(Constantes.ATT_IDHOSP), num);
        cQuery.select(hospitales).where(filtro);
        Hospital hospital = em.createQuery(cQuery).getSingleResult();
        em.close();
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
