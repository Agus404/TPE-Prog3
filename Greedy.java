import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Greedy {
    private List<Maquina> secuenciaActual;
    private List<Maquina> secuenciaSolucion;
    private int cantCandidatosConsiderados;
    private int piezasRequeridas;

    public Greedy(int piezasTotales, List<Maquina> maquinas){
        secuenciaActual = new LinkedList<>();
        secuenciaSolucion = new LinkedList<>();
        cantCandidatosConsiderados = 0;
        piezasRequeridas = piezasTotales;
        // maquinas.sort() ???
        this.generarSecuenciaMaquinas(maquinas, 0);
    }

    private void generarSecuenciaMaquinas(List<Maquina> maquinas, int piezasProducidas) {
        
        //
        //  GREEDY A COMPLETAR
        //

    }

    public List<Maquina> getSecuenciaSolucion() {
        return new LinkedList<>(secuenciaSolucion);
    }

    public int getCantCandidatosConsiderados(){
        return cantCandidatosConsiderados;
    }

    public String toString(){
        return  "Greedy:" + "\n" + 
                "Solucion obtenida: " + getSecuenciaSolucion() + "\n"  + 
                "Piezas producidas: " + piezasRequeridas + "\n"  + 
                "Cantidad de puestas en funcionamiento: " + getSecuenciaSolucion().size() + "\n"  + 
                "Cantidad de candidatos considerados: " + getCantCandidatosConsiderados() + "\n";
    }
}
