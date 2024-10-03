import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<Droid> teamBlue = new ArrayList<>();
    private ArrayList<Droid> teamRed = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    // Затримка результату в терміналі
    private void pause(){
        System.out.print("Enter для продвження...");
        scanner.nextLine();
    }

    // Головне меню
    public void showMenu() {
        while (true) {
            System.out.println("1. Створити дроїда");
            System.out.println("2. Видалити дроїда");
            System.out.println("3. Показати список дроїдів в командах");
            System.out.println("4. Запустити бій команда на команду");
            System.out.println("5. Записати проведений бій у файл");
            System.out.println("6. Відтворити проведений бій зі збереженого файлу");
            System.out.println("7. Вийти з програми");
            System.out.print("Оберіть дію: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createDroid();
                    pause();
                    break;
                case 2:
                    removeDroid();
                    pause();
                    break;
                case 3:
                    showTeams();
                    pause();
                    break;
                case 4:
                    startBattle();
                    pause();
                    break;
                case 5:
                    saveBattleToFile();
                    pause();
                    break;
                case 6:
                    loadBattleFromFile();
                    pause();
                    break;
                case 7:
                    System.out.println("Вихід з програми...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
            }
        }
    }

    // Створення дроїда
    private void createDroid() {
        System.out.println("1. Алхімік (отруює ворогів та посилює союзників)");
        System.out.println("2. Ассасін (швидкий воїн з шансом на ухилення від атаки та критчну шкоду)");
        System.out.println("3. Цілитель (лікує та знімає негативні ефекти з союзників)");
        System.out.println("3. Знемовлювач (знемовлює ворогів та повертає їм частину завданої шкоди)");
        System.out.print("Оберіть тип дроїда: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        Droid droid = null;
        switch (choice) {
            case 1:
                droid = createAlchemistDroid();
                break;
            case 2:
                droid = createAssassinDroid();
                break;
            case 3:
                droid = createHealerDroid();
                break;
            case 4:
                droid = createStunDroid();
                break;
            default:
                System.out.println("Неправильний вибір.");
                return;
        }

        System.out.println("1. Синя команда");
        System.out.println("2. Червона команда");
        System.out.print("Виберіть команду для цього дроїда: ");

        int teamChoice = scanner.nextInt();
        scanner.nextLine();
        if (teamChoice == 1) {
            teamBlue.add(droid);
            System.out.println("Дроїд " + droid.getName() + " додано до синьої команди!");
        } else if (teamChoice == 2) {
            teamRed.add(droid);
            System.out.println("Дроїд " + droid.getName() + " додано до червоної команди!");
        } else {
            System.out.println("Неправильний вибір команди.");
        }
    }

    // Метод для перевірки чи слід використовувати рекомендовані характеристики
    private boolean askForRecommendedStats() {
        System.out.print("Ви хочете використовувати рекомендовані характеристики? (так/ні): ");
        return scanner.nextLine().equalsIgnoreCase("так");
    }

    private Droid createDefaultDroid() {
        System.out.print("Введіть ім'я дроїда: ");
        String name = scanner.nextLine();
        System.out.print("Введіть кількість здоров'я: ");
        int health = scanner.nextInt();
        System.out.print("Введіть кількість шкоди: ");
        int damage = scanner.nextInt();
        System.out.print("Введіть кількість енергії: ");
        int power = scanner.nextInt();
        scanner.nextLine();
        return new Droid(name, health, damage, power);
    }

    private AlchemistDroid createAlchemistDroid() {
        if (askForRecommendedStats()) {
            System.out.print("Введіть ім'я дроїда: ");
            String name = scanner.nextLine();
            return new AlchemistDroid(name);
        } else {
            Droid droid = createDefaultDroid();
            System.out.print("Введіть вартість Отруєння: ");
            int poisonCost = scanner.nextInt();
            System.out.print("Введіть тривалість Отруєння: ");
            int poisonDuration = scanner.nextInt();
            System.out.print("Введіть вартість Підсилення: ");
            int boostCost = scanner.nextInt();
            System.out.print("Введіть тривалість Підсилення: ");
            int boostDuration = scanner.nextInt();
            scanner.nextLine();
            return new AlchemistDroid(droid.getName(), droid.getHealth(), droid.getDamage(), droid.getPower(), poisonCost, poisonDuration, boostCost, boostDuration);
        }
    }

    private AssassinDroid createAssassinDroid() {
        if (askForRecommendedStats()) {
            System.out.print("Введіть ім'я дроїда: ");
            String name = scanner.nextLine();
            return new AssassinDroid(name);
        } else {
            Droid droid = createDefaultDroid();
            System.out.print("Введіть шанс критичної шкоди: ");
            int critChance = scanner.nextInt();
            System.out.print("Введіть шанс ухилитись: ");
            int dodgeChance = scanner.nextInt();
            scanner.nextLine();
            return new AssassinDroid(droid.getName(), droid.getHealth(), droid.getDamage(), droid.getPower(), critChance, dodgeChance);
        }
    }

    private HealerDroid createHealerDroid() {
        if (askForRecommendedStats()) {
            System.out.print("Введіть ім'я дроїда: ");
            String name = scanner.nextLine();
            return new HealerDroid(name);
        } else {
            Droid droid = createDefaultDroid();
            System.out.print("Введіть вартість Лікування: ");
            int healCost = scanner.nextInt();
            System.out.print("Введіть вартість Очищення: ");
            int purifyCost = scanner.nextInt();
            System.out.print("Введіть к-сть Лікування: ");
            int healAmmount = scanner.nextInt();
            scanner.nextLine();
            return new HealerDroid(droid.getName(), droid.getHealth(), droid.getDamage(), droid.getPower(), healCost, purifyCost, healAmmount);
        }
    }

    private StunDroid createStunDroid() {
        if (askForRecommendedStats()) {
            System.out.print("Введіть ім'я дроїда: ");
            String name = scanner.nextLine();
            return new StunDroid(name);
        } else {
            Droid droid = createDefaultDroid();
            System.out.print("Введіть вартість Знемовлення: ");
            int stunCost = scanner.nextInt();
            System.out.print("Введіть тривалість Знемовлення: ");
            int stunDuration = scanner.nextInt();
            System.out.print("Введіть відсоток поверненої шкоди: ");
            double reflectedPercentage = scanner.nextDouble();
            scanner.nextLine();
            return new StunDroid(droid.getName(), droid.getHealth(), droid.getDamage(), droid.getPower(), stunCost, stunDuration, reflectedPercentage);
        }
    }

    private void removeDroid(){
        System.out.println("1. Синя команда");
        System.out.println("2. Червона команда");
        System.out.print("Виберіть команду для видалення дроїда: ");

        int teamChoice = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Droid> selectedTeam = null;

        if (teamChoice == 1) {
            selectedTeam = teamBlue;
        } else if (teamChoice == 2) {
            selectedTeam = teamRed;
        } else {
            System.out.println("Неправильний вибір команди.");
            return;
        }

        if (selectedTeam.isEmpty()) {
            System.out.println("У цій команді немає дроїдів.");
            return;
        }

        System.out.println("Дроїди в команді:");
        for (int i = 0; i < selectedTeam.size(); i++) {
            System.out.println(i + 1 + ". " + selectedTeam.get(i));
        }

        System.out.print("Виберіть номер дроїда для видалення: ");
        int droidIndex = scanner.nextInt();
        scanner.nextLine();

        if (droidIndex > 0 && droidIndex <= selectedTeam.size()) {
            Droid removedDroid = selectedTeam.remove(droidIndex - 1);
            System.out.println("Дроїд " + removedDroid.getName() + " був видалений з команди.");
        } else {
            System.out.println("Неправильний вибір дроїда.");
        }
    }

    private void showTeams() {
        System.out.println("Синя команда:");
        if (teamBlue.isEmpty()) {
            System.out.println("Немає дроїдів.");
        } else {
            for (Droid d : teamBlue) {
                System.out.println(d);
            }
        }

        System.out.println("Червона команда:");
        if (teamRed.isEmpty()) {
            System.out.println("Немає дроїдів.");
        } else {
            for (Droid d : teamRed) {
                System.out.println(d);
            }
        }
    }


    ArrayList<Droid> blueTeamCopy = new ArrayList<>();
    ArrayList<Droid> redTeamCopy = new ArrayList<>();

    private void startBattle() {
        if (teamBlue.isEmpty() || teamRed.isEmpty()) {
            System.out.println("Обидві команди повинні містити хоча б одного дроїда.");
            return;
        }
        blueTeamCopy.clear();
        redTeamCopy.clear();
        // Копіювання з основного масиву
        for (Droid d : teamBlue) {
            blueTeamCopy.add(d.clone());
        }
        for (Droid d : teamRed) {
            redTeamCopy.add(d.clone());
        }
        Battle.battle(blueTeamCopy, redTeamCopy);
    }

    private void saveBattleToFile() {
        System.out.print("Введіть назву файлу для запису бою: ");
        String filename = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Синя команда:\n");
            for (Droid d : teamBlue) {
                writer.write(d.toString() + "\n");
            }
            writer.write("Червона команда:\n");
            for (Droid d : teamRed) {
                writer.write(d.toString() + "\n");
            }
            writer.write("Переможець: " + (blueTeamCopy.isEmpty() ? "Червоні" : "Сині") + "\n");
            System.out.println("Бій успішно записано у файл.");
        } catch (IOException e) {
            System.out.println("Помилка при записі файлу: " + e.getMessage());
        }
    }

    private void loadBattleFromFile() {
        System.out.print("Введіть назву файлу для завантаження бою: ");
        String filename = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Помилка при завантаженні файлу: " + e.getMessage());
        }
    }
}


