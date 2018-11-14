/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import utils.Utiles;
import utils.Utiles.Sdf;

/**
 *
 * @author silvia
 */
public class Corredor implements Serializable, Comparable<Corredor>, Cloneable {

    // ATRIBUTOS
    private String dni;
    private String nombre;
    private Date fecha_nac;
    private String direccion;
    private String telefono;
    public static final String[] DATOS = {"DNI", "NOMBRE", "FECHA DE NACIMIENTO", "DIRECCION", "TELEFONO"};

    // METODOS
    public Corredor(String dni, String nombre, Date fecha_nac, String direccion, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    @Override
    public int compareTo(Corredor o) {
        return this.dni.compareToIgnoreCase(o.getDni());
    }

    @Override
    public String toString() {
        return "Corredor{" + "dni=" + dni + ", nombre=" + nombre
                + ", fecha_nacimiento=" + Sdf.format(fecha_nac)
                + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

    public String[] toArray() {
        String array[] = new String[5];
        array[0] = this.dni;
        array[1] = this.nombre;
        array[2] = Utiles.Sdf.format(this.fecha_nac);
        array[3] = this.direccion;
        array[4] = this.telefono;
        return array;
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
        final Corredor other = (Corredor) obj;
        return Objects.equals(this.dni, other.dni);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object clon = null;
        try {
            clon = super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("Error al clonar el corredor");
        }
        return clon;
    }

    // GETTER Y SETTER
    public String[] getCorredor() {
        String[] datos = {this.dni, this.nombre, Sdf.format(this.fecha_nac), this.direccion, this.telefono};
        return datos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public Date getFecha_nac() {
        return this.fecha_nac;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return this.dni;
    }

}
