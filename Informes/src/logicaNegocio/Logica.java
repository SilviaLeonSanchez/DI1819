package logicaNegocio;

import dto.Carrera;
import dto.Corredor;
import dto.TiemposCorredor;
import java.util.ArrayList;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author silvia
 */
public class Logica {
    
    private Carrera carreraElegida;
    private ArrayList<Corredor> corredores;
    private ArrayList<Carrera> carreras;
    private ArrayList<TiemposCorredor> corredoresApuntadosCarreras;

    public Logica() {
        inicializarListaCorredores();
        inicializarListaCarreras();
        inicializarCorredoresApuntadosCarreras();
    }
    
    private void inicializarListaCorredores(){
        this.corredores = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        
        calendar.set(1999, 0, 5);
        this.corredores.add(new Corredor("11111111A", "Pedro Perez", calendar.getTime(), "Calle de la mar, 3", "654325983"));
        
        calendar.set(1985, 3, 27);
        this.corredores.add(new Corredor("22222222B", "María Martínez", calendar.getTime(), "Calle Castillejos, 5", "695873265"));
        
        calendar.set(1959, 9, 5);
        this.corredores.add(new Corredor("33333333C", "Alvaro Alvarez", calendar.getTime(), "Calle Olivo, 133", "695321942"));
        
        calendar.set(1977, 6, 16);
        this.corredores.add(new Corredor("44444444D", "Daniel Donsanto", calendar.getTime(), "Calle Manuel de Falla, 27", "649315781"));
        
        calendar.set(2001, 5, 22);
        this.corredores.add(new Corredor("55555555E", "Jaime Jimenez", calendar.getTime(), "Calle Lepanto, 1", "695319873"));
        
        calendar.set(1988, 11, 17);
        this.corredores.add(new Corredor("66666666F", "Sara Santaolaya", calendar.getTime(), "Calle Nuestra señora de la esperanza, 39", "669785419"));
        
        calendar.set(1972, 4, 12);
        this.corredores.add(new Corredor("77777777G", "Carmen Cáceres", calendar.getTime(), "Calle Arriondas, 41", "693487214"));
        
        calendar.set(1993, 7, 21);
        this.corredores.add(new Corredor("88888888H", "Tomás Toledo", calendar.getTime(), "Calle General, 10", "698521478"));
        
        calendar.set(1996, 2, 27);
        this.corredores.add(new Corredor("99999999J", "Esperanza Estepa", calendar.getTime(), "Calle de la libertad, 62", "632598652"));
        
        
    }
    
