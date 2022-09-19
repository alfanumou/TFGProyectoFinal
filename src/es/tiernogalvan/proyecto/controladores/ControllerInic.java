/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.controladores;

import es.tiernogalvan.proyecto.datos.persistencia.Factory.FactoryDAO;
import es.tiernogalvan.proyecto.ui.Hospitales;
import es.tiernogalvan.proyecto.ui.Inicio;
import es.tiernogalvan.proyecto.utilidades.Constantes;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author vekto
 */
public class ControllerInic {

    private Inicio inicio;

    public ControllerInic() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ControllerInic.class.getName()).log(Level.SEVERE, null, ex);
        }
        inicio = new Inicio();
        botonInicio();
        inicio.setVisible(Constantes.TRUE);

    }

    //asigna la accion del boton inicio
    private void botonInicio() {

        inicio.getHiber().addActionListener((ActionEvent ae) -> {
            FactoryDAO.setTipo(FactoryDAO.HIBERNATE);
            accionIni();
        });
        inicio.getEclipse().addActionListener((ActionEvent ae) -> {
            FactoryDAO.setTipo(FactoryDAO.ECLIPSE_LINK);
            accionIni();
        });

    }

    //abre la ventana de seleccion de hospitales
    private void accionIni() {
        try {
            ControllerHosp chosp = new ControllerHosp(new Hospitales());
            this.inicio.dispose();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(inicio, Constantes.NO_DATA);
        }
        

    }

}
