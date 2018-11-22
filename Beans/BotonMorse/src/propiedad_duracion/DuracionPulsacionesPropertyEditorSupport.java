/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propiedad_duracion;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author silvia
 */
public class DuracionPulsacionesPropertyEditorSupport extends PropertyEditorSupport {

    private PanelDuracionPulsaciones panelDuracionPulsaciones = new PanelDuracionPulsaciones();

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return panelDuracionPulsaciones;
    }

    @Override
    public Object getValue() {
        return panelDuracionPulsaciones.getDuracionPulsaciones();
    }

    @Override
    public String getJavaInitializationString() {
        long duracionPulsacionCorta = panelDuracionPulsaciones.getDuracionPulsaciones().getPulsacionCorta();
        long duracionPulsacionLarga = panelDuracionPulsaciones.getDuracionPulsaciones().getPulsacionLarga();
        long duracionTiempoMaximoEntrePulsaciones = panelDuracionPulsaciones.getDuracionPulsaciones().getTiempoMaximoEntrePulsaciones();
        long duracionSenialEspacio = panelDuracionPulsaciones.getDuracionPulsaciones().getDuracionEspacio();
        long duracionSenialFin = panelDuracionPulsaciones.getDuracionPulsaciones().getDuracionEspacio();
        return "new propiedad_duracion.DuracionPulsaciones("
                + duracionPulsacionCorta + "l, "+ duracionPulsacionLarga + "l, " 
                + duracionTiempoMaximoEntrePulsaciones + "l, " + duracionSenialEspacio  + "l, " 
                + duracionSenialFin + "l)";
    }
}
