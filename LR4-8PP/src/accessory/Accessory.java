package accessory;

public abstract class Accessory {
    private String name;
    private double price;

    public Accessory(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public String getName() {return name;}
    public double getPrice() {return price;}

    private void setName(String name) {this.name = name;}
    private void setPrice(double price) {this.price = price;}

    public String toString() {
        return "Товар: " + name +
                ", Вартість: " + price;
    }
}
