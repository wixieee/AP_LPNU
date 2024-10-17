package menu;

import command.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Map<Integer, Command> commands = new HashMap<>();

    public void addCommand(int option, Command command) {
        commands.put(option, command);
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int option;

        do{
            System.out.println("==== Меню ====");
            System.out.println("1. Додати/Видалити квітку до букета");
            System.out.println("2. Додати/Видалити аксесуари");
            System.out.println("3. Обчислити вартість букета");
            System.out.println("4. Сортувати квіти за свіжістю");
            System.out.println("5. Знайти квітку за довжиною стебла");
            System.out.println("6. Переглянути букет");
            System.out.println("7. Вийти");
            System.out.print("Оберіть опцію: ");
            option = sc.nextInt();
            sc.nextLine();

            Command cmd = commands.get(option);
            if (cmd != null) {
                cmd.execute();
            } else if (option != 7) {
                System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        } while (option != 7);

        System.out.println("Програма завершена.");
        sc.close();
    }
}
