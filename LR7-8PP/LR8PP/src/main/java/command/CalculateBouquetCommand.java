package command;

import bouquet.Bouquet;

import static main.Main.logger;

public class CalculateBouquetCommand implements Command {
    private Bouquet bouquet;

    public CalculateBouquetCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }
    @Override
    public void execute() {
        double totalPrice = bouquet.calculatePrice();
        if (totalPrice != 0) {
            logger.info("Загальна вартість букета: {} грн.", totalPrice);
        } else {
            System.out.println("Не знайдено букет");
        }
    }
}
