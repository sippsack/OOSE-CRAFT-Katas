package de.oose.breakout.highscore.impl;

import de.oose.breakout.highscore.HighScore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODOs
 * (1) test get high scores ✅
 * (2) test save high score ✅
 * (3) test get high score by name ✅
 * (4) test auto generated id
 */
public class HighScoreDAOInMemoryTests {
    private HighScoreDAOInMemory dao;

    @BeforeEach
    void setUp() {
        dao = new HighScoreDAOInMemory();
    }

    @Test
    void testGetHighScores() {
        List<HighScore> actual = dao.getHighScores();
        assertEquals(4, actual.size());
        assertEquals("Heinz", actual.get(0).getName());
    }

    @Test
    void testSaveHighScore() {
        dao.saveHighScore(200, "Dieter Develop");
        assertEquals(5, dao.getHighScores().size());
        assertEquals("Dieter Develop", dao.getHighScores().get(4).getName());
        // assertEquals(1, dao.getHighScores().get(4).getId());
    }

    @Test
    void testGetHighScoreByEmptyName() {
        HighScore hs1 = dao.getHighScoreByName("");
        assertNull(hs1);
    }

    @Test
    void testGetHighScoreByNameHeinz() {
        HighScore hs = dao.getHighScoreByName("Heinz");
        assertNotNull(hs);
    }
}
