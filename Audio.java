package crazyarcade;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.HashMap;

public class Audio {
    public static Audio instance;

    public static final String MENU = "put.wav";
    public static final String MENU1="bang.wav";
    public static final String MENU2="item.wav";
        public static final String MENU3="pick.wav";
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
        putAudio(MENU1);
        putAudio(MENU2);
        putAudio(MENU3);
    }
  public void stop() {
        getAudio(MENU).stop();
         getAudio(MENU1).stop();
          getAudio(MENU2).stop();
           getAudio(MENU3).stop();
      
    }
   

    public void putAudio(String name) {
        AudioClip auClip = Applet.newAudioClip(Audio.class.getResource(name));
        audioMap.put(name, auClip);
    }

    public AudioClip getAudio(String name) {
        return audioMap.get(name);
    }
}
