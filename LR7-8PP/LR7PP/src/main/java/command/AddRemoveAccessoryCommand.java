package command;

import accessory.Accessory;
import accessory.Card;
import accessory.Ribbon;
import accessory.Wrapper;
import bouquet.Bouquet;

import java.util.ArrayList;
import java.util.Scanner;

public class AddRemoveAccessoryCommand implements Command {
    private Bouquet bouquet;

    public AddRemoveAccessoryCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        int choice;
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
                choice = sc.nextInt();
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
                System.out.println("Добавлено аксесуар");
                break;
            case 2:
                int i = 0;
                ArrayList<Accessory> accessories = bouquet.getAccessories();
                if(!accessories.isEmpty()) {
                    for(Accessory accessory : accessories) {
                        i++;
                        System.out.printf("%d. %s\n", i,accessory);
                    }
                    System.out.println("Виберіть аксесуар для видалення:");
                    choice = sc.nextInt();
                    bouquet.removeAccessory(choice-1);;
                    System.out.println("Видалено аксесуар");
                }
                else{
                    System.out.println("Не знайдено аксесуарів");
                }
                break;
            default:
                System.out.println("Некоректний ввід");
        }
    }
}
