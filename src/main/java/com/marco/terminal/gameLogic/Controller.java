package com.marco.terminal.gameLogic;

import com.marco.terminal.ui.Menu;

/**
 * This class is for control the movement of the blocks in the game
 */
public class Controller {
    // Init other class
    InputAndOutput inputAndOutput = new InputAndOutput();
    //Logic logic = new Logic();
    Menu menu = new Menu();

    public void getControl() {
        loop:
        while (true) {
            String input = inputAndOutput.getInput();
            switch (input) {
                case "w", "W" -> {
                    moveUp();
                    break loop;
                }
                case "s", "S" -> {
                    moveDown();
                    break loop;
                }
                case "a", "A" -> {
                    moveLeft();
                    break loop;
                }
                case "d", "D" -> {
                    moveRight();
                    break loop;
                }
                case "h", "H" -> menu.helpMessage();
                default -> inputAndOutput.outPutMessage("No such command, please enter 'W', 'A', 'S' or 'D' to move the tiles.");
            }
        }
    }

    private void moveUp() {

    }

    private void moveDown() {

    }

    private void moveLeft() {

    }

    private void moveRight() {

    }
}
