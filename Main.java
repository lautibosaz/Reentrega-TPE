import java.util.List;

public class Main {
    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();
        fabrica.leerArchivo("especificaciones.txt");
        int objetivo = fabrica.getPiezasObjetivo();
        List<Maquina> maquinas = fabrica.getMaquinas();

        fabrica.mostrarDatos();

        System.out.println();
        Backtrack back = new Backtrack();
        back.resolver(maquinas, objetivo);

        System.out.println();
        Greedy greedy = new Greedy();
        greedy.resolver(maquinas, objetivo);
    }
}
