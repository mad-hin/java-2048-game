package com.marco.terminal.ui;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class layout {

    // Function to generate ASCII Art
    public void asciiTextGen(String text) throws IOException {
        int width;
        int height;
        try (Terminal terminal = TerminalBuilder.terminal()) {
            // Get the terminal width and height
            width = terminal.getWidth();
            height = terminal.getHeight();
        }
        // In case width = 0, it will have default width
        if (width == 0) {
            width = 90;
        }
        // In case height = 0, it will have default  height
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

    // Function to build the frame
    public void buildFrame(int[][] grid){

    }
}
