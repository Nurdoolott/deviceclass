public class Tablet extends Device {
    private String brand;
    private boolean hasStylus;

    public Tablet(String type, double price, double weight, String brand, boolean hasStylus) {
        super(type, price, weight);
        this.brand = brand;
        this.hasStylus = hasStylus;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isHasStylus() {
        return hasStylus;
    }

    public void setHasStylus(boolean hasStylus) {
        this.hasStylus = hasStylus;
    }
}
