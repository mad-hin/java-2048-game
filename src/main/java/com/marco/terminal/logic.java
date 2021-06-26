package com.marco.terminal;

import com.marco.terminal.ui.layout;

import java.util.Scanner;

import static java.lang.System.exit;

public class logic {
    // public variable
    public int[][] grid;
    public int dimension;

    // private variable
    private final Scanner scanner = new Scanner(System.in);

    // Init other class
    layout Layout = new layout();

    // get input message
    public String getInput() {
        return scanner.nextLine();
    }

    // create the grid for the game
    public void creatGrid(int size) {
        dimension = size;
        switch (size) {
            case 2 -> grid = new int[2][2];
            case 4 -> grid = new int[4][4];
            case 8 -> grid = new int[8][8];
        }
    }

    // output message
    public void outPutMessage(String msg) {
        System.out.println(msg);
    }

    // Exit Game
    private void exitGame() {
        outPutMessage("Thank you for playing the game");
        exit(0);
    }

    // Game over
    private void gameover() {
        gameOverLoop:
        while (true) {
            outPutMessage("Game Over, restart with current mode? [Y/n]");
            String s = getInput();
            switch (s) {
                case "y", "Y", "" -> {
                    creatGrid(dimension);
                    break gameOverLoop;
                }
                case "n", "N" -> {
                    changeOrExit();
                    break gameOverLoop;
                }
                default -> outPutMessage("No such command, please re-enter the correct command");
            }
        }
    }

    // Let the user decide change game mode or exit
    private void changeOrExit() {
        changeOrExitLoop:
        while (true) {
            outPutMessage("[C]hange game mode, [E]xit game (Default C)");
            String s = getInput();
            switch (s) {
                case "c", "C", "" -> {
                    chooseGameMode();
                    break changeOrExitLoop;
                }
                case "e", "E" -> {
                    exitGame();
                    break changeOrExitLoop;
                }
                default -> outPutMessage("No such command, please re-enter the correct command");
            }
        }
    }

    // choose the game mode (2x2, 4x4 or 8x8)
    public void chooseGameMode() {
        loop:
        while (true) {
            outPutMessage("Please choose the game mode:");
            outPutMessage("[1] 2x2 grid, [2] 4x4 grid, [3] 8x8 grid, [E]xit Game");
            String input = getInput();
            switch (input) {
                case "1" -> {
                    creatGrid(2);
                    Layout.buildFrame(grid);
                    break loop;
                }
                case "2" -> {
                    creatGrid(4);
                    Layout.buildFrame(grid);
                    break loop;
                }
                case "3" -> {
                    creatGrid(8);
                    Layout.buildFrame(grid);
                    break loop;
                }
                case "e", "E" -> exitGame();
                default -> outPutMessage("No such command, please re-enter the correct command");
            }
        }
    }
}
