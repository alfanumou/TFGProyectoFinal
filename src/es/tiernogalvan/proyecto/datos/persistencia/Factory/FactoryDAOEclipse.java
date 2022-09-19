/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.Factory;


import es.tiernogalvan.proyecto.datos.persistencia.DAO.GenerDAO;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.EclipseLink.HospitalDAOImplEclipse;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.EclipseLink.MedicoDAOImplEclipse;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.EclipseLink.PacienteDAOImplEclipse;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.EclipseLink.SolicitudDAOImplEclipse;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.EclipseLink.UnidadDAOImplEclipse;

/**
 *
 * @author vsanc
 */
public class FactoryDAOEclipse extends FactoryDAO {

    @Override
    public GenerDAO getDAO(String tipo) {
        GenerDAO dao;
        switch (tipo) {
            case GenerDAO.HOS_DAO: {
                dao = new HospitalDAOImplEclipse();
                break;
            }
            case GenerDAO.MED_DAO: {
                dao = new MedicoDAOImplEclipse();
                break;
            }
            case GenerDAO.PAC_DAO: {
                dao = new PacienteDAOImplEclipse();
                break;
            }
            case GenerDAO.UNI_DAO: {
                dao = new UnidadDAOImplEclipse();
                break;
            }
            case GenerDAO.SOL_DAO: {
                dao = new SolicitudDAOImplEclipse();
                break;

            }
            default: {
                dao = null;
                break;
            }

        }

        return dao;
    }

}
