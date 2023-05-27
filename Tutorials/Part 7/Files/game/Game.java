package game;

import main.GamePanel;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Game {
    private GamePanel gp;

    private long updates = 0; //Total times update() has been run

    //A BufferedImage which does not store anything yet
    public BufferedImage image = null;

    //Position and dimensions of the image
    private int x = 350;    //Top left corner x
    private int y = 100;    //Top left corner y
    private int w = 800;    //Image width
    private int h = 800;    //Image height

    public Game(GamePanel gp) {
        this.gp = gp;
        
        //Loads the chest image from the res folder to image
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/chest.png"));
        } catch (IOException e) {
            //Prints the error and the stack trace if it fails to load the image from res
            e.printStackTrace();
        }
    }
    
    public void update() {
        //Keeps track of total times update() was called
        updates++;

        //The image moves right and then left, switching direction every second
        if (updates % 10 == 0) {
            if (updates % 2000 < 1000)
                x++;    //Moving right
            else
                x--;    //Moving left
        }
    }
    
    public void draw(Graphics2D g2, double GS) {
        g2.drawImage(image, x, y, w, h, null);
    }
}
