package logica;

import utiles.FicheroTexto;
import modelo.Corredor;
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
import utiles.ExcepcionesPropias;

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
            INSTANCE = new LogicaCorredor();
        }
        return INSTANCE;
    }

    // ATRIBUTOS
    private HashMap<String, Corredor> corredores;
    private FicheroTexto fichero_corredores;
    private final String separadorCSV;
    private final String[] opcionesOrdenCorredores = {"Dni", "Nombre", "Fecha de nacimiento"};

    // METODOS
    private LogicaCorredor(File fichero, String separadorCSV, boolean usarFichero) throws IllegalArgumentException {
        if (fichero.exists() & fichero.canRead() & fichero.canWrite()) {
            this.fichero_corredores = new FicheroTexto(fichero);
        } else {
            throw new IllegalArgumentException("El fichero no es valido o no existe.");
        }
        this.separadorCSV = separadorCSV;
        leerCorredores(usarFichero);
    }

    private LogicaCorredor() throws IOException {
        this.corredores = new HashMap<>();
        File fichero = new File("fichero_corredores.csv");
        if (!fichero.exists()) {
            fichero.createNewFile();
        }
        this.fichero_corredores = new FicheroTexto(fichero);
        this.separadorCSV = ";";
        leerCorredores(true);
    }

    // COLECCION
    public List<Corredor> getCorredores() {
        return new ArrayList(corredores.values());
    }

    public Corredor buscarCorredor(String dni) {
        return this.corredores.get(dni);
    }

    public boolean altaCorredor(String dni, String nombre, Date fecha_nac, String dir, String tfn) throws ExcepcionesPropias.CorredorRepetido {
        if (corredores.putIfAbsent(dni, new Corredor(dni, nombre, fecha_nac, dir, tfn)) == null) {
            return true;
        } else {
            throw new ExcepcionesPropias.CorredorRepetido();
        }
    }

    public boolean bajaCorredor(String dni) throws ExcepcionesPropias.CorredorNoEsta {
        if (!corredores.containsKey(dni)) {
            throw new ExcepcionesPropias.CorredorNoEsta();
        }
        return !(corredores.remove(dni) == null);
    }

    public boolean modificarCorredor(Corredor c_original, Corredor c_modificado) throws ExcepcionesPropias.CorredorRepetido, ExcepcionesPropias.CorredorNoEsta {
        if (!corredores.containsKey(c_original)){
            throw new ExcepcionesPropias.CorredorNoEsta();
        }else if (c_original.equals(c_modificado)) {
            return corredores.replace(c_original.getDni(), c_original, c_modificado);
        }else if (corredores.containsKey(c_modificado.getDni())){
            throw new ExcepcionesPropias.CorredorRepetido();
        }else{
            corredores.remove(c_original);
            return (corredores.put(c_modificado.getDni(), c_modificado) == null);
        }
    }
    
    // PERSISTENCIA
    public void guardarCorredores(boolean usarFichero){
        if (usarFichero){
            guardarCSV();
        }else{
            // BASE DE DATOS
        }
    }
    
    public void leerCorredores(boolean usarFichero){
        if (usarFichero){
            leerCSV();
        }else{
            // BASE DE DATOS
        }
    }
    
    // FICHERO
    private Corredor toRunner(String linea) {
        if (linea == null) {
            throw new IllegalArgumentException("No se puede convertir a string un objeto null");
        }
        StringTokenizer st = new StringTokenizer(linea, this.separadorCSV);
        ArrayList<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy"); // Meses en mayuscular porque sino cree que es minutos
        Corredor runner = null;
        try {
            runner = new Corredor(tokens.get(0), tokens.get(1),
                    sdf.parse(tokens.get(2)), tokens.get(3), tokens.get(4));
        } catch (ParseException ex) {
            System.out.println("Error al transformar la fecha del fichero");
        }
        return runner;
    }

    private String toStringCSV(Corredor corredor) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy"); // Meses en mayuscular porque sino cree que es minutos
        String linea = corredor.getDni() + this.separadorCSV;
        linea += corredor.getNombre() + this.separadorCSV;
        linea += sdf.format(corredor.getFecha_nac()) + this.separadorCSV;
        linea += corredor.getDireccion() + this.separadorCSV;
        linea += corredor.getTelefono() + this.separadorCSV;
        return linea;
    }

    private void leerCSV() {
        this.fichero_corredores.abrirLector();
        String linea = null;
        Corredor runner = null;
        while ((linea = this.fichero_corredores.leerString()) != null) {
            runner = toRunner(linea);
            this.corredores.put(runner.getDni(), runner);
        }
        this.fichero_corredores.cerrarLector();
    }

    private void guardarCSV() {
        this.fichero_corredores.abrirEscritor(true);
        for (Corredor runner : corredores.values()) {
            fichero_corredores.println(toStringCSV(runner));
        }
        this.fichero_corredores.cerrarEscritor();
    }
    
    // BBDD
    

    // ORDENACION    
    public String[] getOpcionesOrdenCorredores() {
        return opcionesOrdenCorredores;
    }

    public List<Corredor> ordenarDni() {
        ArrayList<Corredor> lista_ordenada = new ArrayList(corredores.values());
        Collections.sort(lista_ordenada);
        return lista_ordenada;
    }

    public List<Corredor> ordenarFechaNac() {
        ArrayList<Corredor> lista_ordenada = new ArrayList(corredores.values());
        Collections.sort(lista_ordenada, (Corredor c1, Corredor c2) -> c1.getFecha_nac().compareTo(c2.getFecha_nac()));
        return lista_ordenada;
    }

    public List<Corredor> ordenarNombre() {
        ArrayList<Corredor> lista_ordenada = new ArrayList(corredores.values());
        Collections.sort(lista_ordenada, (Corredor c1, Corredor c2) -> c1.getNombre().compareToIgnoreCase(c2.getNombre()));
        return lista_ordenada;
    }

}
