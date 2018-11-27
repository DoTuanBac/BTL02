package boom;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.HashMap;

public class Audio {
    public static Audio instance;

    public static final String MENU = "put.wav";

    private HashMap<String, AudioClip> audioMap;
    
    public Audio() {
        audioMap = new HashMap<>();
        loadAllAudio();
    }

    public static Audio getIstance() {
        if (instance == null) {
            instance = new Audio();
        }

        return instance;
    }

    public void loadAllAudio() {
        putAudio(MENU);

    }
  public void stop() {
        getAudio(MENU).stop();
  
    }
   

    public void putAudio(String name) {
        AudioClip auClip = Applet.newAudioClip(Audio.class.getResource(name));
        audioMap.put(name, auClip);
    }

    public AudioClip getAudio(String name) {
        return audioMap.get(name);
    }
}
