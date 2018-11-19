/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

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

    public DuracionPulsaciones(long pulsacionCorta, long pulsacionLarga, long tiempoMaximoEntrePulsaciones) {
        this.pulsacionCorta = pulsacionCorta;
        this.pulsacionLarga = pulsacionLarga;
        this.tiempoMaximoEntrePulsaciones = tiempoMaximoEntrePulsaciones;
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

}
