package command;

import bouquet.Bouquet;
import flower.Daisy;
import flower.Rose;
import flower.Tulip;

import java.util.Scanner;

public class AddRemoveFlowerCommand implements Command {
    private Bouquet bouquet;

    public AddRemoveFlowerCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Додати квітку");
        System.out.println("2. Видалити квітку");
        System.out.print("Оберіть опцію: ");
        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                System.out.println("1. Троянда");
                System.out.println("2. Ромашка");
                System.out.println("3. Тюльпан");
                System.out.print("Оберіть квітку: ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        bouquet.addFlower(new Rose());
                        break;
                    case 2:
                        bouquet.addFlower(new Daisy());
                        break;
                    case 3:
                        bouquet.addFlower(new Tulip());
                        break;
                    default:
                        System.out.println("Некоректний ввід");
                }
                break;
            case 2:
                bouquet.removeFlower();
                break;
            default:
                System.out.println("Некоректний ввід");
        }
    }
}
