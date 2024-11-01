package flower;

public class Rose extends Flower{
    private int thornLengthCm;
    private int fragranceLevel; //в діапазоні 1-10

    public Rose(){
        super("Троянда", 10, 30, 25);
        setThornLengthCm(1);
        setFragranceLevel(7);
    }

    public int getThornLengthCm() {return thornLengthCm;}
    public int getFragranceLevel() {return fragranceLevel;}

    private void setThornLengthCm(int thornLengthCm) {this.thornLengthCm = thornLengthCm;}
    private void setFragranceLevel(int fragranceLevel) {this.fragranceLevel = fragranceLevel;}

    @Override
    public String toString(){
        return super.toString() +
                ", Довжина шипів: " + thornLengthCm + " сантиметрів" +
                ", Аромат: " + fragranceLevel + "/10";
    }
}
