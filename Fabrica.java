import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fabrica {
    private int piezasObjetivo;
    private List<Maquina> maquinas = new ArrayList<>();

    public void leerArchivo(String nombreArchivo) {
        maquinas.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int lineaActual = 0;

            while ((linea = br.readLine()) != null) {
                if (lineaActual == 0) {
                    piezasObjetivo = Integer.parseInt(linea.trim());
                } else {
                    String[] partes = linea.split(",");
                    String nombre = partes[0].trim();
                    int capacidad = Integer.parseInt(partes[1].trim());
                    maquinas.add(new Maquina(nombre, capacidad));
                }
                lineaActual++;
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public int getPiezasObjetivo() {
        return piezasObjetivo;
    }

    public List<Maquina> getMaquinas() {
        return maquinas;
    }

    public void mostrarDatos() {
        System.out.println("Piezas a producir: " + piezasObjetivo);
        for (Maquina m : maquinas) {
            System.out.println(m);
        }
    }
}