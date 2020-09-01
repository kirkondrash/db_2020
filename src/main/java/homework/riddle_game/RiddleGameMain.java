package homework.riddle_game;

import design_patterns.template_method.*;

/**
 * @author Evgeny Borisov
 */
public class RiddleGameMain {

    public static void main(String[] args) {
        // we could ask for it, or make a static const - decided to not overcomplicate
        int bound = 42;

        /*
        there are a lot of things I would have tried to write better or more elaborate,
        for example - bounds are passed everywhere, but with other class structure it could be avoided
        but here more than anything else I challenged myself to adhere the method play() of AbstractGame class
        without changing existing structure to comply with the template method pattern
         */

        RiddleGuesser john = new RiddleGuesser("John",bound);
        RiddleGuesser james = new RiddleGuesser("James",bound);

        Game game = new RiddleGame(john, james, bound);
        game.play();
    }
}
