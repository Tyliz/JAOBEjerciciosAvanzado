package Ejercicio222324;

import java.util.ArrayList;

import Ejercicio222324.SOLID.Excepciones.Coche.CocheException;
import Ejercicio222324.SOLID.Models.Coche;
import Ejercicio222324.SOLID.Models.Coches;
import Ejercicio222324.SOLID.Models.CochesBusqueda;

public class Main {
    public static void main(String[] args) {
        CochesBusqueda coches = new CochesBusqueda();

        Coche coche1 = new Coche();
        coche1.setMarca("BMW");
        coche1.setModelo("2016");
        coche1.setTraccionDelantera(false);
        coche1.setTraccionTrasera(false);

        crearCoche(coches, coche1);

        borrarCoche(coches, "864d34d7-15ae-416e-8d1c-90e321b4566d");
        borrarCoche(coches, "843ed84c-9310-4972-aba3-9b5079e96a9f");

        mostrarCoches(coches.listar());

        System.out.println("Busqueda de Toyota");

        mostrarCoches(coches.listar("Toyota"));
    }

    private static void crearCoche(Coches coches, Coche coche) {
        try {
            coches.crear(coche);
        } catch (CocheException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void borrarCoche(Coches coches, String idCoche) {
        try {
            coches.borrar(idCoche);
        } catch (CocheException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarCoches(ArrayList<Coche> coches) {
        System.out.println("\r\n---------------Coches---------------");

        for (Coche coche : coches) {
            System.out.println("------------------------------------");

            System.out.println(
                coche.getMarca() + "|" +
                coche.getModelo() + "|" +
                coche.tieneTraccionDelantera() + "|" +
                coche.tieneTraccionTrasera()
            );
        }
    }
}
