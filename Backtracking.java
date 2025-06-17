import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Backtracking {
    private List<Maquina> secuenciaActual;
    private List<Maquina> secuenciaSolucion;
    private int cantEstadosGenerados;

    public Backtracking(int piezasTotales, List<Maquina> maquinas){
        secuenciaActual = new LinkedList<>();
        secuenciaSolucion = new LinkedList<>();
        cantEstadosGenerados = 0;
        this.generarSecuenciaMaquinas(piezasTotales, maquinas, 0);
    }

    private void generarSecuenciaMaquinas(int piezasRequeridas, List<Maquina> maquinas, int piezasProducidas) {
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
                    generarSecuenciaMaquinas(piezasRequeridas,maquinas,piezasProducidas);
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

    public String toString(){
        return  "Backtracking:" + "\n" + 
                "Solucion obtenida: " + getSecuenciaSolucion() + "\n"  + 
                "Cantidad de puestas en funcionamiento: " + getSecuenciaSolucion().size() + "\n"  + 
                "Cantidad de estados generados: " + getCantEstadosGenerados();
    }
}
