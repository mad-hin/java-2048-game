package com.marco.terminal;

import com.marco.terminal.ui.layout;

import java.io.IOException;

public class Game {

    // Init layout class here
    layout Layout = new layout();
    // Init logic class in here
    logic Logic = new logic();

    public static void main(String[] args) throws IOException {
        new Game();
    }

    public Game() throws IOException {
        welcome();
        Layout.init();
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
