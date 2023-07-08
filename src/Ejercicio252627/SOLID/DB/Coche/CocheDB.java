package Ejercicio252627.SOLID.DB.Coche;


import java.util.ArrayList;


import Ejercicio252627.SOLID.Models.Coche;
import Ejercicio252627.SOLID.Excepciones.Coche.CocheException;


public interface CocheDB<T extends Coche> {
    ArrayList<T> listar();
    T obtener(String idCoche) throws CocheException;
    void crear(T coche) throws CocheException;
    void borrar(T coche) throws CocheException;
}
