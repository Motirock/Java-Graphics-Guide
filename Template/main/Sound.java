package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
    URL soundURL[] = new URL[30];   //By default, it can store 30 sounds
    Clip clip;                      //Used to play audio
    public int volume = 50;         //Volume: default is 50%. I made sure it is linear instead of in decibels (logarithmic)
    FloatControl fc;                //Used to help control volume
    
    //Loads URLs of sounds
    public Sound() {
        //soundURL[0] = getClass().getResource("/res/audio/example_1.wav");
        //soundURL[1] = getClass().getResource("/res/audio/example_2.wav");
    }
    
    //Sets the file being played
    public void setFile(int i) {
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(sound);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            updateVolume();
        } catch(Exception e) {}
    }
    
    //Plays the current sound from the beginning
    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }
    
    //Loops the current sound
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    //Stops the current sounds
    public void stop() {
        clip.stop();
    }
    
    //Updates volume of the FloatControl to the current linear-scaled volume
    void updateVolume() {
        fc.setValue((float) (Math.log10(Math.pow(10, volume))/100*86-80));
    }
    
    //Sets volume to an integer 0-100 on a logarthmic scale
    public void setVolume(int vol) {
        volume = vol;
        updateVolume();
    }
}