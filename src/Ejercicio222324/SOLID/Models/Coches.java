package Ejercicio222324.SOLID.Models;

import java.util.ArrayList;

import Ejercicio222324.SOLID.DB.CocheDBBusqueda;
import Ejercicio222324.SOLID.DB.CocheDBFichero;
import Ejercicio222324.SOLID.Excepciones.Coche.CocheException;
import Ejercicio222324.SOLID.Excepciones.Coche.CocheNoExisteException;

public class Coches<T extends Coche> {
    protected CocheDBFichero<T> cocheDB;


    public Coches(Class<T> type) {
        this.cocheDB = new CocheDBBusqueda<T>(type);
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
