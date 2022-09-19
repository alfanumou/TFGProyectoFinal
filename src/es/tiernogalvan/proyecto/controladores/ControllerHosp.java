/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.controladores;

import es.tiernogalvan.proyecto.datos.persistencia.DAO.GenerDAO;
import es.tiernogalvan.proyecto.datos.persistencia.Factory.FactoryDAO;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.HospitalDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Hospital;
import es.tiernogalvan.proyecto.ui.HUD;
import es.tiernogalvan.proyecto.ui.Hospitales;
import es.tiernogalvan.proyecto.utilidades.Constantes;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author vekto
 */
public class ControllerHosp {

    private Hospitales hospitales;
    private List<Hospital> lHospitales;
    private HospitalDAO ch;

    public ControllerHosp(Hospitales hospitales) {
        this.hospitales = hospitales;
        this.ch = (HospitalDAO) FactoryDAO.getFactoryDAO().getDAO(GenerDAO.HOS_DAO);
        cargarComboBox();
        controlBotonHosp();
        hospitales.setVisible(Constantes.TRUE);

    }
    //asigna la acción del boton seleccionar
    private void controlBotonHosp() {
        this.hospitales.getjButton1().addActionListener((ActionEvent ae) -> {
            Hospital h=(Hospital)lHospitales.get(this.hospitales.getjComboBox1().getSelectedIndex());
            acceso(h);
        });

    }
    //abre la ventana de HUD
    private void acceso(Hospital hospital) {
        ControllerHUD chud=new ControllerHUD(new HUD(),hospital );
        ControllerHUD.getHud().setEnabled(Constantes.TRUE);
        this.hospitales.dispose();

    }
    //carga el combobox de hositales
    private void cargarComboBox() {

        DefaultComboBoxModel combobox = new DefaultComboBoxModel();
        this.lHospitales = 
                ch.selectAllHospi(0);

        for (Hospital lHospitale : lHospitales) {
            Hospital hosp =  lHospitale;
            combobox.addElement(hosp.getNomhosp());

        }

        this.hospitales.getjComboBox1().setModel(combobox);

    }
}
