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

/**
 *
 * @author silvia
 */
public class Cronometro extends JLabel implements Serializable {

    private Timer timer;
    private int tiempo;
    private ArrayList<StopCronometro> listenersStopCronometro;
    private ArrayList<StartCronometro> listenersStartCronometro;

    public Cronometro() {
        setHorizontalTextPosition(JLabel.HORIZONTAL);
        setText(String.valueOf(tiempo));
        this.listenersStartCronometro = new ArrayList<>();
        this.listenersStopCronometro = new ArrayList<>();
        timer = new Timer();
    }

    public void addStopCronometrorListener(StopCronometro listener) {
        this.listenersStopCronometro.add(listener);
    }

    public void addStartCronometroListener(StartCronometro listener) {
        this.listenersStartCronometro.add(listener);
    }
    
    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
        this.setText(String.valueOf(tiempo));
    }

    public void start() {
        for (StartCronometro startCronometro : listenersStartCronometro) {
            startCronometro.startCronometro();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                    setText(String.valueOf(tiempo++));
            }
        }, 0, 1000);

    }
    
    public void stop(){
        this.timer.cancel();
        for (StopCronometro stopCronometro : listenersStopCronometro) {
            stopCronometro.stopCronometro();
        }
    }
    
    public void restart(){
        this.tiempo = 0;
        this.setText(String.valueOf(tiempo));
    }

}
