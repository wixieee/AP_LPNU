package bouquet;

import accessory.Accessory;
import flower.Flower;

import java.util.ArrayList;
import java.util.Comparator;

import static main.Main.logger;


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
    }

    public void removeFlower(int index) {
        flowers.remove(flowers.get(index));
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
    }

    public void removeAccessory(int index) {
        accessories.remove(accessories.get(index));
    }

    public double calculatePrice() {
        double flowerPrice = 0;
        double accessoriesPrice = 0;

        for (Flower flower : flowers) {
            flowerPrice += flower.getPrice();
        }
        for (Accessory accessory : accessories) {
            accessoriesPrice += accessory.getPrice();
        }

        return flowerPrice + accessoriesPrice;
    }

    public ArrayList<Flower> sortByFreshness(){
        flowers.sort(Comparator.comparingInt(Flower::getFreshness).reversed());
        return flowers;
    }

    public ArrayList<Flower> findFlowerByStemLength(int minLength , int maxLength){
        ArrayList<Flower> result = new ArrayList<>();
        for (Flower flower : flowers) {
            int stemLength = flower.getStemLengthCm();
            if (stemLength >= minLength && stemLength <= maxLength) {
                result.add(flower);
            }
        }
        return result;
    }

    public void displayBouquet(){
        if(!flowers.isEmpty()){
            logger.info("Квіти у букеті: ");
            for (Flower flower : flowers) {
                logger.info(flower);
            }
        }
        else{
            System.out.println("Не знайдено букет");
        }
        if(!accessories.isEmpty()){
            logger.info("Аксесуари у букеті: ");
            for (Accessory accessory : accessories) {
                logger.info(accessory);
            }
        }
    }
}
