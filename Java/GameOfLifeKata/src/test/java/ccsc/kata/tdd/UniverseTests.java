package ccsc.kata.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniverseTests {

    public static final Cell.CellState X = Cell.CellState.ALIVE;
    public static final Cell.CellState O = Cell.CellState.DEAD;

    @Test
    void testUniverse() {
        Cell.CellState[][] original = {
                {X, X, O},
                {O, X, X},
                {O, O, O}
        };
        Universe universe = new Universe(original);
        assertArrayEquals(original, universe.getState());
    }

    @Test
    void shouldUpdateSingleCell() {
        Universe universe = new Universe(new Cell.CellState[][] {{ X }});
        Cell.CellState[][] actual = universe.nextGeneration().getState();
        assertEquals(Cell.CellState.DEAD, actual[0][0]);
    }

    @Test
    void shouldUpdateAllCells() {
        Cell.CellState[][] original = {
                {X, X, O},
                {O, X, X},
                {O, O, O}
        };
        Universe universe = new Universe(original);

        Cell.CellState[][] expected = {
                {X, X, X},
                {X, X, X},
                {O, O, O}
        };

        Cell.CellState[][] actual = universe.nextGeneration().getState();
        assertArrayEquals(expected, actual);
    }
}
