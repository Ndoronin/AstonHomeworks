package homework2.Enemies;

public class Bandit extends Enemy{

    public Bandit(int health) {
        super(health);
        final int BANDIT_DAMAGE = 3;
        super.setDamage(BANDIT_DAMAGE);
    }
}
