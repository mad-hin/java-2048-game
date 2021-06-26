package com.marco.terminal.ui;

import com.marco.terminal.logic;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static java.lang.System.exit;

public class layout {
    private final Terminal terminal = TerminalBuilder.terminal();
    // Init logic class in here
    logic Logic = new logic();

    public layout() throws IOException {
    }

    public void asciiTextGen(String text) {
        int width, height;
        // Get the terminal width and height
        width = terminal.getWidth();
        height = terminal.getHeight();
        // In case width or height = 0, it will have default width and height
        if (width == 0) {
            width = 90;
        }
        if (height == 0) {
            height = 24;
        }
        BufferedImage stringImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = stringImage.getGraphics();
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.drawString(text, 1, 24);
        // Print the Ascii Art Text
        for (int y = 0; y < height; y++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int x = 0; x < width; x++) {
                stringBuilder.append(stringImage.getRGB(x, y) == -16777216 ? " " : stringImage.getRGB(x, y) == -1 ? "#" : "*");
            }

            if (stringBuilder.toString().trim().isEmpty()) {
                continue;
            }

            System.out.println(stringBuilder);
        }
    }

    public void init() {
        loop:
        while (true) {
            Logic.outPutMessage("Please choose the game mode:");
            Logic.outPutMessage("[1] 2x2 grid, [2] 4x4 grid, [3] 8x8 grid, [E]xit Game");
            String input = Logic.getInput();
            switch (input) {
                case "1" -> {
                    Logic.creatGrid(2);
                    break loop;
                }
                case "2" -> {
                    Logic.creatGrid(4);
                    break loop;
                }
                case "3" -> {
                    Logic.creatGrid(8);
                    break loop;
                }
                case "e", "E" -> {
                    Logic.outPutMessage("Thank you for playing the game");
                    exit(0);
                }
                default -> Logic.outPutMessage("No such command, please re-enter the correct command");
            }
        }
    }
}
