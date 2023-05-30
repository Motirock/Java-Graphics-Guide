# 1.10: Keyboard Input

If you have ever used a computer, chances are you've used a keyboard. But how can we incorporate this into our application?  

### Use Existing Keybinds

The template comes with four built in keybinds: the up, down, left, and right arrows.  
Technically, this is treated as 8, as pressed and released are different, but let's ignore this for now.  
In `Game` if we want to know if a key is pressed we use the following syntax (written in pseudocode):

    if (gp.keyH.keyIsPressed) {
        doSomething();
    }

Here is an example (written in `update()`):

    if (gp.keyH.upArrowIsPressed) {
        System.out.println("You are pressing the up arrow!");
    }
    
### Adding new Keybinds

Comparatively, creaing new keybinds is much more complicated.  

##### In `KeyHandler`

First navigate to the `KeyHandler.java` file in `main`.  
At the top there are detailed versions of the first three steps:  
-Create a boolean to keep track of if a certain key is pressed. I format it as [keyName]IsPressed. For this example, I'll being using the "up" key stroke (whether that is by pressing w or the up arrow).  
-Create two new classes with a relevant name, one for handling the key being pressed and the other for being released:  

	public class UpPressedAction extends AbstractAction {}
	
	public class UpReleasedAction extends AbstractAction {}

-Add the actionPerformed method to each, updating the boolean variable we created.  

	public class UpPressedAction extends AbstractAction {
		@Override public void actionPerformed(ActionEvent e) {
			upIsPressed = true;
		}
	}

	public class UpReleasedAction extends AbstractAction {
		@Override public void actionPerformed(ActionEvent e) {
			upIsPressed = false;
		}
	}
	    
##### In `GamePanel`

The next two steps are all in the `GamePanel` class.  
-Create new objects of the classes you created.

	Action upPressedAction = keyH.new UpPressedAction();
	Action upReleasedAction = keyH.new UpReleasedAction();
	
-Inside the `updateKeyBindings` method, we would add the following code:

	thisWindow.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upPressed");
		thisWindow.getActionMap().put("upPressed", upPressedAction);
	thisWindow.getInputMap().put(KeyStroke.getKeyStroke("released UP"), "upReleased");
		thisWindow.getActionMap().put("upReleased", upReleasedAction);
		
This code maps the keystroke of the up arrow key to our actions.  
If you wanted to make it so pressing the w key did the same thing, you would replace "UP" with "W" in both places.  It is important that every piece of information matches up for keybindings to work correctly.  

### Example: Moving a Shape

Let's say you wanted to make a simple program that moved a square around the canvas using the arrow keys.  
This code segment assumes that arrow keys are already tracked in `KeyHandler` (built into template) and just shows how to implement this in `Game`.  
First, add the following instance variables to `Game`:  

	//Keeps track of rectangle position
    private double centerX = 800, centerY = 450;
    private int width = 100, height = 100;
	
Second, add the following statements to `update()`:

	//Keyboard controls, where each arrow key moves the rectangle accordingly
	if (gp.keyH.upArrowPressed) {
		centerY -= 0.1;
	}
	if (gp.keyH.downArrowPressed) {
		centerY += 0.1;
	}
	if (gp.keyH.leftArrowPressed) {
		centerX -= 0.1;
	}
	if (gp.keyH.rightArrowPressed) {
		centerX += 0.1;
	}
	
	//Keeps rectangle from going out of bounds
	if (centerX < width)
		centerX = width;
	if (centerX > 1600-width)
		centerX = 1600-width;
	if (centerY < height)
		centerY = height;
	if (centerY > 900-height)
		centerY = height;
	
Finally, draw the rectangle in `draw(Graphics2D, double)`:

	//Setting the color to be green
        g2.setColor(Color.GREEN);
	//Draws the rectangle
	g2.fillRectangle((int) ((centerX-width/2.0)*GS), (int) ((centerY-height/2.0)*GS), width, height);
	
You'll notice that I'm using `GS` so that the graphics work well as long as the screen dimensions (width/height) remain around 16/9.  
	
Now, let's move on to mouse input.  
[Part 11: Mouse Input](https://github.com/Motirock/An-Introduction-To-Java-Graphics/tree/main/Tutorials/Part%2011)
