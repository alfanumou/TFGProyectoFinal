/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.utilidades;

import com.qoppa.pdfWriter.PDFDocument;
import com.qoppa.pdfWriter.PDFGraphics;
import com.qoppa.pdfWriter.PDFPage;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.GenerDAO;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.MedicoDAO;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.PacienteDAO;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.UnidadDAO;
import es.tiernogalvan.proyecto.datos.persistencia.Factory.FactoryDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Hospital;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Medico;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Paciente;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.SolicitudAnalitica;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Unidad;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.io.File;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

/**
 *
 * @author vekto
 */
public class CreacionPeticion {


    private Paciente paciente;
    private Medico medico;
    private Hospital hospital;
    private Unidad unidad;
    private SolicitudAnalitica solicitud;

  public CreacionPeticion(SolicitudAnalitica solicitud, Hospital hospital) {
      
        this.solicitud =solicitud;
        this.hospital = hospital;  
        PacienteDAO ap =(PacienteDAO) FactoryDAO.getFactoryDAO().getDAO(GenerDAO.PAC_DAO);
        this.paciente = ap.select(solicitud.getId().getNumPa());
        MedicoDAO am =(MedicoDAO) FactoryDAO.getFactoryDAO().getDAO(GenerDAO.MED_DAO);
        this.medico = am.select(solicitud.getId().getCodMed());
        UnidadDAO um = (UnidadDAO) FactoryDAO.getFactoryDAO().getDAO(GenerDAO.UNI_DAO);
        this.unidad = um.select(solicitud.getId().getCodUni());

    }

    public void crearPdf(String prioridad, String observaciones) {

        try {
            PDFDocument pdfDoc = new PDFDocument();

            Paper p = new Paper();
            p.setSize(8.5 * 72, 11 * 72);
            p.setImageableArea(0, 0, 8.5 * 72, 11 * 72);
            PageFormat pf = new PageFormat();
            pf.setPaper(p);

            PDFPage page = pdfDoc.createPage(pf);
            pdfDoc.addPage(page);

            PDFGraphics g2d = (PDFGraphics) page.createGraphics();

            BufferedImage image = cBarras128(solicitud.getId().toString());

            g2d.drawImage(image, 0, 50, null);
            g2d.setFont(PDFGraphics.HELVETICA.deriveFont(12f));
            g2d.drawLine(20, 100, 480, 100);
            g2d.drawString(Constantes.HOSPITAL_SOLI + hospital.getNomhosp(), 20, 130);
            g2d.drawString(Constantes.TELEFONO_SOLI + hospital.getTlfhosp(), 200, 130);
            g2d.drawString(Constantes.CIUDAD_SOLI + hospital.getDirhosp(), 340, 130);
            g2d.drawString(Constantes.MEDICO_SOLI + medico.getNombre(), 20, 170);
            g2d.drawString(Constantes.UNIDAD_PET + unidad.getNomuni(), 20, 190);
            g2d.drawString(Constantes.PACIENTE_SOLI + paciente.getNombre(), 20, 210);
            g2d.drawLine(20, 250, 480, 250);
            g2d.drawString(Constantes.PRUEBAS, 20, 280);
            g2d.drawString(solicitud.getDescripcion(), 20, 310);
            g2d.drawLine(20, 340, 480, 340);
            g2d.drawString(Constantes.PRIORIDAD_SOLI + prioridad, 20, 370);
            g2d.drawString(Constantes.OBSERVACIONES, 20, 390);
            g2d.drawString(observaciones, 20, 410);
            
            pdfDoc.saveDocument(System.getProperty(Constantes.USER) + Constantes.BARRA+ solicitud.getId().toString() + Constantes.PDF);
            File peticionCreada=new File(System.getProperty(Constantes.USER) + Constantes.BARRA + solicitud.getId().toString() + Constantes.PDF);
            Desktop.getDesktop().open(peticionCreada);
            
        } catch (Exception t) {

        }

    }

    public BufferedImage cBarras128(final String texto) throws Exception {
        Barcode barcode = BarcodeFactory.createCode128(texto);
        barcode.setFont(new Font(Font.MONOSPACED, Font.ROMAN_BASELINE, 12));
        return BarcodeImageHandler.getImage(barcode);
    }


}
