package homework.riddle_game;

import design_patterns.template_method.Player;
import lombok.AllArgsConstructor;

import javax.swing.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@AllArgsConstructor
public final class RiddleGuesser implements Player {

    private String inputString;
    private String name;
    private List<Integer> guessHistory;

    public RiddleGuesser(String name, int bound) {
        this.name = name;
        inputString = String.format("Player %s, input your number from 0 to %d", name, bound);
        guessHistory = new LinkedList<>();
    }

    @Override
    public void makeMove() {
        // we could parse the input, check the bounds, throw exceptions, etc...
        guessHistory.add(Integer.parseInt(JOptionPane.showInputDialog(inputString)));
    }

    public int getLastGuess() {
        return guessHistory.isEmpty() ? -1 : guessHistory.get(guessHistory.size()-1);
    }

    public int getBestGuess(int answer) {
        return guessHistory
                .stream()
                .min(Comparator.comparingInt(elem -> Math.abs(answer - elem)))
                .get();
    }

    public String getName() {
        return name;
    }
}
