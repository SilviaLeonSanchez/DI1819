/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import dto.Carrera;
import dto.Corredor;
import dto.TiemposCorredor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import utils.ExcepcionesPropias;

/**
 *
 * @author silvia
 */
public class LogicaCarrera implements Serializable {

    private static LogicaCarrera INSTANCE;

    // ATRIBUTOS
    private List<Carrera> carreras;
    private final String[] opcionesOrdenCarreras = {"Id", "Fecha", "Limite participantes", "Numero participantes"};

    // METODOS
    private LogicaCarrera() {
        this.carreras = new ArrayList<>();
    }

    public static LogicaCarrera getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LogicaCarrera();
        }
        return INSTANCE;
    }

    public static void setInstance(LogicaCarrera logicaCarrera) {
        INSTANCE = logicaCarrera;
    }

    // COLECCION CARRERAS
    public List<Carrera> getCarreras() {
        return carreras;
    }

    public boolean altaCarrera(String nombre, Date fecha, String lugar, int plazas) throws ExcepcionesPropias.CarreraRepetida {
        List<Carrera> carrerasPorId = new ArrayList<>(carreras);
        Collections.sort(carrerasPorId);
        String id = "";
        if (carrerasPorId.isEmpty()) {
            id = "1";
        } else {
            Carrera ultimaCarrera = carrerasPorId.get(carrerasPorId.size() - 1);
            id = Integer.toString(Integer.parseInt(ultimaCarrera.getId()) + 1);
        }
        Carrera c = new Carrera(id, nombre, fecha, lugar, plazas);
        if (!this.carreras.contains(c)) {
            return this.carreras.add(c);
        } else {
            throw new ExcepcionesPropias.CarreraRepetida();
        }
    }

    public boolean bajaCarrera(Carrera carrera) throws ExcepcionesPropias.CarreraNoEsta {
        if (!this.carreras.contains(carrera)) {
            throw new ExcepcionesPropias.CarreraNoEsta();
        }
        return carreras.remove(carrera);
    }

    public boolean modificarCarrera(Carrera c_original, Carrera c_modificada) throws ExcepcionesPropias.CarreraCerrada, ExcepcionesPropias.CarreraNoEsta, ExcepcionesPropias.CarreraRepetida {
        if (c_original.isCarreraCerrada()) {
            throw new ExcepcionesPropias.CarreraCerrada();

        } else if (!carreras.contains(c_original)) {
            throw new ExcepcionesPropias.CarreraNoEsta();

        } else if ((!c_original.equals(c_modificada)) && carreras.contains(c_modificada)) {
            throw new ExcepcionesPropias.CarreraRepetida();
        }
        carreras.remove(c_original);
        carreras.add(c_modificada);
        return true;
    }

    // COLECCION CORREDORES DE CARRERA
    private void checkAddCorredor(Carrera carrera, TiemposCorredor corredor) throws ExcepcionesPropias.CarreraCerrada, ExcepcionesPropias.DemasiadosCorredores, ExcepcionesPropias.CorredorRepetido {
        if (corredor == null) {
            throw new IllegalArgumentException("El corredor no puede ser null");
        } else if (carrera.getListaCorredores().contains(corredor)) {
            throw new ExcepcionesPropias.CorredorRepetido();
        } else if (carrera.isCarreraCerrada()) {
            throw new ExcepcionesPropias.CarreraCerrada();
        } else if (carrera.getListaCorredores().size() >= carrera.getMaxCorredores()) {
            throw new ExcepcionesPropias.DemasiadosCorredores();
        }
    }

    public boolean addCorredor(Carrera carrera, Corredor corredor) throws ExcepcionesPropias.CarreraCerrada, ExcepcionesPropias.DemasiadosCorredores, ExcepcionesPropias.CorredorRepetido {
        List<TiemposCorredor> corredoresPorDorsal = new ArrayList<>(carrera.getListaCorredores());
        Collections.sort(corredoresPorDorsal);
        String dorsal = "";
        if (corredoresPorDorsal.isEmpty()){
            dorsal = "1";
        }else{
            TiemposCorredor ultimoCorredor = corredoresPorDorsal.get(corredoresPorDorsal.size()-1);
            dorsal = Integer.toString(Integer.parseInt(ultimoCorredor.getDorsal())+1);
        }
        TiemposCorredor tiemposCorredor = new TiemposCorredor(carrera.getId(), corredor, dorsal);
        checkAddCorredor(carrera, tiemposCorredor);
        return carrera.aniadirCorredor(tiemposCorredor);
    }

    public boolean addCorredores(Carrera carrera, List<Corredor> corredores) throws ExcepcionesPropias.CarreraCerrada, ExcepcionesPropias.DemasiadosCorredores, ExcepcionesPropias.CorredorRepetido {
        boolean isOk = true;
        for (Corredor corredor : corredores) {
            if (!addCorredor(carrera, corredor)){
                isOk = false;
            }
        }
        return isOk;
    }

    private void checkDelCorredor(Carrera carrera, TiemposCorredor corredor) throws ExcepcionesPropias.CorredorNoEsta, ExcepcionesPropias.CarreraCerrada {
        if (!carrera.getListaCorredores().contains(corredor)) {
            throw new ExcepcionesPropias.CorredorNoEsta();
        } else if (carrera.isCarreraCerrada()) {
            throw new ExcepcionesPropias.CarreraCerrada();
        }
    }

    public boolean delCorredor(Carrera carrera, TiemposCorredor corredor) throws ExcepcionesPropias.CorredorNoEsta, ExcepcionesPropias.CarreraCerrada {
        checkDelCorredor(carrera, corredor);
        return carrera.borrarCorredor(corredor);
    }

    public boolean delCorredores(Carrera carrera, List<TiemposCorredor> corredores) throws ExcepcionesPropias.CorredorNoEsta, ExcepcionesPropias.CarreraCerrada {
        Iterator<TiemposCorredor> it = corredores.iterator();
        while (it.hasNext()) {
            TiemposCorredor corredor = it.next();
            checkDelCorredor(carrera, corredor);
            carrera.borrarCorredor(corredor);
        }
        return true;
    }

    // BORRADO CORREDOR DE TODAS LAS CARRERAS
    public static boolean bajaCorredorCarreras(Corredor corredor) {
        boolean isOk = true;
        Iterator<Carrera> iteratorCarreras = LogicaCarrera.getInstance().getCarreras().iterator();
        while (iteratorCarreras.hasNext()) {
            Carrera carrera = iteratorCarreras.next();
            if (!carrera.isCarreraCerrada() && carrera.contieneCorredor(corredor.getDni())) {
                if (!carrera.borrarCorredor(corredor.getDni())){
                    isOk = false;
                }
            }
        }
        return isOk;
    }

    // ORDENACION    
    public String[] getOpcionesOrdenCarreras() {
        return opcionesOrdenCarreras;
    }

    public void ordenarId() {
        Collections.sort(carreras);
    }

    public void ordenarFecha() {
        this.carreras.sort((Carrera o1, Carrera o2) -> o1.getFecha().compareTo(o2.getFecha()));
    }

    public void ordenarMaxCorredores() {
        this.carreras.sort((Carrera o1, Carrera o2) -> Integer.compare(o1.getMaxCorredores(), o2.getMaxCorredores()));
    }

    public void ordenarNumCorredores() {
        this.carreras.sort((Carrera o1, Carrera o2) -> Integer.compare(o1.getListaCorredores().size(), o2.getListaCorredores().size()));
    }

}
