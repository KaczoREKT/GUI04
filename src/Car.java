public class Car {
    private String maker;
    private String model;
    private int productionYear;
    private String vin = VinGenerator.vinGenerator();

    public Car(String maker, String model, int productionYear) {
        this.maker = maker;
        this.model = model;
        this.productionYear = productionYear;
    }
}
