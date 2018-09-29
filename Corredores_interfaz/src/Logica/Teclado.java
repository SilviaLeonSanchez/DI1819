package Logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teclado {

    public static String leerString() {
        String cadena = "";
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            cadena = br.readLine();
            return cadena;
        } catch (IOException e) {
            System.out.println("Error al introducir el dato");
            return null;
        }
    }

    public static int leerInt() {
        int numInt = 0;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            numInt = Integer.parseInt(br.readLine());
            return numInt;
        } catch (NumberFormatException | IOException ex) {
            System.out.println("Error al introducir el entero.");
            return Integer.MIN_VALUE;
        }
    }

    public static byte leerByte() {
        byte numByte;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            numByte = Byte.parseByte(br.readLine());
            return numByte;
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error al introducir el número");
            return Byte.MIN_VALUE;
        }
    }
}
