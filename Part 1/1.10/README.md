# 1.10: Keyboard Input

If you have ever used a computer, chances are you've used a keyboard.  

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
1. Create a boolean to keep track of if a certain key is pressed. I format it as [keyName]IsPressed. For this example, I'll being using the "up" key stroke (whether that is by pressing w or the up arrow).  
2. Create two new classes with a relevant name, one for handling the key being pressed and the other for being released.  
Example:

    	public class UpPressedAction extends AbstractAction {}
	
    	public class UpReleasedAction extends AbstractAction {}
	
3. Add the actionPerformed method to each, updating the boolean variable we created.  
Example:

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

The next four steps are all in the `GamePanel` class.  
First, create new objects of the classes you created.

	Action upPressedAction = keyH.new UpPressedAction();
	Action upReleasedAction = keyH.new UpReleasedAction();
	
Next, inside the `updateKeyBindings` method, we would add the following code:

	thisWindow.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upPressed");
		thisWindow.getActionMap().put("upPressed", upPressedAction);
        thisWindow.getInputMap().put(KeyStroke.getKeyStroke("released UP"), "upReleased");
		thisWindow.getActionMap().put("upReleased", upReleasedAction);
		
This code maps the keystroke of the up arrow key to our actions.  
If you wanted to make it so pressing the w key did the same thing, you would replace "UP" with "W" in both places.  It is important that every piece of information matches up for keybindings to work correctly.  

### Example: Moving a Shape

Let's say you wanted to make a simple program that moved a square around the canvas, where w moved it up, s moved it down, a moved it right and d moved it right.  
This code will go through adding the actions and booleans to `KeyhHndler`, binding the actions in `GamePanel`, and then using it to move the rectangle in `update()`.  
