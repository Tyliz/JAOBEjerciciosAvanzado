package Ejercicio252627.SOLID.Excepciones.Coche;

public class CocheNoExisteException extends CocheException {
    public CocheNoExisteException(String idCoche) {
        super("El coche no existe, " + idCoche);
    }
}
