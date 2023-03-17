# 1.2 Creating the Game class

When you first try to compile Main.java, it will fail to compile because there is no Game class.  
##### Steps to create a Game class:
-Navigate to the "src" folder
-Create a new folder named "game"
-Create a new file named "Game.java" (the suffix/file type is important)
-Some applications automatically create a class header for you, but if it is not there create it like so:  

    package game;  
  
    public class Game {}  
   
-Add the following imports after the package statement but before the class header:  
    
    import main.KeyHandler;  
    import main.GamePanel;  

    import java.awt.Graphics2D;  
    
