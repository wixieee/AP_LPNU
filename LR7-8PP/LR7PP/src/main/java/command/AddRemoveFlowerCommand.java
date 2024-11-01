package command;

import bouquet.Bouquet;
import flower.Daisy;
import flower.Flower;
import flower.Rose;
import flower.Tulip;

import java.util.ArrayList;
import java.util.Scanner;

public class AddRemoveFlowerCommand implements Command {
    private Bouquet bouquet;

    public AddRemoveFlowerCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        int choice;
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
                choice = sc.nextInt();
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
                System.out.println("Добавлено квітку");
                break;
            case 2:
                int i = 0;
                ArrayList<Flower> flowers = bouquet.getFlowers();
                if(!flowers.isEmpty()) {
                    for(Flower flower : flowers) {
                        i++;
                        System.out.printf("%d. %s\n", i,flower);
                    }
                    choice = sc.nextInt();
                    bouquet.removeFlower((choice-1));
                    System.out.println("Видалено квітку");
                }
                else{
                    System.out.println("Не знайдено квітів");
                }
                break;
            default:
                System.out.println("Некоректний ввід");
        }
    }
}
