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
@Table(name = "unidad")
@XmlRootElement
public class Unidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_uni")
    private Integer codUni;
    @Basic(optional = false)
    @Column(name = "nomuni")
    private String nomuni;
    @JoinColumn(name = "idhosp", referencedColumnName = "idhosp")
    @ManyToOne(optional = false)
    private Hospital hospital;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidad")
    private List<SolicitudAnalitica> solicitudAnaliticas;

    public Unidad() {
    }

    public Unidad(Integer codUni) {
        this.codUni = codUni;
    }

    public Unidad(Integer codUni, String nomuni) {
        this.codUni = codUni;
        this.nomuni = nomuni;
    }

    public Unidad(Integer codUni, Hospital idhosp, String nomuni) {
        this.codUni = codUni;
        this.nomuni = nomuni;
        this.hospital = idhosp;
    }
    
    

    public Integer getCodUni() {
        return codUni;
    }

    public void setCodUni(Integer codUni) {
        this.codUni = codUni;
    }

    public String getNomuni() {
        return nomuni;
    }

    public void setNomuni(String nomuni) {
        this.nomuni = nomuni;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
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
        hash += (codUni != null ? codUni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.codUni == null && other.codUni != null) || (this.codUni != null && !this.codUni.equals(other.codUni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.tiernogalvan.proyecto.datos.persistencia.eclipselink.Unidad[ codUni=" + codUni + " ]";
    }
    
}
