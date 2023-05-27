package game;

import main.GamePanel;

import java.awt.Color;
import java.awt.Graphics2D;

public class Game {
    private GamePanel gp;

    private long updates = 0; //Total times update() has been run

    public Game(GamePanel gp) {
        this.gp = gp;
    }
    
    public void update() {
        updates++; //Note that by default 1000 updates per second are attempted
    }
    
    public void draw(Graphics2D g2, double GS) {
        g2.setColor(Color.BLUE);
        g2.fillOval(400, 50, 800, 800);
        g2.setColor(Color.GREEN);
        g2.fillOval(400, 50, 800, 800);
        g2.setColor(new Color(1.0f, 0.0f, 0.0f, 0.5f)); //Transparent red
        g2.fillRect(400, 0, 800, 800); //Rectangle
    }
}
