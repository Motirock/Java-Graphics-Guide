package game;

import main.GamePanel;

import java.awt.Color;

public class Game {
    private GamePanel gp;

    private long updates = 0;

    //Keeps track of rectangle position
    private double centerX = 800, centerY = 450;
    private int width = 100, height = 100;
    
    public Game(GamePanel gp) {
        this.gp = gp;
    }
    
    public update() {
        updates++;

        //Keyboard controls, where each arrow key moves the rectangle accordingly
        if (gp.keyH.upArrowPressed) {
            centerY -= 0.1;
        }
        if (gp.keyH.downArrowPressed) {
            centerY += 0.1;
        }
        if (gp.keyH.leftArrowPressed) {
            centerX -= 0.1;
        }
        if (gp.keyH.rightArrowPressed) {
            centerX += 0.1;
        }

        //Keeps rectangle from going out of bounds
        if (centerX < width)
            centerX = width;
        if (centerX > 1600-width)
            centerX = 1600-width;
        if (centerY < height)
            centerY = height;
        if (centerY > 900-height)
            centerY = height;
    }
    
    public draw(Graphics2D g2, double GS) {
        //Setting the color to be green
        g2.setColor(Color.GREEN);
        //Draws the rectangle
        g2.fillRectangle((int) ((centerX-width/2.0)*GS), (int) ((centerY-height/2.0)*GS), width, height);
    }
}
