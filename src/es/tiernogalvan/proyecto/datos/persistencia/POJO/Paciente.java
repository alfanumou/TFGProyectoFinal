/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.POJO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vekto
 */
@Entity
@Table(name = "paciente")
@XmlRootElement

public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "num_pa")
    private Integer numPa;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "cod_med", referencedColumnName = "cod_med")
    @ManyToOne(optional = false)
    private Medico medico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private List<SolicitudAnalitica> solicitudAnaliticas;

    public Paciente() {
    }

    public Paciente(Integer numPa) {
        this.numPa = numPa;
    }

    public Paciente(Integer numPa, String nombre) {
        this.numPa = numPa;
        this.nombre = nombre;
    }

    public Paciente(Integer numPa, Medico codMed, String nombre) {
        this.numPa = numPa;
        this.nombre = nombre;
        this.medico = codMed;
    }
    

    public Integer getNumPa() {
        return numPa;
    }

    public void setNumPa(Integer numPa) {
        this.numPa = numPa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @XmlTransient
    public List<SolicitudAnalitica> getSolicitudAnaliticas() {
        return solicitudAnaliticas;
    }

    public void setSolicitudAnaliticas(List<SolicitudAnalitica> solicitudAnaliticas) {
        this.solicitudAnaliticas = solicitudAnaliticas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numPa != null ? numPa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.numPa == null && other.numPa != null) || (this.numPa != null && !this.numPa.equals(other.numPa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.tiernogalvan.proyecto.datos.persistencia.eclipselink.Paciente[ numPa=" + numPa + " ]";
    }
    
}
