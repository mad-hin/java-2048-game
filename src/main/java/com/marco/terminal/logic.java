package com.marco.terminal;

import java.util.Scanner;

public class logic {
    // public variable
    public int[][] grid;

    // private variable
    private Scanner scanner = new Scanner(System.in);

    // get input message
    public String getInput() {
        return scanner.nextLine();
    }

    // create the grid for the game
    public void creatGrid(int size) {
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

}
