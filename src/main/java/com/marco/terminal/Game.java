package com.marco.terminal;

import com.marco.terminal.gameLogic.InputAndOutput;
import com.marco.terminal.ui.layout;
import com.marco.terminal.ui.Menu;

import java.io.IOException;

public class Game {

    // Init other class
    layout Layout = new layout();
    Menu menu  = new Menu();
    InputAndOutput inputAndOutput=new InputAndOutput();

    public static void main(String[] args) throws IOException {
        new Game();
    }

    public Game() throws IOException {
        welcome();
        menu.chooseGameMode();
    }

    private void welcome() throws IOException {
        try {
            // Generate the ASCII Art Text of 2048
            Layout.asciiTextGen("2048");
        } catch (Exception e) {
            throw new IOException(e);
        }
        // Welcome message
        inputAndOutput.outPutMessage("Welcome to the terminal version 2048");
    }
}
