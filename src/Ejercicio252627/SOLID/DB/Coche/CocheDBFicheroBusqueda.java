package Ejercicio252627.SOLID.DB.Coche;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import Ejercicio252627.SOLID.Models.Coche;
import Ejercicio252627.SOLID.Models.CocheCombustion;
import Ejercicio252627.SOLID.Models.CocheElectrico;
import Ejercicio252627.SOLID.Models.CocheHibrido;


public class CocheDBFicheroBusqueda<T extends Coche> extends CocheDBFichero<T> {
    public CocheDBFicheroBusqueda(Class<T> tipoCoche) {
        super(tipoCoche);
    }


    public ArrayList<T> listar(String textoBusqueda) {
        ArrayList<T> aCoches = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(ficheroCoches));

            while (scanner.hasNext()) {
                String cocheString = scanner.next();
                String[] cocheValores = cocheString.split(",");

                if (cocheString.contains(textoBusqueda)) {
                    T coche = tipoCoche.getDeclaredConstructor().newInstance(cocheValores[0]);

                    coche.setMarca(cocheValores[1]);
                    coche.setModelo(cocheValores[2]);
                    coche.setTraccionDelantera(Boolean.parseBoolean(cocheValores[3]));
                    coche.setTraccionTrasera(Boolean.parseBoolean(cocheValores[4]));

                    if (this.tipoCoche == CocheElectrico.class) {
                        coche.setCapacidadBateria(Double.parseDouble(cocheValores[5]));
                    } else if (this.tipoCoche == CocheHibrido.class) {
                        coche.setCapacidadBateria(Double.parseDouble(cocheValores[5]));
                        coche.setCapacidadCombustible(Double.parseDouble(cocheValores[6]));
                    } else if (this.tipoCoche == CocheCombustion.class) {
                        coche.setCapacidadBateria(Double.parseDouble(cocheValores[5]));
                    }

                    aCoches.add(coche);
                }
            }
        } catch (Exception e) { }

        return aCoches;
    }
}
