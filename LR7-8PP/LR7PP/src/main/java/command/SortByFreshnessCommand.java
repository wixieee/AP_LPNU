package command;

import bouquet.Bouquet;
import flower.Flower;

import java.util.ArrayList;

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
            System.out.println("Квіти відсортовано за свіжістю.");
        }
        else {
            System.out.println("Не знайдено букет");
        }
    }
}
