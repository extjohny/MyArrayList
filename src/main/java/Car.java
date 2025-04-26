public class Car {

    private final String brand;

    private final String owner;

    private final double price;


    public Car(String brand, String owner, double price) {
        this.brand = brand;
        this.owner = owner;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getOwner() {
        return owner;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + " Owner: " + owner + " Price: " + price;
    }
}
