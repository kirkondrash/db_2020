package heroes_game;

import heroes_game.characters.*;

import java.util.Random;
import java.util.function.Supplier;

public class HeroFactory {
    private static Random random = new Random();

    enum AllPlayableHeroes{
        Elf(Elf::new),
        Hobbit(Hobbit::new),
        King(King::new),
        Knight(Knight::new);

        private final Supplier<Hero> hero;
        AllPlayableHeroes(Supplier<Hero> hero) { this.hero = hero; }
        public Hero create() { return hero.get(); }
    }


    public static Hero createHero() {
        return AllPlayableHeroes.values()[random.nextInt(AllPlayableHeroes.values().length)].create();
    }

}
