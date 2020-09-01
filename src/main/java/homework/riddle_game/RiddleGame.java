package homework.riddle_game;

import design_patterns.template_method.AbstractGame;
import design_patterns.template_method.Game;
import design_patterns.template_method.Pair;

import java.util.List;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
public class RiddleGame extends AbstractGame<RiddleGuesser> implements Game {

    // decided to limit the rounds not to take guesses eternally
    public static int ROUND_COUNT = 3;

    private int answer;
    private final int guessBound;
    private int currentRound = 0;

    public RiddleGame(RiddleGuesser player1,RiddleGuesser player2, int guessBound) {
        super(player1,player2);
        this.guessBound = guessBound;
    }

    @Override
    protected boolean endOfGame() {
        currentRound++;
        // we stop if the round limit is reached or someone guessed right
        return currentRound > ROUND_COUNT || player1.getLastGuess() == answer || player2.getLastGuess() == answer;
    }

    @Override
    protected List<Pair> calcBestScores() {
        // the "best" score in guessing is the closest to the correct
        return List.of(
                new Pair(player1.getName(),player1.getBestGuess(answer)),
                new Pair(player2.getName(),player2.getBestGuess(answer)),
                new Pair("Correct answer",answer));
    }

    @Override
    protected void prepareBoard() {
        answer = new Random().nextInt(guessBound);
        System.out.println(String.format("*whisper* correct answer is %d", answer));
    }
}
