package flower;

public class Tulip extends Flower {
    private String bulbSize;
    private String petalShape;

    public Tulip() {
        super("Тюльпан", 9, 7, 15.0);
        setBulbSize("Велика");
        setPetalShape("Загострена");
    }

    public String getBulbSize() {return bulbSize;}
    public String getPetalShape() {return petalShape;}

    private void setBulbSize(String bulbSize) {this.bulbSize = bulbSize;}
    private void setPetalShape(String petalShape) {this.petalShape = petalShape;}

    public String toString(){
        return super.toString() +
                ", Розмір цибулини: " + bulbSize +
                ", Форма пелюсток: " + petalShape;
    }
}
