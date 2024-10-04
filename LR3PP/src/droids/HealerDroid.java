package droids;

import java.util.ArrayList;

public class HealerDroid extends Droid {
    private int healCost;
    private int purifyCost;
    private int healAmount;

    // Рекомендовані характеристики
    public HealerDroid(String name) {
        super(name, 100, 10, 60);
        setHealCost(20);
        setPurifyCost(40);
        setHealAmount(30);
    }

    public HealerDroid(String name, int health, int damage, int power, int healCost, int healAmount, int purifyCost) {
            super(name, health, damage, power);
            setHealCost(healCost);
            setHealAmount(healAmount);
            setPurifyCost(purifyCost);
    }

    public int getHealCost() {return healCost;}
    public int getHealAmount() {return healAmount;}
    public int getPurifyCost() {return purifyCost;}

    private void setHealCost(int healCost) {this.healCost = healCost;}
    private void setHealAmount(int healAmount) {this.healAmount = healAmount;}
    private void setPurifyCost(int purifyCost) {this.purifyCost = purifyCost;}

    @Override
    public void takeTurn(ArrayList<Droid> allies, ArrayList<Droid> enemies) {
        if (!hasEffect("Знемовленний")) {
            int maxNegativeEffectsIndex = findMaxEffects(allies);
            int weakestDroid = findLowestHealth(allies);
            if (purifyCost <= getPower() && maxNegativeEffectsIndex != -1) {
                cast(purifyCost);
                purify(allies.get(maxNegativeEffectsIndex));
            } else if (healCost <= getPower() && allies.get(weakestDroid).getHealth() <= 50) {
                cast(healCost);
                heal(allies.get(weakestDroid), healAmount);
            } else {
                attack(enemies);
            }
        }
    }

    private void purify(Droid otherDroid){
        System.out.println(getName() + BattleVisualizer.GREEN + " знімає негативні ефекти" + BattleVisualizer.RESET +  " з "  + otherDroid.getName());
        otherDroid.removeNegativeEffects();
    }

    private void heal(Droid otherDroid,int healAmount) {
        System.out.println(getName() + BattleVisualizer.GREEN + " лікує "+ BattleVisualizer.RESET + otherDroid.getName());
        otherDroid.gainHealth(healAmount);
    }

    // Пошук союзника з найбільшою к-сю негативних еффектів
    public int findMaxEffects(ArrayList<Droid> droids){
        int max = droids.getFirst().getNegativeEffects();
        int maxIndex = 0;
        for (int i = 1; i < droids.size(); i++) {
            if(droids.get(i).getNegativeEffects() > max){
                max = droids.get(i).getNegativeEffects();
                maxIndex = i;
            }
        }
        return max > 0 ? maxIndex : -1;
    }

    // Пошук союзника з найменшою к-стю здоровя
    public int findLowestHealth(ArrayList<Droid> droids){
        int min = droids.getFirst().getHealth();
        int minIndex = 0;
        for(int i = 1; i < droids.size(); i++){
            if(droids.get(i).getHealth() < min){
                min = droids.get(i).getHealth();
                minIndex = i;
            }
        }
        return minIndex;
    }

    @Override
    public HealerDroid clone() {
        return new HealerDroid(getName(), getHealth(), getDamage(), getPower(), getHealCost(), getHealAmount(), getPurifyCost());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Вартість лікування = " + getHealCost() +
                ", К-сть лікування = " + getHealAmount() +
                ", Вартість очищення = " + getPurifyCost();
    }
}
