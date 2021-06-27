package com.marco.terminal;

import com.marco.terminal.ui.layout;
import com.marco.terminal.ui.menu;

import java.util.Scanner;

import static java.lang.System.exit;

public class logic {
    // Init other class
    menu Menu = new menu();
    layout Layout = new layout();

    // public variable
    public int[][] grid;
    public int dimension;

    // private variable
    private final Scanner scanner = new Scanner(System.in);

    // get input message
    public String getInput() {
        return scanner.nextLine();
    }

    // create the grid for the game
    public void creatGrid(int size) {
        dimension = size;
        switch (size) {
            case 4 -> grid = new int[4][4];
            case 8 -> grid = new int[8][8];
        }
        startGame();
    }

    // output message
    public void outPutMessage(String msg) {
        System.out.println(msg);
    }

    // Exit Game
    public void exitGame() {
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
                    Menu.changeOrExit();
                    break gameOverLoop;
                }
                default -> outPutMessage("No such command, please re-enter the correct command");
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
