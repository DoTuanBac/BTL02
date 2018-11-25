package crazyarcade;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Audios {
    public long Songpos;
    public long SongTotalLength;
    public String Songnowplaying;
    public FileInputStream FIS;
    public BufferedInputStream BIS;
    public Player player;
    String name[];
    

    public Audios() {
        name = new String[6];
        name[0] = "Songs/All Time Low - Time-Bomb.mp3";
        name[1] = "Songs/Avicii - Waiting For Love.mp3";
        name[2] = "Songs/Levianth & Axol - Remember (feat. The Tech Thieves) [NCS Release].mp3";
        name[3] = "Songs/Mendum - Stay With Me (Krys Talk Remix) [NCS Release].mp3";
        name[4] = "Songs/NIVIRO - Memes [NCS Release].mp3";
        name[5] = "Songs/Reality - Lost Frequencies Lyrics Vietsub.mp3";
        
    }
    
    public void stop(){
        
        if(player!=null){
            player.close();
            try {
                FIS.close();
                 BIS.close();
            } catch (IOException ex) {
               
            }
       
        }
    }
    public void play (String Songpath){
        try {
           
            FIS=new FileInputStream(Songpath);
            BIS=new BufferedInputStream(FIS);
            player = new Player(BIS);
            Songnowplaying=Songpath;
            SongTotalLength=FIS.available();
        } catch (Exception ex) {
            
        }
        new Thread ()
        {
            @Override
            public void run(){
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                   ex.printStackTrace();
                }
            }
        }.start();
    }
    

 public void pause(){
        if(player!=null){
            try {
                Songpos = FIS.available();
                player.close();
            } catch (IOException ex) {
               
            }           
        }
    }
 public void resume (){
        try {
            stop();
            FIS=new FileInputStream(Songnowplaying);
            BIS=new BufferedInputStream(FIS);
            player = new Player(BIS);
            FIS.skip(SongTotalLength-Songpos);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        new Thread ()
        {
            @Override
            public void run(){
                try {
                    player.play();
                    
                } catch (Exception ex) {
                   ex.printStackTrace();
                }
            }
        }.start();
    }
}
