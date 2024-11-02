package homework2.Heroes;

import homework2.Enemies.Enemy;
import homework2.Main.Mortal;

public abstract class Hero implements Mortal {
    private final String name;
    private int health;
    protected int damage = 1;
    protected final String heroType = this.getClass().getSimpleName();

    public Hero(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public String getHeroType() {
        return heroType;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    @Override
    public void takeDamage(int damage) {
        health -= damage;
        final String HERO_TAKES_DAMAGE = heroType + " takes " + damage + " damage!\n" + heroType + " health is now " + health;
        System.out.println(HERO_TAKES_DAMAGE);
    }


    @Override
    public boolean isAlive() {
        return health > 0;
    }

    public abstract void attackEnemy(Enemy enemy);
}
