# Sound

For these past tutorials, we have only been using visuals. But what about sound?  
This tutorial will cover a basic sound class and how to use it.  

### The `Sound` Class

Inside the `main` folder, there should be a `Sound.java` file. Let's look inside.  
At the top, you will notice several import statements. You don't have to know what each one does or how it works, but you can find their APIs online.  
In the beginning of the class definition for `Sound`, there are the following instance variables:  
  
    private URL soundURL[] = new URL[30];   //By default, it can store 30 sounds
    private Clip clip;                      //Used to play audio
    private public int volume = 50;         //Volume: default is 50%. I made sure it is linear instead of in decibels (logarithmic)
    private FloatControl fc; 
  
Much more importantly, there are methods to actually use the class.  
