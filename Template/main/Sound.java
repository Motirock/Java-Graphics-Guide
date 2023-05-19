package main;

import java.util.ArrayList;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
    private ArrayList<URL> soundURLs = new ArrayList<URL>();   //By default, it can store 30 sounds
    private Clip clip;                      //Used to play audio
    private int volume = 50;         //Volume: default is 50%. I made sure it is linear instead of in decibels (logarithmic)
    private FloatControl fc;                //Used to help control volume
    
    //Loads URLs of sounds
    public Sound(ArrayList<String> files) {
        for (int i = 0; i < files.size(); i++)
            soundURLs.getClass().getResource("/res/audio/"+add(files.get(i));
    }
    
    //Sets the file being played
    public void setFile(int i) {
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(soundURLs.get(i));
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