    private void inicializarListaCarreras(){
        this.carreras = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        Carrera carrera;
        
        // CARRERA 1
        calendar.set(2019, 3, 20);
        carrera = new Carrera("MA-036","Maratón de Málaga",calendar.getTime(), "Málaga", 50);
        
        // CORREDORES
        calendar.set(0, 0, 0, 1, 26, 32);
        carrera.aniadirCorredor(new TiemposCorredor("MA-036", this.corredores.get(0), "001", calendar.getTime()));
        calendar.set(0, 0, 0, 1, 44, 01);
        carrera.aniadirCorredor(new TiemposCorredor("MA-036", this.corredores.get(3), "002", calendar.getTime()));
        calendar.set(0, 0, 0, 2, 01, 54);
        carrera.aniadirCorredor(new TiemposCorredor("MA-036", this.corredores.get(4), "003", calendar.getTime()));
        calendar.set(0, 0, 0, 1, 32, 46);
        carrera.aniadirCorredor(new TiemposCorredor("MA-036", this.corredores.get(6), "004", calendar.getTime()));
        
        carrera.cerrarCarrera();
        this.carreras.add(carrera);
        
        
        // CARRERA 2
        calendar.set(2019, 9, 2);
        carrera = new Carrera("SE-025","Maratón de Sevilla",calendar.getTime(), "Sevilla", 200);
        
        // CORREDORES
        carrera.aniadirCorredor(new TiemposCorredor("SE-025", this.corredores.get(1), "005", null));
        carrera.aniadirCorredor(new TiemposCorredor("SE-025", this.corredores.get(5), "006", null));
        this.carreras.add(carrera);
        
        
        // CARRERA 3
        calendar.set(2020, 1, 13);
        carrera = new Carrera("CA-012","Maratón de Castellón",calendar.getTime(), "Castellón", 70);
        
        // CORREDORES
        calendar.set(0, 0, 0, 2, 36, 40);
        carrera.aniadirCorredor(new TiemposCorredor("CA-012", this.corredores.get(8), "007", calendar.getTime()));
        calendar.set(0, 0, 0, 2, 10, 22);
        carrera.aniadirCorredor(new TiemposCorredor("CA-012", this.corredores.get(7), "008", calendar.getTime()));
        calendar.set(0, 0, 0, 1, 59, 54);
        carrera.aniadirCorredor(new TiemposCorredor("CA-012", this.corredores.get(3), "009", calendar.getTime()));
        calendar.set(0, 0, 0, 2, 15, 46);
        carrera.aniadirCorredor(new TiemposCorredor("CA-012", this.corredores.get(2), "010", calendar.getTime()));
        
        carrera.cerrarCarrera();
        this.carreras.add(carrera);
        
        
        // CARRERA 4
        calendar.set(2019, 5, 21);
        carrera = new Carrera("BA-040","Maratón de Barcelona",calendar.getTime(), "Barcelona", 100);
        this.carreras.add(carrera);
        
        
        // CARRERA 5
        calendar.set(2019, 6, 7);
        carrera = new Carrera("M-072","Maratón de Madrid",calendar.getTime(), "Madrid", 220);
        
        // CORREDORES
        carrera.aniadirCorredor(new TiemposCorredor("M-072", this.corredores.get(0), "011", null));
        carrera.aniadirCorredor(new TiemposCorredor("M-072", this.corredores.get(1), "012", null));
        carrera.aniadirCorredor(new TiemposCorredor("M-072", this.corredores.get(7), "013", null));
        
        this.carreras.add(carrera);
        
        
        // CARRERA 6
        calendar.set(2019, 8, 12);
        carrera = new Carrera("ZA-022","Maratón de Zaragoza",calendar.getTime(), "Zaragoza", 360);
        
        // CORREDORES
        calendar.set(0, 0, 0, 0, 56, 20);
        carrera.aniadirCorredor(new TiemposCorredor("ZA-022", this.corredores.get(6), "014", calendar.getTime()));
        calendar.set(0, 0, 0, 1, 10, 29);
        carrera.aniadirCorredor(new TiemposCorredor("ZA-022", this.corredores.get(2), "015", calendar.getTime()));
        calendar.set(0, 0, 0, 1, 2, 33);
        carrera.aniadirCorredor(new TiemposCorredor("ZA-022", this.corredores.get(0), "016", calendar.getTime()));
        
        carrera.cerrarCarrera();
        this.carreras.add(carrera);
        
        
        // CARRERA 7
        calendar.set(2019, 7, 26);
        carrera = new Carrera("SF-033","Maratón de San Fermín",calendar.getTime(), "Pamplona", 120);
        this.carreras.add(carrera);
        
        
        // CARRERA 8
        calendar.set(2019, 02, 15);
        carrera = new Carrera("LA-025","Maratón de Laredo",calendar.getTime(), "Cantabria", 115);
        
        // CORREDORES
        calendar.set(0, 0, 0, 1, 35, 49);
        carrera.aniadirCorredor(new TiemposCorredor("LA-025", this.corredores.get(3), "017", calendar.getTime()));
        calendar.set(0, 0, 0, 1, 19, 38);
        carrera.aniadirCorredor(new TiemposCorredor("LA-025", this.corredores.get(4), "018", calendar.getTime()));
        
        carrera.cerrarCarrera();
        this.carreras.add(carrera);
        
        
        // CARRERA 9
        calendar.set(2019, 10, 6);
        carrera = new Carrera("PM-001","Maratón de Palma",calendar.getTime(), "Malorca", 200);
        
        // CORREDORES
        calendar.set(0, 0, 0, 3, 36, 40);
        carrera.aniadirCorredor(new TiemposCorredor("PM-001", this.corredores.get(2), "019", calendar.getTime()));
        calendar.set(0, 0, 0, 3, 16, 22);
        carrera.aniadirCorredor(new TiemposCorredor("PM-001", this.corredores.get(6), "020", calendar.getTime()));
        calendar.set(0, 0, 0, 3, 20, 54);
        carrera.aniadirCorredor(new TiemposCorredor("PM-001", this.corredores.get(5), "021", calendar.getTime()));
        calendar.set(0, 0, 0, 3, 37, 46);
        carrera.aniadirCorredor(new TiemposCorredor("PM-001", this.corredores.get(1), "022", calendar.getTime()));
        
        carrera.cerrarCarrera();
        this.carreras.add(carrera);
    }

    private void inicializarCorredoresApuntadosCarreras() {
        this.corredoresApuntadosCarreras = new ArrayList<>();
        for (Carrera carrera : carreras) {
            if (carrera.getTotalCorredores() > 0) {
                this.corredoresApuntadosCarreras.addAll(carrera.getListaCorredores());
            }
        }
    }

    public ArrayList<Corredor> getCorredores() {
        return corredores;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public ArrayList<TiemposCorredor> getCorredoresApuntadosCarreras() {
        return corredoresApuntadosCarreras;
    }
    
    public Carrera getCarreraElegida() {
        return carreraElegida;
    }

    public void setCarreraElegida(Carrera carreraElegida) {
        this.carreraElegida = carreraElegida;
    }
    
}
