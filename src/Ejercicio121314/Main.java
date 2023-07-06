package Ejercicio121314;

import java.util.ArrayList;

import Ejercicio121314.Funciones.Utils;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> aPrimos = Utils.generadorDePrimos(79);
        System.out.println(aPrimos);
    }
}