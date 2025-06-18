import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Backtracking {
    private List<Maquina> secuenciaActual;
    private List<Maquina> secuenciaSolucion;
    private int cantEstadosGenerados;
    private int piezasRequeridas;

    public Backtracking(int piezasTotales, List<Maquina> maquinas){
        secuenciaActual = new LinkedList<>();
        secuenciaSolucion = new LinkedList<>();
        cantEstadosGenerados = 0;
        piezasRequeridas = piezasTotales;
        this.generarSecuenciaMaquinas(maquinas, 0);
    }

    private void generarSecuenciaMaquinas(List<Maquina> maquinas, int piezasProducidas) {
        cantEstadosGenerados++;
        if(piezasRequeridas==piezasProducidas){
            if (secuenciaSolucion.isEmpty() || secuenciaActual.size() < secuenciaSolucion.size()) {
                secuenciaSolucion = new ArrayList<Maquina>(secuenciaActual);
            }
        }else if(!secuenciaSolucion.isEmpty() && secuenciaActual.size() >= secuenciaSolucion.size() || piezasProducidas > piezasRequeridas){
            return;
        }else{
            for(Maquina m:maquinas) {
                piezasProducidas += m.getPiezas();
                if(piezasProducidas <= piezasRequeridas){
                    secuenciaActual.add(m);
                    generarSecuenciaMaquinas(maquinas,piezasProducidas);
                    secuenciaActual.removeLast();
                }
                piezasProducidas -= m.getPiezas();
	        }
        }
    }

    public List<Maquina> getSecuenciaSolucion() {
        return new LinkedList<>(secuenciaSolucion);
    }

    public int getCantEstadosGenerados(){
        return cantEstadosGenerados;
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
        return  "Backtracking:" + "\n" + 
                resultado + "\n"  + 
                "Cantidad de estados generados: " + getCantEstadosGenerados() + "\n";
    }
}
