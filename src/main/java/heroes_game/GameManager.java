package heroes_game;

import heroes_game.characters.Hero;

public class GameManager {

    public static void main(String[] args) {
        Hero h1 = HeroFactory.createHero();
        Hero h2 = HeroFactory.createHero();
        if (h1.getName().equals(h2.getName())) {
            h1.deduplicateName();
        }
        fight(h1,h2);
    }

    public static void fight(Hero h1, Hero h2) {
        for (int i = 0; h1.isAlive() && h2.isAlive(); i++) {
            System.out.println(String.format("Round #%d", i));
            System.out.println(h1.toString());
            System.out.println(h2.toString());
            h1.kick(h2);
            h2.kick(h1);
            System.out.println("===================");
        }
        Hero winner = h1.isAlive() ? h1 : h2;
        if (winner.isAlive()) {
            System.out.println(winner + " is a winner!");
        } else  {
            System.out.println("..double suicide");
        }
    }
}
