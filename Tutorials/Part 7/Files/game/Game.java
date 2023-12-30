package game;

import main.GamePanel;
import main.Rectangle;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Game {
    private GamePanel gp;

    private long updates = 0; //Total times update() has been run

    //A BufferedImage which does not store anything yet
    public BufferedImage image = null;

    //Position and dimensions of the image stored in a Rectangle objects
    //Note that by default it will have a position of (0, 0) and both its width and height will be 0
    private Rectangle rect;

    public Game(GamePanel gp) {
        this.gp = gp;

        //Creating rectangle to store image position and dimensions
        int x = 350;    //Top left corner x
        int y = 100;    //Top left corner y
        int w = 800;    //Image width
        int h = 800;    //Image height
        rect = new Rectangle(x, y, w, h);
        
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

        //The image moves right and then left, switching directions after the image moves over 100 units
        if (updates % 2000 < 1000)
            rect.x += 0.1;  //Moving right
        else
            rect.x -= 0.1;  //Moving left
    }
    
    public void draw(Graphics2D g2, double GS) {
        g2.drawImage(image, (int) (rect.x*GS), (int) (rect.y*GS), (int) (rect.width*GS), (int) (rect.height*GS), null);

        /*
        //Alternatively:
        int sourceX = 0;    //Top left corner y
        int sourceY = 0;    //Top left corner x
        int sourceW = 20;   //Width for whole image
        int sourceH = 20;   //Height for whole image
        g2.drawImage(image, //Image
            (int) (rect.x*GS), (int) (rect.y*GS), (int) ((rect.x+rect.width)*GS), (int) ((rect.y+rect.height)*GS),  //Destination rectangle, with the last two parameters forming the bottom-left point
            sourceX, sourceY, sourceX+sourceW, sourceY+sourceH, //Source Rectangle
            null);  //ImageObserver
        */
    }
}
