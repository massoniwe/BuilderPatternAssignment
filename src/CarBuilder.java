public class CarBuilder implements Builder {
    private String carType;
    private int seats;
    private String engine;
    private boolean hasGPS;

    @Override
    public CarBuilder setCarType(String carType) {
        this.carType = carType;
        return this;
    }

    @Override
    public CarBuilder setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    @Override
    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public CarBuilder setGPS(boolean hasGPS){
        this.hasGPS=hasGPS;
        return this;
    }

    public Car build() {
        return new Car(carType, seats, engine,hasGPS);
    }






}