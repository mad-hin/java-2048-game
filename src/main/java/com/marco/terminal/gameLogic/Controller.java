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
     */
    public void getControl() {
        loop:
        while (true) {
            String input = inputAndOutput.getInput();
            switch (input) {
                case "w", "W" -> {
                    moveUp();
                    logic.twoOrFour();
                    break loop;
                }
                case "s", "S" -> {
                    moveDown();
                    logic.twoOrFour();
                    break loop;
                }
                case "a", "A" -> {
                    moveLeft();
                    logic.twoOrFour();
                    break loop;
                }
                case "d", "D" -> {
                    moveRight();
                    logic.twoOrFour();
                    break loop;
                }
                case "h", "H" -> menu.helpMessage();
                case "e", "E" -> {
                    warning();
                    break loop;
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
                for (int c = 0; c < logic.grid[0].length; c++) {
                    if (logic.grid[r][c] == logic.grid[r - 1][c] || logic.grid[r - 1][0] == 0) {
                        logic.grid[r - 1][c] += logic.grid[r][c];
                        logic.grid[r][c] = 0;
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
                for (int c = 0; c < logic.grid[0].length; c++) {
                    if (logic.grid[r][c] == logic.grid[r + 1][c] || logic.grid[r + 1][c] == 0) {
                        logic.grid[r + 1][c] += logic.grid[r][c];
                        logic.grid[r][c] = 0;
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
            for (int c = 1; c < logic.grid[0].length; c++) {
                for (int r = 0; r < logic.grid.length; r++) {
                    if (logic.grid[r][c] == logic.grid[r][c - 1] || logic.grid[r][c - 1] == 0) {
                        logic.grid[r][c - 1] += logic.grid[r][c];
                        logic.grid[r][c] = 0;
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
                for (int r = 0; r < logic.grid.length; r++) {
                    if (logic.grid[r][c] == logic.grid[r][c + 1] || logic.grid[r][c + 1] == 0) {
                        logic.grid[r][c + 1] += logic.grid[r][c];
                        logic.grid[r][c] = 0;
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
                    getControl();
                    break warningLoop;
                }
                default -> inputAndOutput.outPutMessage("No such command, please re-enter the correct command");
            }
        }
    }
}
