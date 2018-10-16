/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import utils.Utiles;

/**
 *
 * @author silvia
 */
public class Carrera {

    // ATRIBUTOS
    private String id;
    private String nombre;
    private Date fecha;
    private String lugar;
    private int maxCorredores;
    private HashMap<Corredor,TiemposCorredor> listaCorredores;

    private boolean carreraCerrada;
    private int contadorDorsales;
    private static int contadorCarreras;
    public static final String[] DATOS = {"ID", "NOMBRE", "FECHA", "LUGAR", "LIMITE PARTICIPANTES", "CERRADA"};

    //  METODOS
    public Carrera(String nombre, Date fecha, String lugar, int maxCorredores) {
        this.id = Integer.toString(++contadorCarreras);
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.maxCorredores = maxCorredores;
        this.carreraCerrada = false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carrera other = (Carrera) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        String carrera = "Carrera{" + "id=" + id + ", nombre=" + nombre + ", fecha=" + Utiles.Sdf.format(fecha) + ", lugar=" + lugar + ", max_corredores=" + maxCorredores + ", terminada=" + carreraCerrada + '}';
        for (Corredor corredor : listaCorredores.keySet()) {
            carrera = carrera.concat("\t" + corredor.toString() + "\n");
            carrera = carrera.concat(listaCorredores.get(corredor).toString());
        }
        return carrera;
    }

    public String[] toArray() {
        String array[] = new String[6];
        array[0] = this.id;
        array[1] = this.nombre;
        array[2] = Utiles.Sdf.format(this.fecha);
        array[3] = this.lugar;
        array[4] = Integer.toString(this.maxCorredores);
        array[5] = ((this.carreraCerrada) ? ("CERRADA") : ("ABIERTA"));
        return array;
    }

    // SETTER
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMaxCorredores(int maxCorredores) {
        if (maxCorredores <= 0) {
            throw new IllegalArgumentException("El numero máximo de corredores tiene que ser mayor que 0.");
        } else if (maxCorredores < this.listaCorredores.size()) {
            throw new IllegalArgumentException("El numero actual de corredores es mayor. Borra corredores o indica un numero más alto.");
        }
        this.maxCorredores = maxCorredores;
    }

    public void cerrarCarrera() {
        this.carreraCerrada = true;
    }

    // GETTER
    public HashMap<Corredor,TiemposCorredor> getListaCorredores() {
        return listaCorredores;
    }

    public int getMaxCorredores() {
        return maxCorredores;
    }

    public String getLugar() {
        return lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public static int getContadorCarreras() {
        return contadorCarreras;
    }

    public boolean isCarreraCerrada() {
        return carreraCerrada;
    }
    /*
    // CORREDORES
    public boolean addCorredor(Corredor corredor,TiemposCorredor tiempos) throws ExcepcionesPropias.CarreraCerrada, ExcepcionesPropias.DemasiadosCorredores, ExcepcionesPropias.CorredorRepetido {
    if (corredor == null) {
    throw new IllegalArgumentException("El corredor no puede ser null");
    } else if (this.listaCorredores.containsKey(corredor)) {
    throw new ExcepcionesPropias.CorredorRepetido();
    } else if (this.carreraCerrada) {
    throw new ExcepcionesPropias.CarreraCerrada();
    } else if (this.listaCorredores.size() == this.maxCorredores) {
    throw new ExcepcionesPropias.DemasiadosCorredores();
    } else if (this.listaCorredores.(corredor)) {
    this.contadorDorsales++;
    }
    return true;
    }
    
    public boolean delCorredor(Corredor corredor) throws ExcepcionesPropias.CorredorNoEsta, ExcepcionesPropias.CarreraCerrada {
    if (!this.listaCorredores.contains(corredor)) {
    throw new ExcepcionesPropias.CorredorNoEsta();
    } else if (this.carreraCerrada) {
    throw new ExcepcionesPropias.CarreraCerrada();
    } else {
    return this.listaCorredores.remove(corredor);
    }
    }
    
    */
    
    

}
