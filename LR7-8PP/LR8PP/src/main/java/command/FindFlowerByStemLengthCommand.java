package command;

import bouquet.Bouquet;
import flower.Flower;

import java.util.ArrayList;
import java.util.Scanner;

import static main.Main.logger;

public class FindFlowerByStemLengthCommand implements Command {
    private Bouquet bouquet;

    public FindFlowerByStemLengthCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        ArrayList<Flower> result;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть мінімальну довжину стебла:");
        int minLength = scanner.nextInt();
        System.out.println("Введіть максимальну довжину стебла:");
        int maxLength = scanner.nextInt();

        result = bouquet.findFlowerByStemLength(minLength, maxLength);
        if(result.isEmpty()){
            System.out.println("Не знайдено квітів в діапазоні");
        }
        else {
            logger.info("Знайдені квіти в діапазоні({} - {}):", minLength, maxLength);
            for (Flower flower : result) {
                logger.info(flower);
            }
        }
    }
}
