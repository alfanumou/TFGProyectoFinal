/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.datos.persistencia.POJO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author vekto
 */
@Embeddable
public class SolicitudAnaliticaId implements Serializable {

    @Basic(optional = false)
    @Column(name = "cod_uni")
    private int codUni;
    @Basic(optional = false)
    @Column(name = "num_pa")
    private int numPa;
    @Basic(optional = false)
    @Column(name = "cod_med")
    private int codMed;

    public SolicitudAnaliticaId() {
    }

    public SolicitudAnaliticaId(int codUni, int numPa, int codMed) {
        this.codUni = codUni;
        this.numPa = numPa;
        this.codMed = codMed;
    }

    public int getCodUni() {
        return codUni;
    }

    public void setCodUni(int codUni) {
        this.codUni = codUni;
    }

    public int getNumPa() {
        return numPa;
    }

    public void setNumPa(int numPa) {
        this.numPa = numPa;
    }

    public int getCodMed() {
        return codMed;
    }

    public void setCodMed(int codMed) {
        this.codMed = codMed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codUni;
        hash += (int) numPa;
        hash += (int) codMed;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudAnaliticaId)) {
            return false;
        }
        SolicitudAnaliticaId other = (SolicitudAnaliticaId) object;
        if (this.codUni != other.codUni) {
            return false;
        }
        if (this.numPa != other.numPa) {
            return false;
        }
        if (this.codMed != other.codMed) {
            return false;
        }
        return true;
    }

   @Override
   public String toString(){
   return String.valueOf(getCodUni())+String.valueOf(getNumPa())+String.valueOf(getCodMed());
   
   }
    
}
