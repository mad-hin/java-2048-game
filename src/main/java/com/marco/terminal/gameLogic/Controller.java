package com.marco.terminal.gameLogic;

import com.marco.terminal.ui.Menu;

/**
 * This class is for control the movement of the blocks in the game
 */
public class Controller {
    // Init other class
    InputAndOutput inputAndOutput = new InputAndOutput();
    Logic logic = new Logic();
    Menu menu = new Menu();

    /**
     * Function to get the user input and preform move the blocks action
     * @return boolean to let the program know is time to print out the grid
     */
    public boolean getControl() {
        while (true) {
            String input = inputAndOutput.getInput();
            switch (input) {
                case "w", "W" -> {
                    moveUp();
                    return true;
                }
                case "s", "S" -> {
                    moveDown();
                    return true;
                }
                case "a", "A" -> {
                    moveLeft();
                    return true;
                }
                case "d", "D" -> {
                    moveRight();
                    return true;
                }
                case "h", "H" -> menu.helpMessage();
                case "e", "E" -> {
                    warning();
                    return false;
                }
                default -> inputAndOutput.outPutMessage("No such command, please enter 'W', 'A', 'S' or 'D' to move the tiles.");
            }
        }
    }

    /**
     * Function to move the value in the grid up and sum up the same number
     */
    private void moveUp() {
        for (int i = 0; i < logic.dimension; i++) {
            for (int r = 1; r <= logic.dimension - 1; r++) {
                for (int c = 0; c < Logic.grid[0].length; c++) {
                    if (Logic.grid[r][c] == Logic.grid[r - 1][c] || Logic.grid[r - 1][c] == 0) {
                        Logic.grid[r - 1][c] += Logic.grid[r][c];
                        Logic.grid[r][c] = 0;
                    }
                }
            }
        }
    }

    /**
     * Function to move the values in the grid down and sum up the same number
     */
    private void moveDown() {
        for (int i = 0; i < logic.dimension; i++) {
            for (int r = logic.dimension - 2; r >= 0; r--) {
                for (int c = 0; c < Logic.grid[0].length; c++) {
                    if (Logic.grid[r][c] == Logic.grid[r + 1][c] || Logic.grid[r + 1][c] == 0) {
                        Logic.grid[r + 1][c] += Logic.grid[r][c];
                        Logic.grid[r][c] = 0;
                    }
                }
            }
        }
    }

    /**
     * Function to move the values in the grid left and sum up the same number
     */
    private void moveLeft() {
        for (int i = 0; i < logic.dimension; i++) {
            for (int c = 1; c < Logic.grid[0].length; c++) {
                for (int r = 0; r < Logic.grid.length; r++) {
                    if (Logic.grid[r][c] == Logic.grid[r][c - 1] || Logic.grid[r][c - 1] == 0) {
                        Logic.grid[r][c - 1] += Logic.grid[r][c];
                        Logic.grid[r][c] = 0;
                    }
                }
            }
        }
    }

    /**
     * Function to move the values in the grid right and sum up the same number
     */
    private void moveRight() {
        for (int i = 0; i < logic.dimension; i++) {
            for (int c = 2; c >= 0; c--) {
                for (int r = 0; r < Logic.grid.length; r++) {
                    if (Logic.grid[r][c] == Logic.grid[r][c + 1] || Logic.grid[r][c + 1] == 0) {
                        Logic.grid[r][c + 1] += Logic.grid[r][c];
                        Logic.grid[r][c] = 0;
                    }
                }
            }
        }
    }

    /**
     * Function to make sure the user want to exit the game when playing the game
     */
    private void warning(){
        warningLoop:
        while (true){
            inputAndOutput.outPutMessage("Are you sure to exit the game? [Y/n]");
            String s = inputAndOutput.getInput();
            switch (s) {
                case "y", "Y", "" -> {
                    menu.exitGame();
                    break warningLoop;
                }
                case "n", "N" -> {
                    logic.gamePlaying();
                    break warningLoop;
                }
                default -> inputAndOutput.outPutMessage("No such command, please re-enter the correct command");
            }
        }
    }
}
