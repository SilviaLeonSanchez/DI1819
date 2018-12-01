/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dto.Carrera;
import dto.Corredor;
import dto.TiemposCorredor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import javax.swing.Timer;
import utils.FicheroDeObjetos;
import utils.FicheroDeTexto;

/**
 *
 * @author silvia
 */
public class LogicaGuardado {

    private Timer timer;
    private Configuracion configuracion;

    private FicheroDeObjetos<Configuracion> gestorFicheroConfiguracion;
    private final File ficheroConfiguracion = new File("configuracion.dat");

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
        this.gestorFicheroConfiguracion = new FicheroDeObjetos<>(ficheroConfiguracion);
        this.gestorFicheroCarreras = new FicheroDeObjetos<>(ficheroCarreras);
        this.gestorFicheroCorredores = new FicheroDeObjetos<>(ficheroCorredores);
        
        this.timer = new Timer(5 * 60 * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });
        this.timer.start();

        
    }

    // GETTER Y SETTER
    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public void setIntervaloGuardado(int intervaloGuardado) {
        this.configuracion.setIntervaloDeGuardado(intervaloGuardado);
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
        leerConfiguracion();
    }

    public boolean guardarDatos() {
        boolean carrerasOk = guardarLogicaCarreras();
        boolean corredoresOk = guardarLogicaCorredores();
        boolean configuracionOk = guardarConfiguracion();
        return carrerasOk && corredoresOk && configuracionOk;
    }

    public boolean ficheroOk(File fichero) {
        if (!fichero.exists()) {
            try {
                fichero.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        return true;
    }

    // CONFIGURACION
    private boolean leerConfiguracion() {
        if (!ficheroOk(ficheroConfiguracion)) {
            return false;
        } else {
            if (ficheroConfiguracion.length() > 0) {
                this.gestorFicheroConfiguracion.abrirLector();
                this.configuracion = gestorFicheroConfiguracion.leerObjeto();
                this.gestorFicheroConfiguracion.cerrarLector();
            }
            return true;
        }
    }

    private boolean guardarConfiguracion() {
        if (!ficheroOk(ficheroConfiguracion)) {
            return false;
        } else {
            gestorFicheroConfiguracion.abrirEscritor(false);
            gestorFicheroConfiguracion.grabarPrimerObjeto(configuracion);
            gestorFicheroConfiguracion.cerrarEscritor();
            return true;
        }
    }

    // FICHERO CARRERAS
    private boolean leerLogicaCarreras() {
        if (!ficheroOk(ficheroCarreras)) {
            return false;
        } else {
            LogicaCarrera logicaCarreras = null;
            if (ficheroCarreras.length() > 0) {
                this.gestorFicheroCarreras.abrirLector();
                logicaCarreras = gestorFicheroCarreras.leerObjeto();
                this.gestorFicheroCarreras.cerrarLector();
            }
            LogicaCarrera.setInstance(logicaCarreras);
            return true;
        }
    }

    private boolean guardarLogicaCarreras() {
        if (!ficheroOk(ficheroCarreras)) {
            return false;
        } else {
            gestorFicheroCarreras.abrirEscritor(false);
            gestorFicheroCarreras.grabarPrimerObjeto(LogicaCarrera.getInstance());
            gestorFicheroCarreras.cerrarEscritor();
            return true;
        }
    }

    //  FICHERO CORREDORES
    private boolean leerLogicaCorredores() {
        if (!ficheroOk(ficheroCorredores)) {
            return false;
        } else {
            LogicaCorredor logicaCorredores = null;
            if (ficheroCorredores.length() > 0) {
                this.gestorFicheroCorredores.abrirLector();
                logicaCorredores = gestorFicheroCorredores.leerObjeto();
                this.gestorFicheroCorredores.cerrarLector();
            }
            LogicaCorredor.setInstance(logicaCorredores);
            return true;
        }
    }

    private boolean guardarLogicaCorredores() {
        if (!ficheroOk(ficheroCorredores)) {
            return false;
        } else {
            gestorFicheroCorredores.abrirEscritor(false);
            gestorFicheroCorredores.grabarPrimerObjeto(LogicaCorredor.getInstance());
            gestorFicheroCorredores.cerrarEscritor();
            return true;
        }
    }

    // CSV CORREDORES
    public boolean exportarCorredoresCSV(File ficheroCSVCorredores) {

        // Comprobar si el fichero existe
        if (!ficheroOk(ficheroCSVCorredores)) {
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

    // CSV CARRERA TERMINADA
    public boolean exportarCarreraCSV(File ficheroCSVCarreraTerminada, Carrera carrera) {

        // Comprobar si el fichero existe
        if (!carrera.isCarreraCerrada() || !ficheroOk(ficheroCSVCarreraTerminada)) {
            return false;
        }

        // GESTOR DE FICHERO CSV
        FicheroDeTexto gestorCSVCarrera;
        gestorCSVCarrera = new FicheroDeTexto(ficheroCSVCarreraTerminada);
        gestorCSVCarrera.abrirEscritor(false);

        // CABECERA CARRERA
        gestorCSVCarrera.println("CARRERA: " + carrera.getNombre());
        gestorCSVCarrera.println("FECHA: " + new SimpleDateFormat("dd/MM/yyyy").format(carrera.getFecha()));

        // CABECERA CORREDORES
        gestorCSVCarrera.print("POSICION,");
        for (String nombreAtributo : TiemposCorredor.DATOS) {
            gestorCSVCarrera.print(nombreAtributo + ",");
        }
        gestorCSVCarrera.print("\n");

        // CORREDORES
        Collections.sort(carrera.getListaCorredores());
        int posicion = 1;

        for (TiemposCorredor corredor : carrera.getListaCorredores()) {

            gestorCSVCarrera.print(posicion + "º,");
            for (String atributo : corredor.toArray()) {
                gestorCSVCarrera.print(atributo + ",");
            }
            gestorCSVCarrera.print("\n");
            posicion++;
        }

        gestorCSVCarrera.cerrarEscritor();
        return true;

    }

}
