/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import interfaces.StartCronometro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import interfaces.StopCronometro;
import interfaces.ListenerLlegada;
import interfaces.ReceptorTiempoCronometro;
import java.time.Duration;
import java.time.Instant;

/**
 *
 * @author silvia
 */
public class Cronometro extends JLabel implements Serializable {

   
    // ATRIBUTOS
    private final ArrayList<StopCronometro> listenersStopCronometro;
    private final ArrayList<ListenerLlegada> listenersLlegada;
    private final ArrayList<StartCronometro> listenersStartCronometro;

    private Timer timer;
    private Instant momentoStart;
    private volatile Duration tiempo;
    private volatile boolean running;

    // PROPIEDADES
    private boolean conDecimales;

    /**
     * Creates new form RelojDigital
     */
    public Cronometro() {
        this.listenersStartCronometro = new ArrayList<>();
        this.listenersStopCronometro = new ArrayList<>();
        this.listenersLlegada = new ArrayList<>();
        this.timer = new Timer();
        this.tiempo = Duration.ZERO;
        setTiempoEnLabel(tiempo);
    }

    // GETTER Y SETTER    
    public boolean isConDecimales() {
        return conDecimales;
    }

    public void setConDecimales(boolean conDecimales) {
        this.conDecimales = conDecimales;
    }

    // LISTENER
    public void addStopCronometrorListener(StopCronometro listener) {
        this.listenersStopCronometro.add(listener);
    }

    public void addStartCronometroListener(StartCronometro listener) {
        this.listenersStartCronometro.add(listener);
    }

    public void addLlegadaListener(ListenerLlegada listener) {
        this.listenersLlegada.add(listener);
    }

    public void start() {

        for (StartCronometro listener : listenersStartCronometro) {
            listener.startCronometro();
        }

        this.tiempo = Duration.ZERO;

        this.momentoStart = Instant.now();
        this.running = true;

        this.timer = new Timer();
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tiempo = tiempo.plusMillis(100);
                setTiempoEnLabel(tiempo);
            }
        }, 100, 100);
    }

    public void stop() {
        if (this.running) {

            this.timer.cancel();
            this.running = false;

            for (StopCronometro listener : listenersStopCronometro) {
                listener.stopCronometro();
            }

            this.tiempo = Duration.between(this.momentoStart, Instant.now());
        }
    }

    public void llegada() {
        for (ListenerLlegada listenerLlegada : listenersLlegada) {
            ReceptorTiempoCronometro receptorTiempo = listenerLlegada.llegaReceptorACronometro();
            receptorTiempo.recibirTiempo(tiempo);
            listenerLlegada.vuelveReceptorDeCronometro(receptorTiempo);
        }
    }

    // TIEMPO
    private void setTiempoEnLabel(Duration tiempo) {
        String textoTiempo;
        if (conDecimales) {
            textoTiempo = String.format("%02d:%02d:%02d", (int) tiempo.toHours(), (int) tiempo.toMinutes(), (int) tiempo.getSeconds());
        } else {
            textoTiempo = String.format("%02d:%02d:%02d %01d", (int) tiempo.toHours(), (int) tiempo.toMinutes(), (int) tiempo.getSeconds(), (int) (tiempo.getNano() / 100000000));
        }
        setText(textoTiempo);
    }

    public Duration getTiempo() {
        return tiempo;
    }

}
