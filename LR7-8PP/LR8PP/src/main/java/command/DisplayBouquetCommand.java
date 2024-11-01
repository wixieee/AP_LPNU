package command;

import bouquet.Bouquet;

public class DisplayBouquetCommand implements Command {
    private Bouquet bouquet;

    public DisplayBouquetCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        bouquet.displayBouquet();
    }
}
