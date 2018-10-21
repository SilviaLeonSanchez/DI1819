/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.xml.datatype.Duration;

/**
 *
 * @author silvia
 */
public class TiemposCorredor implements Serializable{

    // ATRIBUTOS
    private String dorsal;
    private LinkedList<Duration> tiempos;

    // METODOS
    public TiemposCorredor(String dorsal) {
        this.tiempos = new LinkedList<>();
    }

    @Override
    public String toString() {
        String corredorCarrera = "CorredorCarrera{"+" dorsal=" + dorsal + ", tiempos=";
        for (Duration tiempo : tiempos) {
            corredorCarrera = corredorCarrera.concat("\n\t" + tiempo.getHours()+":"+tiempo.getMinutes()+":"+tiempo.getSeconds());
        }
        return corredorCarrera + "\n}";
    }


    // GETTER
    public List<Duration> getTiempos() {
        return tiempos;
    }

    public String getDorsal() {
        return dorsal;
    }


    // SETTER

    public void setTiempos(LinkedList<Duration> tiempos) {
        this.tiempos = tiempos;
    }
    
    public void addTiempo(Duration tiempo){
        this.tiempos.add(tiempo);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.dorsal);
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
        if (!Objects.equals(this.dorsal, other.dorsal)) {
            return false;
        }
        return true;
    }
    
    
}
