/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.controladores;

import es.tiernogalvan.proyecto.datos.persistencia.DAO.Hibernate.HospitalDAOImplHiber;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.HospitalDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Hospital;
import es.tiernogalvan.proyecto.utilidades.Constantes;
import es.tiernogalvan.proyecto.utilidades.ModeloTabla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author vekto
 */
public abstract class ControllerModelo implements ActionListener, MouseListener, WindowListener {

    private DefaultComboBoxModel dcm;
    private Hospital hospital;
    private ModeloTabla dtf;


    public ControllerModelo(Hospital hospital) {
        this.hospital = hospital;

    }

    public DefaultComboBoxModel getDcm() {
        return dcm;
    }

    public void setDcm(DefaultComboBoxModel dcm) {
        this.dcm = dcm;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public ModeloTabla getDtf() {
        return dtf;
    }

    public void setDtf(ModeloTabla dtf) {
        this.dtf = dtf;
    }
    
    protected abstract void iniciarPantalla();

    protected void insertar() {
    }

    protected void modificar() {
    }

    protected void borrar() {
    }

    protected void buscar() {
    }

    protected void limpiarPantalla() {
    }
    protected void cargarTabla(){}

    protected void tocarFila() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case Constantes.AC_INSERT: {
                //asigna la accion del boton insertar
                insertar();
                break;
            }
            case Constantes.AC_MODIFICAR: {
                //asigna la accion del boton modificar
                modificar();
                break;
            }
            case Constantes.AC_BORRAR: {
                //asigna la accion del boton borrar
                borrar();
                break;

            }
            case Constantes.AC_BUSCAR: {
                //asigna la accion del boton de buscar
                buscar();
                break;
            }

        }
        limpiarPantalla();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        tocarFila();
    }

    @Override
    public void windowClosing(WindowEvent we) {
        ControllerHUD.getHud().setEnabled(Constantes.TRUE);

    }

    public int castNum(String numero) {
        return Integer.parseInt(numero);
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

}
