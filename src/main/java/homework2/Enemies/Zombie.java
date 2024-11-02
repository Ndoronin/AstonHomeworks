package homework2.Enemies;

public class Zombie extends Enemy{



    public Zombie(int health) {
        super(health);
        final int ZOMBIE_DAMAGE = 2;
        super.setDamage(ZOMBIE_DAMAGE);
    }

}
