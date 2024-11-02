package homework2.Heroes;

import homework2.Enemies.Enemy;

public class Warrior extends Hero{
    public Warrior(String name, int health){
        super(name,health);
        final int WARRIOR_DAMAGE = 6;
        super.setDamage(WARRIOR_DAMAGE);
    }

    @Override
    public void takeDamage(int damage) {

    }

    @Override
    public void attackEnemy(Enemy enemy){
        final String WARRIOR_ATTACKS = "Warrior "+getName()+" attacks an enemy";
        System.out.println(WARRIOR_ATTACKS);
        enemy.takeDamage(this.damage);
    }
}