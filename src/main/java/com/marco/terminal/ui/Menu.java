package com.marco.terminal.ui;

import com.marco.terminal.gameLogic.InputAndOutput;
import com.marco.terminal.gameLogic.Logic;

import static java.lang.System.exit;

/**
 * This class is for the menu for the user to choose in the game
 */
public class Menu {
    // Init other class
    InputAndOutput inputAndOutput = new InputAndOutput();
    Logic logic = new Logic();

    // choose the game mode (2x2, 4x4 or 8x8)
    public void chooseGameMode() {
        loop:
        while (true) {
            inputAndOutput.outPutMessage("Please choose the game mode:");
            inputAndOutput.outPutMessage("[1] 4x4 grid, [2] 8x8 grid, [E]xit Game, [H]elp");
            String input = inputAndOutput.getInput();
            switch (input) {
                case "1" -> {
                    logic.creatGrid(4);
                    break loop;
                }
                case "2" -> {
                    logic.creatGrid(8);
                    break loop;
                }
                case "e", "E" -> exitGame();
                case "h", "H" -> helpMessage();
                default -> inputAndOutput.outPutMessage("No such command, please re-enter the correct command");
            }
        }
    }

    // Let the user decide change game mode or exit
    public void changeOrExit() {
        changeOrExitLoop:
        while (true) {
            inputAndOutput.outPutMessage("[C]hange game mode, [E]xit game (Default C)");
            String s = inputAndOutput.getInput();
            switch (s) {
                case "c", "C", "" -> {
                    chooseGameMode();
                    break changeOrExitLoop;
                }
                case "e", "E" -> {
                    exitGame();
                    break changeOrExitLoop;
                }
                default -> inputAndOutput.outPutMessage("No such command, please re-enter the correct command");
            }
        }
    }

    private void helpMessage() {
        inputAndOutput.outPutMessage("HOW TO PLAY:");
        inputAndOutput.outPutMessage("Use your 'W', 'A', 'S', 'D' to move the tiles.");
        inputAndOutput.outPutMessage("Tiles with the same number merge into one when they touch.");
        inputAndOutput.outPutMessage("");
        inputAndOutput.outPutMessage("HOW TO WIN AND LOSE");
        inputAndOutput.outPutMessage("WIN: Add the tiles up to reach 2048");
        inputAndOutput.outPutMessage("LOSE: If there are no any possible movement, you will lose.");
    }
    
    // Exit Game
    public void exitGame() {
        inputAndOutput.outPutMessage("Thank you for playing the game");
        exit(0);
    }

    // Game over
    public void gameover() {
        gameOverLoop:
        while (true) {
            inputAndOutput.outPutMessage("Game Over, restart with current mode? [Y/n]");
            String s = inputAndOutput.getInput();
            switch (s) {
                case "y", "Y", "" -> {
                    logic.creatGrid(logic.dimension);
                    break gameOverLoop;
                }
                case "n", "N" -> {
                    changeOrExit();
                    break gameOverLoop;
                }
                default -> inputAndOutput.outPutMessage("No such command, please re-enter the correct command");
            }
        }
    }
}
