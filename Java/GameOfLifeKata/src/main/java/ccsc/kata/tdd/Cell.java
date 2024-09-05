package ccsc.kata.tdd;

public class Cell {
    private final CellState state;

    public CellState getState() {
        return state;
    }

    public enum CellState {
        ALIVE("X"),
        DEAD("O");

        private final String symbol;

        CellState(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }
    }

    public Cell(CellState state) {
        this.state = state;
    }

    public CellState getNextState(int numberOfActiveNeighbors) {
        if (CellState.DEAD.equals(state)) {
            return numberOfActiveNeighbors == 3 ? CellState.ALIVE : CellState.DEAD;
        }
        return numberOfActiveNeighbors > 1 && numberOfActiveNeighbors < 4 ? CellState.ALIVE : CellState.DEAD;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
