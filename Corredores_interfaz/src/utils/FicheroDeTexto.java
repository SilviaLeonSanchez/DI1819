package utils;

import java.io.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Clase que gestiona la transferencia de caracteres hacia o desde un fichero de
 * texto. Hay que abrir el flujo antes y cerrarlo despues de usarlo con sendos
 * metodos. Abre un flujo de caracteres con File(Reader/Writer) que envuelve con
 * un BufferedReader o PrintWriter, segun el metodo sea de lectura o escritura,
 * transformando los caracteres al tipo de dato que devuelve cada metodo con los
 * Wrapper.
 *
 * @author Silvia Leon
 */
public class FicheroDeTexto {

    // ATRIBUTOS
    private File fichero;
    private PrintWriter pw;
    private BufferedReader br;

    // METODOS
    // CONSTRUCTOR    
    /**
     * Crea un objeto de tipo FicheroDeTexto y asigna el parametro al atributo
     * fichero.
     *
     * @param fichero Con este fichero se abrira el flujo de transferencia de
     * caracteres para leer o grabar en el.
     */
    public FicheroDeTexto(File fichero) {
        this.fichero = fichero;
    }

    // ABRIR FICHERO
    /**
     * Abre el flujo para grabar en el fichero. Si el fichero no existe lo crea,
     * si no puede devuelve un mensaje,
     *
     * @param anadir True para escribir la informacion al final de la existente,
     * False para sobrescribir.
     */
    public void abrirEscritor(boolean anadir) {
        try {
            pw = new PrintWriter(new FileWriter(fichero, anadir), true);
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el fichero.");
        } catch (IOException ex) {
            System.out.println("No se pudo acceder al fichero.");
        }
    }

    /**
     * Abre el flujo para leer del fichero situando el puntero en la posicion
     * inicial. Devuelve un mensaje si el fichero no existe.
     */
    public void abrirLector() {
        try {
            br = new BufferedReader(new FileReader(fichero));
        } catch (FileNotFoundException ex) {
            System.out.println("El fichero no existe.");
        }
    }

    /**
     * Cambia el modo de grabacion en el fichero escribiendo la informacion a
     * continuacion de la existente. Muestra un mensaje si no encuentra el
     * fichero o no puede acceder.
     *
     */
    public void anadir() {
        pw.flush();
        pw.close();
        try {
            pw = new PrintWriter(new FileWriter(fichero, true), true);
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el fichero.");
        } catch (IOException ex) {
            System.out.println("No se pudo acceder al fichero.");
        }
    }

    // CIERRA EL FICHERO
    /**
     * Cierra el flujo de escritura abierto con el fichero.
     */
    public void cerrarEscritor() {
        pw.flush();
        pw.close();
    }

    /**
     * Cierra el flujo de lectura abierto con el fichero.
     */
    public void cerrarLector() {
        try {
            br.close();
        } catch (IOException ex) {
            System.out.println("No se ha podido cerrar el fichero.");
        }
    }

