package utils;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Date;




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

    public static String verDuracionFormatoLargo(Duration duracion) {
        return getHoras(duracion) + " horas  " + getMinutos(duracion) + " minutos  " + getSegundos(duracion) + " segundos  ";
    }
    
    public static String verDuracionFormatoCorto(Duration duracion) {
        return String.format("%02d:%02d:%02d %01d", (int) duracion.toHours(), (int) duracion.toMinutes(), (int) duracion.getSeconds(), (int) duracion.toMillis());
    }
    
    private static int getHoras(Duration duracion){
        return (int) Math.floor(duracion.toHours());
    }
    
    private static int getMinutos(Duration duracion){
        return (int) Math.floor(duracion.toMinutes() - getHoras(duracion) * 60);
    }
    
    private static int getSegundos(Duration duracion){
        return (int) Math.floor(duracion.getSeconds() - getHoras(duracion) * 3600 - getMinutos(duracion) * 60);
    }
    
    public static Duration nuevaDuracion(int minSeg, int maxSeg) {
        return Duration.ofSeconds(minSeg+((int)(Math.random()*(maxSeg-minSeg))));
    }
    

}
