package Ejercicio15161718;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            dividir(150, 0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            obtenerUsuario(9);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            mostrarArchivo("usuarios.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    public static double dividir(double dividendo, double divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("No es posible dividir entre cero");
        }

        return dividendo / divisor;
    }


    public static String obtenerUsuario(int index) throws IndexOutOfBoundsException {
        String[] aUsuarios = { "Lucia", "Juan", "Massi", "Luis", "Alex", "Javier" };

        try {
            return aUsuarios[index];
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("No existe ningún usuario en la posición " + index);
        }
    }

    public static void mostrarArchivo(String rutaArchivo) throws FileNotFoundException {
        try {
            Scanner scanner = new Scanner(new File(rutaArchivo));

            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("El archivo no existe.");
        }
    }
}
