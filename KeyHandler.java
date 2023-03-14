package main;

import java.awt.event.*;//TODO refine this to be only necessary libraries

import javax.swing.AbstractAction;

public class KeyHandler {
	public boolean upArrowPressed, downArrowPressed, leftArrowPressed, rightArrowPressed;

	//Arrow keys
	public class UpPressedAction extends AbstractAction {
		@Override public void actionPerformed(ActionEvent e) {
			upPressed = true;
		}
	}
	public class UpReleasedAction extends AbstractAction {
		@Override public void actionPerformed(ActionEvent e) {
			upPressed = false;
		}
	}
	public class DownPressedAction extends AbstractAction {
		@Override public void actionPerformed(ActionEvent e) {
			downPressed = true;
		}
	}
	public class DownReleasedAction extends AbstractAction {
		@Override public void actionPerformed(ActionEvent e) {
			downPressed = false;
		}
	}
	public class LeftPressedAction extends AbstractAction {
		@Override public void actionPerformed(ActionEvent e) {
			leftPressed = true;
		}
	}
	public class LeftReleasedAction extends AbstractAction {
		@Override public void actionPerformed(ActionEvent e) {
			leftPressed = false;
		}
	}
	public class RightPressedAction extends AbstractAction {
		@Override public void actionPerformed(ActionEvent e) {
			rightPressed = true;
		}
	}
	public class RightReleasedAction extends AbstractAction {
		@Override public void actionPerformed(ActionEvent e) {
			rightPressed = false;
		}
	}
}	
