package accessory;

public class Ribbon extends Accessory {
    private String color;
    private double lengthCm;

    public Ribbon() {
        super("Стрічка", 10);
        setLengthCm(15);
        setColor("Рожевий");
    }

    public String getColor() {return color;}
    public double getLengthCm() {return lengthCm;}

    private void setColor(String color) {this.color = color;}
    private void setLengthCm(double length) {this.lengthCm = length;}

    @Override
    public String toString() {
        return super.toString() + ", Колір: " + color + ", Довжина: " + lengthCm + " сантиметрів";
    }
}

