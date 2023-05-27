# 1.2: Creating the Game class

If you downloaded the template, you most likely can just open up `Game.java` and it should have all of what is in this section.  
If you try to compile Main.java, it will fail to compile because there is no Game class. To fix this, we will need to create a rudimentary Game class with the required methods.  

### Steps:
-Navigate to the `src` folder
-Create a new folder named `game`
-Create a new file named `Game.java` (the suffix/file type is important)
-Some applications automatically create a class header for you, but if it is not there create it like so:  

    package game;  
  
    public class Game {}  
   
-Add the following imports after the package statement but before the class header:  
    
    import main.KeyHandler;  
    import main.GamePanel;  

    import java.awt.Graphics2D;  
    
-Create the following instance variable inside the class body:

    //Allows access to system functions, like activating fullscreen, playing a sound, or getting mouse and keyboard input.
    private GamePanel gp;
    
-Create the following methods inside the class body:

    public Game(GamePanel gp) {
        this.gp = gp;
    }
    
    public update() {
    
    }
    
    public draw(Graphics2D g2, double GS) {
    
    }

[1.3](https://github.com/Motirock/An-Introduction-To-Java-Graphics/tree/main/Part%201/1.3)
