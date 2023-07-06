package Ejercicio121314.Funciones;


import java.util.ArrayList;


public class Utils {
    /**
     * Función que genera números primos hasta el número dado
     *
     * @param numeroTope número hasta se generarán los números
     * @return ArrayList<Integer> lista de los números primos generados
     */
    public static ArrayList<Integer> generadorDePrimos(int numeroTope) {
        ArrayList<Integer> aPrimos = new ArrayList<>();

        if (numeroTope < 2) return aPrimos;

        for (int i = 2; i <= numeroTope; i++) {
            if (verificarPrimo(i, aPrimos)) {
                aPrimos.add(i);
            }
        }

        return aPrimos;
    }


    /**
     * Función para verificar si un número es primo en base a una lista de primos generados anteriormente
     *
     * @param numero el número que se verificará si es primo
     * @param primos lista de números primos
     * @return boolean que indica si el número es primo o no
     */
    private static boolean verificarPrimo(int numero, ArrayList<Integer> primos) {
        for (int primo: primos) {
            if (numero % primo == 0) return false;
        }
        return true;
    }
}
