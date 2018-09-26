/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelos.Runner;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author silvia
 */
public class LogicaAplicacion {

    // ATRIBUTOS
    private HashMap<String, Runner> corredores;
    private Fichero_csv fichero_corredores;
    private String separador;

    // METODOS
    public LogicaAplicacion(File fichero, String separador) {
        if (fichero.exists() & fichero.canRead() & fichero.canWrite()) {
            this.fichero_corredores = new Fichero_csv(fichero);
        } else {
            throw new IllegalArgumentException("El fichero no es valido o no existe.");
        }
        this.separador = separador;
        //volcar_de_csv();
    }

    public LogicaAplicacion() throws IOException {
        this.corredores = new HashMap<>();
        File fichero = new File("fichero_corredores.csv");
        fichero.createNewFile();
        this.fichero_corredores = new Fichero_csv(fichero);
        this.separador = ";";
    }

    // COLECCION
    public List<Runner> getCorredores() {
        return new ArrayList(corredores.values());
    }

    public Runner buscar_corredor(String dni) {
        return this.corredores.get(dni);
    }

    public boolean alta_corredor(String dni, String nombre, Date fecha_nac, String dir, String tfn) {
        if (corredores.containsKey(dni)) {
            return false;
        } else {
            corredores.put(dni, new Runner(dni, nombre, fecha_nac, dir, tfn));
            return true;
        }
    }

    public boolean baja_corredor(String dni) {
        return !(corredores.remove(dni) == null);
    }

    public boolean modificar_dni(Runner c, String nuevo_dni) {
        if (corredores.containsKey(nuevo_dni)) {
            return false;
        } else {
            c.setDni(nuevo_dni);
            return true;
        }
    }

    public void modificar_nombre(Runner c, String nuevo_nombre) {
        c.setNombre(nuevo_nombre);
    }

    public void modificar_direccion(Runner c, String nueva_dir) {
        c.setDireccion(nueva_dir);
    }

    public void modificar_tfn(Runner c, String nuevo_tfn) {
        c.setTelefono(nuevo_tfn);
    }

    public void modificar_fecha_nac(Runner c, Date nueva_fecha) {
        c.setFecha_nac(nueva_fecha);
    }

    public void guardar_cambios(Runner c, Runner c_modificado) {
        corredores.remove(c.getDni());
        corredores.put(c_modificado.getDni(), c_modificado);
    }

    // FICHERO
    public Runner linea_a_runner(String linea) {
        if (linea == null) {
            throw new IllegalArgumentException("No se puede convertir a string un objeto null");
        }
        StringTokenizer st = new StringTokenizer(linea, this.separador);
        ArrayList<String> tk = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tk.add(st.nextToken());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy");
        Runner c = null;
        try {
            c = new Runner(tk.get(0), tk.get(1),
                    sdf.parse(tk.get(2)), tk.get(3), tk.get(4));
        } catch (ParseException ex) {
            System.out.println("Error al transformar la fecha del fichero");
        }
        return c;
    }

    public String runner_a_linea(Runner corredor) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy");
        String linea = corredor.getDni() + this.separador;
        linea += corredor.getNombre() + this.separador;
        linea += sdf.format(corredor.getFecha_nac()) + this.separador;
        linea += corredor.getDireccion() + this.separador;
        linea += corredor.getTelefono() + this.separador;
        return linea;
    }

    public void volcar_de_csv() {
        this.fichero_corredores.abrirLector();
        String linea = "";
        Runner r = null;
        while ((linea = this.fichero_corredores.leerString()) != null) {
            r = linea_a_runner(linea);
            this.corredores.put(r.getDni(), r);
        }
        this.fichero_corredores.cerrarLector();
    }

    public void volcar_a_csv() {
        this.fichero_corredores.abrirEscritor(false);
        for (Runner r : corredores.values()) {
            fichero_corredores.println(runner_a_linea(r));
        }
        this.fichero_corredores.cerrarEscritor();
    }

}
