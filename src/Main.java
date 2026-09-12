public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder builder = new CarBuilder();

        director.constructSportsCar(builder);
        Car sportsCar = builder.build();
        System.out.println("Из директора: " + sportsCar);

        director.constructSUV(builder);
        Car suv = builder.build();
        System.out.println("Из директора: " + suv);
    }
}

