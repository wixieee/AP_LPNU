package flower;

public class Daisy extends Flower{
    private String centerColor;
    private String leafShape;

    public Daisy(){
        super("Ромашка", 7, 5, 2.0);
        setCenterColor("Жовтий");
        setLeafShape("Овал");
    }

    public String getCenterColor() {return centerColor;}
    public String getLeafShape() {return leafShape;}

    private void setCenterColor(String centerColor) {this.centerColor = centerColor;}
    private void setLeafShape(String leafShape) {this.leafShape = leafShape;}

    @Override
    public String toString(){
        return super.toString() +
                ", Колір середини: " + centerColor +
                ", Форма пелюсток: " + leafShape;
    }
}
