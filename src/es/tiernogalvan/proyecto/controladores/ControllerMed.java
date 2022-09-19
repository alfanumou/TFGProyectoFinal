/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.controladores;

import es.tiernogalvan.proyecto.datos.persistencia.DAO.GenerDAO;
import es.tiernogalvan.proyecto.datos.persistencia.Factory.FactoryDAO;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.MedicoDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Hospital;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Medico;
import es.tiernogalvan.proyecto.ui.Medicos;
import es.tiernogalvan.proyecto.utilidades.Constantes;
import es.tiernogalvan.proyecto.utilidades.EntradaTecladoListener;
import es.tiernogalvan.proyecto.utilidades.ModeloTabla;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author vekto
 */
public class ControllerMed extends ControllerModelo {

    private Medicos medicos;
    private MedicoDAO med;

    public MedicoDAO getMed() {
        return med;
    }

    public ControllerMed(Medicos medicos, Hospital hospital) {
        super(hospital);
        this.med =(MedicoDAO) FactoryDAO.getFactoryDAO().getDAO(GenerDAO.MED_DAO);
        this.medicos = medicos;
        
        

    }

    //inicia la venta de medicos
    @Override
    public void iniciarPantalla() {
        getMedicos().getjTable1().getTableHeader().setReorderingAllowed(Constantes.FALSE);
        cargarTabla();
        cargarCombo(getMedicos().getjComboBox1());
        limpiarPantalla();
        getMedicos().addWindowListener(this);
        getMedicos().getjButton1().addActionListener(this);
        getMedicos().getjButton2().addActionListener(this);
        getMedicos().getjButton3().addActionListener(this);
        getMedicos().getBusqueda().addActionListener(this);
        getMedicos().getjTable1().addMouseListener(this);
        getMedicos().getjTextField1().addKeyListener(new EntradaTecladoListener());
        getMedicos().setVisible(Constantes.TRUE);

    }

    public Medicos getMedicos() {
        return this.medicos;

    }

    //carga la tabla de medicos
    @Override
    protected void cargarTabla() {
        setDtf(new ModeloTabla());
        getDtf().setColumnIdentifiers(Constantes.COL_MED);
        List<Medico> lMed = getMed().selectAllHospi(getHospital().getIdhosp());
        for (Medico medico : lMed) {

            try {
                String rowMed[] = {String.valueOf(medico.getCodMed()), medico.getNombre(), medico.getProfesion(), Integer.toString(medico.getMedico().getCodMed())};
                getDtf().addRow(rowMed);
            } catch (NullPointerException e) {
                String rowMed[] = {String.valueOf(medico.getCodMed()), medico.getNombre(), medico.getProfesion(), null};
                getDtf().addRow(rowMed);
            }

        }
        getMedicos().getjTable1().setModel(getDtf());
        getMedicos().getjTable1().setShowGrid(Constantes.FALSE);

    }

    //filtra y carga la tabla de medicos
    @Override
    protected void buscar() {
        String filtro = getMedicos().getjTextField6().getText().toUpperCase();
        setDtf(new ModeloTabla());
        getDtf().setColumnIdentifiers(Constantes.COL_MED);
        List<Medico> lMed = getMed().selectAllHospi(getHospital().getIdhosp());
        for (Medico medico : lMed) {
            if (medico.getNombre().contains(filtro) || String.valueOf(medico.getCodMed()).contains(filtro)||String.valueOf(medico.getProfesion()).contains(filtro)) {
                try {
                    String rowMed[] = {String.valueOf(medico.getCodMed()), medico.getNombre(), medico.getProfesion(), Integer.toString(medico.getMedico().getCodMed())};
                    getDtf().addRow(rowMed);
                } catch (NullPointerException e) {
                    String rowMed[] = {String.valueOf(medico.getCodMed()), medico.getNombre(), medico.getProfesion(), null};
                    getDtf().addRow(rowMed);
                }
            }
        }
        getMedicos().getjTable1().setModel(getDtf());
        getMedicos().getjTable1().setShowGrid(Constantes.FALSE);

    }
    //carga un combobox de medicos
    private void cargarCombo(JComboBox combo) {
        setDcm(new DefaultComboBoxModel());
        getDcm().addElement(Constantes.VACIO);
        List<Medico> lMed = getMed().selectAllHospi(getHospital().getIdhosp());
        for (Medico medico : lMed) {
            getDcm().addElement(medico.getCodMed());
        }
        combo.setModel(getDcm());
    }

    //limpia los datos de la pantalla
    @Override
    protected void limpiarPantalla() {

        getMedicos().getjComboBox2().removeAllItems();
        getMedicos().getjComboBox5().removeAllItems();
        getMedicos().getjComboBox6().removeAllItems();
        getMedicos().getjTextField1().setText(Constantes.VACIO);
        getMedicos().getjTextField2().setText(Constantes.VACIO);
        getMedicos().getjTextField3().setText(Constantes.VACIO);
        getMedicos().getjTextField4().setText(Constantes.VACIO);
        getMedicos().getjTextField5().setText(Constantes.VACIO);
        getMedicos().getjLabel10().setText(Constantes.CODIGO);
        getMedicos().getjLabel13().setText(Constantes.CODIGO);
        getMedicos().getjLabel14().setText(Constantes.NOMBRE);
        getMedicos().getjTextField6().setText(Constantes.VACIO);

    }

