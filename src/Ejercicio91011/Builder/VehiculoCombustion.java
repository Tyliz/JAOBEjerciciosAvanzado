package Ejercicio91011.Builder;

public class VehiculoCombustion extends Vehiculo {
    private int capacidadTanque;

    private VehiculoCombustion(Builder builder) {
        super(builder);
        this.capacidadTanque = builder.capacidadTanque;
    }


    public int getCapacidadTanque() { return capacidadTanque; }


    public static class Builder extends Vehiculo.Builder<VehiculoCombustion, Builder> {
        private int capacidadTanque;

        public Builder setCapacidadTanque(int capacidadTanque) {
            this.capacidadTanque = capacidadTanque;
            return self();
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public VehiculoCombustion build() {
            return new VehiculoCombustion(this);
        }
    }


    @Override
    public String toString() {
        return super.toString() + "\n\tCombustion [Capacidad del tanque=" + capacidadTanque + "]";
    }
}
