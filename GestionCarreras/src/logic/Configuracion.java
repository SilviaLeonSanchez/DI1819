/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.Serializable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author silvia
 */
public class Configuracion implements Serializable {

    private int intervaloDeGuardado;
    private transient UIManager.LookAndFeelInfo lookAndFeel;
    private String name;
    private String className;

    public Configuracion() {
        this.intervaloDeGuardado = 5;
    }

    public int getIntervaloDeGuardado() {
        return intervaloDeGuardado;
    }

    public void setIntervaloDeGuardado(int intervaloDeGuardado) {
        this.intervaloDeGuardado = intervaloDeGuardado;
    }

    public LookAndFeelInfo getLookAndFeel() {
        if (name != null && className != null) {
            if (!name.isEmpty() && !className.isEmpty()) {
                this.lookAndFeel = new LookAndFeelInfo(name, className);
            }
        }
        return lookAndFeel;
    }

    public void setLookAndFeel(UIManager.LookAndFeelInfo lookAndFeel) {
        this.lookAndFeel = lookAndFeel;
        this.name = lookAndFeel.getName();
        this.className = lookAndFeel.getClassName();
    }

}
