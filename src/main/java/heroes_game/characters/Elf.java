package heroes_game.characters;

public class Elf extends AbstractHero {

    public static final String[] ELF_NAMES = {"Imin", "Tata", "Enel"};

    public Elf() {
        super(ELF_NAMES[random.nextInt(ELF_NAMES.length)], 10, 10);
    }

    @Override
    public void kick(Hero h) {
        if (h.getPower() < power) {
            h.dealDamage(h.getHp());
        } else {
            h.weakenPower(1);
        }
    }

}
