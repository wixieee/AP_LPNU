package droids;

import java.util.*;

public class Droid {
    private String name;
    private int health;
    private int damage;
    private int power;

    public Droid(String name, int health, int damage, int power) {
        setName(name);
        setHealth(health);
        setDamage(damage);
        setPower(power);
    }

    public String getName() {return name;}
    public int getDamage() {return damage;}
    public int getHealth() {return health;}
    public int getPower() {return power;}

    private void setName(String name) {this.name = name;}
    private void setDamage(int damage) {this.damage = damage;}
    private void setHealth(int health) {this.health = health;}
    private void setPower(int power) {this.power = power;}

    private List<String> activeEffects = new ArrayList<>();
    private Map<String, Integer> effectDurations = new HashMap<>();

    // К-сть негативних ефектів на дроїді
    public int getNegativeEffects() {
        int negativeEffects = 0;
        for (String effect : activeEffects) {
            if (effect.equals("Знемовленний") || effect.equals("Отруєнний")) {
                negativeEffects++;
            }
        }
        return negativeEffects;
    }

    public void removeNegativeEffects() {
        List<String> effectsToRemove = new ArrayList<>();
        for (String effect : activeEffects) {
            if (effect.equals("Знемовленний") || effect.equals("Отруєнний")) {
                effectsToRemove.add(effect);
            }
        }
        activeEffects.removeAll(effectsToRemove);
        for (String effect : effectsToRemove) {
            effectDurations.remove(effect);
        }
    }

    public void addEffect(String effect, Integer duration){
        activeEffects.add(effect);
        effectDurations.put(effect, duration);
    }

    public boolean hasEffect(String effect){
        return activeEffects.contains(effect);
    }

    // Зменшення тривалості ефектів
    public void updateEffects(){
        if (activeEffects.isEmpty()){
            return;
        }
        List<String> effectsToRemove = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : effectDurations.entrySet()){
            int remainingDuration = entry.getValue() - 1;

            if(entry.getKey().equals("Отруєнний")){
                takePoisonDamage(15);
            }
            if(remainingDuration <= 0){
                System.out.println(name + " втратив ефект " + BattleVisualizer.YELLOW + entry.getKey() + BattleVisualizer.RESET);
                effectsToRemove.add(entry.getKey());
            }
            else{
                entry.setValue(remainingDuration);
            }
        }
        activeEffects.removeAll(effectsToRemove);
        for(String effect : effectsToRemove){
            effectDurations.remove(effect);
        }
    }

    public void attack(ArrayList<Droid> enemies) {
        if(hasEffect("Знемовленний")){
            System.out.println(name + " не може атакувати, оскільки він" + BattleVisualizer.ORANGE + " знемовленний" + BattleVisualizer.RESET);
            return;
        }
        Random random = new Random();
        int enemy = random.nextInt(enemies.size());
        System.out.println(getName() + BattleVisualizer.RED + " атакує " + BattleVisualizer.RESET + enemies.get(enemy).getName());
        if(this.hasEffect("Підсилений")){
            enemies.get(enemy).takeDamage((int)(this.getDamage() * 1.2), this,false);
        }
        else{
            enemies.get(enemy).takeDamage(this.getDamage(), this,false);
        }
        if (enemies.get(enemy).getHealth() <= 0) {
            System.out.println(enemies.get(enemy).getName() + BattleVisualizer.RED + " було знищено!" + BattleVisualizer.RESET);
            enemies.remove(enemy);
        }
    }

    public void takePoisonDamage(int damage) {
        if (this.health - damage <= 0) {
            this.health = 1;
            System.out.println(this.name + " отримав " + BattleVisualizer.RED + damage + BattleVisualizer.RESET + " шкоди від " + BattleVisualizer.PURPLE + "отрути" + BattleVisualizer.RESET + ". Залишилося здоров'я: " + BattleVisualizer.GREEN + this.health + BattleVisualizer.RESET + " (на межі смерті)");
        } else {
            this.health -= damage;
            System.out.println(this.name + " отримав " + BattleVisualizer.RED + damage + BattleVisualizer.RESET + " шкоди від " + BattleVisualizer.PURPLE + "отрути" + BattleVisualizer.RESET + ". Залишилося здоров'я: " + BattleVisualizer.GREEN + this.health + BattleVisualizer.RESET);
        }
    }

    public void takeDamage(int damage, Droid attacker, boolean isReflected) {
        this.health -= damage;
        System.out.println(this.name + " отримав " + BattleVisualizer.RED + damage + BattleVisualizer.RESET + " шкоди. Залишилося здоров'я: " + BattleVisualizer.GREEN + this.health + BattleVisualizer.RESET);
    }

    public void takeTurn(ArrayList<Droid> allies, ArrayList<Droid> enemies){
        attack(enemies);
    }

    public void cast(int cost){
        this.power -= cost;
    }

    public void gainHealth(int healAmount) {
        this.health += healAmount;
        System.out.println(this.name + " вилікував "  + BattleVisualizer.GREEN + healAmount + BattleVisualizer.RESET + " здоров'я. Залишилося здоров'я: " + BattleVisualizer.GREEN + this.health + BattleVisualizer.RESET);
    }

    public Droid clone() {
        return new Droid(this.name, this.health, this.damage, this.power);
    }

    @Override
    public String toString() {
        return "Назва = '" + name + '\'' +
                ", Здоров'я = " + health +
                ", Шкода = " + damage +
                ", Енергія = " + power;
    }
}
