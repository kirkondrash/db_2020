package heroes_game.characters;

public class Knight extends Human {

    public static final String[] KNIGHT_NAMES = {"John", "Jack"};

    public Knight() {
        super(KNIGHT_NAMES[random.nextInt(KNIGHT_NAMES.length)], random.nextInt(10)+2, random.nextInt(10)+2);
    }

}
