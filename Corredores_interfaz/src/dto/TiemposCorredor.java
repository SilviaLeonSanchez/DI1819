/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.datatype.Duration;

/**
 *
 * @author silvia
 */
public class TiemposCorredor implements Serializable{

    // ATRIBUTOS
    private final Corredor corredor;
    private final String idCarrera;
    private final String dorsal;
    private Duration tiempo;

    // METODOS
    public TiemposCorredor(String idCarrera, Corredor corredor, String dorsal) {
        this.idCarrera = idCarrera;
        this.corredor = corredor;
        this.dorsal = dorsal;
    }

    @Override
    public String toString() {
        return "TiemposCorredor{" + "corredor=" + corredor + ", idCarrera=" + idCarrera + ", dorsal=" + dorsal + ", tiempo=" + tiempo + '}';
    }

    


    // GETTER
    public Duration getTiempo() {
        return tiempo;
    }

    public String getDorsal() {
        return dorsal;
    }

    public Corredor getCorredor() {
        return corredor;
    }

    public String getIdCarrera() {
        return idCarrera;
    }


    // SETTER
    public void setTiempo(Duration tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.corredor);
        hash = 47 * hash + Objects.hashCode(this.idCarrera);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TiemposCorredor other = (TiemposCorredor) obj;
        if (!Objects.equals(this.idCarrera, other.idCarrera)) {
            return false;
        }
        if (!Objects.equals(this.corredor, other.corredor)) {
            return false;
        }
        return true;
    }
    

    
    
}
