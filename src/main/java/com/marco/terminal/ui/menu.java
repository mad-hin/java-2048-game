package com.marco.terminal.ui;

import com.marco.terminal.logic;

public class menu {
    // Init other class
    layout Layout = new layout();
    logic Logic = new logic();

    // choose the game mode (2x2, 4x4 or 8x8)
    public void chooseGameMode() {
        loop:
        while (true) {
            Logic.outPutMessage("Please choose the game mode:");
            Logic.outPutMessage("[1] 2x2 grid, [2] 4x4 grid, [3] 8x8 grid, [E]xit Game");
            String input = Logic.getInput();
            switch (input) {
                case "1" -> {
                    Logic.creatGrid(2);
                    Logic.assignNumber(Logic.grid);
                    Layout.buildFrame(Logic.grid);
                    break loop;
                }
                case "2" -> {
                    Logic.creatGrid(4);
                    Logic.assignNumber(Logic.grid);
                    Layout.buildFrame(Logic.grid);
                    break loop;
                }
                case "3" -> {
                    Logic.creatGrid(8);
                    Logic.assignNumber(Logic.grid);
                    Layout.buildFrame(Logic.grid);
                    break loop;
                }
                case "e", "E" -> Logic.exitGame();
                default -> Logic.outPutMessage("No such command, please re-enter the correct command");
            }
        }
    }

    // Let the user decide change game mode or exit
    public void changeOrExit() {
        changeOrExitLoop:
        while (true) {
            Logic.outPutMessage("[C]hange game mode, [E]xit game (Default C)");
            String s = Logic.getInput();
            switch (s) {
                case "c", "C", "" -> {
                    chooseGameMode();
                    break changeOrExitLoop;
                }
                case "e", "E" -> {
                    Logic.exitGame();
                    break changeOrExitLoop;
                }
                default -> Logic.outPutMessage("No such command, please re-enter the correct command");
            }
        }
    }
}
