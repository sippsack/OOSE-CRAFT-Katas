package de.oose.breakout.highscore.impl;

import de.oose.breakout.highscore.HighScore;
import de.oose.breakout.highscore.HighScoreDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * TODOs
 * (1) test get high scores ✅
 * (2) test save high score ✅
 * (3) test get high score by name ✅
 * (4) test auto generated id
 */
@ExtendWith(MockitoExtension.class)
public class HighScoreDAOInMemoryTests {
    private HighScoreDAOInMemory dao;

    @Mock
    private HighScoreDAO highScoreDAOMock;

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

    @Test
    void mockDao() {
        when(highScoreDAOMock.getHighScoreByName("Dieter Develop")).thenReturn(new HighScore(1, "Dieter Develop"));

        assertEquals(highScoreDAOMock.getHighScoreByName("Dieter Develop").getScore(), 1);
        highScoreDAOMock.getHighScoreByName("Dieter Develop");

        verify(highScoreDAOMock, times(2)).getHighScoreByName("Dieter Develop");
    }
}
