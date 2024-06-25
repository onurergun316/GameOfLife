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
        // Set initial patterns at different locations
        setInitialPattern(1, 2); // Glider at (1, 2)
        setInitialPattern(10, 10); // Glider at (10, 10)
        setInitialPattern(20, 20); // Glider at (20, 20)
    }

    private void setInitialPattern(int startX, int startY) {
        // Example pattern: a simple glider
        if (isWithinBounds(startX + 1, startY + 2)) grid[startX + 1][startY + 2].setAlive(true);
        if (isWithinBounds(startX + 2, startY + 3)) grid[startX + 2][startY + 3].setAlive(true);
        if (isWithinBounds(startX + 3, startY + 1)) grid[startX + 3][startY + 1].setAlive(true);
        if (isWithinBounds(startX + 3, startY + 2)) grid[startX + 3][startY + 2].setAlive(true);
        if (isWithinBounds(startX + 3, startY + 3)) grid[startX + 3][startY + 3].setAlive(true);
    }

    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
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

