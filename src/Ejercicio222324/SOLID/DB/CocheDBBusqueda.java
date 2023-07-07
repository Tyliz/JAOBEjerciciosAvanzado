package Ejercicio222324.SOLID.DB;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


import Ejercicio222324.SOLID.Models.Coche;


public class CocheDBBusqueda extends CocheDB {
    public ArrayList<Coche> listar(String textoBusqueda) {
        ArrayList<Coche> aCoches = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(ficheroCoches));

            while (scanner.hasNext()) {
                String cocheString = scanner.next();
                String[] cocheValores = cocheString.split(",");

                if (cocheString.contains(textoBusqueda)) {
                    Coche coche = new Coche(cocheValores[0]);
                    coche.setMarca(cocheValores[1]);
                    coche.setModelo(cocheValores[2]);
                    coche.setTraccionDelantera(Boolean.parseBoolean(cocheValores[3]));
                    coche.setTraccionTrasera(Boolean.parseBoolean(cocheValores[4]));

                    aCoches.add(coche);
                }
            }
        } catch (Exception e) { }

        return aCoches;
    }
}
