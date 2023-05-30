# Part 11: Mouse Input

Whenever we use a computer, we will almost certainly use a mouse at least at some point.  

### Using `MouseHandler` & `GamePanel`

If the previous lesson was a bit overwhelming, know that it is much easier to get mouse input.  
Unlike for `KeyHandler`, the variables that are best used are stored in `GamePanel`.  
I will now give a brief rundown of what each variable involving the mouse stored in `GamePanel` represents.  
-`mouseLeftClicked`: only true when the left mouse button is *released.*  
-`mouseLeftPressed`: true if the left mouse button is actively pressed.  
-`mouseRightClicked`: only true when the right mouse button is *released.*. 
-`mouseRightPressed`: true if the right mouse button is actively pressed.  
-`mouseX`: position of mouse on screen where 0 is left side and 1600 is right side. The position is scaled so that it will always be between 0-1600, even if 1.5x bigger. This relies on the ratio being the same. The same applies for mouseY.  
-`mouseY`: position of mouse on screen where 0 is top side and 900 is bottom side.  
-`mouseScrolled`: whether or not the mouse was just scrolled.  
-`mouseScrollAmount`: amount the mouse was scrolled most recently.  

##### Testing `mouseScrollAmount`

How much your mouse scroll and in which direction depends on your computer, your mouse, and your settings.  
I would reccomend testing it so that you can know which direction is which, and how sensitive your mouse is. Try putting this code in `update()` and scrolling while having your mouse on the window:  

    if (gp.mouseScrolled) {
        System.out.println("Mouse scroll amount: "+gp.mouseScrollAmount);
    }
    
Try scrolling in different directions in different speeds to see what is printed.  

### Example: Moving a Shape

In the previous tutorial, we moved a rectangle with a keyboard. To keep it interesting, let's move a circle with a mouse.  
First, create the following instance variables in `Game`:  

    //Keeps track of circle position
    private double centerX = 800, centerY = 450;
    private double radius = 50;
    
Then, add the following code to `update()` to make the circle's position change while staying in bounds:  

    //Mouse controls
    centerX = gp.mouseX;
    centerY = gp.mouseY;

    //Keeps rectangle from going out of bounds
    if (centerX < radius)
        centerX = radius;
    if (centerX > 1600-radius)
        centerX = 1600-radius;
    if (centerY < radius)
        centerY = radius;
    if (centerY > 900-radius)
        centerY = radius;

Finally, update `draw(Graphics2D, double)`:

    //Setting the color to be blue
    g2.setColor(Color.BLUE);
    //Draws the circle
    g2.fillOval((int) ((centerX-radius/2.0)*GS), (int) ((centerY-radius/2.0)*GS), radius, radius);
    
This is my final tutorial! I created some example programs as well, so feel free to explore them.  
If you found this guide useful, make sure to SMASH that star button and DESTROY that follow button (can we get to TWO followers by the end of 2075?).    
