/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propiedad_duracion;

import java.io.Serializable;

/**
 *
 * @author silvia
 */
public class DuracionPulsaciones implements Serializable {

    // PROPIEDADES
    private final long pulsacionCorta;
    private final long pulsacionLarga;
    private final long tiempoMaximoEntrePulsaciones;
    
    private final long duracionEspacio;
    private final long duracionFin;

    public DuracionPulsaciones(long pulsacionCorta, long pulsacionLarga, long tiempoMaximoEntrePulsaciones, long duracionEspacio, long duracionFin) {
        this.pulsacionCorta = pulsacionCorta;
        this.pulsacionLarga = pulsacionLarga;
        this.tiempoMaximoEntrePulsaciones = tiempoMaximoEntrePulsaciones;
        this.duracionEspacio = duracionEspacio;
        this.duracionFin = duracionFin;
    }

    public long getPulsacionCorta() {
        return pulsacionCorta;
    }

    public long getPulsacionLarga() {
        return pulsacionLarga;
    }

    public long getTiempoMaximoEntrePulsaciones() {
        return tiempoMaximoEntrePulsaciones;
    }

    public long getDuracionEspacio() {
        return duracionEspacio;
    }

    public long getDuracionFin() {
        return duracionFin;
    }

}
