package ccsc.kata.tdd;

import java.util.Collection;
import java.util.List;

public class Neighbours {
    private final Cell.CellState[][] cellStates;

    public Neighbours(Cell.CellState[][] cellStates) {
        this.cellStates = cellStates;
    }

    public int getAlive(int i, int i1) {
        return 2;
    }
}
