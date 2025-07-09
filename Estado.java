import java.util.ArrayList;
import java.util.List;

public class Estado {
    List<Maquina> seleccionadas;
    int suma;
    int index;

    public Estado(List<Maquina> seleccionadas, int suma, int index) {
        this.seleccionadas = new ArrayList<>(seleccionadas);
        this.suma = suma;
        this.index = index;
    }

    public int getCantidadMaquinas() {
        return seleccionadas.size();
    }
}
