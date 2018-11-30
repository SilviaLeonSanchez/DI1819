/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dto.Corredor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;
import utils.FicheroDeObjetos;
import utils.FicheroDeTexto;

/**
 *
 * @author silvia
 */
public class LogicaGuardado {

    private Timer timer;
    private int intervaloGuardado;

    private FicheroDeObjetos<LogicaCarrera> gestorFicheroCarreras;
    private final File ficheroCarreras = new File("fichero_carreras.dat");

    private FicheroDeObjetos<LogicaCorredor> gestorFicheroCorredores;
    private final File ficheroCorredores = new File("fichero_corredores.dat");

    private static LogicaGuardado INSTANCE;

    public static LogicaGuardado getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LogicaGuardado();
        }
        return INSTANCE;
    }

    // CONSTRUCTOR
    public LogicaGuardado() {
        this.intervaloGuardado = (intervaloGuardado == 0) ? 5 : intervaloGuardado;

        this.timer = new Timer(intervaloGuardado * 60 * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
                System.out.println("Guardado automatico");
            }
        });
        this.timer.start();
    }

    // GETTER Y SETTER
    public int getIntervaloGuardado() {
        return intervaloGuardado;
    }

    public void setIntervaloGuardado(int intervaloGuardado) {
        this.intervaloGuardado = intervaloGuardado;
        this.timer = new Timer(intervaloGuardado * 60 * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });
        this.timer.start();
    }

    public File getFicheroCarreras() {
        return ficheroCarreras;
    }

    public File getFicheroCorredores() {
        return ficheroCorredores;
    }

    // PERSISTENCIA
    public void cargarDatos() {
        leerLogicaCarreras();
        leerLogicaCorredores();
    }

    public boolean guardarDatos() {
        boolean carrerasOk = guardarLogicaCarreras();
        boolean corredoresOk = guardarLogicaCorredores();
        return carrerasOk && corredoresOk;
    }

    // FICHERO CARRERAS
    private boolean leerLogicaCarreras() {
        if (checkFicheroCarreras()) {
            LogicaCarrera logicaCarreras = null;
            if (ficheroCarreras.length() > 0) {
                this.gestorFicheroCarreras.abrirLector();
                logicaCarreras = gestorFicheroCarreras.leerObjeto();
                this.gestorFicheroCarreras.cerrarLector();
            }
            LogicaCarrera.setInstance(logicaCarreras);
            return true;
        } else {
            return false;
        }
    }

    private boolean guardarLogicaCarreras() {
        if (checkFicheroCarreras()) {
            gestorFicheroCarreras.abrirEscritor(false);
            gestorFicheroCarreras.grabarPrimerObjeto(LogicaCarrera.getInstance());
            gestorFicheroCarreras.cerrarEscritor();
            return true;
        } else {
            return false;
        }
    }

    private boolean checkFicheroCarreras() {
        if (!ficheroCarreras.exists()) {
            try {
                ficheroCarreras.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        this.gestorFicheroCarreras = new FicheroDeObjetos<>(ficheroCarreras);
        return true;
    }

    //  FICHERO CORREDORES
    private boolean leerLogicaCorredores() {
        if (checkFicheroCorredores()) {
            LogicaCorredor logicaCorredores = null;
            if (ficheroCorredores.length() > 0) {
                this.gestorFicheroCorredores.abrirLector();
                logicaCorredores = gestorFicheroCorredores.leerObjeto();
                this.gestorFicheroCorredores.cerrarLector();
            }
            LogicaCorredor.setInstance(logicaCorredores);
            return true;
        } else {
            return false;
        }
    }

    private boolean guardarLogicaCorredores() {
        if (checkFicheroCorredores()) {
            gestorFicheroCorredores.abrirEscritor(false);
            gestorFicheroCorredores.grabarPrimerObjeto(LogicaCorredor.getInstance());
            gestorFicheroCorredores.cerrarEscritor();
            return true;
        } else {
            return false;
        }
    }

    private boolean checkFicheroCorredores() {
        if (!ficheroCorredores.exists()) {
            try {
                ficheroCorredores.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        this.gestorFicheroCorredores = new FicheroDeObjetos<>(ficheroCorredores);
        return true;
    }

    // CSV CORREDORES
    public boolean exportarCorredoresCSV(File ficheroCSVCorredores) {

        // Comprobar si el fichero existe
        if (!checkCSVCorredores(ficheroCSVCorredores)) {
            return false;
        }
        
        // GESTOR DE FICHERO CSV
        FicheroDeTexto gestorCSVCorredores;
        gestorCSVCorredores = new FicheroDeTexto(ficheroCSVCorredores);
        gestorCSVCorredores.abrirEscritor(false);

        // CABECERA
        for (String nombreAtributo : Corredor.DATOS) {
            gestorCSVCorredores.print(nombreAtributo + ",");
        }
        gestorCSVCorredores.print("\n");

        // CORREDORES
        for (Corredor corredor : LogicaCorredor.getInstance().getCorredores()) {
            for (String atributo : corredor.toArray()) {
                gestorCSVCorredores.print(atributo + ",");
            }
            gestorCSVCorredores.print("\n");
        }

        gestorCSVCorredores.cerrarEscritor();
        return true;
    }

    public boolean checkCSVCorredores(File ficheroCSVCorredores) {
        if (!ficheroCSVCorredores.exists()) {
            try {
                ficheroCSVCorredores.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        return true;
    }


}


