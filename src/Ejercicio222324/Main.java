package Ejercicio222324;

import java.util.ArrayList;

import Ejercicio222324.SOLID.Excepciones.Coche.CocheException;
import Ejercicio222324.SOLID.Models.Coche;
import Ejercicio222324.SOLID.Models.Coches;

public class Main {
    public static void main(String[] args) {
        Coches coches = new Coches();

        Coche coche1 = new Coche();
        coche1.setMarca("BMW");
        coche1.setModelo("2016");
        coche1.setTraccionDelantera(false);
        coche1.setTraccionTrasera(false);

        crearCoche(coches, coche1);

        borrarCoche(coches, "1e1ce8e8-2c43-42bf-bcd3-77db77764b28");
        borrarCoche(coches, "ad9207fb-a68e-47eb-8a96-2bf48590fd44");

        listarCoches(coches);
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

    private static void listarCoches(Coches coches) {
        ArrayList<Coche> aCoches = coches.listar();

        System.out.println("\r\n---------------Coches---------------");

        for (Coche coche : aCoches) {
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
