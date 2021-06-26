package com.marco.terminal;

import com.marco.terminal.ui.layout;

public class Game {
    // Init layout class here
    layout Layout = new layout();
    // Init logic class in here
    logic logic = new logic();

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        welcome();
        logic.getInput();
    }

    private void welcome() {
        Layout.asciiTextGen("2048");
        // Welcome message
        System.out.println("Welcome to the terminal version 2048");
    }
}
