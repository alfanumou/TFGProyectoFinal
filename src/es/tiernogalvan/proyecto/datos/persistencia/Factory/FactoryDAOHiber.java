/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.Factory;

import es.tiernogalvan.proyecto.datos.persistencia.DAO.GenerDAO;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.Hibernate.HospitalDAOImplHiber;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.Hibernate.MedicoDAOImplHiber;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.Hibernate.PacienteDAOImplHiber;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.Hibernate.SolicitudDAOImplHiber;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.Hibernate.UnidadDAOImplHiber;

/**
 *
 * @author vsanc
 */
public class FactoryDAOHiber extends FactoryDAO {

    @Override
    public GenerDAO getDAO(String tipo) {
        GenerDAO dao = null;
        switch (tipo) {
            case GenerDAO.HOS_DAO: {
                dao =  new HospitalDAOImplHiber();
                break;
            }
            case GenerDAO.MED_DAO: {
                dao = new MedicoDAOImplHiber();
                break;
            }
            case GenerDAO.PAC_DAO: {
                dao = new PacienteDAOImplHiber();
                break;
            }
            case GenerDAO.UNI_DAO: {
                dao = new UnidadDAOImplHiber();
                break;
            }
            case GenerDAO.SOL_DAO: {
                dao = new SolicitudDAOImplHiber();
                break;

            }

        }

        return dao;
    }
}
