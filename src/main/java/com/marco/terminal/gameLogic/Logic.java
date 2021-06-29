package com.marco.terminal.gameLogic;

import com.marco.terminal.ui.layout;
import com.marco.terminal.ui.Menu;

import static java.lang.System.exit;

public class Logic {
    // Init other class
    layout Layout = new layout();
    InputAndOutput inputAndOutput = new InputAndOutput();

    // public variable
    public int[][] grid;
    public int dimension;

    // create the grid for the game
    public void creatGrid(int size) {
        dimension = size;
        switch (size) {
            case 4 -> grid = new int[4][4];
            case 8 -> grid = new int[8][8];
        }
        startGame();
    }

    // Exit Game
    public void exitGame() {
        inputAndOutput.outPutMessage("Thank you for playing the game");
        exit(0);
    }

    // Game over
    private void gameover() {
        Menu menu = new Menu();
        gameOverLoop:
        while (true) {
            inputAndOutput.outPutMessage("Game Over, restart with current mode? [Y/n]");
            String s = inputAndOutput.getInput();
            switch (s) {
                case "y", "Y", "" -> {
                    creatGrid(dimension);
                    break gameOverLoop;
                }
                case "n", "N" -> {
                    menu.changeOrExit();
                    break gameOverLoop;
                }
                default -> inputAndOutput.outPutMessage("No such command, please re-enter the correct command");
            }
        }
    }

    // Assign random number to the grid
    public void assignNumber(int[][] grid) {
        int assignPlace = (int) (Math.random() * (grid.length * grid.length));
        boolean haveNotAssign = true;
        while (haveNotAssign) {
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
    private int twoOrFour() {
        if ((int) (Math.random() * 10000000) % 2 == 0) {
            return 4;
        } else {
            return 2;
        }
    }

    // Start game
    public void startGame() {
        while (!isGameOver()) {
            assignNumber(grid);
            Layout.buildFrame(grid);
        }

        if (isGameOver()) {
            gameover();
        }
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
            }
        }
        return false;
    }
}
