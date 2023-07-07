package Ejercicio192021.Argumentos;

import java.util.ArrayList;

import Ejercicio121314.Funciones.Utils;

public class Main {
    public static void main(String[] args) {
        OpcionesParser opcionesParser = new OpcionesParser(args);
        opcionesParser.registrarOpcion("numeroTope");

        opcionesParser.parse();

        int numeroTope = opcionesParser.obtenerIntOpcion("numeroTope");

        ArrayList<Integer> aPrimos = Utils.generadorDePrimos(numeroTope);

        System.out.println("Los números primos existentas hasta " + numeroTope + " son:");
        System.out.println(aPrimos);
    }
}
