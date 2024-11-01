package command;

import accessory.Card;
import accessory.Ribbon;
import accessory.Wrapper;
import bouquet.Bouquet;

import java.util.Scanner;

public class AddRemoveAccessoryCommand implements Command {
    private Bouquet bouquet;

    public AddRemoveAccessoryCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Додати аксесуар");
        System.out.println("2. Видалити аксесуар");
        System.out.print("Оберіть опцію: ");
        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                System.out.println("1. Стрічка");
                System.out.println("2. Пакування");
                System.out.println("3. Листівка");
                System.out.print("Оберіть аксесуар: ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        bouquet.addAccessory(new Ribbon());
                        break;
                    case 2:
                        bouquet.addAccessory(new Wrapper());
                        break;
                    case 3:
                        bouquet.addAccessory(new Card());
                        break;
                    default:
                        System.out.println("Некоректний ввід");
                }
                break;
            case 2:
                bouquet.removeAccessory();
                break;
            default:
                System.out.println("Некоректний ввід");
        }
    }
}
