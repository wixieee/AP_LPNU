package command;

import bouquet.Bouquet;

public class DisplayBouquetPriceCommand implements Command {
    private Bouquet bouquet;

    public DisplayBouquetPriceCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        bouquet.displayBouquet();
    }
}
