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
import javax.persistence.FetchType;
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
@Table(name = "medico")
@XmlRootElement

public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_med")
    private Integer codMed;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "profesion")
    private String profesion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medico")
    private List<Paciente> pacientes;
    @JoinColumn(name = "idhosp", referencedColumnName = "idhosp")
    @ManyToOne(optional = false)
    private Hospital hospital;
    @OneToMany(mappedBy = "medico")
    private List<Medico> medicos;
    @JoinColumn(name = "cod_med_jefe", referencedColumnName = "cod_med")
    @ManyToOne
    private Medico medico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medico")
    private List<SolicitudAnalitica> solicitudAnaliticas;

    public Medico() {
    }

    public Medico(Integer codMed) {
        this.codMed = codMed;
    }

    public Medico(Integer codMed, String nombre, String profesion) {
        this.codMed = codMed;
        this.nombre = nombre;
        this.profesion = profesion;
    }
    public Medico(int codMed, Hospital hospital, String nombre, String profesion) {
        this.codMed = codMed;
        this.hospital = hospital;
        this.nombre = nombre;
        this.profesion = profesion;
    }

    public Medico(Integer codMed, Hospital idhosp, String nombre, String profesion, Medico codMedJefe) {
        this.codMed = codMed;
        this.nombre = nombre;
        this.profesion = profesion;
        this.hospital = idhosp;
        this.medico = codMedJefe;
    }
    
    public Integer getCodMed() {
        return codMed;
    }

    public void setCodMed(Integer codMed) {
        this.codMed = codMed;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @XmlTransient
    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setIdhosp(Hospital idhosp) {
        this.hospital = idhosp;
    }

    @XmlTransient
    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
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
        hash += (codMed != null ? codMed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.codMed == null && other.codMed != null) || (this.codMed != null && !this.codMed.equals(other.codMed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.tiernogalvan.proyecto.datos.persistencia.eclipselink.Medico[ codMed=" + codMed + " ]";
    }
    
}
