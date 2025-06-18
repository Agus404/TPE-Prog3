import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fabrica {

    List<Maquina> maquinas;
    int piezasTotales;

    public Fabrica(String source){
        this.maquinas = new ArrayList<Maquina>();
        this.leerArchivo(source);
    }
    
    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica("data.txt");

        if (fabrica.getPiezasTotales()==0) {
            System.out.println("Error al leer el archivo.");
            return;
        }

        String resultado = fabrica.getPiezasTotales() + "\n";
        for (Maquina m : fabrica.getMaquinas()) 
            resultado += m.toString() + "\n";
        System.out.println(resultado);

        Backtracking backtracking = new Backtracking(fabrica.getPiezasTotales(),fabrica.getMaquinas());
        System.out.println(backtracking);
        Greedy greedy = new Greedy(fabrica.getPiezasTotales(),fabrica.getMaquinas());
        System.out.println(greedy);
    }

    public void leerArchivo(String source){
        try (BufferedReader br = new BufferedReader(new FileReader(source))) {
            String linea;

            if((linea = br.readLine()) != null){
                piezasTotales = Integer.parseInt(linea.trim());
                while ((linea = br.readLine()) != null) {
                    String[] line = linea.split(",");
                    if (line.length == 2) {
                        String nombre = line[0].trim();
                        int piezas = Integer.parseInt(line[1].trim());
                        this.maquinas.add(new Maquina(nombre, piezas));
                    }
                
                }
            }
		} catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Maquina> getMaquinas() {
        return new ArrayList<Maquina>(maquinas);
    }

    public int getPiezasTotales() {
        return piezasTotales;
    }

    
}