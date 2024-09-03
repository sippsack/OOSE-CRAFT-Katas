package de.oose.breakout.highscore.impl;

import de.oose.breakout.highscore.HighScore;
import de.oose.breakout.highscore.HighScoreDAO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODOs
 * (1) test get high scores ✅
 * (2) test save high score
 *
 * Testdaten aus DB für HighScoreDAOHibernate:
 *
 * INSERT INTO HIGHSCORE VALUES(1,'2019-01-18','Heinz',3000)
 * INSERT INTO HIGHSCORE VALUES(2,'2019-01-18','EasyMock',2000)
 * INSERT INTO HIGHSCORE VALUES(3,'2019-01-18','jMock',1000)
 * INSERT INTO HIGHSCORE VALUES(22,'2019-07-17','Hermann',3000)
 */
public class HighScoreDAOInMemoryTests {



    @Test
    void testGetHighScores() {
        HighScoreDAO dao = new HighScoreDAOInMemory();
        List<HighScore> actual = dao.getHighScores();
        assertEquals(4, actual.size());
    }
}
