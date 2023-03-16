# 1.1: Summary of Main, GamePanel, and Game

### Main
As you probably know, Main is typically the class that contains main() which runs when execution begins. However, main is not the main part of our program. For the most part, all main does is set up the window and create the GamePanel.

### GamePanel
The GamePanel coordinates the functions of the game. It handles loading graphics, keyboard controls, mouse input, sound, and more. Most importantly, it contains three functions which are key to understand.
#### run()
The run method is run in a loop until the program ends. The program executes run() as many times as possible. This is not typically desired for games, because it may make it run too fast and use up too many resources. Instead, it executes the methods update() and draw(). These are called at set intervals.  
To change the interval at which it updates, change the variable updatesPerSecond.  
To change the interval at which it draws, change the varibale FPS.  
