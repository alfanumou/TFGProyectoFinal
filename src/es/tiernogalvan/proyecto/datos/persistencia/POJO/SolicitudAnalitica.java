/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.POJO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vekto
 */
@Entity
@Table(name = "solicitud_analitica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudAnalitica.findAll", query = "SELECT s FROM SolicitudAnalitica s")
    , @NamedQuery(name = "SolicitudAnalitica.findByCodUni", query = "SELECT s FROM SolicitudAnalitica s WHERE s.Id.codUni = :codUni")
    , @NamedQuery(name = "SolicitudAnalitica.findByNumPa", query = "SELECT s FROM SolicitudAnalitica s WHERE s.Id.numPa = :numPa")
    , @NamedQuery(name = "SolicitudAnalitica.findByCodMed", query = "SELECT s FROM SolicitudAnalitica s WHERE s.Id.codMed = :codMed")
    , @NamedQuery(name = "SolicitudAnalitica.findByDescripcion", query = "SELECT s FROM SolicitudAnalitica s WHERE s.descripcion = :descripcion")})
public class SolicitudAnalitica implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SolicitudAnaliticaId Id;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "cod_med", referencedColumnName = "cod_med", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Medico medico;
    @JoinColumn(name = "num_pa", referencedColumnName = "num_pa",insertable = false, updatable = false)
    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private Paciente paciente;
    @JoinColumn(name = "cod_uni", referencedColumnName = "cod_uni", insertable = false, updatable = false)
    @ManyToOne(optional = false,  fetch = FetchType.EAGER )
    private Unidad unidad;

    public SolicitudAnalitica() {
    }

    public SolicitudAnalitica(SolicitudAnaliticaId solicitudAnaliticaPK) {
        this.Id = solicitudAnaliticaPK;
    }
    
    public SolicitudAnalitica(SolicitudAnaliticaId solicitudAnaliticaPK,String descrip) {
        this.Id = solicitudAnaliticaPK;
        this.descripcion=descrip;
    }

    public SolicitudAnalitica(int codUni, int numPa, int codMed) {
        this.Id = new SolicitudAnaliticaId(codUni, numPa, codMed);
    }

    public SolicitudAnaliticaId getId() {
        return Id;
    }

    public void setId(SolicitudAnaliticaId solicitudAnaliticaPK) {
        this.Id = solicitudAnaliticaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Id != null ? Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudAnalitica)) {
            return false;
        }
        SolicitudAnalitica other = (SolicitudAnalitica) object;
        if ((this.Id == null && other.Id != null) || (this.Id != null && !this.Id.equals(other.Id))) {
            return false;
        }
        return true;
    }


    
}
