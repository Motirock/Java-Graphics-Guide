# Part 2: Creating the `Game` Class

If you downloaded the template, you most likely can just open up `Game.java` in `game`, and it should have all of what is in this section.  
If you try to compile Main.java without the `Game` class, it will fail. If you want to create the `Game.java` file from scratch, you can follow this tutorial.  

### Steps:
-Navigate to the `src` folder
-Create a new folder named `game`
-Create a new file named `Game.java` (the suffix/file type is important)
-Some applications automatically create a class header for you, but if it is not there create it like so:  

    package game;  
  
    public class Game {}  
   
-Add the following imports after the package statement but before the class header:  
    
    import java.awt.Graphics2D;  
    
-Create the following instance variable inside the class body:

    //Allows access to system functions, like activating fullscreen, playing a sound, or getting mouse and keyboard input.
    private GamePanel gp;
    
-Create the following methods inside the class body:

    public Game(GamePanel gp) {
        this.gp = gp;
    }
    
    public void update() {
    
    }
    
    public void draw(Graphics2D g2, double GS) {
    
    }

[Part 3: Using the `draw` Method](https://github.com/Motirock/An-Introduction-To-Java-Graphics/tree/main/Tutorials/Part%203)
