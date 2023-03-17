# 1.3 My First Graphics

Last time, we created the fundamentals of the Game class. In this section, we will draw our first shape: a red circle.  
We will NOT modify update() because there are no logical updates to be executed. We will just modify draw().

### Steps:  
-Open Game.java.
-Import a Color class with the following import statement.

    import java.awt.Color;
    
-Now we can begin writing our draw() method. First, add the following statement to change the color of what *will* be drawn to red:
    
    g2.setColor(Color.RED);
    
-Finally, we can draw the circle with the following staement:

    g2.fillOval(400, 50, 800, 800);
    
 -Now when you compile and run Main.java, a red circle should be shown on screen.
 
 [1.4](https://github.com/Motirock/An-Introduction-To-Java-Graphics/tree/main/Part%201/1.4)
    
    
