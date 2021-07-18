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
                case "e", "E" -> {
                    warning();
                    break loop;
                }
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

    private int mergeBlocks(int bk1, int bk2){
        if(bk1 == bk2) {
            return bk1 + bk2;
        }else{
            return bk1;
        }
    }
}
