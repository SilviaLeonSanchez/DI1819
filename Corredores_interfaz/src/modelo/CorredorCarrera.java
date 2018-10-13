/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.util.Duration;
import utiles.ExcepcionesPropias;

/**
 *
 * @author silvia
 */
public class CorredorCarrera {
    
    // ATRIBUTOS
    private Carrera carrera;
    private Corredor corredor;
    private String dorsal;
    private List<Duration> tiempos;

    // METODOS
    public CorredorCarrera(Carrera carrera, Corredor corredor) {
        this.carrera = carrera;
        this.corredor = corredor;
        this.tiempos = new ArrayList<>();
    }

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        String corredorCarrera = "CorredorCarrera{" + "carrera=" + carrera + ", corredor=" + corredor + ", dorsal=" + dorsal + ", tiempos=";
        for (Duration tiempo : tiempos){
            corredorCarrera = corredorCarrera.concat("\n\t" + tiempo.toString());
        }
        return corredorCarrera + "\n}";
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
        final CorredorCarrera other = (CorredorCarrera) obj;
        if (!Objects.equals(this.carrera, other.carrera)) {
            return false;
        }
        if (!Objects.equals(this.corredor, other.corredor)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.carrera);
        hash = 83 * hash + Objects.hashCode(this.corredor);
        return hash;
    }

    // GETTER
    public List<Duration> getTiempos() {
        return tiempos;
    }

    public String getDorsal() {
        return dorsal;
    }

    public Corredor getCorredor() {
        return corredor;
    }

    public Carrera getCarrera() {
        return carrera;
    }
    
    // SETTER
    
    
    
}
