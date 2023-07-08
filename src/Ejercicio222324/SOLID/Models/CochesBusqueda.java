package Ejercicio222324.SOLID.Models;

import java.util.ArrayList;

import Ejercicio222324.SOLID.DB.CocheDBBusqueda;

public class CochesBusqueda<T extends Coche> extends Coches<T> {
    public CochesBusqueda(Class<T> type) {
        super(type);
        cocheDB = new CocheDBBusqueda<T>(type);
    }

    public ArrayList<T> listar(String textoBusqueda) {
        return ((CocheDBBusqueda<T>)cocheDB).listar(textoBusqueda);
    }
}
