package Ejercicio91011.Builder;

public interface VehiculoIterator<T extends Vehiculo> {
    void crear(T item);
    boolean hayMas();
    void reiniciar();
    T siguiente();
}
