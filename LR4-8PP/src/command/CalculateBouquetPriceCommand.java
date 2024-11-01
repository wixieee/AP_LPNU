package command;

import bouquet.Bouquet;

public class CalculateBouquetPriceCommand implements Command {
    private Bouquet bouquet;

    public CalculateBouquetPriceCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }
    @Override
    public void execute() {
        bouquet.calculatePrice();
    }
}
