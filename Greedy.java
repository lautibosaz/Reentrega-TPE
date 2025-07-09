import java.util.ArrayList;
import java.util.List;

/* 
 * Estrategia de resolución con Greedy:
 * 
 * En este algoritmo se ordenan las máquinas de mayor a menor en base a su capacidad de producción,
 * y siempre que no se haya alcanzado la cantidad de piezas requeridas, selecciona de forma secuencial 
 * las que más producen.
 * 
 * Candidatos: todas las máquinas disponibles.
 * Estrategia de selección: Se eligen primero las máquinas que producen más piezas.
 * 
 * El agloritmo es eficiente en costo computacional, ya que recorre las máquinas una sola vez.
 * Sin embargo, no garantiza encontrar la mejor solución en todos los casos, pero si una aproximación
 * válida cercana a la mejor solución.
 */

class Greedy {

    public void resolver(List<Maquina> maquinas, int objetivo) {
        List<Maquina> seleccionadas = new ArrayList<>();
        int suma = 0;

        maquinas.sort((a, b) -> b.capacidad - a.capacidad);

        for (Maquina m : maquinas) {
            while (suma + m.capacidad <= objetivo) {
                seleccionadas.add(m);
                suma += m.capacidad;
            }
            if (suma == objetivo)
                break;
        }

        System.out.println("=== GREEDY ===");
        if (suma == objetivo) {
            System.out.println("Solución encontrada:");
            for (Maquina m : seleccionadas)
                System.out.println(m);
            System.out.println("Piezas producidas: " + suma);
            System.out.println("Máquinas utilizadas: " + seleccionadas.size());
        } else {
            System.out.println("No se pudo encontrar solución exacta con estrategia Greedy.");
        }
    }
}