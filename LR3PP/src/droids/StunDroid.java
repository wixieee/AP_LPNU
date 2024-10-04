package droids;

import java.util.ArrayList;
import java.util.Random;

public class StunDroid extends Droid {
    private int stunCost;
    private int stunDuration;
    private double reflectedPercentage;

    // Рекомендовані характеристики
    public StunDroid(String name){
        super(name, 165, 20, 30);
        setStunCost(15);
        setStunDuration(1);
        setReflectedPercentage(0.2);
    }

    public StunDroid(String name, int health, int damage, int power, int stunCost, int stunDuration, double reflectedPercentage) {
        super(name, health, damage, power);
        setStunCost(stunCost);
        setStunDuration(stunDuration);
        setReflectedPercentage(reflectedPercentage);
    }

    public int getStunCost() {return stunCost;}
    public int getStunDuration() {return stunDuration;}
    public double getReflectedPercentage() {return reflectedPercentage;}

    private void setStunDuration(int stunDuration) {this.stunDuration = stunDuration;}
    private void setStunCost(int stunCost) {this.stunCost = stunCost;}
    private void setReflectedPercentage(double reflectedPercentage) {this.reflectedPercentage = reflectedPercentage;}

    @Override
    public void takeTurn(ArrayList<Droid> allies, ArrayList<Droid> enemies) {
        if(getHealth() > 0 && !hasEffect("Знемовленний")){
            Random rand = new Random();
            if(stunCost <= getPower() && rand.nextBoolean()){
                cast(getStunCost());
                stun(enemies);
            }
            else{
                attack(enemies);
            }
        }
    }

    public void stun(ArrayList<Droid> enemies){
        Random random = new Random();
        int enemy = random.nextInt(enemies.size());
        System.out.println(getName() + BattleVisualizer.ORANGE + " знемовлює " + BattleVisualizer.RESET + enemies.get(enemy).getName() + " на " + BattleVisualizer.YELLOW + getStunDuration() + BattleVisualizer.RESET + " ходів");
        enemies.get(enemy).addEffect("Знемовленний", getStunDuration());
    }

    @Override
    // Повернення шкоди
    public void takeDamage(int damage, Droid attacker, boolean isReflected) {
        super.takeDamage(damage, attacker, isReflected);

        if(!isReflected){
            int reflectedDamage = (int) (damage * getReflectedPercentage());
            if (this.getHealth() - reflectedDamage <= 0){
                reflectedDamage = getHealth() - 1;
                System.out.println(getName() + " повертає " + BattleVisualizer.RED + reflectedDamage + BattleVisualizer.RESET + " шкоди " + attacker.getName() +  " (на межі смерті)");
                attacker.takeDamage(reflectedDamage, this, true);
            }
            else {
                System.out.println(getName() + " повертає " + BattleVisualizer.RED + reflectedDamage + BattleVisualizer.RESET + " шкоди " + attacker.getName());
                attacker.takeDamage(reflectedDamage, this, true);
            }

        }
    }

    @Override
    public StunDroid clone() {
        return new StunDroid(getName(), getHealth(), getDamage(), getPower(), getStunCost(), getStunDuration(), getReflectedPercentage());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Вартість знемовлення = " + getStunCost() +
                ", Тривалість знемовлення = " + getStunDuration() +
                ", Відсоток поверненої шкоди = " + getReflectedPercentage();
    }
}
