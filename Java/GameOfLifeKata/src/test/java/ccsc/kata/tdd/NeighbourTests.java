package ccsc.kata.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NeighbourTests {
    public static final Cell.CellState X = Cell.CellState.ALIVE;
    public static final Cell.CellState O = Cell.CellState.DEAD;

    @Test
    public void testNeighbour() {
        Cell.CellState[][] states = {
                {X, X, O},
                {O, X, X},
                {O, O, O}
        };
        Neighbours neighbours = new Neighbours(states);
        assertEquals(2, neighbours.getAlive(1,1));
    }
}
