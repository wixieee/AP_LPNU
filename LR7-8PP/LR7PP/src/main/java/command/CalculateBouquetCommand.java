package command;

import bouquet.Bouquet;

public class CalculateBouquetCommand implements Command {
    private Bouquet bouquet;

    public CalculateBouquetCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }
    @Override
    public void execute() {
        double totalPrice = bouquet.calculatePrice();
        if (totalPrice != 0) {
            System.out.println("Загальна вартість букета: " + totalPrice + " грн.");
        } else {
            System.out.println("Не знайдено букет");
        }
    }
}
