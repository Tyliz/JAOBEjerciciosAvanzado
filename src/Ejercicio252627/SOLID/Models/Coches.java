package Ejercicio252627.SOLID.Models;


import java.util.ArrayList;


import Ejercicio252627.SOLID.DB.Coche.CocheDBPostgresBusqueda;
import Ejercicio252627.SOLID.Excepciones.Coche.CocheException;
import Ejercicio252627.SOLID.Excepciones.Coche.CocheNoExisteException;

public class Coches<T extends Coche> {
    protected CocheDBPostgresBusqueda<T> cocheDB;


    public Coches(Class<T> type) {
        this.cocheDB = new CocheDBPostgresBusqueda<T>(type);
    }


    public ArrayList<T> listar() {
        return cocheDB.listar();
    }

    public T obtener(String idCoche) throws CocheException {
        T coche = (T) cocheDB.obtener(idCoche);

        if (coche != null) return coche;

        throw new CocheNoExisteException(idCoche);
    }

    public void crear(T coche) throws CocheException {
        if (!coche.tieneTraccionDelantera() && !coche.tieneTraccionTrasera()) {
            throw new CocheException("Error al crear el coche:\r\n\tDebe asignar al menos una tracción");
        }

        cocheDB.crear(coche);
    }

    public void borrar(String idCoche) throws CocheException {
        T coche = cocheDB.obtener(idCoche);

        if (coche == null) return;

        cocheDB.borrar(coche);
    }
}
