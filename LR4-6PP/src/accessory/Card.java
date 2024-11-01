package accessory;

public class Card extends Accessory {
    private String message;
    private String occasion;

    public Card() {
        super("Листівка", 20);
        setMessage("Вітаю!");
        setOccasion("День Народження");
    }

    public String getMessage() {return message;}
    public String getOccasion() {return occasion;}

    private void setMessage(String message) {this.message = message;}
    private void setOccasion(String occasion) {this.occasion = occasion;}

    @Override
    public String toString() {
        return super.toString() + ", Подія: " + occasion + ", Повідомлення: " + message;
    }
}

