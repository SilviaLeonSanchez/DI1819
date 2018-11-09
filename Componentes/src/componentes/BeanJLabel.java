/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author silvia
 */
public class BeanJLabel extends JLabel implements Serializable{
    
    private final String SALUDO = "Hola mundo";
    private String nombre;
    
    private File file;
    private Color color;
    private int integer;
    private float unFloat;
    private String string;
    private boolean boleano;
    private Font fuente;
    private Date fecha;

    public BeanJLabel() {
        setText(SALUDO);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = SALUDO + " " + nombre;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public float getUnFloat() {
        return unFloat;
    }

    public void setUnFloat(float unFloat) {
        this.unFloat = unFloat;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public boolean isBoleano() {
        return boleano;
    }

    public void setBoleano(boolean boleano) {
        this.boleano = boleano;
    }

    public Font getFuente() {
        return fuente;
    }

    public void setFuente(Font fuente) {
        this.fuente = fuente;
    }
    
    
    
}
