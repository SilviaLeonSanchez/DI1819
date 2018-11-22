/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import propiedad_duracion.DuracionPulsaciones;
import listener.CodigoDetectado;
import listener.LetraDetectada;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JButton;
import listener.IntervaloDetectado;
import listener.FinDetectado;

/**
 *
 * @author silvia
 */
public class BotonMorse extends JButton implements Serializable {

    // ATRIBUTOS
    private long inicioClick;
    private long finClick;
    private long duracionClick;
    private long tiempoEntreClicks;

    String[] letras = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
        "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
        "y", "z"};

    String[] codigos = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
        ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
        "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    private String letra;
    private String codigo;

    // PROPIEDADES
    private DuracionPulsaciones duracionPulsaciones;
    private ArrayList<LetraDetectada> listenerLetraDetectada;
    private ArrayList<CodigoDetectado> listenerCodigoDetectado;
    private ArrayList<IntervaloDetectado> listenerIntervaloDetectado;
    private ArrayList<FinDetectado> listenerFinDetectado;

    public BotonMorse() {

        // Valores por defecto
        this.duracionPulsaciones = new DuracionPulsaciones(200, 1500, 2000, 3000, 5000);

        this.listenerLetraDetectada = new ArrayList<>();
        this.listenerCodigoDetectado = new ArrayList<>();
        this.listenerIntervaloDetectado = new ArrayList<>();
        this.listenerFinDetectado = new ArrayList<>();

        this.codigo = "";
        this.letra = "";

        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                checkClick();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                inicioClick = e.getWhen();
                // Diferencia entre el inicio del click y fin del anterior click
                tiempoEntreClicks = inicioClick - finClick;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                finClick = e.getWhen();
                duracionClick = finClick - inicioClick;
                if (duracionClick > duracionPulsaciones.getDuracionFin()) {
                    checkClick();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
    
    public DuracionPulsaciones getDuracionPulsaciones() {
        return duracionPulsaciones;
    }

    public void setDuracionPulsaciones(DuracionPulsaciones duracionPulsaciones) {
        this.duracionPulsaciones = duracionPulsaciones;
    }

    private void checkClick() {
        long pulsacionCorta = this.duracionPulsaciones.getPulsacionCorta();
        long pulsacionLarga = this.duracionPulsaciones.getPulsacionLarga();
        long intervaloMax = this.duracionPulsaciones.getTiempoMaximoEntrePulsaciones();
        long duracionEspacio = this.duracionPulsaciones.getDuracionEspacio();
        long duracionFin = this.duracionPulsaciones.getDuracionFin();

        if (this.tiempoEntreClicks > intervaloMax) {

            for (int i = 0; i < this.codigos.length; i++) {
                if (this.codigo.compareToIgnoreCase(this.codigos[i]) == 0) {

                    this.letra = this.letras[i];
                    for (LetraDetectada listener : listenerLetraDetectada) {
                        listener.letraDetectada(letra, codigo);
                    }
                }
            }

            this.codigo = "";
            this.letra = "";
            for (IntervaloDetectado listener : listenerIntervaloDetectado) {
                listener.intervaloDetectado();
            }
        }

        if (this.duracionClick < pulsacionCorta) {
            this.codigo += ".";
            for (CodigoDetectado listener : listenerCodigoDetectado) {
                listener.codigoDetectado(".");
            }
        } else if (this.duracionClick > pulsacionCorta && this.duracionClick < pulsacionLarga) {
            this.codigo += "-";
            for (CodigoDetectado listener : listenerCodigoDetectado) {
                listener.codigoDetectado("-");
            }
        } else if (this.duracionClick > duracionEspacio && this.duracionClick < duracionFin) {
            for (LetraDetectada listener : listenerLetraDetectada) {
                listener.letraDetectada(" ", "");
            }
        } else if (this.duracionClick > duracionFin) {
            for (FinDetectado listener : listenerFinDetectado) {
                listener.finDetectado();
            }
        }

    }

    public void addListenerLetraDetectada(LetraDetectada listener) {
        this.listenerLetraDetectada.add(listener);
    }

    public void addListenerCodigoDetectado(CodigoDetectado listener) {
        this.listenerCodigoDetectado.add(listener);
    }

    public void addListenerIntervaloDetectado(IntervaloDetectado listener) {
        this.listenerIntervaloDetectado.add(listener);
    }

    public void addListenerFinDetectado(FinDetectado listener) {
        this.listenerFinDetectado.add(listener);
    }

}
