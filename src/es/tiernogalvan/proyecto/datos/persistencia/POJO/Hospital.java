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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vekto
 */
@Entity
@Table(name = "hospital")
@XmlRootElement
public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idhosp")
    private Integer idhosp;
    @Basic(optional = false)
    @Column(name = "nomhosp")
    private String nomhosp;
    @Basic(optional = false)
    @Column(name = "dirhosp")
    private String dirhosp;
    @Basic(optional = false)
    @Column(name = "tlfhosp")
    private String tlfhosp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospital")
    private List<Unidad> unidads;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospital")
    private List<Medico> medicos;

    public Hospital() {
    }

    public Hospital(Integer idhosp) {
        this.idhosp = idhosp;
    }

    public Hospital(Integer idhosp, String nomhosp, String dirhosp, String tlfhosp) {
        this.idhosp = idhosp;
        this.nomhosp = nomhosp;
        this.dirhosp = dirhosp;
        this.tlfhosp = tlfhosp;
    }

    public Integer getIdhosp() {
        return idhosp;
    }

    public void setIdhosp(Integer idhosp) {
        this.idhosp = idhosp;
    }

    public String getNomhosp() {
        return nomhosp;
    }

    public void setNomhosp(String nomhosp) {
        this.nomhosp = nomhosp;
    }

    public String getDirhosp() {
        return dirhosp;
    }

    public void setDirhosp(String dirhosp) {
        this.dirhosp = dirhosp;
    }

    public String getTlfhosp() {
        return tlfhosp;
    }

    public void setTlfhosp(String tlfhosp) {
        this.tlfhosp = tlfhosp;
    }

    @XmlTransient
    public List<Unidad> getUnidads() {
        return unidads;
    }

    public void setUnidads(List<Unidad> unidads) {
        this.unidads = unidads;
    }

    @XmlTransient
    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhosp != null ? idhosp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospital)) {
            return false;
        }
        Hospital other = (Hospital) object;
        if ((this.idhosp == null && other.idhosp != null) || (this.idhosp != null && !this.idhosp.equals(other.idhosp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.tiernogalvan.proyecto.datos.persistencia.eclipselink.Hospital[ idhosp=" + idhosp + " ]";
    }
    
}
