package utils;

import java.time.Duration;




/**
 *
 * @author silvia
 */
public class Duracion {

    public static double segundosEntre(Duration duracion1, Duration duracion2) {
        return duracion2.getSeconds() - duracion1.getSeconds();
    }

    public static double minutosEntre(Duration duracion1, Duration duracion2) {
        return duracion2.toMinutes() - duracion1.toMinutes();
    }

    public static double horasEntre(Duration duracion1, Duration duracion2) {
        return duracion2.toHours() - duracion1.toHours();
    }

    public static String verDuracion(Duration duracion) {
        int horas = (int) Math.floor(duracion.toHours());
        int minutos = (int) Math.floor(duracion.toMinutes() - horas * 60);
        int segundos = (int) Math.floor(duracion.getSeconds() - horas * 3600 - minutos * 60);

        return horas + " h  " + minutos + " min  " + segundos + " seg  ";
    }
    
    public static Duration nuevaDuracion(int minSeg, int maxSeg) {
        return Duration.ofSeconds(minSeg+((int)(Math.random()*(maxSeg-minSeg))));
    }

}
