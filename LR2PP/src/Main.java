import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    static boolean name_compare(Product p, String name) {
        return p.getName().equalsIgnoreCase(name);
    }

    static boolean price_compare(Product p, double price) {
        return p.getPrice() <= price;
    }

    static boolean shelf_life_compare(Product p, int shelf_life) {
        return p.getShelfLife() > shelf_life;
    }

    //Пошук товарів з заданою назвою
    static void name_search(ArrayList<Product> list) {
        String name;
        do{
            System.out.print("Введіть назву продукта: ");
            name = sc.nextLine();
        }while (name.isEmpty());
        boolean found = false;
        for(Product p : list){
            if(name_compare(p,name)){
                System.out.println(p);
                found = true;
            }
        }
        if(!found){
            System.out.println("Не знайдено таких товарів");
        }
    }

    //Пошук товарів для заданого найменування, ціна яких не перевищує задану
    static void price_search(ArrayList<Product> list) {
        String name;
        do{
            System.out.print("Введіть назву продукта: ");
            name = sc.nextLine();
        }while (name.isEmpty());
        double price = -1;
        do{
            try {
                System.out.print("Введіть ціну продукта: ");
                price = sc.nextDouble();
            }catch (InputMismatchException e){
                System.out.println("Некоректний ввід");
                sc.nextLine();
            }
        }while(price < 0);
        sc.nextLine();
        boolean found = false;
        for(Product p : list){
            if(name_compare(p,name) && price_compare(p,price)){
                System.out.println(p);
                found = true;
            }
        }
        if(!found){
            System.out.println("Не знайдено таких товарів");
        }
    }

    //Пошук товарів, термін зберігання яких більше заданого
    static void shelf_life_search(ArrayList<Product> list) {
        int shelf_life = -1;
        do{
            try {
                System.out.print("Введіть термін зберігання продукта: ");
                shelf_life = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Некоректний ввід");
                sc.nextLine();
            }
        }while(shelf_life < 0);
        sc.nextLine();
        boolean found = false;
        for(Product p : list){
            if(shelf_life_compare(p,shelf_life)){
                System.out.println(p);
                found = true;
            }
        }
        if(!found){
            System.out.println("Не знайдено таких товарів");
        }
    }

    public static void main(String[] args) {
        ArrayList<Product> list = new ArrayList<>();
        //Товари
        list.add(new Product(1, "Молоко", "Молокія", 35.50, 7, 100));
        list.add(new Product(2, "Хліб", "Пекарня", 20.00, 3, 200));
        list.add(new Product(3, "Масло", "Ферма", 80.75, 14, 50));
        list.add(new Product(4, "Сир", "Комо", 150.00, 30, 25));
        list.add(new Product(5, "Яблуко", "Фруктик", 15.00, 10, 150));

        //Меню
        int choice = 0;
        do{
            System.out.println("Меню:");
            System.out.println("1.Список товарів для заданого найменування");
            System.out.println("2.Список товарів для заданого найменування, ціна яких не перевищує задану");
            System.out.println("3.Список товарів, термін зберігання яких більше заданого");
            System.out.println("4.Вихід");
            do{
                try {
                    choice = 0;
                    System.out.print("Виберіть варіант: ");
                    choice = sc.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("Некоректний ввід");
                    sc.nextLine();
                }
            }while(choice < 1 || choice > 4);
            sc.nextLine();
            switch(choice) {
                case 1:
                    name_search(list);
                    System.out.print("Enter для продовження...");
                    sc.nextLine();
                    break;
                case 2:
                    price_search(list);
                    System.out.print("Enter для продовження...");
                    sc.nextLine();
                    break;
                case 3:
                    shelf_life_search(list);
                    System.out.print("Enter для продовження...");
                    sc.nextLine();
                    break;
                case 4:
                    sc.close();
                    break;
                default:
                    System.out.println("Некоректний ввід");
                    break;
            }
        }while(choice != 4);
    }
}

