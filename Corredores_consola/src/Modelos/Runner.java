/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author silvia
 */
public class Runner implements Comparable<Runner>, Cloneable {

    // ATRIBUTOS
    private String dni;
    private String nombre;
    private Date fecha_nac;
    private String direccion;
    private String telefono;

    // METODOS
    public Runner(String dni, String nombre, Date fecha_nac, String direccion, String telefono) {
        if (dni == null) {
            throw new IllegalArgumentException("El dni no puede ser null");
        } else if (fecha_nac == null) {
            throw new IllegalArgumentException("La fecha no puede ser null");
        }
        this.dni = dni;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    @Override
    public int compareTo(Runner o) {
        return this.dni.compareToIgnoreCase(o.getDni());
    }

    @Override
    public String toString() {
        return "Corredor{" + "dni=" + dni + ", nombre=" + nombre + ", fecha_nacimiento=" + fecha_nac + ", direccion=" + direccion + ", telefono=" + telefono + '}';
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
        final Runner other = (Runner) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public Object clone() {
        Object clon = null;
        try {
            clon = super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("Error al clonar el corredor");
        }
        return clon;
    }

    // GETTER Y SETTER
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setFecha_nac(Date fecha_nac) {
        if (fecha_nac == null) {
            throw new IllegalArgumentException("La fecha no puede ser null");
        }
        this.fecha_nac = fecha_nac;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDni(String dni) {
        if (dni == null) {
            throw new IllegalArgumentException("El dni no puede ser null");
        }
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }
    
    public static class ComparadorFecha implements Comparator<Runner> {

        @Override
        public int compare(Runner o1, Runner o2) {
            return o1.getFecha_nac().compareTo(o2.getFecha_nac());
        }
    }

    public static class ComparadorNombre implements Comparator<Runner> {

        @Override
        public int compare(Runner o1, Runner o2) {
            return o1.getNombre().compareTo(o2.getNombre());
        }
    }

    
}
