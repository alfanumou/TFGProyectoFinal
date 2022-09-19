/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.DAO;

import es.tiernogalvan.proyecto.datos.persistencia.POJO.Medico;


/**
 *
 * @author vsanc
 */
public interface MedicoDAO extends GenerDAO<Medico, Integer> {

    //update Medico set codmedjefe=? where codmed=?
    public void updateAllForMedico(int num, int newMed);
    //updateAllForMedico + update Paciente set codmed=? where codmed=?
    public void updateAllForMedicoPaciente(int num, int newMed, int newPac);
    
}
