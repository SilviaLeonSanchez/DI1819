/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import dto.Carrera;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import utils.ExcepcionesPropias;

/**
 *
 * @author silvia
 */
public class LogicaCarrera {

    private static LogicaCarrera INSTANCE;

    // ATRIBUTOS
    private List<Carrera> carreras;
    private final String[] opcionesOrdenCarreras = {"Id", "Fecha", "Limite participantes", "Numero participantes"};

    // METODOS
    public LogicaCarrera(){
        this.carreras = new ArrayList<>();
    }
    
    public static LogicaCarrera getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LogicaCarrera();
        }
        return INSTANCE;
    }

    // COLECCION
    public List<Carrera> getCarreras() {
        return carreras;
    }

    public boolean altaCarrera(String nombre, Date fecha, String lugar, int plazas) throws ExcepcionesPropias.CarreraRepetida {
        List<Carrera> carrerasPorId = new ArrayList<>(carreras);
        Collections.sort(carrerasPorId);
        String id = "";
        if(carrerasPorId.isEmpty()){
            id = "1";
        }else{
            Carrera ultimaCarrera = carrerasPorId.get(carrerasPorId.size()-1);
            id = Integer.toString(Integer.parseInt(ultimaCarrera.getId())+1);
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
