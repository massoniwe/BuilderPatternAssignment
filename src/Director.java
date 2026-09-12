public class Director {
    public void constructSportsCar(Builder builder){
        builder.setCarType("Sports Car")
                .setSeats(2)
                .setEngine("V8 Turbo");
    }

    public void constructSUV(Builder builder){
        builder.setCarType("SUV")
                .setSeats(7)
                .setEngine("V6 Diesel");
    }
}
