package homework2.Heroes;

import homework2.Enemies.Enemy;

public class Mage extends Hero{
    public Mage(String name, int health){
        super(name,health);
        final int MAGE_DAMAGE = 4;
        super.setDamage(MAGE_DAMAGE);
    }
    @Override
    public void attackEnemy(Enemy enemy){
        final String MAGE_ATTACKS = "Mage "+getName()+" attacks an enemy";
        System.out.println(MAGE_ATTACKS);
        enemy.takeDamage(this.damage);
    }
}
