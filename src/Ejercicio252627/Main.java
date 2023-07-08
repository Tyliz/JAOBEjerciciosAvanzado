package Ejercicio252627;


import java.util.ArrayList;

import Ejercicio252627.SOLID.Excepciones.Coche.CocheException;
import Ejercicio252627.SOLID.Models.Coche;
import Ejercicio252627.SOLID.Models.CochesBusqueda;


public class Main {
    public static void main(String[] args) {
        CochesBusqueda<Coche> coches = new CochesBusqueda<Coche>(Coche.class);

        Coche coche1 = new Coche();
        coche1.setMarca("VW");
        coche1.setModelo("2010");
        coche1.setTraccionDelantera(false);
        coche1.setTraccionTrasera(false);
        coche1.setCapacidadBateria(1800);
        coche1.setCapacidadCombustible(1500);

        crearCoche(coches, coche1);

        borrarCoche(coches, "7b4a6a77-4263-4fdb-88f9-8f4e237c89b5");

        mostrarCoches(coches.listar());

        System.out.println("\r\nBusqueda de Toyota");

        mostrarCoches(coches.listar("Toyota"));
    }

    private static void crearCoche(CochesBusqueda<Coche> coches, Coche coche) {
        try {
            coches.crear(coche);
        } catch (CocheException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void borrarCoche(CochesBusqueda<Coche> coches, String idCoche) {
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
                coche.getIdCoche() + "|" +
                coche.getMarca() + "|" +
                coche.getModelo() + "|" +
                coche.obtenerTraccion() + "|" +
                coche.getCapacidadBateria() + " A|" +
                coche.getCapacidadCombustible() + " L"
            );
        }
    }
}