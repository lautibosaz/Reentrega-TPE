import java.util.ArrayList;
import java.util.List;

public class Solucion {
    List<Maquina> maquinas;
    int piezasTotales;

    public Solucion() {
        this.maquinas = new ArrayList<>();
        this.piezasTotales = 0;
    }

    public Solucion(List<Maquina> maquinas, int piezasTotales) {
        this.maquinas = new ArrayList<>(maquinas);
        this.piezasTotales = piezasTotales;
    }

    public void imprimir() {
        for (Maquina m : maquinas) {
            System.out.println(m);
        }
        System.out.println("Piezas producidas: " + piezasTotales);
        System.out.println("Máquinas utilizadas: " + maquinas.size());
    }
}