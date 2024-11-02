package homework2.Enemies;

import homework2.Heroes.Hero;
import homework2.Main.Mortal;

public class Enemy implements Mortal {
    protected int health;
    protected final String enemyType = this.getClass().getSimpleName();
    private int damage = 1;

    public Enemy(int health) {
        this.health = health;
    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public String getEnemyType() {
        return enemyType;
    }

    public void attackHero(Hero hero) {
        System.out.println(enemyType + " attacks " + hero.getName());
        hero.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        final String ENEMY_TAKES_DAMAGE = enemyType + " takes " + damage + " damage!\n"+enemyType + " health is now " + health;
        System.out.println(enemyType + " takes " + damage + " damage!");
    }


    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
