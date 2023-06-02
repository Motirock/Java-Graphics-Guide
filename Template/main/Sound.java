package main;

import java.util.ArrayList;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
    private ArrayList<URL> soundURLs = new ArrayList<URL>();   //By default, it can store 30 sounds
    private Clip clip;                  //Used to play audio
    private int volume = 50;        //Volume: default is 50%. I made sure it is linear instead of in decibels (logarithmic)
    private FloatControl fc;    //Used to help control volume
    private float maxVolume = 6.0f;     //Max volume in decibels
    private float minVolume = -80.0f;   //Min volume in decibels
    
    //Loads URLs of sounds
    public Sound(ArrayList<String> files) {
        for (int i = 0; i < files.size(); i++)
            soundURLs.add(getClass().getResource("/res/audio/"+files.get(i)));
    }
    
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
    
    //Plays the current sound from the beginning
    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }
    
    //Loops the current sound WHEN DOES STOP LOOPING?
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    //Stops the current sounds
    public void stop() {
        clip.stop();
    }
    
    //Updates volume of the FloatControl to the current linear-scaled volume
    private void updateVolume() {
        if (volume <= 0) {
            volume = 0;
            fc.setValue(-80.0f);
            return;
        }
        if (volume >= 100)//TODO automatically to max
            volume = 100;
        fc.setValue((float) (Math.log10(volume/10.0)*(maxVolume-minVolume)+minVolume));
    }
    
    //Sets volume to an integer 0-100 on a logarthmic scale
    public void setVolume(int vol) {
        volume = vol;
        updateVolume();
    }
                                             
    //Returns volume
    public int getVolume() {
        return volume;
    }
    
    //Increments volume by 5
    public void incrementVolume() {
        volume += 5;
        updateVolume();
    }
    
    //Decrements volume by 5
    public void decrementVolume() {
        volume -= 5;
        updateVolume();
    }
}
