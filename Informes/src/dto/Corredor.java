/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author silvia
 */
public class Corredor {

    // ATRIBUTOS
    private String dni;
    private String nombre;
    private String fecha_nac;
    private String direccion;
    private String telefono;

    // METODOS
    public Corredor(String dni, String nombre, Date fecha_nac, String direccion, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.fecha_nac = (new SimpleDateFormat("dd/MM/yyyy")).format(fecha_nac);
        this.direccion = direccion;
        this.telefono = telefono;
    }


    @Override
    public String toString() {
        return "Corredor{" + "dni=" + dni + ", nombre=" + nombre
                + ", fecha_nacimiento=" + fecha_nac
                + ", direccion=" + direccion + ", telefono=" + telefono + '}';
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


    // GETTER Y SETTER
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
        this.fecha_nac = (new SimpleDateFormat("dd/MM/yyyy")).format(fecha_nac);
    }

    public String getFecha_nac() {
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
