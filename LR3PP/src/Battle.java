import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Battle {

    // Затримка виводу
    public static void delay(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Помилка");
        }
    }

    public static void battle(ArrayList<Droid> teamBlue, ArrayList<Droid> teamRed) {
        Random random = new Random();

        boolean teamTurn = random.nextBoolean();
        System.out.println(BattleVisualizer.BOLD + BattleVisualizer.YELLOW + "=== Початок битви ===" + BattleVisualizer.RESET);

        while (!teamBlue.isEmpty() && !teamRed.isEmpty()) {

            if (teamTurn) {
                System.out.println(BattleVisualizer.BLUE + BattleVisualizer.BOLD + "Хід синьої команди" + BattleVisualizer.RESET);
                Collections.shuffle(teamBlue);
                for (Droid d : teamBlue) {
                    if (teamRed.isEmpty()) break;
                    d.takeTurn(teamBlue, teamRed);
                    d.updateEffects();
                    delay();
                }
            }
            else {
                System.out.println(BattleVisualizer.RED + BattleVisualizer.BOLD + "Хід червоних" + BattleVisualizer.RESET);
                Collections.shuffle(teamRed);
                for (Droid d : teamRed) {
                    if (teamBlue.isEmpty()) break;
                    d.takeTurn(teamRed, teamBlue);
                    d.updateEffects();
                    delay();
                }
            }
            teamTurn = !teamTurn;

            if(teamBlue.isEmpty()){
                System.out.println(BattleVisualizer.YELLOW + BattleVisualizer.BOLD + "Перемогли червоні" + BattleVisualizer.RESET);
            }
            else if(teamRed.isEmpty()) {
                System.out.println(BattleVisualizer.YELLOW + BattleVisualizer.BOLD + "Перемогли сині" + BattleVisualizer.RESET);
            }
        }
    }
}
