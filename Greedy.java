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

        //  GREEDY A COMPLETAR
        //  asignar solución a secuenciaSolucion
        //  calcular cantCandidatosConsiderados

    }

    public List<Maquina> getSecuenciaSolucion() {
        return new LinkedList<>(secuenciaSolucion);
    }

    public int getCantCandidatosConsiderados(){
        return cantCandidatosConsiderados;
    }

    public int getPiezasRequeridas() {
        return piezasRequeridas;
    }

    public String toString(){
        String resultado;
        if(secuenciaSolucion.isEmpty()){
            resultado = "No hay solución";
        }else{
            resultado = "Solucion obtenida: " + getSecuenciaSolucion() + "\n"  + 
                        "Piezas producidas: " + getPiezasRequeridas() + "\n"  + 
                        "Cantidad de puestas en funcionamiento: " + getSecuenciaSolucion().size();
        }
        return  "Greedy:" + "\n" + 
                resultado + "\n"  + 
                "Cantidad de candidatos considerados: " + getCantCandidatosConsiderados() + "\n";
    }
}
