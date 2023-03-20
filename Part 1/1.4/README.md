# 1.4 Using update()

Last time, we created a single, red circle. However, it is static.
To fix this, we can use the update() method in Game.java.
By the end of this section, the circle's radius will oscillate.

### Steps:
-Open Game.java
-Create a new instance variables in the Game class:
    
    private long updates = 0; //Total times update() has been run
    private int radius = 100;
    
-Next, we will need to actually implement the update() method.  
 Add the following code inside the the update() method
