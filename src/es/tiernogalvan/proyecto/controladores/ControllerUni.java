/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.controladores;

import es.tiernogalvan.proyecto.datos.persistencia.DAO.GenerDAO;
import es.tiernogalvan.proyecto.datos.persistencia.Factory.FactoryDAO;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.UnidadDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Hospital;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Unidad;
import es.tiernogalvan.proyecto.ui.Unidades;
import es.tiernogalvan.proyecto.utilidades.Constantes;
import es.tiernogalvan.proyecto.utilidades.EntradaTecladoListener;
import es.tiernogalvan.proyecto.utilidades.ModeloTabla;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vekto
 */
public class ControllerUni extends ControllerModelo {

    private Unidades unidades;
    private UnidadDAO uni;

    ControllerUni(Unidades unidades, Hospital hospital) {
        super(hospital);
        uni = (UnidadDAO)FactoryDAO.getFactoryDAO().getDAO(GenerDAO.UNI_DAO);
        this.unidades = unidades;

    }

    public UnidadDAO getUni() {
        return uni;
    }

    public void setUni(UnidadDAO uni) {
        this.uni = uni;
    }

    //inicia la pantalla de unidades
    @Override
    public void iniciarPantalla() {
        getUnidades().getTablaUni().getTableHeader().setReorderingAllowed(Constantes.FALSE);
        limpiarPantalla();
        cargarTabla();
        getUnidades().addWindowListener(this);
        getUnidades().getCodigoInsert().addKeyListener(new EntradaTecladoListener());
        getUnidades().getInsertar().addActionListener(this);
        getUnidades().getModificar().addActionListener(this);
        getUnidades().getBorrar().addActionListener(this);
        getUnidades().getBuscador().addActionListener(this);
        getUnidades().getTablaUni().addMouseListener(this);
        unidades.setVisible(Constantes.TRUE);
    }

    public Unidades getUnidades() {
        return this.unidades;
    }

    //carga la tabla de unidades
    @Override
    protected void cargarTabla() {
        setDtf(new ModeloTabla());
        getDtf().setColumnIdentifiers(Constantes.COL_UNI);
        List<Unidad> lUni = getUni().selectAllHospi(getHospital().getIdhosp());
        for (Unidad unidad : lUni) {

            String rowMed[] = {String.valueOf(unidad.getCodUni()), unidad.getNomuni()};
            this.getDtf().addRow(rowMed);

        }
        getUnidades().getTablaUni().setModel(getDtf());

    }

    //filtra y carga la tabla de unidades
    @Override
    protected void buscar() {
        String filtro = getUnidades().getCuadroBusq().getText().toUpperCase();
        setDtf(new ModeloTabla());
        getDtf().setColumnIdentifiers(Constantes.COL_UNI);
        List<Unidad> lUni = getUni().selectAllHospi(getHospital().getIdhosp());
        for (Unidad unidad : lUni) {
            if (String.valueOf(unidad.getCodUni()).contains(filtro) || unidad.getNomuni().contains(filtro)) {
                String rowMed[] = {String.valueOf(unidad.getCodUni()), unidad.getNomuni()};
                this.getDtf().addRow(rowMed);
            }

        }
        getUnidades().getTablaUni().setModel(getDtf());
    }
    
    //limpia los datos de la ventana de unidades
    @Override
    protected void limpiarPantalla() {
        getUnidades().getCodigoInsert().setText(Constantes.VACIO);
        getUnidades().getUnidadInsert().setText(Constantes.VACIO);
        getUnidades().getCodMod().setText(Constantes.CODIGO);
        getUnidades().getCodDel().setText(Constantes.CODIGO);
        getUnidades().getNombreMod().setText(Constantes.VACIO);
        getUnidades().getNomDel().setText(Constantes.NOMBRE);
        getUnidades().getCuadroBusq().setText(Constantes.VACIO);

    }

    //inserta una unidad
    @Override
    protected void insertar() {
        String cod = String.valueOf(getUnidades().getCodigoInsert().getText());
        String nombre = getUnidades().getUnidadInsert().getText().toUpperCase();
        if (!cod.equals(Constantes.VACIO) && !nombre.equals(Constantes.VACIO)) {
            Unidad unidad = new Unidad(Integer.parseInt(cod), getHospital(), nombre);
            getUni().insert(unidad);
            cargarTabla();
        } else {

            JOptionPane.showMessageDialog(getUnidades(), Constantes.FALTAN_DATOS);
        }
    }

    //modifica una unidad
    @Override
    protected void modificar() {
        String cod = String.valueOf(getUnidades().getCodMod().getText());
        String nombre = getUnidades().getNombreMod().getText().toUpperCase();
        if (!cod.equals(Constantes.CODIGO) && !nombre.equals(Constantes.VACIO)) {
            Unidad unidad = new Unidad(Integer.parseInt(cod), getHospital(), nombre);
            getUni().update(unidad);
            cargarTabla();
        } else {

            JOptionPane.showMessageDialog(getUnidades(), Constantes.FALTA_UNIDAD);
        }

    }

    //borra una unidad
    @Override
    protected void borrar() {
        String cod = String.valueOf(getUnidades().getCodDel().getText());
        if (!cod.equals(Constantes.CODIGO)) {
            getUni().delete(Integer.parseInt(cod));
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(getUnidades(), Constantes.FALTA_UNIDAD);
        }

    }

    //carga los datos de la unidad seleccionada en la tabla
    @Override
    protected void tocarFila() {

                Unidad unidad = getUni().select(Integer.parseInt(getUnidades().getTablaUni().getValueAt(getUnidades().getTablaUni().getSelectedRow(), Constantes.CERO).toString()));
                getUnidades().getCodDel().setText(String.valueOf(unidad.getCodUni()));
                getUnidades().getCodMod().setText(String.valueOf(unidad.getCodUni()));
                getUnidades().getNomDel().setText(unidad.getNomuni());
                getUnidades().getNombreMod().setText(unidad.getNomuni());
            }



    

}
