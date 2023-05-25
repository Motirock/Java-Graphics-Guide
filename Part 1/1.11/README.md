# 1.11: Mouse Input

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
First, create instance variables.  
