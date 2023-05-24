package game;

import main.GamePanel;

import java.awt.Graphics2D;

public class Game {
    private long updates = 0;

    private GamePanel gp;

    public Game(GamePanel gp) {
        this.gp = gp;
    }

    public void update() {
        updates++;
    }

    public void draw(Graphics2D g2, double GS) {}
}
