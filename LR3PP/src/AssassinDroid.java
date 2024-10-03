import java.util.ArrayList;
import java.util.Random;

public class AssassinDroid extends Droid {
    private int critChance;
    private int dodgeChance;

    // Рекомендовані характеристики
    public AssassinDroid(String name){
        super(name, 115, 35, 0);
        setCritChance(10);
        setDodgeChance(15);
    }

    public AssassinDroid(String name, int health, int damage, int power, int critChance, int dodgeChance){
        super(name, health, damage, power);
        setCritChance(critChance);
        setDodgeChance(dodgeChance);
    }

    public int getCritChance(){return critChance;}
    public int getDodgeChance(){return dodgeChance;}

    private void setCritChance(int chance){this.critChance = chance;}
    private void setDodgeChance(int chance){this.dodgeChance = chance;}

    @Override
    // Шанс завдати критичної шкоди
    public void attack(ArrayList<Droid> enemies) {
        if (hasEffect("Знемовленний")) {
            System.out.println(getName() + " не може атакувати, оскільки він" + BattleVisualizer.ORANGE + " знемовленний" + BattleVisualizer.RESET);
            return;
        }
        Random random = new Random();
        int enemy = random.nextInt(enemies.size());

        if (random.nextInt(0, 100) <= getCritChance()) {
            if(this.hasEffect("Підсилений")){
                int critDamage = (int)(getDamage() * 1.2 * 2);
                System.out.println(getName() + BattleVisualizer.MAROON + " завдає критичної шкоди " + BattleVisualizer.RESET + enemies.get(enemy).getName());
                enemies.get(enemy).takeDamage(critDamage, this,false);
            }
            else {
                int critDamage = getDamage() * 2;
                System.out.println(getName() + BattleVisualizer.MAROON + " завдає критичної шкоди " + BattleVisualizer.RESET + enemies.get(enemy).getName());
                enemies.get(enemy).takeDamage(critDamage, this,false);
            }
            if (enemies.get(enemy).getHealth() <= 0) {
                System.out.println(enemies.get(enemy).getName() + BattleVisualizer.RED + " було знищено!" + BattleVisualizer.RESET);
                enemies.remove(enemy);
            }
        } else {
            super.attack(enemies);
        }
    }



    @Override
    // Шанс ухилитись від атаки
    public void takeDamage(int damage, Droid attacker, boolean isReflected) {
        Random random = new Random();
        if(!hasEffect("Знемовленний") && !hasEffect("Отруєнний") && random.nextInt(0, 100) <= getDodgeChance()){
            System.out.println(getName() + BattleVisualizer.DARK_BLUE + " ухилився " + BattleVisualizer.RESET + "від атаки");
        }
        else{
            super.takeDamage(damage, attacker, isReflected);
        }
    }

    @Override
    public AssassinDroid clone() {
        return new AssassinDroid(getName(), getHealth(), getDamage(), getPower(), getCritChance(), getDodgeChance());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Шанс критичного удару = " + getCritChance() +
                ", Шанс ухилитись = " + getDodgeChance();
    }
}
