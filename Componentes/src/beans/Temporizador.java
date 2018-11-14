/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import listener.StopTemporizador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author silvia
 */
public class Temporizador extends JLabel implements Serializable {

    Timer timer;
    private int tiempo;
    private int tiempoRestante;
    private ArrayList<StopTemporizador> listeners;

    public Temporizador() {
        setHorizontalTextPosition(JLabel.HORIZONTAL);
        setText(String.valueOf(tiempo));
        this.listeners = new ArrayList<>();
        timer = new Timer();
    }

    public void addFinCuentaAtrasListener(StopTemporizador listener) {
        this.listeners.add(listener);
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
        this.tiempoRestante = tiempo;
        this.setText(String.valueOf(tiempo));
    }

    public void start() {
        this.tiempoRestante = this.tiempo;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (tiempoRestante >= 0) {
                    setText(String.valueOf(tiempoRestante--));
                } else {
                    cancel();
                    for (StopTemporizador listener : listeners) {
                        listener.stopTemporizador();
                    }
                }
            }
        }, 0, 1000);

    }
    
    public void stop(){
        this.timer.cancel();
    }
    
    public void restart(){
        this.tiempoRestante = tiempo;
        this.setText(String.valueOf(tiempo));
    }

}
