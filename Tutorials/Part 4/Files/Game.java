package game;

import main.GamePanel;

import java.awt.Color;
import java.awt.Graphics2D;

public class Game {
    private GamePanel gp;

    private long updates = 0; //Total times update() has been run
    private int radius = 100;

    public Game(GamePanel gp) {
        this.gp = gp;
    }
    
    public void update() {
        updates++; //Note that by default 1000 updates per second are attempted

        if (updates % 10 == 0) { //The radius will oscillate between 100 and 200, switching direction every second.
            if (updates % 2000 < 1000)
                radius++;
            else
                radius--;
        }
    }
    
    public void draw(Graphics2D g2, double GS) {
        g2.setColor(Color.RED);
        g2.fillOval(800-radius, 450-radius, radius*2, radius*2);
    }
}
