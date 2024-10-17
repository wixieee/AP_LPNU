package command;

import bouquet.Bouquet;

import java.util.Scanner;

public class FindFLowerByStemLengthCommand implements Command {
    private Bouquet bouquet;

    public FindFLowerByStemLengthCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть мінімальну довжину стебла:");
        int minLength = scanner.nextInt();
        System.out.println("Введіть максимальну довжину стебла:");
        int maxLength = scanner.nextInt();

        bouquet.findFlowerByStemLength(minLength, maxLength);
    }
}
