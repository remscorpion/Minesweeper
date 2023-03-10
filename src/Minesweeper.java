public class Minesweeper {
    public static void main(String[] args) {
        StdOut.println("Welcome to minesweeper!");
        int size  = 10, numMines = 10;
        boolean[][] grid = new boolean[size][size];
        boolean[][] revealed = new boolean[size][size];  // clicked or not


        //TODO initialize grid: place bombs in random location
        initMinefield(numMines, grid);

        //TODO 1. draw the grid (take into account revealed)
        StdDraw.setScale(-0.5, size - 0.5);
        drawMinefield(grid, revealed);

        //TODO keep doing there steps until otherwise told
        while (true) {
            //TODO 2. wait until the user clicks (give coordinates)

            //TODO 3. update "revealed" (based on theses coordinates)

            handleMouseClick(grid, revealed);

            drawMinefield(grid, revealed);

            //TODO 4. check for losing/winning condition
            if (hasWon(grid, revealed)) {
                StdOut.println("You Won!");
                break;
            }
        }



    }

    public static boolean hasWon(boolean[][] grid, boolean[][] revealed) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != revealed[i][j]) return false;
            }
        }

        return true;
    }

    public static void handleMouseClick(boolean[][] grid, boolean[][] revealed) {

    }

    public static void drawMinefield(boolean[][] grid, boolean[][] revealed) {
        int x = 0;
        while (x < grid.length) {
            int y = 0;
            while (y < grid.length) {
                if (!revealed[x][y]) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(x, y, 0.5);
                    StdDraw.setPenColor(StdDraw.BLACK);
                }
                else if (grid[x][y]) {
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledCircle(x, y, 0.3);
                    StdDraw.setPenColor(StdDraw.BLACK);
                }
                else {
                    int count = countNeighboringMines(grid, x, y);
                    if (count != 0) StdDraw.text(x, y, "" + count);
                }
                StdDraw.square(x, y, 0.5);
                y = y + 1;
            }
            x = x + 1;
        }
    }


    public static void initMinefield(int numMines, boolean[][] grid) {
        for (int i = 0; i < numMines; ++i) {
            while (true) {
                int x = StdRandom.uniformInt(grid.length);
                int y = StdRandom.uniformInt(grid.length);
                if (!grid[x][y]) {
                    grid[x][y] = true;
                    break;
                }
            }
        }
    }

    public static int countNeighboringMines(boolean[][] grid, int row, int col) {
        int count = 0;
        int i, j;

        for (i = Math.max(0, row - 1);i <= Math.min(grid.length - 1, row + 1); ++i) {
            for (j = Math.max(0, col - 1); j <= Math.min(grid.length - 1, col + 1); ++j) {
                if (grid[i][j]) ++count;
            }
        }


        return count;
    }
}