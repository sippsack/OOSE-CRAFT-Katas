package ccsc.bowling.kata;

public class Game {
    private int score = 0;

    public int getScore() {
        return score;
    }

    public void roll(int numberOfPins) {
        score += numberOfPins;
    }
}
