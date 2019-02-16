/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author silvia
 */
public class TiemposCorredor {

    // ATRIBUTOS
    private final String idCarrera;
    private final String dorsal;
    private String tiempo;
    private long tiempoParaComparar;
    
    private String dni;
    private String nombre;
    private String fecha_nac;
    private String direccion;
    private String telefono;
    
    // METODOS
    public TiemposCorredor(String idCarrera, Corredor corredor, String dorsal, Date tiempo) {
        this.idCarrera = idCarrera;
        this.dorsal = dorsal;
        this.tiempo = (tiempo != null)? (new SimpleDateFormat("hh:mm:ss")).format(tiempo) : "Sin tiempo";
        this.tiempoParaComparar = (tiempo != null)? tiempo.getTime() : 0;
        this.dni =  corredor.getDni();
        this.nombre = corredor.getNombre();
        this.fecha_nac = corredor.getFecha_nac();
        this.direccion = corredor.getDireccion();
        this.telefono = corredor.getTelefono();
    }

    public long getTiempoParaComparar() {
        return tiempoParaComparar;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    // GETTER
    public String getTiempo() {
        return tiempo;
    }

    public String getDorsal() {
        return dorsal;
    }

    public String getIdCarrera() {
        return idCarrera;
    }


    // SETTER
    public void setTiempo(Date tiempo) {
        this.tiempo = (new SimpleDateFormat("hh:mm:ss")).format(tiempo);
    }

    
    
    
}
