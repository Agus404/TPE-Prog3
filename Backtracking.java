import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Se busca encontrar la menor combinación de máquinas que produzca una cantidad de piezas determinadas.
// Para ello, en cada llamada recursiva se genera un estado en el que se considerar agregar una máquina a la secuencia, hasta cubrir todas las posibles soluciones.
// Se considera solución a una secuencia si la suma de la producción de sus máquinas es exactamente igual a las piezas requeridas.
// Se guardará solo la solución más corta. Se podarán las secuencias que superen en longitud a la solución actual y las que produzcan más piezas de las requeridas.
// Se llevará la cuenta de la cantidad de llamados recursivos en cantEstadosGenerados.

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

        // Si encontró una solución, comprueba si es la más corta
        if(piezasRequeridas==piezasProducidas){
            // Si es la solución más corta, la guarda como secuencia solución.
            if (secuenciaSolucion.isEmpty() || secuenciaActual.size() < secuenciaSolucion.size()) {
                secuenciaSolucion = new ArrayList<Maquina>(secuenciaActual);
            }
        // Podas. Si la secuencia actual es mayor a la solución alcanzada previamente o si produjo más piezas de las requeridas.
        }else if(!secuenciaSolucion.isEmpty() && secuenciaActual.size() >= secuenciaSolucion.size() || piezasProducidas > piezasRequeridas){
            return;
        }else{
            // Si al sumar la producción de piezas de una máquina no supera las piezas requeridas 
            // se agrega a la secuencia actual y se sigue construyendo la secuencia de forma recursiva
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
            resultado = "Solución obtenida: " + getSecuenciaSolucion() + "\n"  + 
                        "Piezas producidas: " + getPiezasRequeridas() + "\n"  + 
                        "Cantidad de puestas en funcionamiento: " + getSecuenciaSolucion().size();
        }
        return  "Backtracking:" + "\n" + 
                resultado + "\n"  + 
                "Cantidad de estados generados: " + getCantEstadosGenerados() + "\n";
    }
}
