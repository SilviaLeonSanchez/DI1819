package logica;

import modelo.Runner;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author silvia
 */
public class LogicaCorredor {

    // PATRON DE DISEÑO SINGLETON 
    // Para que solo se pueda crear una instancia
    private static LogicaCorredor INSTANCE;

    // Constructor privado
    public static LogicaCorredor getInstance() throws IOException {
        if (INSTANCE == null) {
            return new LogicaCorredor();
        } else {
            return INSTANCE;
        }
    }

    // ATRIBUTOS
    private HashMap<String, Runner> corredores;
    private Fichero_csv fichero_corredores;
    private final String separadorCSV;
    private final String[] opcionesOrdenCorredores = {"Dni", "Nombre", "Fecha de nacimiento"};

    // METODOS
    private LogicaCorredor(File fichero, String separadorCSV) throws IllegalArgumentException {
        if (fichero.exists() & fichero.canRead() & fichero.canWrite()) {
            this.fichero_corredores = new Fichero_csv(fichero);
        } else {
            throw new IllegalArgumentException("El fichero no es valido o no existe.");
        }
        this.separadorCSV = separadorCSV;
        leerCSV();
    }

    private LogicaCorredor() throws IOException {
        this.corredores = new HashMap<>();
        File fichero = new File("fichero_corredores.csv");
        if (!fichero.exists()) {
            fichero.createNewFile();
        }
        this.fichero_corredores = new Fichero_csv(fichero);
        this.separadorCSV = ";";
    }

    // COLECCION
    public List<Runner> getCorredores() {
        return new ArrayList(corredores.values());
    }

    public Runner buscarCorredor(String dni) {
        return this.corredores.get(dni);
    }

    public boolean altaCorredor(String dni, String nombre, Date fecha_nac, String dir, String tfn) {
        if (corredores.containsKey(dni)) {
            return false;
        } else {
            corredores.put(dni, new Runner(dni, nombre, fecha_nac, dir, tfn));
            return true;
        }
    }

    public boolean bajaCorredor(String dni) {
        return !(corredores.remove(dni) == null);
    }

    public boolean modificarDni(Runner c, String nuevo_dni) {
        if (corredores.containsKey(nuevo_dni)) {
            return false;
        } else {
            c.setDni(nuevo_dni);
            return true;
        }
    }

    public void modificarNombre(Runner c, String nuevo_nombre) {
        c.setNombre(nuevo_nombre);
    }

    public void modificarDireccion(Runner c, String nueva_dir) {
        c.setDireccion(nueva_dir);
    }

    public void modificarTfn(Runner c, String nuevo_tfn) {
        c.setTelefono(nuevo_tfn);
    }

    public void modificarFechaNac(Runner c, Date nueva_fecha) {
        c.setFecha_nac(nueva_fecha);
    }

    public void guardarCambios(Runner c, Runner c_modificado) {
        corredores.remove(c.getDni());
        corredores.put(c_modificado.getDni(), c_modificado);
    }

    // FICHERO
    public Runner toRunner(String linea) {
        if (linea == null) {
            throw new IllegalArgumentException("No se puede convertir a string un objeto null");
        }
        StringTokenizer st = new StringTokenizer(linea, this.separadorCSV);
        ArrayList<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy"); // Meses en mayuscular porque sino cree que es minutos
        Runner runner = null;
        try {
            runner = new Runner(tokens.get(0), tokens.get(1),
                    sdf.parse(tokens.get(2)), tokens.get(3), tokens.get(4));
        } catch (ParseException ex) {
            System.out.println("Error al transformar la fecha del fichero");
        }
        return runner;
    }

    public String toStringCSV(Runner corredor) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy"); // Meses en mayuscular porque sino cree que es minutos
        String linea = corredor.getDni() + this.separadorCSV;
        linea += corredor.getNombre() + this.separadorCSV;
        linea += sdf.format(corredor.getFecha_nac()) + this.separadorCSV;
        linea += corredor.getDireccion() + this.separadorCSV;
        linea += corredor.getTelefono() + this.separadorCSV;
        return linea;
    }

    public void leerCSV() {
        this.fichero_corredores.abrirLector();
        String linea = null;
        Runner runner = null;
        while ((linea = this.fichero_corredores.leerString()) != null) {
            runner = toRunner(linea);
            this.corredores.put(runner.getDni(), runner);
        }
        this.fichero_corredores.cerrarLector();
    }

    public void grabarCSV() {
        this.fichero_corredores.abrirEscritor(false);
        for (Runner runner : corredores.values()) {
            fichero_corredores.println(toStringCSV(runner));
        }
        this.fichero_corredores.cerrarEscritor();
    }

    // ORDENACION    
    public String[] getOpcionesOrdenCorredores() {
        return opcionesOrdenCorredores;
    }
    
    public List<Runner> ordenarDni() {
        ArrayList<Runner> lista_ordenada = new ArrayList(corredores.values());
        Collections.sort(lista_ordenada);
        return lista_ordenada;
    }

    public List<Runner> ordenarFechaNac() {
        ArrayList<Runner> lista_ordenada = new ArrayList(corredores.values());
        Collections.sort(lista_ordenada, new Runner.ComparadorFecha());
        return lista_ordenada;
    }

    public List<Runner> ordenarNombre() {
        ArrayList<Runner> lista_ordenada = new ArrayList(corredores.values());
        Collections.sort(lista_ordenada, new Runner.ComparadorNombre());
        return lista_ordenada;
    }
    

}
