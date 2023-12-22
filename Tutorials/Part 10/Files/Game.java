package game;

import main.GamePanel;

import java.awt.Color;
import java.awt.Graphics2D;

public class Game {
    private GamePanel gp;

    private long updates = 0;

    //Keeps track of rectangle position
    private double centerX = 800, centerY = 450;
    private int width = 100, height = 100;
    
    public Game(GamePanel gp) {
        this.gp = gp;
    }
    
    public void update() {
        updates++;

        //Keyboard controls, where each arrow key moves the rectangle accordingly
        if (gp.keyH.upArrowIsPressed) {
            centerY -= 0.1;
        }
        if (gp.keyH.downArrowIsPressed) {
            centerY += 0.1;
        }
        if (gp.keyH.leftArrowIsPressed) {
            centerX -= 0.1;
        }
        if (gp.keyH.rightArrowIsPressed) {
            centerX += 0.1;
        }

        //Keeps rectangle from going out of bounds
        if (centerX < width/2)
            centerX = width/2;
        if (centerX > 1600-width/2)
            centerX = 1600-width/2;
        if (centerY < height/2)
            centerY = height/2;
        if (centerY > 900-height/2)
            centerY = 900-height/2;
    }
    
    public void draw(Graphics2D g2, double GS) {
        //Setting the color to be green
        g2.setColor(Color.GREEN);
        //Draws the rectangle
        g2.fillRect((int) ((centerX-width/2.0)*GS), (int) ((centerY-height/2.0)*GS), (int) (width*GS), (int) (height*GS));
    }
}
