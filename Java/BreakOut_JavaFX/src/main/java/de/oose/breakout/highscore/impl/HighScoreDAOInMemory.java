package de.oose.breakout.highscore.impl;

import de.oose.breakout.highscore.HighScore;
import de.oose.breakout.highscore.HighScoreDAO;

import java.util.ArrayList;
import java.util.List;

public class HighScoreDAOInMemory implements HighScoreDAO {

    private final static List<HighScore> testData = List.of(
            new HighScore(3000, "Heinz"),
            new HighScore(2000, "EasyMock"),
            new HighScore(1000, "jMock"),
            new HighScore(3000, "Hermann")
    );

    private final List<HighScore> highScores = new ArrayList<>(testData);

    @Override
    public List<HighScore> getHighScores() {
        return highScores;
    }

    @Override
    public void saveHighScore(int score, String name) {
        highScores.add(new HighScore(score, name));
    }

    @Override
    public HighScore getHighScoreByName(String name) {
        return null;
    }
}
