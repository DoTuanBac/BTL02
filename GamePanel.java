package crazyarcade;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.w3c.dom.events.MouseEvent;

public class GamePanel extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener {

    private Thread thread;
    private boolean running = false;
    private InputManager inputManger;
    public GameWorld GW;
    public GameWorlds GWs;
    double temp1 = 0;
    double temp2 = 0;

    @Override
    public void paint(Graphics g) {
        GWs.render((Graphics2D) g);
        GW.render((Graphics2D) g);

    }

    public GamePanel() {
        inputManger = new InputManager(this);
        GW = new GameWorld(inputManger.i, null, null, null);
        GWs = new GameWorlds();
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    public void switchMap() {
        inputManger.i++;
        if (inputManger.i <= 4) {
            temp1 = GW.diem1;
            temp2 = GW.diem2;
            GW = new GameWorld(inputManger.i, null, inputManger.name1, inputManger.name2);
            GW.diem1 = temp1;
            GW.diem2 = temp2;
        }

    }

    public void resetMap(String str) {
        inputManger.i = -1;
        GW = new GameWorld(-1, str, null, null);
        temp1 = 0;
        temp2 = 0;

    }

    public void update() {

        GW.update();
        if (GW.man >= 2 && GW.man < 5) {
            if (GW.count_nqv == 0) {
                switchMap();
            }
            else if (GW.count_nqv == 0 && GW.man == 4) {
                resetMap("     Thắng !!!");
            }
            else if (GW.count_nv == 0) {
                resetMap("      Thua !!!");
            }
            else if (GW.time.denta > 0 && GW.time.denta <= 0.5) {
               resetMap("      Thua !!!");
            }
        }
        if (GW.man == 5) {
            if (GW.count_nv == 0) {
                resetMap("     Hòa !!!");
            } else if (GW.count_nv == 1 && GW.ob.life == false && GW.ob2.life == true) {
                resetMap(inputManger.name2 + " thắng !!!");
            } else if (GW.count_nv == 1 && GW.ob2.life == false && GW.ob.life == true) {
                resetMap(inputManger.name1 + " thắng !!!");
            }
            else if (GW.time.denta > 0 && GW.time.denta <= 0.5) {
                resetMap("Hòa !!! ");
            }
        }

    }

    public void Start() //Bắt đầu
    {
        if (thread == null) {
            thread = new Thread(this);
            running = true;
            thread.start();
        }

    }

    @Override
    public void run() {         //Hàm sau chạy chương trình

        long period = 1000 * 1000000 / Parameter.FPS;      //Chu kì
        long beginTime;
        long sleepTime;

        beginTime = System.nanoTime();

        while (running) //Update +Render 
        {

            update();
            // RenderGame();
            repaint();           //Vẽ lại màn hình
            long dentaTime = System.nanoTime() - beginTime;      //Khoảng thời gian

            sleepTime = period - dentaTime;        //Chu kì trừ khoảng thời gian
            try {
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime / 1000000);
                } else {
                    Thread.sleep(period / 2000000);
                }
            } catch (InterruptedException ex) {
            }
            beginTime = System.nanoTime();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {             //Gõ kí tự
    }

    @Override
    public void keyPressed(KeyEvent ke) {           //Nhấn phím
        inputManger.processKeyPressed(ke.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent ke) {          //Nhả phím ra
        inputManger.processKeyReleased(ke.getKeyCode());
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent me) {

    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent me) {

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent me) {
        inputManger.mouseReleased(me);
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent me) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent me) {
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent me) {
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent me) {
        inputManger.mouseMoved(me);
    }

}
