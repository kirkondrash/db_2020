package heroes_game.characters;

public interface Hero {

    void kick(Hero h);

    boolean isAlive();

    int getPower();

    int getHp();

    void weakenPower(int pts);

    void dealDamage(int dmg);
}
