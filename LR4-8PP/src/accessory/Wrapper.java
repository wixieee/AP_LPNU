package accessory;

public class Wrapper extends Accessory {
    private String material;
    private String size;

    public Wrapper() {
        super("Упаковка", 30);
        setMaterial("Папір");
        setSize("Середній");
    }

    public String getMaterial() {return material;}
    public String getSize() {return size;}

    private void setMaterial(String material) {this.material = material;}
    private void setSize(String size) {this.size = size;}

    @Override
    public String toString() {
        return super.toString() + ", Матеріал: " + material + ", Розмір: " + size;
    }
}