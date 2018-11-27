
package boom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JPanel;
import javazoom.jl.player.Player;


public class GamePanel extends JPanel implements Runnable,KeyListener {
    private Thread thread;
    private boolean isRunning=true;
    public static int x=50,y=50;
    public static int vx=0,vy=0;
    BufferedImage img ;
    BufferedImage subimg ;
    static InputStream Song ;
    @Override
    public void paint(Graphics g){
        Toolkit toolkit = this.getToolkit();
        Dimension dimension = toolkit.getScreenSize();
        g.setColor(Color.white);
        g.fillRect(0, 0, dimension.width, dimension.height);
    try {
       
        img = ImageIO.read(new File("C:/Users/Asus/Desktop/Boom/src/data/character.png"));
        subimg=img.getSubimage(0, 0, 50, 50);
        g.drawImage(subimg, x, y, this);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    
    
     public void startGame(){
        if (thread == null){
            thread=new Thread (this);
            thread.start();
        }             
    }

    public GamePanel() {
            addKeyListener(this);
    }
    @Override
    public void run()
    {
        
        long FPS = 80;
        long period = 1000*1000000/FPS;
        long beginTime;
        long sleepTime;
        
        int a = 1;
        
        beginTime = System.nanoTime();
        while(isRunning){
           
           repaint();
            long deltaTime = System.nanoTime() - beginTime;
            sleepTime = period - deltaTime;     
            try {
                if(sleepTime > 0)
                    Thread.sleep(sleepTime/1000000);
                else Thread.sleep(period/2000000);
            } catch (InterruptedException ex) {}
            
            beginTime = System.nanoTime();         
        }
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key press");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        InputManager.processKeyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        InputManager.processKeyReleased(e.getKeyCode());
    }
}
