package heroes_game.characters;

import java.util.Random;

public abstract class AbstractHuman extends AbstractHero {

    public AbstractHuman(String name, int power, int hp) {
        super(name, power, hp);
    }

    @Override
    public void kick(Hero h) {
        h.dealDamage(random.nextInt(power));
    }

}
