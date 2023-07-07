package Ejercicio222324.SOLID.Models;

import java.util.ArrayList;

import Ejercicio222324.SOLID.DB.CocheDB;
import Ejercicio222324.SOLID.Excepciones.Coche.CocheException;
import Ejercicio222324.SOLID.Excepciones.Coche.CocheNoExisteException;

public class Coches {
    private CocheDB cocheDB;


    public Coches() {
        this.cocheDB = new CocheDB();
    }


    public ArrayList<Coche> listar() {
        return cocheDB.listar();
    }

    public Coche obtener(String idCoche) throws CocheException {
        Coche coche = cocheDB.obtener(idCoche);

        if (coche != null) return coche;

        throw new CocheNoExisteException(idCoche);
    }

    public void crear(Coche coche) throws CocheException {
        if (!coche.tieneTraccionDelantera() && !coche.tieneTraccionTrasera()) {
            throw new CocheException("Error al crear el coche:\r\n\tDebe asignar al menos una tracción");
        }

        cocheDB.crear(coche);
    }

    public void borrar(String idCoche) throws CocheException {
        Coche coche = cocheDB.obtener(idCoche);

        if (coche == null) return;

        cocheDB.borrar(coche);
    }
}
