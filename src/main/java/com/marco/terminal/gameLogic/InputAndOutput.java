package com.marco.terminal.gameLogic;

import java.util.Scanner;

/**
 * This class is for input and output
 */
public class InputAndOutput {
    // private variable
    private final Scanner scanner = new Scanner(System.in);

    // get input message
    public String getInput() {
        return scanner.nextLine();
    }

    // output message
    public void outPutMessage(String msg) {
        System.out.println(msg);
    }
}
