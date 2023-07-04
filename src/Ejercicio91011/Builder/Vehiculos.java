package Ejercicio91011.Builder;

import java.util.ArrayList;

public class Vehiculos<T extends Vehiculo> implements VehiculoIterator<T> {
    private ArrayList<T> lstVehiculos = new ArrayList<>();
    private int posicion = 0;

    @Override
    public void crear(T vehiculo) {
        lstVehiculos.add(vehiculo);
    }

    @Override
    public T siguiente() {
        T vehiculo = lstVehiculos.get(posicion);
        posicion++;
        return vehiculo;
    }

    @Override
    public boolean hayMas() {
        return posicion < lstVehiculos.size();
    }

    @Override
    public void reiniciar() {
        posicion = 0;
    }
}
