package main;

import bouquet.Bouquet;
import command.*;
import menu.Menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Запуск програми.");

        try {
            Bouquet bouquet = new Bouquet();

            Menu menu = new Menu();

            menu.addCommand(1, new AddRemoveFlowerCommand(bouquet));
            menu.addCommand(2, new AddRemoveAccessoryCommand(bouquet));
            menu.addCommand(3, new CalculateBouquetCommand(bouquet));
            menu.addCommand(4, new SortByFreshnessCommand(bouquet));
            menu.addCommand(5, new FindFlowerByStemLengthCommand(bouquet));
            menu.addCommand(6, new DisplayBouquetCommand(bouquet));

            menu.showMenu();

        } catch (Exception e) {
            logger.error("Критична помилка у програмі.", e);
        }

        logger.info("Програма завершена.");
    }
}
