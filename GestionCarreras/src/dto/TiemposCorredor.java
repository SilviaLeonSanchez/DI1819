/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import interfaces.ReceptorTiempoCronometro;
import java.io.Serializable;
import java.time.Duration;
import java.util.Objects;
import utils.Duracion;
import utils.Utiles;

/**
 *
 * @author silvia
 */
public class TiemposCorredor implements Serializable, Comparable<TiemposCorredor>, ReceptorTiempoCronometro{

    // ATRIBUTOS
    private final String idCarrera;
    private final Corredor corredor;
    private final String dorsal;
    private Duration tiempo;
    public static final String[] DATOS = {"DNI", "NOMBRE", "FECHA DE NACIMIENTO", "DIRECCION", "TELEFONO", "DORSAL", "TIEMPO"};

    // METODOS
    public TiemposCorredor(String idCarrera, Corredor corredor, String dorsal) {
        this.idCarrera = idCarrera;
        this.corredor = corredor;
        this.dorsal = dorsal;
        tiempo = Duration.ZERO;
    }

    @Override
    public int compareTo(TiemposCorredor o) {
        return this.dorsal.compareToIgnoreCase(o.getDorsal());
    }


    @Override
    public String toString() {
        return "TiemposCorredor{" + "corredor=" + corredor + ", idCarrera=" + idCarrera + ", dorsal=" + dorsal + ", tiempo=" + Duracion.verDuracionFormatoLargo(this.tiempo) + '}';
    }

    public String[] toArray() {
        String array[] = new String[7];
        array[0] = this.corredor.getDni();
        array[1] = this.corredor.getNombre();
        array[2] = Utiles.Sdf.formatFecha(this.corredor.getFecha_nac());
        array[3] = this.corredor.getDireccion();
        array[4] = this.corredor.getTelefono();
        array[5] = this.dorsal;
        array[6] = Duracion.verDuracionFormatoCorto(this.tiempo);
        return array;
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
    
@Override
    public void recibirTiempo(Duration tiempo) {
        this.tiempo = tiempo;
    }
    
    
}
