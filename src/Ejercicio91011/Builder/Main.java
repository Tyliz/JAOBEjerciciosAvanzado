package Ejercicio91011.Builder;


/**
 * Se aplico un Iterator (Sesion 9) a el proyecto del patron Build (sesion 7)
 * - Ya que parecia ser un uso útil para poder controlar las listas de nuestos modelos de Vehiculo
 *
 * Se refactorizaron las clases de Vehiculo.
 */
public class Main {
    public static void main(String[] args) {
        VehiculoCombustion vehiculoCombustion = new VehiculoCombustion.Builder()
            .setCapacidadTanque(1400)
            .setMarca("BMW")
            .setModelo("2018")
            .setPuertas(4)
            .build();

        VehiculoElectrico vehiculoElectrico = new VehiculoElectrico.Builder()
            .setBateria(1400)
            .setMarca("Honda")
            .setModelo("2016")
            .setPuertas(5)
            .build();

        Vehiculos<Vehiculo> vehiculos = new Vehiculos<>();

        vehiculos.crear(vehiculoCombustion);
        vehiculos.crear(vehiculoElectrico);

        MostrarVehiculos(vehiculos);
    }

    public static void MostrarVehiculos(Vehiculos<Vehiculo> vehiculos) {
        System.out.println("--------------------Vehículos--------------------");

        while (vehiculos.hayMas()) {
            System.out.println(vehiculos.siguiente());
        }
    }
}
