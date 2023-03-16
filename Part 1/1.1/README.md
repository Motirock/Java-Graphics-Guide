# 1.1: Summary of Main, GamePanel, and Game

### Main
As you probably know, Main is typically the class that contains main() which runs when execution begins. However, main is not the main part of our program. For the most part, all main does is set up the window and create the GamePanel.

### GamePanel
The GamePanel coordinates the functions of the game. It handles loading graphics, keyboard controls, mouse input, sound, and more. Most importantly, it contains three functions which are key to understand.
#### run()
The run method is run in a loop until the program ends. The program executes run() as many times as possible. This is not typically desired for games, because it may make it run too fast and use up too many resources. Instead, it executes the methods update() and draw(). These are called at set intervals.  
To change the interval at which it updates, change the variable updatesPerSecond.  
To change the interval at which it draws, change the varibale FPS.  
#### update()
The update method handles all logical updates for GamePanel. It resets variables and most importantly calls update() on Game object game.  
It is important to have most classes contain an update() method to handle their own logical updates.
Game handles all game objects and so updates them independently of GamePanel.
#### draw()
The draw method handles all graphical updates for GamePanel. It  most importantly calls draw() on Game object game.  
It is important to have most classes contain an draw() method to handle their own graphical updates.
Game handles all game objects and so draws them independently of GamePanel.
