package com.marco.terminal;

import com.marco.terminal.ui.layout;
import com.marco.terminal.ui.menu;

import java.io.IOException;

public class Game {

    // Init other class
    layout Layout = new layout();
    logic Logic = new logic();
    menu Menu = new menu();

    public static void main(String[] args) throws IOException {
        new Game();
    }

    public Game() throws IOException {
        welcome();
        Menu.chooseGameMode();
    }

    private void welcome() throws IOException {
        try {
            // Generate the ASCII Art Text of 2048
            Layout.asciiTextGen("2048");
        } catch (Exception e) {
            throw new IOException(e);
        }
        // Welcome message
        Logic.outPutMessage("Welcome to the terminal version 2048");
    }
}
