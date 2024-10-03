import java.util.ArrayList;
import java.util.Random;

public class AlchemistDroid extends Droid {
    private int poisonCost;
    private int poisonDuration;
    private int boostCost;
    private int boostDuration;

    public int getPoisonCost() {return poisonCost;}
    public int getPoisonDuration() {return poisonDuration;}
    public int getBoostCost() {return boostCost;}
    public int getBoostDuration() {return boostDuration;}

    private void setPoisonCost(int poisonCost) {this.poisonCost = poisonCost;}
    private void setPoisonDuration(int poisonDuration) {this.poisonDuration = poisonDuration;}
    private void setBoostCost(int boostCost) {this.boostCost = boostCost;}
    private void setBoostDuration(int boostDuration) {this.boostDuration = boostDuration;}

    //Рекомендовані характеристики
    public AlchemistDroid(String name) {
        super(name, 90, 5, 45);
        setPoisonCost(15);
        setPoisonDuration(3);
        setBoostCost(15);
        setBoostDuration(2);
    }

    public AlchemistDroid(String name, int health, int damage, int power, int poisonCost, int poisonDuration, int boostCost, int boostDuration) {
        super(name, health, damage, power);
        setPoisonCost(poisonCost);
        setPoisonDuration(poisonDuration);
        setBoostCost(boostCost);
        setBoostDuration(boostDuration);
    }

    public void poison(Droid enemy) {
        System.out.println(getName() + BattleVisualizer.PURPLE + " отруює " + BattleVisualizer.RESET + enemy.getName() + " на " + BattleVisualizer.YELLOW + getPoisonDuration() + BattleVisualizer.RESET + " ходів");
        enemy.addEffect("Отруєнний", getPoisonDuration());
    }

    public void boost(Droid ally) {
        System.out.println(getName() + BattleVisualizer.PINK + " підсилює " + BattleVisualizer.RESET + ally.getName() + " на " + BattleVisualizer.YELLOW + getBoostDuration() + BattleVisualizer.RESET + " ходів");
        ally.addEffect("Підсилений", getBoostDuration());
    }

    @Override
    public AlchemistDroid clone() {
        return new AlchemistDroid(getName(), getHealth(), getDamage(), getPower(), getPoisonCost(), getPoisonDuration(), getBoostCost(), getBoostDuration());
    }

    @Override
    public void takeTurn(ArrayList<Droid> allies, ArrayList<Droid> enemies) {
        Random random = new Random();
        int droid = random.nextInt(enemies.size());
        if(!hasEffect("Знемовленний")) {
            if(getPower() >= getPoisonCost() && random.nextBoolean() && !enemies.get(droid).hasEffect("Отруєнний")) {
                cast(getPoisonCost());
                poison(enemies.get(droid));
            }
            else if(!random.nextBoolean()){
                cast(getBoostCost());
                boost(allies.get(droid));
            }
            else {
                attack(enemies);
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Вартість отруєння = " + getPoisonCost() +
                ", Тривалість отруєння = " + getPoisonDuration() +
                ", Вартість посилення = " + getBoostCost() +
                ", Тривалість посилення = " + getBoostDuration();
    }
}
