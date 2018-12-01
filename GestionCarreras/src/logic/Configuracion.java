/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javax.swing.UIManager;

/**
 *
 * @author silvia
 */
public class Configuracion {
    
    private int intervaloDeGuardado;
    private UIManager.LookAndFeelInfo lookAndFeel;

    public int getIntervaloDeGuardado() {
        return intervaloDeGuardado;
    }

    public void setIntervaloDeGuardado(int intervaloDeGuardado) {
        this.intervaloDeGuardado = intervaloDeGuardado;
    }

    public UIManager.LookAndFeelInfo getLookAndFeel() {
        return lookAndFeel;
    }

    public void setLookAndFeel(UIManager.LookAndFeelInfo lookAndFeel) {
        this.lookAndFeel = lookAndFeel;
    }
    
    
    
    
    
}
