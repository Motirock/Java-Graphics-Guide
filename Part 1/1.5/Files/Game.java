package game;

import main.GamePanel;

import java.awt.Color;

public class Game {
    private GamePanel gp;

    private long updates = 0; //Total times update() has been run
    private int radius = 100;

    public Game(GamePanel gp) {
        this.gp = gp;
    }
    
    public update() {
        updates++; //Note that by default 1000 updates per second are attempted
    }
    
    public draw(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillOval(400, 50, 800, 800);
        g2.setColor(Color.GREEN);
        g2.fillOval(400, 50, 800, 800);
        g2.setColor(new Color(1.0f, 0.0f, 0.0f, 0.5f)); //Transparent red
        g2.fillRect(400, 0, 800, 800); //Rectangle
    }
}