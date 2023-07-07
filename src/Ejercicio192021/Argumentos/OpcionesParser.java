package Ejercicio192021.Argumentos;

import java.util.HashMap;

public class OpcionesParser {
    private HashMap<String, String> opciones = new HashMap<>();
    private String[] args;

    public OpcionesParser(String[] args) {
        this.args = args;
    }

    public void registrarOpcion(String nombre) {
        opciones.put(nombre, "");
    }

    public String obtenerOpcion(String nombreOpcion) {
        return opciones.get(nombreOpcion);
    }

    public int obtenerIntOpcion(String nombreOpcion) {
        return Integer.parseInt(opciones.get(nombreOpcion));
    }

    public void asignarValorOpcion(String opcion, String valor) {
        opciones.replace(opcion, valor);
    }

    public void parse() {
        for (int i = 0; i < args.length; i+=2) {
            String nombreOpcion = args[i].replace("--", "");
            if (opciones.containsKey(nombreOpcion)) {
                asignarValorOpcion(nombreOpcion, args[i + 1]);
            }
        }
    }
}
