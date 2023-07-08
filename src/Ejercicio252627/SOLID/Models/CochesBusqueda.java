package Ejercicio252627.SOLID.Models;


import java.util.ArrayList;


import Ejercicio252627.SOLID.DB.Coche.CocheDBPostgresBusqueda;

public class CochesBusqueda<T extends Coche> extends Coches<T> {
    public CochesBusqueda(Class<T> type) {
        super(type);
        cocheDB = new CocheDBPostgresBusqueda<T>(type);
    }

    public ArrayList<T> listar(String textoBusqueda) {
        return ((CocheDBPostgresBusqueda<T>)cocheDB).listar(textoBusqueda);
    }
}
