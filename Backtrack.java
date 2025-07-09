import java.util.ArrayList;
import java.util.List;

/*
 * Estrategia de resolución con Backtracking:
 * 
 * En este algoritmo cada nodo del árbol de exploración representa un estado en el que se elige una 
 * secuencia parcial de máquinas, con el objetivo de llegar a un estado final donde la suma de piezas
 * producidas sea igual a la requerida.
 * 
 * Se utiliza poda para evitar continuar la exploración en los siguientes casos:
 * - Si la cantidad de piezas acumuladas supera la requerida.
 * - Si la cantidad de máquinas utilizadas ya es igual o mayor a la mejor solución encontrada.
 * 
 * El algoritmo garantiza encontrar la mejor solución, que sería la menor cantidad de máquinas, aunque el costo
 * computacional podria ser elevado si la cantidad de máquinas es grande o si hay muchas combinaciones posibles.
 */

class Backtrack {
    private Solucion mejorSolucion = null;
    private int estadosGenerados = 0;

    public void resolver(List<Maquina> maquinas, int objetivo) {
        Estado inicial = new Estado(new ArrayList<>(), 0, 0);
        backtrack(maquinas, objetivo, inicial);
        System.out.println("=== BACKTRACKING ===");
        if (mejorSolucion != null) {
            System.out.println("Mejor solución encontrada:");
            mejorSolucion.imprimir();
        } else {
            System.out.println("No se encontró solución exacta.");
        }
        System.out.println("Estados generados: " + estadosGenerados);
    }

    private void backtrack(List<Maquina> maquinas, int objetivo, Estado estado) {

        if (estado.suma > objetivo || estado.index >= maquinas.size())
        return;

        if (mejorSolucion != null && estado.getCantidadMaquinas() >= mejorSolucion.maquinas.size())
        return;

        estadosGenerados++;

        if (estado.suma == objetivo) {
            if (mejorSolucion == null || estado.getCantidadMaquinas() < mejorSolucion.maquinas.size()) {
                mejorSolucion = new Solucion(new ArrayList<>(estado.seleccionadas), estado.suma);
            }
            return;
        }

        List<Maquina> nuevaLista = new ArrayList<>(estado.seleccionadas);
        nuevaLista.add(maquinas.get(estado.index));
        backtrack(maquinas, objetivo, new Estado(nuevaLista, estado.suma + maquinas.get(estado.index).capacidad, estado.index));

        backtrack(maquinas, objetivo, new Estado(new ArrayList<>(estado.seleccionadas), estado.suma, estado.index + 1));
    }

}