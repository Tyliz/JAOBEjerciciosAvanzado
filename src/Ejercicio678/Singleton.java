package Ejercicio678;

public class Singleton {
    private static Singleton singleton;
    private int contador = 0;


    private Singleton() { }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
