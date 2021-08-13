package com.marco.terminal.gameLogic;

import com.marco.terminal.ui.Layout;
import com.marco.terminal.ui.Menu;

/**
 * This is a class to handle the game's initial and check is the game over
 */
public class Logic {
    // Init other class
    Layout Layout = new Layout();
    //Controller controller = new Controller(); Have error

    // public variable
    public static int[][] grid;
    public static int dimension;

    // create the grid for the game
    public void creatGrid(int size) {
        dimension = size;
        switch (size) {
            case 4 -> grid = new int[4][4];
            case 8 -> grid = new int[8][8];
        }
        startGame();
    }

    // Assign random number to the grid
    public void assignNumber(int[][] grid) {
        boolean haveNotAssign = true;
        while (haveNotAssign) {
            int assignPlace = (int) (Math.random() * (grid.length * grid.length));
            int cnt = 0;
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    if (cnt == assignPlace) {
                        if (grid[i][j] == 0) {
                            grid[i][j] = twoOrFour();
                            haveNotAssign = false;
                        }
                    }
                    cnt++;
                }
            }
        }
    }

    // Choose generate 2 or 4 in the grid
    public int twoOrFour() {
        if ((int) (Math.random() * 10000000) % 2 == 0) {
            return 4;
        } else {
            return 2;
        }
    }

    // Start game
    public void startGame() {
        assignNumber(grid);
        assignNumber(grid);
        Layout.buildFrame(grid);
        gamePlaying();
    }

    // check game over
    private boolean isGameOver() {
        return !canMoveLeft() && !canMoveRight() && !canMoveUp() && !canMoveDown();
    }

    // check the user can make a move to left
    private boolean canMoveLeft() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension - 1; j++) {
                if (grid[i][j] == 0 && grid[i][j + 1] != 0) {
                    return true;
                }
                if (grid[i][j] != 0 && grid[i][j + 1] == 0) {
                    return true;
                }
                if (grid[i][j] == grid[i][j + 1]) {
                    return true;
                }
            }
        }
        return false;
    }

    // check the user can make a move to right
    private boolean canMoveRight() {
        for (int i = 0; i < dimension; i++) {
            for (int j = dimension - 1; j > 0; j--) {
                if (grid[i][j] == 0 && grid[i][j - 1] != 0) {
                    return true;
                }
                if (grid[i][j] != 0 && grid[i][j - 1] == 0) {
                    return true;
                }
                if (grid[i][j] == grid[i][j - 1]) {
                    return true;
                }
            }
        }
        return false;
    }

    // check the user can make a move to up
    private boolean canMoveUp() {
        for (int i = 0; i < dimension - 1; i++) {
            for (int j = 0; j < dimension; j++) {
                if (grid[i][j] == 0 && grid[i + 1][j] != 0) {
                    return true;
                }
                if (grid[i][j] != 0 && grid[i + 1][j] == 0) {
                    return true;
                }
                if (grid[i][j] == grid[i + 1][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // check the user can make a move to down
    private boolean canMoveDown() {
        for (int i = dimension - 1; i > 0; i--) {
            for (int j = 0; j < dimension; j++) {
                if (grid[i][j] == 0 && grid[i - 1][j] != 0) {
                    return true;
                }
                if (grid[i][j] != 0 && grid[i - 1][j] == 0) {
                    return true;
                }
                if (grid[i][j] == grid[i - 1][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * function to play the game after start up the game
     */
    public void gamePlaying() {
        Controller controller = new Controller(); // This work fine
        while (controller.getControl()) {
            assignNumber(grid);
            Layout.buildFrame(grid);
            if (isGameOver()) {
                Menu menu = new Menu();
                menu.gameover();
            }
        }
    }
}
