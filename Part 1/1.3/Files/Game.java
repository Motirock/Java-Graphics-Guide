package game;

import main.GamePanel;

import java.awt.Color;

public class Game {
    private GamePanel gp;

    public Game(GamePanel gp) {
        this.gp = gp;
    }
    
    public update() {
    
    }
    
    public draw(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.fillOval(700, 350, 200, 200);
    }
}