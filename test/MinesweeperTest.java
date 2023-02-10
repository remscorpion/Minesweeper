import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinesweeperTest {

    @org.junit.jupiter.api.Test
    void initMinefield() {
        boolean[][] grid = new boolean[3][3];
        Minesweeper.initMinefield(5, grid);
        int count = 0;
        for (int x = 0; x < grid.length; ++x) {
            for (int y = 0; y < grid.length; ++y) {
                if (grid[x][y]) ++count;
            }
        }
        assertEquals(5, count);
    }

    @Test
    void countNeighboringMines() {
        boolean[][] grid = {
                { false,  true, false },
                { false, false, false },
                { false, false, false }
        };

        assertEquals(1, Minesweeper.countNeighboringMines(grid, 1,1));

        assertEquals(1, Minesweeper.countNeighboringMines(grid, 1,0));

        assertEquals(1, Minesweeper.countNeighboringMines(grid, 1,2));

        assertEquals(0, Minesweeper.countNeighboringMines(grid, 2,2));

    }
}