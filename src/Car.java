
public class Car {
    private final String carType;
    private final int seats;
    private final String engine;
    private final boolean hasGPS;

    public Car(String carType, int seats, String engine, boolean hasGPS) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.hasGPS = hasGPS;
    }

    @Override
    public String toString() {
        return "Car [Type=" + carType + ", Seats=" + seats +
                ", Engine=" + engine + ", GPS=" + hasGPS + "]";
    }
}
