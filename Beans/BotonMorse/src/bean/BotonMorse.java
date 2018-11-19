/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import listener.CodigoDetectado;
import listener.LetraDetectada;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JButton;
import listener.IntervaloDetectado;

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

    public BotonMorse() {

        // Valores por defecto
        this.duracionPulsaciones = new DuracionPulsaciones(200, 1500, 2000);

        this.listenerLetraDetectada = new ArrayList<>();
        this.listenerCodigoDetectado = new ArrayList<>();
        this.listenerIntervaloDetectado = new ArrayList<>();

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
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void checkClick() {
        long pulsacionCorta = this.duracionPulsaciones.getPulsacionCorta();
        long pulsacionLarga = this.duracionPulsaciones.getPulsacionLarga();
        long intervaloMax = this.duracionPulsaciones.getTiempoMaximoEntrePulsaciones();

        if (this.tiempoEntreClicks > intervaloMax) {
            this.codigo = "";
            this.letra = "";
            for (IntervaloDetectado listener : listenerIntervaloDetectado){
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
        }

        System.out.println("Llega al for");
        for (int i = 0; i < this.codigos.length; i++) {
            
            // Ver recorrido del for
            System.out.println(this.codigo + " -> " + this.codigos[i]);
            
            if (this.codigo.compareToIgnoreCase(this.codigos[i]) == 0) {
                
                // Ver letra encontrada
                System.out.println("Coincidencia encontrada: " + this.letras[i]);
                
                this.letra = this.letras[i];
                listenerLetraDetectada.forEach((listener) -> {
                    listener.letraDetectada(this.letra, this.codigo);
                });
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

    
}
