package Ejercicio252627.SOLID.Models;

public class CocheElectrico extends Coche {
    protected double capacidadBateria;


    public CocheElectrico() {
        super();
    }

    public CocheElectrico(String idCoche) {
        super(idCoche);
    }


    public double getCapacidadBateria() {
        return capacidadBateria;
    }

    public void setCapacidadBateria(double capacidadBateria) {
        this.capacidadBateria = capacidadBateria;
    }
}
