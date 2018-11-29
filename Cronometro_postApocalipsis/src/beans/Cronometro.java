/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import interfaces.StopCronometro;

/**
 *
 * @author silvia
 */
public class Cronometro extends JLabel implements Serializable {

    private Timer timer;
    private int tiempo;
    private ArrayList<StopCronometro> listeners;

    public Cronometro() {
        setHorizontalTextPosition(JLabel.HORIZONTAL);
        setText(String.valueOf(tiempo));
        this.listeners = new ArrayList<>();
        timer = new Timer();
    }

    public void addFinCuentaAtrasListener(StopCronometro listener) {
        this.listeners.add(listener);
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
        this.setText(String.valueOf(tiempo));
    }

    public void start() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                    setText(String.valueOf(tiempo++));
            }
        }, 0, 1000);

    }
    
    public void stop(){
        this.timer.cancel();
    }
    
    public void restart(){
        this.tiempo = 0;
        this.setText(String.valueOf(tiempo));
    }

}
