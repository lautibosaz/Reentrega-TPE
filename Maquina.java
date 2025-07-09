public class Maquina {
    public String nombre;
    public int capacidad;

    public Maquina(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return nombre + " produce " + capacidad;
    }
}