    //modifica a un medico
    @Override
    protected void modificar() {
        String cod = getMedicos().getjLabel10().getText();
        String nombre = getMedicos().getjTextField4().getText().toUpperCase();
        String profesion = getMedicos().getjTextField5().getText().toUpperCase();
        if (!cod.equals(Constantes.CODIGO) && !nombre.equals(Constantes.VACIO) && !profesion.equals(Constantes.VACIO)) {
            Medico med;

            String cod_jefe = getMedicos().getjComboBox2().getSelectedItem().toString();

            if (cod_jefe.equals(Constantes.VACIO)) {
                med = new Medico(Integer.parseInt(cod),
                        getHospital(),
                        nombre, profesion);
            } else {
                med = new Medico(Integer.parseInt(cod),
                        getHospital(),
                        nombre, profesion,
                        getMed().select(Integer.parseInt(cod_jefe)));
            }

            getMed().update(med);

        } else {

            JOptionPane.showMessageDialog(getMedicos(), Constantes.FALTA_MEDICO);

        }
        cargarTabla();

    }

    //inserta a un medico
    @Override
    protected void insertar() {
        String cod = getMedicos().getjTextField1().getText();
        String nombre = getMedicos().getjTextField2().getText().toUpperCase();
        String profesion = getMedicos().getjTextField3().getText().toUpperCase();
        String cod_jefe = getMedicos().getjComboBox1().getSelectedItem().toString();
        try {
            if (!cod.equals(Constantes.VACIO) && !nombre.equals(Constantes.VACIO) && !profesion.equals(Constantes.VACIO)) {
                Medico med;
                if (cod_jefe.equals(Constantes.VACIO)) {
                    med = new Medico(castNum(cod),getHospital(),nombre, profesion);
                } else {
                    med = new Medico(castNum(cod),getHospital(),nombre, profesion,getMed().select(Integer.parseInt(cod_jefe)));
                }

                getMed().insert(med);

            } else {

                JOptionPane.showMessageDialog(getMedicos(), Constantes.FALTAN_DATOS);

            }
        } catch (javax.persistence.PersistenceException e) {

            JOptionPane.showMessageDialog(getMedicos(), Constantes.CLAVE_EXISTE);

        }
        cargarTabla();
        cargarCombo(getMedicos().getjComboBox1());

    }

    //elimina a un medico, obligando a reasignar a los pacientes y a los medicos que dependen de el
    @Override
    protected void borrar() {
        Medico medicoJefe;
        if (!getMedicos().getjLabel13().getText().equals(Constantes.CODIGO)) {
            int cod = castNum(getMedicos().getjLabel13().getText());
            if (getMed().select(cod).getMedicos().isEmpty()) {
                getMed().delete(cod);
            } else {
                if (!getMedicos().getjComboBox5().getSelectedItem().equals(Constantes.VACIO) && getMed().select(cod).getPacientes().isEmpty()) {
                    getMed().updateAllForMedico(cod, Integer.parseInt(getMedicos().getjComboBox5().getSelectedItem().toString()));
                    medicoJefe = getMed().select(castNum(getMedicos().getjComboBox5().getSelectedItem().toString()));
                    medicoJefe.setMedico(null);
                    getMed().update(medicoJefe);
                    getMed().delete(cod);
                } else if (!getMedicos().getjComboBox5().getSelectedItem().toString().equals(Constantes.VACIO)) {
                    getMed().updateAllForMedicoPaciente(cod, castNum(getMedicos().getjComboBox5().getSelectedItem().toString()), castNum(medicos.getjComboBox6().getSelectedItem().toString()));
                    medicoJefe = getMed().select(castNum(getMedicos().getjComboBox5().getSelectedItem().toString()));
                    medicoJefe.setMedico(null);
                    getMed().update(medicoJefe);

                    getMed().delete(cod);
                } else {
                    JOptionPane.showMessageDialog(getMedicos(), Constantes.FALTA_MEDICO);
                }
            }
            cargarTabla();
            cargarCombo(getMedicos().getjComboBox1());
            limpiarPantalla();
        } else {
            JOptionPane.showMessageDialog(getMedicos(), Constantes.FALTA_MEDICO);
        }

    }
    
    @Override
    protected void tocarFila(){
        Medico medico;
        cargarCombo(getMedicos().getjComboBox2());
        cargarCombo(getMedicos().getjComboBox5());
        cargarCombo(getMedicos().getjComboBox6());
        getMedicos().getjComboBox6().removeItem(Constantes.VACIO);
        String cod = getMedicos().getjTable1().getValueAt(getMedicos().getjTable1().getSelectedRow(), Constantes.CERO).toString();
        medico = getMed().select(Integer.parseInt(cod));
        getMedicos().getjLabel10().setText(String.valueOf(medico.getCodMed()));
        getMedicos().getjTextField4().setText(medico.getNombre());
        getMedicos().getjTextField5().setText(medico.getProfesion());
        getMedicos().getjLabel13().setText(String.valueOf(medico.getCodMed()));
        getMedicos().getjComboBox2().removeItem(medico.getCodMed());
        getMedicos().getjComboBox5().removeItem(medico.getCodMed());
        getMedicos().getjComboBox6().removeItem(Constantes.VACIO);
        getMedicos().getjComboBox6().removeItem(medico.getCodMed());
        getMedicos().getjLabel14().setText(medico.getNombre());
        if (medico.getMedico() != null) {
            getMedicos().getjComboBox2().setSelectedItem(medico.getMedico().getCodMed());
        }
    
    
    }


}