    // GRABAR
    /**
     * Graba en el fichero el valor del int introducido correspondiente a su
     * valor en AscII. Si no puede grabarlo muestra un mensaje de error.
     *
     * @param ascii El valor int del caracter en AscII que se quiere grabar en
     * el fichero.
     */
    public void printAscii(int ascii) {
        pw.write(ascii);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del String introducido. Si
     * no puede grabarlo muestra un mensaje de error.
     *
     * @param x El String que se quiere grabar en el fichero.
     */
    public void print(String x) {
        pw.print(x);
        pw.flush();
    }

    /**
     * Graba como caracter en el fichero el valor del char introducido. Si no
     * puede grabarlo muestra un mensaje de error.
     *
     * @param x El char que se quiere grabar en el fichero.
     */
    public void print(char x) {
        pw.print(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del double introducido. Si
     * no puede grabarlo muestra un mensaje de .
     *
     * @param x El double que se quiere grabar en el fichero.
     */
    public void print(double x) {
        pw.print(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del float introducido. Si no
     * puede grabarlo muestra un mensaje de error.
     *
     * @param x El float que se quiere grabar en el fichero.
     */
    public void print(float x) {
        pw.print(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del long introducido. Si no
     * puede grabarlo muestra un mensaje de error.
     *
     * @param x El long que se quiere grabar en el fichero.
     */
    public void print(long x) {
        pw.print(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del int introducido. Si no
     * puede grabarlo muestra un mensaje de error.
     *
     * @param x El int que se quiere grabar en el fichero.
     */
    public void print(int x) {
        pw.print(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del short introducido. Si no
     * puede grabarlo muestra un mensaje de error.
     *
     * @param x El short que se quiere grabar en el fichero.
     */
    public void print(short x) {
        pw.print(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del byte introducido. Si no
     * puede grabarlo muestra un mensaje de error.
     *
     * @param x El byte que se quiere grabar en el fichero.
     */
    public void print(byte x) {
        pw.print(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del boolean introducido. Si
     * no puede grabarlo muestra un mensaje de error.
     *
     * @param x El boolean que se quiere grabar en el fichero.
     */
    public void print(boolean x) {
        pw.print(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del String introducido y
     * despues salta de linea. Si no puede grabarlo muestra un mensaje de error.
     *
     * @param x El String que se quiere grabar en el fichero.
     */
    public void println(String x) {
        pw.println(x);
        pw.flush();
    }

    /**
     * Graba como caracter en el fichero el valor del char introducido y despues
     * salta de linea. Si no puede grabarlo muestra un mensaje de error.
     *
     * @param x El char que se quiere grabar en el fichero.
     */
    public void println(char x) {
        pw.println(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del double introducido y
     * despues salta de linea. Si no puede grabarlo muestra un mensaje de .
     *
     * @param x El double que se quiere grabar en el fichero.
     */
    public void println(double x) {
        pw.println(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del float introducido y
     * despues salta de linea. Si no puede grabarlo muestra un mensaje de error.
     *
     * @param x El float que se quiere grabar en el fichero.
     */
    public void println(float x) {
        pw.println(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del long introducido y
     * despues salta de linea. Si no puede grabarlo muestra un mensaje de error.
     *
     * @param x El long que se quiere grabar en el fichero.
     */
    public void println(long x) {
        pw.println(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del int introducido y
     * despues salta de linea. Si no puede grabarlo muestra un mensaje de error.
     *
     * @param x El int que se quiere grabar en el fichero.
     */
    public void println(int x) {
        pw.println(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del short introducido y
     * despues salta de linea. Si no puede grabarlo muestra un mensaje de error.
     *
     * @param x El short que se quiere grabar en el fichero.
     */
    public void println(short x) {
        pw.println(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del byte introducido y
     * despues salta de linea. Si no puede grabarlo muestra un mensaje de error.
     *
     * @param x El byte que se quiere grabar en el fichero.
     */
    public void println(byte x) {
        pw.println(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del boolean introducido y
     * despues salta de linea. Si no puede grabarlo muestra un mensaje de error.
     *
     * @param x El boolean que se quiere grabar en el fichero.
     */
    public void println(boolean x) {
        pw.println(x);
        pw.flush();
    }

    // LEER
    /**
     * Lee todas las lineas de un fichero CSV y devuelve cuantas hay.
     *
     * @return El int cuyo valor es el numero de lineas que ha encontrado en el
     * fichero.
     */
    public int contarFilasFichero() {
        abrirLector();
        int contador = 0;
        while (leerString() != null) {
            contador++;
        }
        cerrarLector();
        return contador;
    }

    /**
     * Lee una linea del fichero y la devuelve. Si llega al final de fichero o
     * tiene un error devuelve null y muestra un mensaje.
     *
     * @return El String que ha leido del fichero.
     */
    public String leerString() {
        String linea = "";
        try {
            linea = br.readLine();
            return linea;
        } catch (IOException ex) {
            System.out.println("Error al leer la linea del fichero.");
            return null;
        }
    }

    /**
     * Lee un unico char del fichero y lo devuelve. Si llega al fin del fichero
     * o tiene un error devuelve '\0' y muestra un mensaje.
     *
     * @return El valor del char que ha leido del fichero.
     */
    public char leerChar() {
        char c;
        try {
            c = (char) br.read();
            return c;
        } catch (IOException e) {
            System.out.println("Error al leer el caracter.");
            return '\0';
        }
    }

    /**
     * Lee una linea completa del fichero que contenga int y lo devuelve. Si
     * llega al fin del fichero o tiene un error devuelve el MIN_VALUE de
     * Integer y muestra un mensaje.
     *
     * @return El valor del int que ha leido del fichero.
     */
    public int leerInt() {
        int num;
        try {
            num = Integer.parseInt(br.readLine());
            return num;
        } catch (NumberFormatException | IOException ex) {
            System.out.println("Error al leer el entero.");
            return Integer.MIN_VALUE;
        }
    }

    /**
     * Lee una linea completa del fichero que contenga short y lo devuelve. Si
     * llega al fin del fichero o tiene un error devuelve el MIN_VALUE de Short
     * y muestra un mensaje.
     *
     * @return El valor del short que ha leido del fichero.
     */
    public short leerShort() {
        short numShort;
        try {
            numShort = Short.parseShort(br.readLine());
            return numShort;
        } catch (NumberFormatException | IOException ex) {
            System.out.println("Error al leer el número.");
            return Short.MIN_VALUE;
        }
    }

    /**
     * Lee a linea completa del fichero que contenga byte y lo devuelve. Si
     * llega al fin del fichero o tiene un error devuelve el MIN_VALUE de Byte y
     * muestra un mensaje.
     *
     * @return El valor del byte que ha leido del fichero.
     */
    public byte leerByte() {
        byte numByte;
        try {
            numByte = Byte.parseByte(br.readLine());
            return numByte;
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error al leer el número");
            return Byte.MIN_VALUE;
        }
    }

    /**
     * Lee una linea completa del fichero que contenga long y lo devuelve. Si
     * llega al fin del fichero o tiene un error devuelve el MIN_VALUE de Long y
     * muestra un mensaje.
     *
     * @return El valor del long que ha leido del fichero.
     */
    public long leerLong() {
        long numLong;
        try {
            numLong = Long.parseLong(br.readLine());
            return numLong;
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error al leer el número");
            return Long.MIN_VALUE;
        }
    }

    /**
     * Lee una linea completa del fichero que contenga float y lo devuelve. Si
     * llega al fin del fichero o tiene un error devuelve el MIN_VALUE de Float
     * y muestra un mensaje.
     *
     * @return El valor del float que ha leido del fichero.
     */
    public float leerFloat() {
        float numFloat = 0;
        try {
            numFloat = Float.parseFloat(br.readLine());
            return numFloat;
        } catch (NumberFormatException | IOException ex) {
            System.out.println("Error al leer el número.");
            return Float.MIN_VALUE;
        }
    }

    /**
     * Lee una linea completa del fichero que contenga double y lo devuelve. Si
     * llega al fin del fichero o tiene un error devuelve el MIN_VALUE de Double
     * y muestra un mensaje.
     *
     * @return El valor del double que ha leido del fichero.
     */
    public double leerDouble() {
        double numDouble = 0;
        try {
            numDouble = Double.parseDouble(br.readLine());
            return numDouble;
        } catch (NumberFormatException | IOException ex) {
            System.out.println("Error al leer el número.");
            return Double.MIN_VALUE;
        }
    }

    // ARRAYS
    public String[][] guardarCSVEnArrayDePosicionesVariables(String separadorTokens) {
        String[][] array;
        array = new String[contarFilasFichero()][];
        StringTokenizer token;
        abrirLector();
        for (int fila = 0; fila < array.length; fila++) {
            token = new StringTokenizer(leerString(), separadorTokens);
            array[fila] = new String[token.countTokens()];
            for (int posicion = 0; posicion < array[fila].length; posicion++) {
                array[fila][posicion] = token.nextToken();
            }
        }
        cerrarLector();
        return array;
    }

    /**
     * Lee el contenido de un fichero CSV guardando en una coleccion de tipo
     * List el contenido de cada linea en el orden en el que lo va leyendo.
     *
     * @return de tipo LinkedList, que contiene un String con cada linea del
     * fichero en cada posicion.
     */
    public List guardarLineasCSVEnColeccion() {
        LinkedList coleccion = new LinkedList();
        abrirLector();
        String linea;
        while ((linea = leerString()) != null) {
            coleccion.add(linea);
        }
        cerrarLector();
        return coleccion;
    }

    /**
     * Lee el fichero CSV guardando cada elemento de cada linea en una posicion
     * de la coleccion, eliminando los espacios alrededor del elemento para
     * facilitar la futura conversion de String a otro tipo de dato.
     *
     * @param separador de tipo String, conjunto de caracteres que se utiliza en
     * el fichero CSV para separar cada elemento de la linea.
     * @return de tipo LinkedList, que contiene todos los elementos del fichero
     * guardados como String.
     */
    public List guardarTokensCSVEnColeccion(String separador) {
        LinkedList coleccion = new LinkedList();
        abrirLector();
        String linea;
        while ((linea = leerString()) != null) {
            StringTokenizer tokenizador = new StringTokenizer(linea, separador);
            while (tokenizador.hasMoreTokens()) {
                coleccion.add(tokenizador.nextToken().trim());
            }
        }
        cerrarLector();
        return coleccion;
    }

    public boolean guardarColeccionEnCSV(Collection coleccion, String separador, int elementosPorLinea) {
        int contador = 0;
        for (Object objeto : coleccion) {
            print(objeto.toString() + separador);
            contador++;
            if ((contador % elementosPorLinea) == 0) {
                print("\n");
            }
        }
        return false;
    }

}
