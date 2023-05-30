# Part 1: Summary of Main, GamePanel, and Game

#### Main

As you probably know, `Main` is typically the class that contains `main()` which runs when execution begins. However, main is not the main part of our program. For the most part, all main does is set up the window and create the `GamePanel`.

#### GamePanel

The `GamePanel` coordinates the functions of the game. It handles loading graphics, keyboard controls, mouse input, sound, and more. It contains a `Game` object which contains information about the game itself. Most importantly, it contains three functions which are key to understand.  

##### run()
The run method is run in a loop until the program ends. The program executes `run()` as many times as possible. This is not typically desired for games, because it may make it run too fast and use up to many resources. Instead, it executes the methods `update()` and `draw()`. These are called at set intervals.  
To change the interval at which it updates, change the variable `updatesPerSecond`.  
To change the interval at which it draws, change the varbiable `FPS`.  
##### update()
The update method handles all logical updates for `GamePanel`. It resets variables and most importantly calls `update()` on `Game `object game.  
It is important to have most classes contain an `update()` method to handle their own logical updates.  
`Game` handles all game objects and so updates them independently of GamePanel.  
##### draw()
The draw method handles all graphical updates for `GamePanel`. It  most importantly calls `draw()` on the `Game` object that is referred to as `game`.  
It is important to have most classes contain an `draw()` method to handle their own graphical updates.  
`Game` handles all game objects and so draws them independently of `GamePanel`.  


### Getting Started
To get started, download this repository and extract it. Next, create a Java project in your preferred IDE or application.  
Next, we need to find the right folder. For most, the right folder is the `src` folder, like for VS Code. However, if there is no `src` folder, just use the project folder (this is the case for BlueJ).  
Once you have found the right folder, drag in the contents of the `Template` folder in the downloaded version of the repository.  
From now on, I am going to refer to the mentioned folder as `src` even if it not named this.  

[Part 2: Creating the Game Class](https://github.com/Motirock/An-Introduction-To-Java-Graphics/tree/main/Tutorials/Part%202)
