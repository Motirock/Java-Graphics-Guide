# Part 4: Using the `update` Method

Last time, we created a single, red circle. However, it is static.
To fix this, we can use the `update()` method in `Game.java`.
By the end of this section, the circle's radius will oscillate.

### A Dyanmic Circle:
First, open `Game.java`  
Then, reate a new instance variables in the `Game` class:
    
    private long updates = 0; //Total times update() has been run
    private int radius = 100;
    
Next, we will need to actually implement the `update()` method.  Add the following code inside the the `update()` method:
    
    updates++; //Note that by default 1000 updates per second are attempted
    
    if (updates % 10 == 0) { //The radius will oscillate between 100 and 200, switching direction every second.
        if (updates % 2000 < 1000)
            radius++;
        else
            radius--;
    }
    
Finally, we will change our `draw(Graphics2D)` method. We want the circle to stay centered, so we will have to modify the line to be:

    g2.fillOval(800-radius, 450-radius, radius*2, radius*2);
    
Now, the circle's radius should oscillate.  
 
 [Part 5: Shapes and Colors](https://github.com/Motirock/An-Introduction-To-Java-Graphics/edit/main/Tutorials/Part%205)
            
