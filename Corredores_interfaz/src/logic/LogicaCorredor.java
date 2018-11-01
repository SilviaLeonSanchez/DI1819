package logic;

import dto.Corredor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import utils.ExcepcionesPropias;

/**
 *
 * @author silvia
 */
public class LogicaCorredor implements Serializable{

    private static LogicaCorredor INSTANCE;

    // ATRIBUTOS
    private List<Corredor> corredores;
    private final String[] opcionesOrdenCorredores = {"Dni", "Nombre", "Fecha de nacimiento"};

    // METODOS
    private LogicaCorredor(){
        this.corredores = new ArrayList<>();
    }
    
    public static LogicaCorredor getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LogicaCorredor();
        }
        return INSTANCE;
    }
    
    public static void setInstance(LogicaCorredor logicaCorredor) {
        if (logicaCorredor!=null){
            INSTANCE = logicaCorredor;
        }else{
            INSTANCE = new LogicaCorredor();
        }
    }

    // COLECCION
    public List<Corredor> getCorredores() {
        return corredores;
    }
    
    public boolean contieneCorredor(String dni){
        return corredores.stream().anyMatch((corredor) -> (corredor.getDni().equalsIgnoreCase(dni)));
    }

    public Corredor buscarCorredor(Corredor c) {
        return this.corredores.get(this.corredores.indexOf(c));
    }

    public boolean altaCorredor(String dni, String nombre, Date fecha_nac, String dir, String tfn) throws ExcepcionesPropias.CorredorRepetido {
        Corredor c = new Corredor(dni, nombre, fecha_nac, dir, tfn);
        if (!this.corredores.contains(c)) {
            corredores.add(c);
            return true;
        } else {
            throw new ExcepcionesPropias.CorredorRepetido();
        }
    }

    public boolean bajaCorredor(Corredor c) throws ExcepcionesPropias.CorredorNoEsta {
        if (!corredores.contains(c)) {
            throw new ExcepcionesPropias.CorredorNoEsta();
        }
        return corredores.remove(c);
    }
    

    public void modificarCorredor(Corredor c_original, Corredor c_modificado) {
        corredores.remove(c_original);
        corredores.add(c_modificado);
    }


    // ORDENACION    
    public String[] getOpcionesOrdenCorredores() {
        return opcionesOrdenCorredores;
    }

    public void ordenarDni() {
        Collections.sort(this.corredores);
    }

    public void ordenarFechaNac() {
        Collections.sort(corredores, (Corredor o1, Corredor o2) -> o1.getFecha_nac().compareTo(o2.getFecha_nac()));
    }

    public void ordenarNombre() {
        Collections.sort(corredores, (Corredor o1, Corredor o2) -> o1.getNombre().compareTo(o2.getNombre()));
    }

    
    
    
}

