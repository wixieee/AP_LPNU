public class Product {
    private int id;
    private String name;
    private String producer;
    private double price;
    private int shelf_life;
    private int quantity;

    //Конструктор
    public Product(int id, String name, String producer, double price, int shelf_life, int quantity) {
        setId(id);
        setName(name);
        setProducer(producer);
        setPrice(price);
        setShelfLife(shelf_life);
        setQuantity(quantity);
    }

    //Методи доступу
    public int getId() { return id; }
    public String getName() { return name; }
    public String getProducer() { return producer; }
    public double getPrice() { return price; }
    public int getShelfLife() { return shelf_life; }
    public int getQuantity() { return quantity; }

    private void setId(int id) { this.id = id; }
    private void setName(String name) { this.name = name; }
    private void setProducer(String producer) { this.producer = producer; }
    private void setPrice(double price) { this.price = price; }
    private void setShelfLife(int shelf_life) { this.shelf_life = shelf_life; }
    private void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "ID=" + id +
                ", Назва='" + name + '\'' +
                ", Виробник='" + producer + '\'' +
                ", Ціна=" + price +
                ", Термін зберігання='" + shelf_life + '\'' +
                ", Кількість=" + quantity;
    }
}
