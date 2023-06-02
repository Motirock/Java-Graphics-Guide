# Part 9: Sound

For these past tutorials, we have only been using visuals. But what about sound?  
This tutorial will cover a basic sound class and how to use it.  

### The `Sound` Class

Inside the `main` folder, there should be a `Sound.java` file. Let's look inside.  
At the top, you will notice several import statements. You don't have to know what each one does or how it works, but you can find their APIs online.  
In the beginning of the class definition for `Sound`, there are the following instance variables:  
  
    private ArrayList<URL> soundURLs = new ArrayList<URL>();   //By default, it can store 30 sounds
    private Clip clip;                  //Used to play audio
    private int volume = 50;        //Volume: default is 50%. I made sure it is linear instead of in decibels (logarithmic)
    private FloatControl fc;    //Used to help control volume
    private float maxVolume = 6.0f;     //Max volume in decibels
    private float minVolume = -80.0f;   //Min volume in decibels
  
Much more importantly, there are methods to actually use the class.  

### The Constructor

First, there is the constructor. This is used to load the sounds used.  

    //Loads URLs of sounds
    public Sound(ArrayList<String> files) {
        for (int i = 0; i < files.size(); i++)
            soundURLs.add(getClass().getResource("/res/audio/"+files.get(i)));
    }
    
The only parameters is an `ArrayList` of strings which is contains the names of the audio files. For example, if you named your sounds `death.wav` and `heal.wav`, you would load it using the constructor of the `Sound` class in the following way:
    
    //Sound: the Strings are the names of the sound files used. Also note that the order matters.
    ArrayList<String> soundFiles = new ArrayList<String>(Arrays.asList("bruh.wav", "bruh.wav"));
    Sound sound = new Sound(new ArrayList<String>(Arrays.asList("death.wav", "heal.wav")));
  
### Setting the File

After loading them to the `Sound` class we will have to set the file we want as played.  
This is where the `setFile(int)` method comes in.  

    //Sets the file being played. Returns whether or not it was successful without errors
    public boolean setFile(int i) {
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(soundURLs.get(i));
            clip = AudioSystem.getClip();
            clip.open(sound);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            updateVolume();
            return true;
        } catch(Exception e) {
            System.out.println("Setting file in Sound failed!");
            return false;
        }
    }
    
We pass to the method the index of the sound file we want to play. This means that we will have to know the index of the file name in the `ArrayList` we passed in the constructor of the `Sound` object.   
### Playing the Sound

No sound will play yet, because we haven't called the `play()` method.  

    //Plays the current sound from the beginning
    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }

The `play()` method plays the sound we sent with `setfile(int i)` from the beginning.  
For it to work, we most call `play()` after `setFile(int i)` for the `Sound` class to work as intended.  
I actually made some methods in the bottom of `GamePanel` which can help take care of secondary steps in playing a sound, like updating the volume. You can use these, if you prefer.  

### Other Methods

`loop()` loops sounds TODO CHECK. 
`stop()` TODO CHECK. 
`updateVolume()` is only used by the class to update the volume from the linear-scaled `volume` instance variable of `Game` to decibels (logarithmic) and then sets it using classes imported. Also, if `volume` is out of the range of 0-100, it is adjusted appropriately.  
`setVolume(int vol)` sets the volume based on the integer passed as a parameter.  
`getVolume()` returns the volume.  
`incrementVolume()` and `decrementVolume()` increment and decrement volume, respectively. By default it does this by 5 percent, but you can go into the `Sound` class and edit it.  

### Playing a Sound Effect Example

bruh.  
To play a "bruh" sound effect, there are several steps.  

##### Downloading

To play a "bruh" sound effect, we need to first download it.  
After [downloading](https://github.com/Motirock/An-Introduction-To-Java-Graphics/blob/main/Resources/Audio%20Files/bruh.wav) the sound effect, let's put it in the `res` folder.  

##### Setting File Path

File paths are set when we construct the `Sound` object in `GamePanel`, so we will have to modify the `GamePanel` class.  
Change the line where we create the `Sound` object in `GamePanel` (it is after the section involing keystrokes and directly after the creation of the `Game` object) to be:

  Sound sound = new Sound(new ArrayList<String>(Arrays.asList("bruh.wav", "bruh.wav")));
  
If it this already (it is like this in the template), you don't have to modify it.  
Now, we can start modifying the `Game` class. 
In the //TODO do this at home, create example sound program and test all methods.
  

Now that we have covered output, you should be ready to move on to input.  
[Part 10: Keyboard Input](https://github.com/Motirock/An-Introduction-To-Java-Graphics/tree/main/Tutorials/Part%2010)
