package game;

import main.GamePanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Game {
    private GamePanel gp;

    private long updates = 0; //Total times update() has been run

    //Try changing these variables and see what happens
    private String str = "Hello!";
    private int xCoordinate = 400;
    private int yCoordinate = 400;

    public Game(GamePanel gp) {
        this.gp = gp;
    }
    
    public void update() {
        updates++; //Note that by default 1000 updates per second are attempted
    }
    
    public void draw(Graphics2D g2, double GS) {   
        //Attributes about the color only need to be set once; they remain until they are changed.
        g2.setColor(Color.RED);
        g2.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 80));
        //Draws our text at the coordinates given.
        g2.drawString(str, xCoordinate, yCoordinate);
    }
}
