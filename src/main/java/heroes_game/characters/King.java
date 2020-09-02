package heroes_game.characters;

public class King extends Human {

    public static final String[] KING_NAMES = {"Eomer", "Theoden", "Aragorn"};

    public King() {
        super(KING_NAMES[random.nextInt(KING_NAMES.length)], random.nextInt(10)+5, random.nextInt(10)+5);
    }

}
