package bouquet;

import accessory.Accessory;
import flower.Flower;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Bouquet {
    private ArrayList<Flower> flowers;
    private ArrayList<Accessory> accessories;

    public Bouquet() {
        this.flowers = new ArrayList<>();
        this.accessories = new ArrayList<>();
    }

    public ArrayList<Flower> getFlowers() {return flowers;}
    public ArrayList<Accessory> getAccessories() {return accessories;}

    public void addFlower(Flower flower) {
        flowers.add(flower);
        System.out.println("Добавлено квітку");
    }

    public void removeFlower() {
        int i = 0;
        if(!flowers.isEmpty()) {
            for(Flower flower : flowers) {
                i++;
                System.out.printf("%d. %s\n", i,flower);
            }
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            flowers.remove(flowers.get(choice-1));
            System.out.println("Видалено квітку");
        }
        else{
            System.out.println("Не знайдено квітів");
        }
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
        System.out.println("Добавлено аксесуар");
    }

    public void removeAccessory() {
        int i = 0;
        if(!accessories.isEmpty()) {
            for(Accessory accessory : accessories) {
                i++;
                System.out.printf("%d. %s\n", i,accessory);
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("Виберіть аксесуар для видалення:");
            int choice = sc.nextInt();
            accessories.remove(accessories.get(choice-1));
            System.out.println("Видалено аксесуар");
        }
        else{
            System.out.println("Не знайдено аксесуарів");
        }
    }

    public void calculatePrice(){
        double flowerPrice = 0;
        double accessoriesPrice = 0;
        double sum = 0;
        if(!flowers.isEmpty()){
            for (Flower flower : flowers) {
                flowerPrice += flower.getPrice();
            }
            System.out.println("Вартість квітів: " + flowerPrice + " грн.");
        }
        if(!accessories.isEmpty()){
            for (Accessory accessory : accessories) {
                accessoriesPrice += accessory.getPrice();
            }
            System.out.println("Вартість аксесуарів: " + accessoriesPrice + " грн.");
        }
        sum = flowerPrice + accessoriesPrice;
        if(sum > 0){
            System.out.println("Загальна вартість букета: " + sum + " грн.");
        }
        else {
            System.out.println("Не знайдено букет");
        }

    }

    public void sortByFreshness(){
        if(!flowers.isEmpty()){
            flowers.sort(Comparator.comparingInt(Flower::getFreshness).reversed());
            System.out.println("Квіти відсортовано за свіжістю.");
        }
        else{
            System.out.println("Не знайдено букет");
        }
    }

    public void findFlowerByStemLength(int minLength , int maxLength){
        ArrayList<Flower> result = new ArrayList<>();
        for (Flower flower : flowers) {
            int stemLength = flower.getStemLengthCm();
            if (stemLength >= minLength && stemLength <= maxLength) {
                result.add(flower);
            }
        }
        if(result.isEmpty()){
            System.out.println("Не знайдено квітів в діапазоні");
        }
        else {
            System.out.println("Знайдені квіти:");
            for (Flower flower : result) {
                System.out.println(flower);
            }
        }
    }

    public void displayBouquet(){
        if(!flowers.isEmpty()){
            System.out.println("Квіти у букеті: ");
            for (Flower flower : flowers) {
                System.out.println(flower);
            }
        }
        else{
            System.out.println("Не знайдено букет");
        }
        if(!accessories.isEmpty()){
            System.out.println("Аксесуари у букеті: ");
            for (Accessory accessory : accessories) {
                System.out.println(accessory);
            }
        }
    }
}
