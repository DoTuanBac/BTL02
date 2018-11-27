package boom;

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
    
    public void Stop() throws IOException{
        if(player!=null){
            player.close();
            
        }
    }
    public void playSong (String Songpath){
        try {
            Stop();
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
    
 public void Pause(){
        if(player!=null){
            try {
                Songpos = FIS.available();
                player.close();
            } catch (IOException ex) {
               
            }           
        }
    }
 public void Resume (){
        try {
            Stop();
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
