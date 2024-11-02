package homework2.Main;

import homework2.Enemies.Bandit;
import homework2.Enemies.Enemy;
import homework2.Enemies.Zombie;
import homework2.Heroes.Archer;
import homework2.Heroes.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BattleGround {

    public static void battle(Hero hero, Enemy... enemies) {

        List<Enemy> enemyList = new ArrayList<>(Arrays.asList(enemies));
        final String BATTLE_BEGINS = "The hero " + hero.getName() + " has encountered " + enemies.length + "enemies" + "\nBattle begins!";
        final String BATTLE_IS_OVER_HERO_WINS = "Battle is over! " + "\nThe Hero " + hero.getHeroType() + " " + hero.getName() + " wins!";
        final String BATTLE_IS_OVER_ENEMIES_WIN = "Battle is over!\nEnemies win!";

        System.out.println(BATTLE_BEGINS);

        while (hero.isAlive() && !areAllEnemiesDead(enemyList)) {
            for (Enemy enemy : enemyList) {
                if (!enemy.isAlive()) {
                    continue;
                }

                final String ENEMY_IS_DEAD = enemy.getEnemyType() + " is dead!";
                final String HERO_IS_DEAD = hero.getHeroType() + " " + hero.getName() + " is dead!";

                hero.attackEnemy(enemy);
                if (enemy.isAlive())
                    enemy.attackHero(hero);
                else
                    System.out.println(ENEMY_IS_DEAD);

                if (!hero.isAlive()) {
                    System.out.println(HERO_IS_DEAD);
                    System.out.println(BATTLE_IS_OVER_ENEMIES_WIN);
                    break;
                }
                if (areAllEnemiesDead(enemyList)) {
                    System.out.println(BATTLE_IS_OVER_HERO_WINS);
                    break;
                }
            }
        }

    }

    public static boolean areAllEnemiesDead(List<Enemy> enemies) {
        return enemies.stream().noneMatch(Enemy::isAlive);
    }

    public static void main(String[] args) {
        Archer bob = new Archer("Bob", 200);
        Zombie zombie = new Zombie(100);
        Bandit bandit = new Bandit(100);
        battle(bob, zombie, bandit);
    }
}