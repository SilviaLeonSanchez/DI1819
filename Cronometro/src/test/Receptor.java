/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import interfaces.ReceptorTiempoCronometro;
import java.time.Duration;
import javax.swing.JLabel;

/**
 *
 * @author silvia
 */
public class Receptor extends JLabel implements ReceptorTiempoCronometro{

    @Override
    public void recibirTiempo(Duration tiempo) {
        String textoTiempo = String.format("%02d:%02d:%02d %01d", (int) tiempo.toHours(), (int) tiempo.toMinutes(), (int) tiempo.getSeconds(), (int) (tiempo.getNano() / 100000000));
        setText(textoTiempo);
    }
    
}
