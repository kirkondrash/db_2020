package heroes_game.characters;

import lombok.Getter;

import java.util.Random;

@Getter
public abstract class AbstractHero implements Hero {
    protected static Random random = new Random();

    protected String name;
    protected int power;
    protected int hp;

    public AbstractHero(String name, int power, int hp) {
        this.name = name;
        this.power = power;
        this.hp = hp;
    }

    @Override
    public boolean isAlive() {
        return hp>0;
    }

    @Override
    public void dealDamage(int dmg) {
        System.out.println(String.format("%s suffers %d damage!", name, dmg));
        if (dmg >= hp) {
            System.out.println(String.format("%s dies :(", name));
            hp = 0;
        } else {
            hp -= dmg;
        }
    }

    @Override
    public void weakenPower(int pts) {
        System.out.println(String.format("%s power weakens by %d!", name, pts));
        if (pts >= power) {
            System.out.println(String.format("%s is helpless :(", name));
            power = 0;
        } else {
            power -= pts;
        }
    }

    public String toString() {
        return String.format("%s(name=%s, power=%d, hp=%d)", getClass().getSimpleName(), name, power, hp);
    }

}
