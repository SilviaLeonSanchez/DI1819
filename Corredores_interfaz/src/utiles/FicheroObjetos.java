package utiles;

import java.io.*;

/**
 * Clase que gestiona la transferencia de objetos hacia o desde un fichero de
 * bytes. Hay que abrir el flujo antes y cerrarlo despues de usarlo con sendos
 * metodos. Abre un flujo de bytes con File(Input/Output)Stream que envuelve con
 * un Object(Input/Output)Stream, segun el metodo sea de lectura o escritura,
 * transformando los bytes a objetos de tipo Object.
 *
 * @author erizo
 */
public class FicheroObjetos<T extends Object> {

    // ATRIBUTOS
    private File fichero;
    private ObjectInputStream ois;
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private AddOOS addoos;

    // METODOS
    //CONSTRUCTOR
    /**
     * Crea un objeto de tipo FicheroDeObjetos y asigna el parametro al atributo
     * fichero.
     *
     * @param fichero Con este fichero se abrira el flujo de transferencia de
     * objetos para leer o grabar en el.
     */
    public FicheroObjetos(File fichero) {
        this.fichero = fichero;
    }

    // ABRIR FICHERO
    /**
     * Abre el flujo para leer del fichero situando el puntero en la posicion
     * inicial. Devuelve un mensaje si el fichero no existe, o si no ha podido
     * acceder a el.
     */
    public void abrirLector() {
        try {
            ois = new ObjectInputStream(new FileInputStream(fichero));
        } catch (FileNotFoundException ex) {
            System.out.println("El fichero no existe.");
        } catch (IOException ex) {
            System.out.println("Error al abrir el fichero: " + ex.getMessage());
        }
    }

    /**
     * Abre el flujo para grabar en el fichero. Si no puede devuelve un mensaje
     *
     * @param anadir True para escribir el objeto al final de los existentes,
     * False para sobrescribir.
     */
    public void abrirEscritor(boolean anadir) {
        try {
            fos = new FileOutputStream(fichero, anadir);
            oos = new ObjectOutputStream(fos);
            addoos = new AddOOS(fos);
        } catch (FileNotFoundException ex) {
            System.out.println("El fichero no existe.");
        } catch (IOException ex) {
            System.out.println("Error al abrir el fichero: " + fichero.getName());
        }
    }

    // CERRAR FICHERO
    /**
     * Cierra el flujo de lectura abierto con el fichero.
     */
    public void cerrarLector() {
        try {
            ois.close();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero.");
        }
    }

    /**
     * Cierra el flujo de escritura abierto con el fichero.
     */
    public void cerrarEscritor() {
        try {
            fos.close();
            oos.close();
            addoos.close();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero.");
        }
    }

    //  LEER
    /**
     * Lee un objeto del fichero y lo devuelve. Si no ha podido acceder a la
     * clase, muestra un mensaje. Devuelve null en este caso y tambien si llega
     * a final de fichero o no ha podido leer correctamente.
     *
     * @return El objeto de tipo Object que ha leido del fichero.
     */
    public T leerObjeto() {
        try {
            return (T) ois.readObject();
        } catch (ClassNotFoundException ex) {
            System.out.println("No se ha encontrado la clase");
            return null;
        } catch (EOFException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    // GRABAR
    /**
     * Graba el primer objeto en un fichero junto con la cabecera del fichero.
     * Los siguientes objetos que se quieran almacenar con grabarObjeto() tienen
     * que ser de la misma clase.
     *
     * @param x El objeto que se quiere grabar en el fichero que puede ser de
     * cualquier clase (que herede de Object)
     */
    public void grabarPrimerObjeto(T x) {
        try {
            oos.writeObject(x);
        } catch (IOException ex) {
            System.out.println("Error al grabar el objeto: " + ex.getMessage());
        }
    }

    /**
     * Graba objetos en el fichero, pero no graba la cabecera del mismo, por lo
     * que previamente se ha de grabar el primer objeto con
     * grabarPrimerObjeto().
     *
     * @param x El objeto que se quiere grabar en el fichero que puede ser de
     * cualquier clase (que herede de Object)
     */
    public void grabarObjeto(T x) {
        try {
            addoos.writeObject(x);
        } catch (IOException ex) {
            System.out.println("Error al grabar el objeto: " + ex.getMessage());
        }
    }

    /**
     * Transfiere todos los objetos de un fichero a otro de una sola vez,
     * creando su propio lector y escritor y cerrandolos al final.
     *
     * @param entrada Fichero del que vamos a leer los objetos para
     * transferirlos al fichero salida.
     * @param salida Fichero en el que vamos a grabar los objetos que se lean
     * del fichero entrada
     */
    public void TransferirObjetos(File entrada, File salida) {
        FicheroObjetos<T> lector = new FicheroObjetos<>(entrada);
        lector.abrirLector();
        FicheroObjetos<T> escritor = new FicheroObjetos<>(salida);
        escritor.abrirEscritor(false);
        T ob = lector.leerObjeto();
        if (ob != null) {
            escritor.grabarPrimerObjeto(ob);
            while ((ob = lector.leerObjeto()) != null) {
                escritor.grabarObjeto(ob);
            }
        }
        lector.cerrarLector();
        escritor.cerrarEscritor();
    }

    /**
     * Clase que hereda de ObjectOutputStream y realiza las mismas funciones con
     * la salvedad de que al grabar objetos no graba la cabecera del fichero.
     *
     * @author Silvia Leon
     */
    public class AddOOS extends ObjectOutputStream {

        /**
         * Constructor de la clase que crea un objeto de tipo AddOOS.
         *
         * @param out Objeto de tipo OutputStream a traves del cual se va a
         * abrir el flujo de salida hacia el fichero.
         * @throws IOException
         */
        public AddOOS(OutputStream out) throws IOException {
            super(out);
        }

        /**
         * Constructor de la clase que crea un objeto de tipo AddOOS.
         *
         * @throws IOException
         */
        public AddOOS() throws IOException {
            super();
        }

        /**
         *
         * @throws IOException
         */
        @Override
        protected void writeStreamHeader() throws IOException {

        }
    }

}
