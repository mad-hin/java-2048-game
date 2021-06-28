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

    }

    // Start game
    public void startGame() {
        while (!isGameOver()){
            assignNumber(grid);
            Layout.buildFrame(grid);
        }

        if(isGameOver()){
            gameover();
        }
    }

    // check game over
    private boolean isGameOver(){
        // TODO detect is the game over
        return false;
    }
}
