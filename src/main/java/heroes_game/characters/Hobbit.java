package heroes_game.characters;

public class Hobbit extends AbstractHero {

    public static final String[] HOBBIT_NAMES = {"Thorin", "Fili", "Kili", "Balin", "Dwalin"};

    public Hobbit() {
        super(HOBBIT_NAMES[random.nextInt(HOBBIT_NAMES.length)], 0, 3);
    }

    @Override
    public void kick(Hero h) {
        toCry();
    }

    private void toCry(){
        System.out.println(String.format("Hobbit %s cries T_T", name));
    }
}
