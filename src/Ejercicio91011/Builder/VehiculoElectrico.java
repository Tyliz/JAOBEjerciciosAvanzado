package Ejercicio91011.Builder;

public class VehiculoElectrico extends Vehiculo {
    private int bateria;

    private VehiculoElectrico(Builder builder) {
        super(builder);
        this.bateria = builder.bateria;
    }


    public int getBateria() { return bateria; }


    public static class Builder extends Vehiculo.Builder<VehiculoElectrico, Builder> {
        private int bateria;

        public Builder setBateria(int bateria) {
            this.bateria = bateria;
            return self();
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public VehiculoElectrico build() {
            return new VehiculoElectrico(this);
        }
    }


    @Override
    public String toString() {
        return super.toString() + "\n\tElectrico [bateria=" + bateria + "]";
    }
}
