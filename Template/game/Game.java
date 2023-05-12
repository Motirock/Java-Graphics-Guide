package game;

import main.KeyHandler;
import main.MouseHandler;
import main.GamePanel;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Game {
    private long updates = 0;

    private GamePanel gp;

    public Game(GamePanel gp) {
        this.gp = gp;
    }

    public void update() {
        updates++;
    }

    public void draw(Graphics2D g2) {}
}
