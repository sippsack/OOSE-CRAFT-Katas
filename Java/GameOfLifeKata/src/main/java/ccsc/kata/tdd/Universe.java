package ccsc.kata.tdd;

import java.io.IOException;

public class Universe {

    public static final Cell.CellState X = Cell.CellState.ALIVE;
    public static final Cell.CellState O = Cell.CellState.DEAD;

    private final Cell[][] cells;

    private Universe(Cell[][] cells) {
        this.cells = cells;
    }

    public Universe(Cell.CellState[][] cellStates) {
        cells = new Cell[cellStates.length][];
        for (int row = 0; row < cellStates.length; row++) {
            cells[row] = new Cell[cellStates[row].length];
            for (int col = 0; col < cellStates[row].length; col++) {
                cells[row][col] = new Cell(cellStates[row][col]);
            }
        }
    }

    public Cell.CellState[][] getState() {
        Cell.CellState[][] cellStates = new Cell.CellState[cells.length][];
        for (int row = 0; row < cells.length; row++) {
            cellStates[row] = new Cell.CellState[cells[row].length];
            for (int col = 0; col < cells[row].length; col++) {
                cellStates[row][col] = cells[row][col].getState();
            }
        }
        return cellStates;
    }

    public Universe nextGeneration() {
        Cell[][] newCells = new Cell[cells.length][];
        for (int row = 0; row < cells.length; row++) {
            newCells[row] = new Cell[cells[row].length];
            for (int col = 0; col < cells[row].length; col++) {
                int numberOfAliveNeighbors = getNumberOfAliveNeighbors(row, col);
                newCells[row][col] = new Cell(cells[row][col].getNextState(numberOfAliveNeighbors));
            }
        }

        return new Universe(newCells);
    }

    private static final int[][] neighborsOffsets = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    private int getNumberOfAliveNeighbors(int row, int col) {
        int numberOfAliveNeighbors = 0;
        if (row > 0) {
            if (col > 0) {
                if (Cell.CellState.ALIVE.equals(cells[row - 1][col - 1].getState())) numberOfAliveNeighbors++;
            }
            if (Cell.CellState.ALIVE.equals(cells[row - 1][col].getState())) numberOfAliveNeighbors++;
            if (col < cells[row - 1].length - 1) {
                if (Cell.CellState.ALIVE.equals(cells[row - 1][col + 1].getState())) numberOfAliveNeighbors++;
            }
        }
        if (col > 0) {
            if (Cell.CellState.ALIVE.equals(cells[row][col - 1].getState())) numberOfAliveNeighbors++;
        }
        if (col < cells[row].length - 1) {
            if (Cell.CellState.ALIVE.equals(cells[row][col + 1].getState())) numberOfAliveNeighbors++;
        }
        if (row < cells.length - 1) {
            if (col > 0) {
                if (Cell.CellState.ALIVE.equals(cells[row + 1][col - 1].getState())) numberOfAliveNeighbors++;
            }
            if (Cell.CellState.ALIVE.equals(cells[row + 1][col].getState())) numberOfAliveNeighbors++;
            if (col < cells[row + 1].length - 1) {
                if (Cell.CellState.ALIVE.equals(cells[row + 1][col + 1].getState())) numberOfAliveNeighbors++;
            }
        }
        return numberOfAliveNeighbors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                sb.append(cells[row][col] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Cell.CellState[][] start = {
                {X, X, O, X, X, O},
                {O, X, X, O, X, O},
                {O, O, O, X, X, O},
                {O, O, O, X, X, O},
                {O, O, O, X, X, O},
                {O, O, O, X, X, O}
        };

        Universe universe = new Universe(start);
        System.out.println("0: ");
        System.out.print(universe);

        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            for (int j = 0; j < 10000; j++) {
                System.out.print("\b");
            }
            universe = universe.nextGeneration();
            System.out.println();
            System.out.println("" + i + ": ");
            System.out.print(universe);
        }
    }
}
