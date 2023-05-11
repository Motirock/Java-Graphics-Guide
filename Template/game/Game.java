package game;

import main.KeyHandler;
import main.MouseHandler;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Game {
    private long updates = 0;

    private KeyHandler keyH;
    private MouseHandler mouseH;

    public Game(KeyHandler keyH, MouseHandler mouseH) {
        this.keyH = keyH;
        this.mouseH = mouseH;
    }

    public void update() {
        updates++;
    }

    public void draw(Graphics2D g2) {}
}