package Ejercicio222324.SOLID.Models;

import java.util.ArrayList;

public class CochesBusqueda extends Coches {
    public ArrayList<Coche> listar(String textoBusqueda) {
        return cocheDB.listar(textoBusqueda);
    }
}
