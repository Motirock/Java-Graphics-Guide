package game;

import main.GamePanel;

import java.awt.Color;
import java.awt.Graphics2D;

public class Game {
    private GamePanel gp;

    public Game(GamePanel gp) {
        this.gp = gp;
    }
    
    public void update() {
    
    }
    
    public void draw(Graphics2D g2, double GS) {
        g2.setColor(Color.RED);
        g2.fillOval(700, 350, 200, 200);
    }
}
