/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.controladores;

import es.tiernogalvan.proyecto.datos.persistencia.POJO.Hospital;
import es.tiernogalvan.proyecto.ui.HUD;
import es.tiernogalvan.proyecto.ui.Hospitales;
import es.tiernogalvan.proyecto.ui.Medicos;
import es.tiernogalvan.proyecto.ui.Pacientes;
import es.tiernogalvan.proyecto.ui.Recepcion;
import es.tiernogalvan.proyecto.ui.Solicitudes;
import es.tiernogalvan.proyecto.ui.Unidades;
import es.tiernogalvan.proyecto.utilidades.Constantes;
import java.awt.event.ActionEvent;

/**
 *
 * @author vekto
 */
public class ControllerHUD {

    private static HUD hud;
    private Hospital hospital;

    public ControllerHUD(HUD hud, Hospital hospital) {
        setHud(hud);
        this.hospital = hospital;
        iniciarPantalla();

    }

    public static HUD getHud() {
        return hud;
    }

    public static void setHud(HUD hud) {
        ControllerHUD.hud = hud;
    }
    //inicia la pantalla de HUD
    private void iniciarPantalla() {
        cargarHospital();
        manipMedicos();
        manipUnidades();
        manipPacientes();
        manipCitas();
        manipRecep();
        manipSalida();
        hud.setVisible(Constantes.TRUE);
    }
    //carga los datos del hospital pasado por parametro en el constructor
    private void cargarHospital() {

        hud.getjLabel1().setText(this.hospital.getNomhosp());
        hud.getjLabel2().setText(this.hospital.getDirhosp());
        hud.getjLabel3().setText(this.hospital.getTlfhosp());

    }
    //asigna la acción de abrir la ventana de medicos
    private void manipMedicos() {

        hud.getOpMed().addActionListener((ActionEvent ae) -> {
            hud.setEnabled(Constantes.FALSE);
            ControllerMed cntM = new ControllerMed(new Medicos(), hospital);
            cntM.iniciarPantalla();

        });

    }
    //asigna la acción de abrir la ventana de unidades
    private void manipUnidades() {

        hud.getOpUni().addActionListener((ActionEvent ae) -> {
            hud.setEnabled(Constantes.FALSE);
            ControllerUni cntU = new ControllerUni(new Unidades(), hospital);
            cntU.iniciarPantalla();
        });

    }
    //asigna la acción de abrir la ventana de pacientes
    private void manipPacientes() {

        hud.getOpPac().addActionListener((ActionEvent ae) -> {
            hud.setEnabled(Constantes.FALSE);
            ControllerPac cntP = new ControllerPac(new Pacientes(), hospital);
            cntP.iniciarPantalla();
        });

    }
    //asigna la accion de abrir la ventana de solicitudes
    private void manipCitas() {

        hud.getOpSoli().addActionListener((ActionEvent ae) -> {
            hud.setEnabled(Constantes.FALSE);
            ControllerSolicit ctnC = new ControllerSolicit(new Solicitudes(), hospital);
            ctnC.iniciarPantalla();
        });

    }
    //asigna la accion de abrir la ventana de recepcion
    private void manipRecep() {
        
        hud.getOpRecep().addActionListener((ActionEvent ae) -> {
            hud.setEnabled(Constantes.FALSE);
            ControllerRecep cRecep = new ControllerRecep(new Recepcion(), hospital);
            cRecep.iniciarPantalla();
        });

    }
    //vuelve a la ventana de seleccion de hospital
    private void manipSalida() {
        hud.getSalir().addActionListener((ActionEvent ae) -> {
            ControllerHosp cHosp = new ControllerHosp(new Hospitales());
            hud.dispose();
        });

    }

}
