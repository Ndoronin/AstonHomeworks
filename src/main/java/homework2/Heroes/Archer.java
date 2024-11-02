package homework2.Heroes;

import homework2.Enemies.Enemy;

public class Archer extends Hero{

    public Archer(String name, int health){
        super(name,health);
        final int ARCHER_DAMAGE = 5;
        super.setDamage(ARCHER_DAMAGE);
    }

    @Override
    public void attackEnemy(Enemy enemy){
        final String ARCHER_ATTACKS = "Archer "+getName()+" attacks an enemy";
        System.out.println(ARCHER_ATTACKS);
        enemy.takeDamage(this.damage);

    }
}
