package com.marco.terminal;

import com.marco.terminal.ui.layout;

import java.io.IOException;

public class Game {
    // Init layout class here
    layout Layout = new layout();
    // Init logic class in here
    logic logic = new logic();

    public static void main(String[] args) throws IOException {
        new Game();
    }

    public Game() throws IOException {
        welcome();
        logic.getInput();
    }

    private void welcome() throws IOException {
        try{
            Layout.asciiTextGen("2048");
        }catch (Exception e){
            throw new IOException(e);
        }
        // Welcome message
        System.out.println("Welcome to the terminal version 2048");
    }
}
