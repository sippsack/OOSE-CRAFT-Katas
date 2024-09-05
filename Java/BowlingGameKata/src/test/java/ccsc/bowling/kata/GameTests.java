package ccsc.bowling.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * TODOs
 *
 * 1. Test: can roll gutter (no pins at all) ✅
 * 2. Test: can roll One's 20 times ✅
 * 3. Test: Spare
 * 4. Test: Strike
 * 5. Test: Perfect Match
 */
public class GameTests {
    @Test
    void canRollGutter() {
        Game game = new Game();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(0, game.getScore());
    }

    @Test
    void canRollAllOnes() {
        Game game = new Game();
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertEquals(20, game.getScore());
    }
}
