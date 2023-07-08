package Ejercicio222324;

import java.util.ArrayList;

import Ejercicio222324.SOLID.Excepciones.Coche.CocheException;
import Ejercicio222324.SOLID.Models.Coche;
import Ejercicio222324.SOLID.Models.CocheElectrico;
import Ejercicio222324.SOLID.Models.CocheHibrido;
import Ejercicio222324.SOLID.Models.CochesBusqueda;

public class Main {
    public static void main(String[] args) {
        CochesBusqueda<CocheElectrico> coches = new CochesBusqueda<CocheElectrico>(CocheElectrico.class);

        CocheElectrico coche1 = new CocheElectrico();
        coche1.setMarca("Toyota");
        coche1.setModelo("2016");
        coche1.setTraccionDelantera(true);
        coche1.setTraccionTrasera(true);
        coche1.setCapacidadBateria(1800);
        coche1.setCapacidadCombustible(1500);

        crearCoche(coches, coche1);

        borrarCoche(coches, "864d34d7-15ae-416e-8d1c-90e321b4566d");
        borrarCoche(coches, "843ed84c-9310-4972-aba3-9b5079e96a9f");

        mostrarCoches(coches.listar());

        System.out.println("Busqueda de Toyota");

        mostrarCoches(coches.listar("Toyota"));
    }

    private static void crearCoche(CochesBusqueda<CocheElectrico> coches, CocheElectrico coche) {
        try {
            coches.crear(coche);
        } catch (CocheException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void borrarCoche(CochesBusqueda<CocheElectrico> coches, String idCoche) {
        try {
            coches.borrar(idCoche);
        } catch (CocheException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarCoches(ArrayList<CocheElectrico> coches) {
        System.out.println("\r\n---------------Coches---------------");

        for (Coche coche : coches) {
            System.out.println("------------------------------------");

            System.out.println(
                coche.getMarca() + "|" +
                coche.getModelo() + "|" +
                coche.obtenerTraccion() + "|" +
                coche.getCapacidadBateria() + " A|" +
                coche.getCapacidadCombustible() + " L"
            );
        }
    }
}
