package flower;

public abstract class Flower {
    private String name;
    private int freshness; //в діапазоні 1-10
    private int stemLengthCm;
    private double price;

    public Flower(String name, int freshness, int stemLengthCm, double price) {
        setName(name);
        setFreshness(freshness);
        setStemLengthCm(stemLengthCm);
        setPrice(price);
    }

    public String getName() {return name;}
    public int getFreshness() {return freshness;}
    public int getStemLengthCm() {return stemLengthCm;}
    public double getPrice() {return price;}

    private void setName(String name) {this.name = name;}
    private void setFreshness(int freshness) {this.freshness = freshness;}
    private void setStemLengthCm(int stemLengthCm) {this.stemLengthCm = stemLengthCm;}
    private void setPrice(double price) {this.price = price;}

    public String toString() {
        return "Назва: " + name +
                ", Cвіжість: " + freshness + "/10" +
                ", Довжина Стебла: " + stemLengthCm + " сантиметрів" +
                ", Ціна: " + price + " грн.";
    }
}
