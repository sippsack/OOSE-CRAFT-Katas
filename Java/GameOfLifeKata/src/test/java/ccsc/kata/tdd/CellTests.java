package ccsc.kata.tdd;

/**
 * Rules for Game of Life:
 * <p>
 * 1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
 * 2. Any live cell with two or three live neighbours lives on to the next generation.
 * 3. Any live cell with more than three live neighbours dies, as if by overpopulation.
 * 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 * <p>
 * Inspired by https://www.youtube.com/playlist?list=PLwAX_Bwbts_fI71bo62NwIMc05-uGigza
 *
 * TODOs
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellTests {
    @Test
    void shouldDieWithZeroNeighbors() {
        assertEquals(nextStateOfCell(Cell.CellState.ALIVE, 0), Cell.CellState.DEAD);
    }

    @Test
    void shouldDieWithOneNeighbor() {
        assertEquals(nextStateOfCell(Cell.CellState.ALIVE, 1), Cell.CellState.DEAD);
    }

    @Test
    void shouldLiveOnWithTwoNeighbors() {
        assertEquals(nextStateOfCell(Cell.CellState.ALIVE, 2), Cell.CellState.ALIVE);
    }

    @Test
    void shouldLiveOnWithThreeNeighbors() {
        assertEquals(nextStateOfCell(Cell.CellState.ALIVE, 3), Cell.CellState.ALIVE);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8})
    void shouldDieWithFourOrMoreNeighbors(int numberOfActiveNeighbors) {
        assertEquals(nextStateOfCell(Cell.CellState.ALIVE, numberOfActiveNeighbors), Cell.CellState.DEAD);
    }

    /**
     * Funktioniert zufällig direkt.
     * Es fehlen die gegensätzlichen Tests => shouldNotBecomeAliveUnlessWithThreeNeighbors
     */
    @Test
    void shouldBecomeAliveWithThreeNeighbors() {
        assertEquals(nextStateOfCell(Cell.CellState.DEAD, 3), Cell.CellState.ALIVE);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 4, 5, 6, 7, 8})
    void shouldNotBecomeAliveUnlessWithThreeNeighbors(int numberOfActiveNeighbors) {
        assertEquals(Cell.CellState.DEAD, nextStateOfCell(Cell.CellState.DEAD, numberOfActiveNeighbors));
    }

//    @Test
//    void shouldDieWithSixNeighbors() {
//        assertEquals(nextStateOfCell(Cell.CellState.ALIVE, 5), Cell.CellState.DEAD);
//    }
//
//    @Test
//    void shouldDieWithSevenNeighbors() {
//        assertEquals(nextStateOfCell(Cell.CellState.ALIVE, 6), Cell.CellState.DEAD);
//    }
//
//    @Test
//    void shouldDieWithEightNeighbors() {
//        assertEquals(nextStateOfCell(Cell.CellState.ALIVE, 7), Cell.CellState.DEAD);
//    }
//
//    @Test
//    void shouldDieWithNineNeighbors() {
//        assertEquals(nextStateOfCell(Cell.CellState.ALIVE, 8), Cell.CellState.DEAD);
//    }

    private static Cell.CellState nextStateOfCell(Cell.CellState state, int numberOfActiveNeighbors) {
        return new Cell(state).getNextState(numberOfActiveNeighbors);
    }
}
