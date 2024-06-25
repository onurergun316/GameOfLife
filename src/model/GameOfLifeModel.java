package model;

public class GameOfLifeModel {
    private int rows;
    private int cols;
    private Cell[][] grid;

    public GameOfLifeModel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell(false);
            }
        }
    }

    public void update() {
        Cell[][] nextGrid = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = countLiveNeighbors(i, j);
                boolean isAlive = grid[i][j].isAlive();
                nextGrid[i][j] = new Cell(isAlive);
                if (isAlive && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    nextGrid[i][j].setAlive(false);
                } else if (!isAlive && liveNeighbors == 3) {
                    nextGrid[i][j].setAlive(true);
                }
            }
        }
        grid = nextGrid;
    }

    private int countLiveNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c].isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void toggleCell(int row, int col) {
        grid[row][col].setAlive(!grid[row][col].isAlive());
    }
}
