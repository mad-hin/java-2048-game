package com.marco.terminal.ui;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class is for the output view
 */
public class Layout {

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

    /**
     * Function to build the frame
     *
     * @param grid The grid with the values
     */
    public void buildFrame(int[][] grid) {
        int edge = grid[0].length;
        // use PrintWriter to print unicode
        int x = 0, y = 0;
        PrintWriter printWriter = new PrintWriter(System.out, true);
        for (int i = 1; i <= edge * 2 + 1; i++) {
            int cnt_J = 0;
            for (int j = 1; j <= edge * 4 + edge + 1; j++) {
                if (j == 1 && i == 1) {
                    printWriter.print('\u250c'); // ┌
                } else if (j == 1 && i == edge * 2 + 1) {
                    printWriter.print('\u2514'); // └
                } else if (i == 1 && j != edge * 4 + edge + 1 && cnt_J == 4) {
                    printWriter.print('\u252c'); // ┬
                    cnt_J = 0;
                } else if (i == edge * 2 + 1 && cnt_J == 4 && j != edge * 4 + edge + 1) {
                    printWriter.print('\u2534'); // ┴
                    cnt_J = 0;
                } else if (i % 2 == 0 && (cnt_J == 4 || j == 1)) {
                    printWriter.print('\u2502'); // │
                    cnt_J = 0;
                } else if (j == edge * 4 + edge + 1 && i == 1) {
                    printWriter.print('\u2510'); // ┐
                } else if (j == edge * 4 + edge + 1 && i == edge * 2 + 1) {
                    printWriter.print('\u2518');
                } else if (i % 2 == 1) {
                    if (cnt_J == 4 && j != edge * 4 + edge + 1) {
                        printWriter.print('\u253c'); // ┼
                        cnt_J = 0;
                    } else if (j == 1) {
                        printWriter.print('\u251c'); // ├
                    } else if (j == edge * 4 + edge + 1) {
                        printWriter.print('\u2524'); // ┤
                    } else {
                        printWriter.print('\u2500'); // ─
                        cnt_J++;
                    }
                } else{
                    printWriter.print('*');
                    cnt_J++;
                }
            }
            printWriter.println();
        }
    }

    /**
     * function to print the numbers with spaces
     *
     * @param num the number
     *
     */
    private void printGridNumber(int num) {
        int numSize = getNumSize(num);
        StringBuilder s = new StringBuilder();
        PrintWriter printWriter = new PrintWriter(System.out, true);
        s.append(" ".repeat(Math.max(0, 4 - numSize)));
        printWriter.print(s);
        printWriter.print(num);
    }

    /**
     * get the number of digits
     *
     * @param num
     * @return
     */
    private int getNumSize(int num) {
        Integer n = num;
        return n.toString().length();
    }
}
