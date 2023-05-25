package game;

import main.GamePanel;

import java.awt.Color;

public class Game {
    private GamePanel gp;

    private long updates = 0;

    //Keeps track of circle position
    private double centerX = 800, centerY = 450;
    private double radius = 50;
    
    public Game(GamePanel gp) {
        this.gp = gp;
    }
    
    public update() {
        updates++;

        //Mouse controls
        centerX = gp.mouseX;
        centerY = gp.mouseY;

        //Keeps rectangle from going out of bounds
        if (centerX < radius)
            centerX = radius;
        if (centerX > 1600-radius)
            centerX = 1600-radius;
        if (centerY < radius)
            centerY = radius;
        if (centerY > 900-radius)
            centerY = radius;
    }
    
    public draw(Graphics2D g2, double GS) {
        //Setting the color to be blue
        g2.setColor(Color.BLUE);
        //Draws the circle
        g2.fillOval((int) ((centerX-radius/2.0)*GS), (int) ((centerY-radius/2.0)*GS), radius, radius);
    }
}
