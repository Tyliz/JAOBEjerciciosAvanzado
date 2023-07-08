package Ejercicio252627.SOLID.DB.Coche;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import Ejercicio252627.SOLID.Excepciones.Coche.CocheException;
import Ejercicio252627.SOLID.Models.CocheCombustion;

public class CocheCombustionDBFichero {
    protected String ficheroCoches;

    public CocheCombustionDBFichero() {
        ficheroCoches = "cochesCombustion.txt";
    }

    public ArrayList<CocheCombustion> listar() {
        ArrayList<CocheCombustion> aCoches = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(ficheroCoches));

            while (scanner.hasNext()) {
                String cocheString = scanner.next();
                String[] cocheValores = cocheString.split(",");

                CocheCombustion coche = new CocheCombustion(cocheValores[0]);
                coche.setMarca(cocheValores[1]);
                coche.setModelo(cocheValores[2]);
                coche.setTraccionDelantera(Boolean.parseBoolean(cocheValores[3]));
                coche.setTraccionTrasera(Boolean.parseBoolean(cocheValores[4]));
                coche.setCapacidadCombustible(Double.parseDouble(cocheValores[5]));

                aCoches.add(coche);
            }
        } catch (Exception e) { }

        return aCoches;
    }

    public CocheCombustion obtener(String idCoche) throws CocheException {
        try {
            Scanner scanner = new Scanner(new File(ficheroCoches));

            while (scanner.hasNext()) {
                String cocheString = scanner.next();
                String[] cocheValores = cocheString.split(",");
                if (cocheValores[0].equals(idCoche)) {
                    CocheCombustion coche = new CocheCombustion(cocheValores[0]);
                    coche.setMarca(cocheValores[1]);
                    coche.setModelo(cocheValores[2]);
                    coche.setTraccionDelantera(Boolean.parseBoolean(cocheValores[3]));
                    coche.setTraccionTrasera(Boolean.parseBoolean(cocheValores[4]));
                    coche.setCapacidadCombustible(Double.parseDouble(cocheValores[5]));

                    return coche;
                }
            }
        } catch (Exception e) {
            throw new CocheException("Ocurrio un evento mientras se obtenia el coche:\r\n\t" + e.getMessage());
        }

        return null;
    }

    public void crear(CocheCombustion coche) throws CocheException {
        try {
            String idCoche = UUID.randomUUID().toString();
            FileOutputStream fileOutputStream = new FileOutputStream(ficheroCoches, true);
            PrintStream printStream = new PrintStream(fileOutputStream);

            printStream.println(idCoche + separarCochePorComas(coche));

            printStream.flush();
            printStream.close();
        } catch (Exception e) {
            throw new CocheException("Ocurrio un error al guardar el coche:\r\n\t" + e.getMessage());
        }

    }

    public void borrar(CocheCombustion coche) throws CocheException {
        List<CocheCombustion> aCochesRestantes = listar()
            .stream()
            .filter(x -> !x.getIdCoche().equals(coche.getIdCoche()))
            .toList();

        try {
            PrintStream printStream = new PrintStream(ficheroCoches);

            for (CocheCombustion cocheRestante : aCochesRestantes) {
                printStream.println(separarCochePorComas(cocheRestante));
            }

            printStream.flush();
            printStream.close();
        } catch (Exception e) {
            throw new CocheException("Ocurrio un error al borrar el coche\r\n\t" + e.getMessage());
        }

    }


    private String separarCochePorComas(CocheCombustion coche) {
        return coche.getIdCoche() + "," +
            coche.getMarca() + "," +
            coche.getModelo() + "," +
            coche.tieneTraccionDelantera() + "," +
            coche.tieneTraccionTrasera() + "," +
            coche.getCapacidadCombustible();
    }
}
