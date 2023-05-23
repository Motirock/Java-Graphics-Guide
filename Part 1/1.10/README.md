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

Comparetively, creaing new keybinds is much more complicated.  
First navigate to the `KeyHandler.java` file in `main`.  
At the top there are detailed versions of the first three steps:  
1. Create a boolean to keep track of if a certain key is pressed. I format it as [keyName]IsPressed.  
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
