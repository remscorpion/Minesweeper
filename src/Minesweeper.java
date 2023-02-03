public class Minesweeper {
    public static void main(String[] args) {
        StdOut.println("Welcome to minesweeper!");
        int size  = 10, numMines = 10;
        boolean[][] grid = new boolean[size][size];
        boolean[][] revealed = new boolean[size][size];


        //TODO initialize grid: place bombs in random location
        initMinefield(numMines, grid);

        //TODO 1. draw the grid (take into account revealed)
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
        return false;
    }

    public static void handleMouseClick(boolean[][] grid, boolean[][] revealed) {

    }

    public static void drawMinefield(boolean[][] grid, boolean[][] revealed) {

    }

    public static void initMinefield(int numMines, boolean[][] grid) {
    }
}