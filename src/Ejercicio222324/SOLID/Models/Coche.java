package Ejercicio222324.SOLID.Models;

public class Coche {
    private String idCoche;
    private String marca;
    private String modelo;
    private boolean traccionDelantera;
    private boolean traccionTrasera;


    public Coche() {
        idCoche = "";
    }

    public Coche(String idCoche) {
        this.idCoche =  idCoche;
    }

    public String getIdCoche() {
        return idCoche;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean tieneTraccionDelantera() {
        return traccionDelantera;
    }

    public void setTraccionDelantera(boolean traccionDelantera) {
        this.traccionDelantera = traccionDelantera;
    }

    public boolean tieneTraccionTrasera() {
        return traccionTrasera;
    }

    public void setTraccionTrasera(boolean traccionTrasera) {
        this.traccionTrasera = traccionTrasera;
    }

    public String obtenerTraccion() {
        return traccionDelantera && traccionTrasera
            ? "Doble tracción"
            : traccionTrasera
                ? "Tracción trasera"
                : "Tracción delantera";
    }
}
