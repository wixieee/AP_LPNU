package main;
import bouquet.Bouquet;
import command.*;
import menu.Menu;

public class Main {
    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet();

        Menu menu = new Menu();

        menu.addCommand(1, new AddRemoveFlowerCommand(bouquet));
        menu.addCommand(2, new AddRemoveAccessoryCommand(bouquet));
        menu.addCommand(3, new CalculateBouquetPriceCommand(bouquet));
        menu.addCommand(4, new SortByFreshnessCommand(bouquet));
        menu.addCommand(5, new FindFLowerByStemLengthCommand(bouquet));
        menu.addCommand(6, new DisplayBouquetPriceCommand(bouquet));;

        menu.showMenu();
    }
}
