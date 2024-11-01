package command;

import bouquet.Bouquet;
import flower.Flower;

import java.util.ArrayList;

import static main.Main.logger;

public class SortByFreshnessCommand implements Command {
    private Bouquet bouquet;

    public SortByFreshnessCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        ArrayList<Flower> flowers;
        flowers = bouquet.sortByFreshness();
        if (!flowers.isEmpty()) {
            logger.info("Квіти відсортовано за свіжістю: ");
            for (Flower flower : flowers) {
                logger.info(flower);
            }
        }
        else {
            System.out.println("Не знайдено букет");
        }
    }
}
