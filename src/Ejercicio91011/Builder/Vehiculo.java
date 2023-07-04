package Ejercicio91011.Builder;

public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private int puertas;

    public Vehiculo(Builder<?, ?> builder) {
        this.marca = builder.marca;
        this.modelo = builder.modelo;
        this.puertas = builder.puertas;
    }

    public String getMarca() { return marca; }

    public String getModelo() { return modelo; }

    public int getPuertas() { return puertas; }


    @Override
    public String toString() {
        return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", puertas=" + puertas + "]";
    }


    public abstract static class Builder<T extends Vehiculo, B extends Builder<T, B>> {
        private String marca;
        private String modelo;
        private int puertas;

        public B setMarca(String marca) {
            this.marca = marca;
            return self();
        }

        public B setModelo(String modelo) {
            this.modelo = modelo;
            return self();
        }

        public B setPuertas(int puertas) {
            this.puertas = puertas;
            return self();
        }

        protected abstract B self();

        public abstract T build();
    }
}
