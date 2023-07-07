package Ejercicio192021.ArquitecturaLimpia;

public class Main {
    public static void main(String[] args) {
        imprimirRespuestaArquitecturaLimpia();
    }

    public static void imprimirRespuestaArquitecturaLimpia() {
        System.out.println(
            "P. Identifica las características principales de la arquitectura limpia, " +
            "indica en que casos se tendría que utilizar la arquitectura limpia y como lo harías"
        );

        System.out.println("R. las características principales son:");
        System.out.println("\t- Independencia del framework.");
        System.out.println("\t- Separación de responsabilidades.");
        System.out.println("\t- Capas de la arquitectura.");
        System.out.println("\t- Principio de inversión de dependencias.");
        System.out.println("\t- Independencia de la interfaz de usuario.");
        System.out.println("\t- Pruebas unitarias.");

        System.out.println(
            "\r\n   Se deben de utilizar en los proyectos que desarrollemos para que sean lo " +
            "mejor mantenible posible, que sea facil de escalar y reutilizar."
        );

        System.out.println(
            "\r\n   Para implementarlo utilizaría la división por capas separandolo en una aplicación " +
            "distinta por cada capa, utilizando las herramientas o frameworks necesarios en cada una de las " +
            "aplicaciones y teniendo comunicación solo entre las capas necesarias."
        );
    }
}
