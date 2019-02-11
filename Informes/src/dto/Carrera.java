/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author silvia
 */
public class Carrera implements Comparable<Carrera> {

    // ATRIBUTOS
    private String id;
    private String nombre;
    private String fecha;
    private String lugar;
    private boolean carreraCerrada;

    private int maxCorredores;
    private int totalCorredores;
    private List<TiemposCorredor> listaCorredores;

    //  METODOS
    public Carrera(String id, String nombre, Date fecha, String lugar, int maxCorredores) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = (new SimpleDateFormat("dd/MM/yyyy")).format(fecha);
        this.lugar = lugar;
        this.maxCorredores = maxCorredores;
        this.listaCorredores = new ArrayList<>();
        this.carreraCerrada = false;
    }

    @Override
    public String toString() {
        String string = "Carrera{" + "id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", lugar=" + lugar + ", carreraCerrada=" + carreraCerrada + ", maxCorredores=" + maxCorredores + '}';
        string += "\n\tCorredores{\n";
        for (TiemposCorredor c : listaCorredores) {
            string += "\n\t\t" + c.toString();
        }
        string += "}";
        string += "\n\tTotal corredores=" + totalCorredores;
        return string;
    }

    @Override
    public int compareTo(Carrera o) {
        Integer i = Integer.parseInt(id);
        return i.compareTo(Integer.parseInt(o.getId()));
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

    // SETTER
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setFecha(Date fecha) {
        this.fecha = (new SimpleDateFormat("dd/MM/yyyy")).format(fecha);
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

    public void setTotalCorredores(int totalCorredores) {
        this.totalCorredores = totalCorredores;
    }

    public void cerrarCarrera() {
        this.carreraCerrada = true;
    }

    // GETTER
    public ArrayList<TiemposCorredor> getListaCorredores() {
        return new ArrayList<>(listaCorredores);
    }

    public int getMaxCorredores() {
        return maxCorredores;
    }

    public String getLugar() {
        return lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public int getTotalCorredores() {
        return totalCorredores;
    }

    public boolean isCarreraCerrada() {
        return carreraCerrada;
    }

    // CORREDORES
    public boolean contieneCorredor(String dniCorredor) {
        for (TiemposCorredor corredor : listaCorredores) {
            if (corredor.getDni().equalsIgnoreCase(dniCorredor)) {
                return true;
            }
        }
        return false;
    }

    public boolean aniadirCorredor(TiemposCorredor corredor) {
        if (this.listaCorredores.add(corredor)) {
            this.totalCorredores += 1;
            return true;
        } else {
            return false;
        }
    }

public boolean borrarCorredor(TiemposCorredor corredor) {
        return this.listaCorredores.remove(corredor);
    }

    public boolean borrarCorredor(String dni) {
        if (this.contieneCorredor(dni)) {
            Iterator<TiemposCorredor> iteratorCorredores = listaCorredores.iterator();
            while (iteratorCorredores.hasNext()) {
                TiemposCorredor corredor = iteratorCorredores.next();
                if (corredor.getDni().equalsIgnoreCase(dni)) {
                    return this.listaCorredores.remove(corredor);
                }
            }
        }
        return false;
    }

}
