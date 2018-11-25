/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyarcade;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import sun.java2d.loops.FillRect;

/**
 *
 * @author Do Tuan Bac
 */
public class NhanVat {

   Audios au;
 
   private int id;
    private double posX;
    private double posY;
    boolean life = true;
    private double speed;
    private double max_speed;

    private double speedX;
    private double speedY;
     int count_bom=0;
    private int size_bom;
    private int max_size_bom;
    private int n_bom;
    private int max_bom;
    private int speed_a = 200;
    private int max_speed_a = 100;
    private int tx, ty;

    private Animation test1;
    private Animation test2;
    private Animation test3;
    private Animation test4;
    public static int move = 0;
    FrameImage i11;
    FrameImage i12;
    FrameImage i13;
    FrameImage i14;
    FrameImage i21;
    FrameImage i22;
    FrameImage i23;
    FrameImage i24;
    FrameImage i31;
    FrameImage i32;
    FrameImage i33;
    FrameImage i34;
    FrameImage i41;
    FrameImage i42;
    FrameImage i43;
    FrameImage i44;
    BufferedImage image13;
    BufferedImage image23;
    BufferedImage image33;
    BufferedImage image43;
    boolean put=false;
    public  int vector = 0;
    public NhanVat() {
    }

    GameWorld gw;
    int tempx,tempy;
  public void draw(Graphics2D g2) //Vẽ đối tượng lên
    { //x-30. y-25   +10 do bỏ đâu con thịt mỡ
      if(life==true)
      {
        if( put==true && Parameter.Map[(int) (getPosY() + 25) / Parameter.size][(int) (getPosX() + 30) / Parameter.size] == 0   && count_bom<n_bom)
        {
            if(Parameter.sfx==true)
            {
              
               Audio.getIstance().getAudio(Audio.MENU).play();
              
            }
            if(Parameter.Map[tempy][tempx]==-19)  Parameter.Map[tempy][tempx]=-20;
           put=false;
          Parameter.boom[(int) (getPosY() + 25) / Parameter.size][(int) (getPosX() + 30) / Parameter.size] = new Boom((int) (getPosX() + 30) / Parameter.size, (int) (getPosY() + 25) / Parameter.size, size_bom, n_bom, max_size_bom, max_bom, this.gw, id);
        Parameter.boom[(int) (getPosY() + 25) / Parameter.size][(int) (getPosX() + 30) / Parameter.size].setPut(true);
            Parameter.Map[(int) (getPosY() + 25) / Parameter.size][(int) (getPosX() + 30) / Parameter.size] = -19;
              count_bom++;
              tempy=(int) (getPosY() + 25) / Parameter.size;
              tempx=(int) (getPosX() + 30) / Parameter.size;
        }
        else
        {
            put=false;
        }
        
          loadAnimation(g2);
      }
        
     
    }
    public void update() {
        
        if (life == true) {
            
            
            vacham();
            vachamBom();
            vacham_QV();
            item();

            setPosX(getPosX() + speedX);
            setPosY(getPosY() + speedY);

            test1.Update(System.nanoTime());
            test2.Update(System.nanoTime());
            test3.Update(System.nanoTime());
            test4.Update(System.nanoTime());
            if( Parameter.Map[(int) (getPosY() + 25) / Parameter.size][(int) (getPosX() + 30) / Parameter.size]!=Parameter.Map[tempy][tempx]&&Parameter.Map[tempy][tempx]==-19)  Parameter.Map[tempy][tempx]=-20;
        }
    }

    public NhanVat(int id,String name,double posX, double posY, double speed, double max_speed, int size_bom, int max_size_bom, int n_bom, int max_bom, GameWorld gw) {
       this.id=id;
        au = new Audios();
      
        this.posX = posX;
        this.posY = posY;
        this.max_speed = max_speed;
        this.speed = speed;

        this.test1 = new Animation();
        this.test2 = new Animation();
        this.test3 = new Animation();
        this.test4 = new Animation();
         this.gw = gw;

        this.size_bom = size_bom;
        this.max_size_bom = max_size_bom;
        this.n_bom = n_bom;
        this.max_bom = max_bom;
        BufferedImage image = null;
        try {
            if(name=="Thịt Mỡ")image = ImageIO.read(new File("character/ThitMo/thitmo.png"));
             if(name=="Bé Bỏng")image = ImageIO.read(new File("character/ThitMo/bebong.png"));
              if(name=="Mắt Xanh")image = ImageIO.read(new File("character/ThitMo/matxanh.png"));
              
                  if(name=="Khò Khò")image = ImageIO.read(new File("character/ThitMo/khokho.png"));

            BufferedImage image11 = image.getSubimage(0, 0, 55, 60);
            BufferedImage image12 = image.getSubimage(60, 0, 55, 60);
            image13 = image.getSubimage(120, 0, 55, 60);
            BufferedImage image14 = image.getSubimage(180, 0, 55, 60);
            BufferedImage image15 = image.getSubimage(240, 0, 50, 60);

            BufferedImage image21 = image.getSubimage(0, 75, 55, 60);
            BufferedImage image22 = image.getSubimage(60, 75, 55, 60);
            image23 = image.getSubimage(120, 75, 55, 60);
            BufferedImage image24 = image.getSubimage(180, 75, 55, 60);
            BufferedImage image25 = image.getSubimage(240, 75, 50, 60);

            BufferedImage image31 = image.getSubimage(0, 150, 55, 60);
            BufferedImage image32 = image.getSubimage(60, 150, 55, 60);
            image33 = image.getSubimage(120, 150, 55, 60);
            BufferedImage image34 = image.getSubimage(180, 150, 55, 60);
            BufferedImage image35 = image.getSubimage(240, 150, 50, 60);

            BufferedImage image41 = image.getSubimage(0, 225, 55, 60);
            BufferedImage image42 = image.getSubimage(60, 225, 55, 60);
            image43 = image.getSubimage(120, 225, 55, 60);
            BufferedImage image44 = image.getSubimage(180, 225, 55, 60);
            BufferedImage image45 = image.getSubimage(240, 225, 50, 60);

            i11 = new FrameImage("", image11);
            i12 = new FrameImage("", image12);
            i13 = new FrameImage("", image14);
            i14 = new FrameImage("", image15);

            i21 = new FrameImage("", image21);
            i22 = new FrameImage("", image22);
            i23 = new FrameImage("", image24);
            i24 = new FrameImage("", image25);

            i31 = new FrameImage("", image31);
            i32 = new FrameImage("", image32);
            i33 = new FrameImage("", image34);
            i34 = new FrameImage("", image35);

            i41 = new FrameImage("", image41);
            i42 = new FrameImage("", image42);
            i43 = new FrameImage("", image43);
            i44 = new FrameImage("", image45);
        } catch (IOException ex) {
        }

        test1.add(i11, speed_a * 1000000);
        test1.add(i12, speed_a * 1000000);
        test1.add(i11, speed_a * 1000000);
        test1.add(i13, speed_a * 1000000);
        test1.add(i14, speed_a * 1000000);
        test1.add(i13, speed_a * 1000000);

        test2.add(i21, speed_a * 1000000);
        test2.add(i22, speed_a * 1000000);
        test2.add(i21, speed_a * 1000000);
        test2.add(i23, speed_a * 1000000);
        test2.add(i24, speed_a * 1000000);
        test2.add(i23, speed_a * 1000000);

        test3.add(i31, speed_a * 1000000);
        test3.add(i32, speed_a * 1000000);
        test3.add(i31, speed_a * 1000000);
        test3.add(i33, speed_a * 1000000);
        test3.add(i34, speed_a * 1000000);
        test3.add(i33, speed_a * 1000000);

        test4.add(i41, speed_a * 1000000);
        test4.add(i42, speed_a * 1000000);
        test4.add(i41, speed_a * 1000000);
        test4.add(i43, speed_a * 1000000);
        test4.add(i44, speed_a * 1000000);
        test4.add(i43, speed_a * 1000000);

       

    }

    private void loadAnimation(Graphics2D g2) {
        if (vector == 1) {
            test4.draw((int) posX, (int) posY, g2);
        }
        if (vector == 2) {
            test1.draw((int) posX, (int) posY, g2);
        }
        if (vector == 3) {
            test2.draw((int) posX, (int) posY, g2);
        }
        if (vector == 4) {
            test3.draw((int) posX, (int) posY, g2);
        }

        if (vector == 5) {
            g2.drawImage(image43, (int) posX, (int) posY, null);
        }
        if (vector == 6) {
            g2.drawImage(image13, (int) posX, (int) posY, null);
        }
        if (vector == 7) {
            g2.drawImage(image23, (int) posX, (int) posY, null);
        }
        if (vector == 8) {
            g2.drawImage(image33, (int) posX, (int) posY, null);
        }
        if (vector == 0) {
            g2.drawImage(image13, (int) posX, (int) posY, null);
        }

    }

  

    public void vacham() {
        if (life == true) {
            if (Parameter.Map[(int) ((getPosY() + Parameter.saiso + 10) / Parameter.size)][(int) (getPosX() + Parameter.saiso + speedX) / Parameter.size] > 0) {
                if (Parameter.Map[(int) ((getPosY() + Parameter.saiso + 10 + 35) / Parameter.size)][(int) (getPosX() + Parameter.saiso + speedX) / Parameter.size] > 0) {
                    setSpeedX(0);
                    vector = 7;
                } else {

                    setPosY(getPosY() + 1);
                }

            }
            if (Parameter.Map[(int) ((getPosY() + Parameter.saiso + 10) / Parameter.size)][(int) (getPosX() - Parameter.saiso + speedX) / Parameter.size + 1] > 0) {
                if (Parameter.Map[(int) ((getPosY() + Parameter.saiso + 10 + 35) / Parameter.size)][(int) (getPosX() - Parameter.saiso + speedX) / Parameter.size + 1] > 0) {
                    setSpeedX(0);
                    vector = 8;
                } else {

                    setPosY(getPosY() + 1);
                }

            }
            if (Parameter.Map[(int) (getPosY() + Parameter.saiso + 10 + speedY) / Parameter.size][(int) (getPosX() + Parameter.saiso) / Parameter.size] > 0) {
                if (Parameter.Map[(int) (getPosY() + Parameter.saiso + 10 + speedY) / Parameter.size][(int) (getPosX() + Parameter.saiso + 35) / Parameter.size] > 0) {
                    setSpeedY(0);
                    vector = 5;
                } else {

                    setPosX(getPosX() + 1);
                }
            }
            if (Parameter.Map[(int) (getPosY() - Parameter.saiso + 10 + speedY) / Parameter.size + 1][(int) (getPosX() + Parameter.saiso) / Parameter.size] > 0) {
                if (Parameter.Map[(int) (getPosY() - Parameter.saiso + 10 + speedY) / Parameter.size + 1][(int) (getPosX() + Parameter.saiso + 35) / Parameter.size] > 0) {
                    setSpeedY(0);
                    vector = 6;
                } else {

                    setPosX(getPosX() + 1);
                }
            }

            if (Parameter.Map[(int) ((getPosY() - Parameter.saiso + 10) / Parameter.size + 1)][(int) (getPosX() + Parameter.saiso + speedX) / Parameter.size] > 0) {
                if (Parameter.Map[(int) ((getPosY() - Parameter.saiso + 10 - 35) / Parameter.size + 1)][(int) (getPosX() + Parameter.saiso + speedX) / Parameter.size] > 0) {
                    setSpeedX(0);
                    vector = 7;
                } else {

                    setPosY(getPosY() - 1);
                }
            }

            if (Parameter.Map[(int) ((getPosY() - Parameter.saiso + 10) / Parameter.size + 1)][(int) (getPosX() - Parameter.saiso + speedX) / Parameter.size + 1] > 0) {
                if (Parameter.Map[(int) ((getPosY() - Parameter.saiso + 10 - 35) / Parameter.size + 1)][(int) (getPosX() - Parameter.saiso + speedX) / Parameter.size + 1] > 0) {
                    setSpeedX(0);
                    vector = 8;
                } else {

                    setPosY(getPosY() - 1);
                }
            }
            if (Parameter.Map[(int) (getPosY() + Parameter.saiso + 10 + speedY) / Parameter.size][(int) (getPosX() - Parameter.saiso) / Parameter.size + 1] > 0) {
                if (Parameter.Map[(int) (getPosY() + Parameter.saiso + 10 + speedY) / Parameter.size][(int) (getPosX() - Parameter.saiso - 35) / Parameter.size + 1] > 0) {
                    setSpeedY(0);
                    vector = 5;
                } else {

                    setPosX(getPosX() - 1);
                }
            }
            if (Parameter.Map[(int) (getPosY() - Parameter.saiso + 10 + speedY) / Parameter.size + 1][(int) (getPosX() - Parameter.saiso) / Parameter.size + 1] > 0) {
                if (Parameter.Map[(int) (getPosY() - Parameter.saiso + 10 + speedY) / Parameter.size + 1][(int) (getPosX() - Parameter.saiso - 35) / Parameter.size + 1] > 0) {
                    setSpeedY(0);
                    vector = 6;

                } else {

                    setPosX(getPosX() - 1);
                }
            }
        }
    }

    public void vachamBom() {
        if (life == true) {
            if (Parameter.Map[(int) ((getPosY() + Parameter.saisobom + 10) / Parameter.size)][(int) (getPosX() + Parameter.saisobom) / Parameter.size] == -20
                    || Parameter.Map[(int) ((getPosY() + Parameter.saisobom + 10) / Parameter.size)][(int) (getPosX() - Parameter.saisobom) / Parameter.size + 1] == -20
                    || Parameter.Map[(int) (getPosY() - Parameter.saisobom + 10) / Parameter.size + 1][(int) (getPosX() - Parameter.saisobom) / Parameter.size + 1] == -20
                    || Parameter.Map[(int) (getPosY() - Parameter.saisobom + 10) / Parameter.size + 1][(int) (getPosX() + Parameter.saisobom) / Parameter.size] == -20) {
            } else {
                if (Parameter.Map[(int) ((getPosY() + Parameter.saisobom + 10) / Parameter.size)][(int) (getPosX() + Parameter.saisobom + speedX) / Parameter.size] == -20) {
                    if (Parameter.Map[(int) ((getPosY() + Parameter.saisobom + 10 + 35) / Parameter.size)][(int) (getPosX() + Parameter.saisobom + speedX) / Parameter.size] == -20) {
                        setSpeedX(0);
                        vector = 7;
                    } else {
                       
                        setPosY(getPosY() + 5);
                         setSpeedX(0);
                    }

                }
                if (Parameter.Map[(int) ((getPosY() + Parameter.saisobom + 10) / Parameter.size)][(int) (getPosX() - Parameter.saisobom + speedX) / Parameter.size + 1] == -20) {
                    if (Parameter.Map[(int) ((getPosY() + Parameter.saisobom + 10 + 35) / Parameter.size)][(int) (getPosX() - Parameter.saisobom + speedX) / Parameter.size + 1] == -20) {
                        setSpeedX(0);
                        vector = 8;
                    } else {
                     
                        setPosY(getPosY() + 5);
                           setSpeedX(0);
                    }

                }
                if (Parameter.Map[(int) (getPosY() + Parameter.saisobom + 10 + speedY) / Parameter.size][(int) (getPosX() + Parameter.saisobom) / Parameter.size] == -20) {
                    if (Parameter.Map[(int) (getPosY() + Parameter.saisobom + 10 + speedY) / Parameter.size][(int) (getPosX() + Parameter.saisobom + 35) / Parameter.size] == -20) {
                        setSpeedY(0);
                        vector = 5;
                    } else {
                      
                        setPosX(getPosX() + 5);
                        setSpeedY(0);
                    }
                }
                if (Parameter.Map[(int) (getPosY() - Parameter.saisobom + 10 + speedY) / Parameter.size + 1][(int) (getPosX() + Parameter.saisobom) / Parameter.size] == -20) {
                    if (Parameter.Map[(int) (getPosY() - Parameter.saisobom + 10 + speedY) / Parameter.size + 1][(int) (getPosX() + Parameter.saisobom + 35) / Parameter.size] == -20) {
                        setSpeedY(0);
                        vector = 6;
                    } else {
                       
                        setPosX(getPosX() + 5);
                         setSpeedY(0);
                    }
                }

                if (Parameter.Map[(int) ((getPosY() - Parameter.saisobom + 10) / Parameter.size + 1)][(int) (getPosX() + Parameter.saisobom + speedX) / Parameter.size] == -20) {
                    if (Parameter.Map[(int) ((getPosY() - Parameter.saisobom + 10 - 35) / Parameter.size + 1)][(int) (getPosX() + Parameter.saisobom + speedX) / Parameter.size] == -20) {
                        setSpeedX(0);
                        vector = 7;
                    } else {
                       
                        setPosY(getPosY() - 5);
                         setSpeedX(0);
                        
                    }
                }

                if (Parameter.Map[(int) ((getPosY() - Parameter.saisobom + 10) / Parameter.size + 1)][(int) (getPosX() - Parameter.saisobom + speedX) / Parameter.size + 1] == -20) {
                    if (Parameter.Map[(int) ((getPosY() - Parameter.saisobom + 10 - 35) / Parameter.size + 1)][(int) (getPosX() - Parameter.saisobom + speedX) / Parameter.size + 1] == -20) {
                        setSpeedX(0);
                        vector = 8;
                    } else {
                        
                        setPosY(getPosY() - 5);
                        setSpeedX(0);
                    }
                }
                if (Parameter.Map[(int) (getPosY() + Parameter.saisobom + 10 + speedY) / Parameter.size][(int) (getPosX() - Parameter.saisobom) / Parameter.size + 1] == -20) {
                    if (Parameter.Map[(int) (getPosY() + Parameter.saisobom + 10 + speedY) / Parameter.size][(int) (getPosX() - Parameter.saisobom - 35) / Parameter.size + 1] == -20) {
                        setSpeedY(0);
                        vector = 5;
                    } else {
                       
                        setPosX(getPosX() - 5);
                         setSpeedY(0);
                    }
                }
                if (Parameter.Map[(int) (getPosY() - Parameter.saisobom + 10 + speedY) / Parameter.size + 1][(int) (getPosX() - Parameter.saisobom) / Parameter.size + 1] == -20) {
                    if (Parameter.Map[(int) (getPosY() - Parameter.saisobom + 10 + speedY) / Parameter.size + 1][(int) (getPosX() - Parameter.saisobom - 35) / Parameter.size + 1] == -20) {
                        setSpeedY(0);
                        vector = 6;

                    } else {
                       
                        setPosX(getPosX() - 5);
                         setSpeedY(0);
                    }
                }
            }
        }
    }

    void item() {
        if (life == true) {
            if (Parameter.Map[(int) (getPosY() + 30 ) / Parameter.size][(int) (getPosX() + 25) / Parameter.size] == -1) {
               if(Parameter.sfx==true){
               Audio.getIstance().getAudio(Audio.MENU2).play();
              
               }
                Parameter.Map[(int) (getPosY() +30) / Parameter.size][(int) (getPosX() + 25) / Parameter.size] = 0;
                n_bom++;
            }
           
            if (n_bom > max_bom) {
                n_bom--;
            }

            if (Parameter.Map[(int) (getPosY() + 30) / Parameter.size][(int) (getPosX() +25) / Parameter.size] == -3) {
                if(Parameter.sfx==true)
                {
                   Audio.getIstance().getAudio(Audio.MENU2).play();
                }
                Parameter.Map[(int) (getPosY() + 30) / Parameter.size][(int) (getPosX() + 25) / Parameter.size] = 0;
                size_bom++;
            }
      
            if (size_bom > max_size_bom) {
                size_bom--;
            }

            if (Parameter.Map[(int) (getPosY() +30) / Parameter.size][(int) (getPosX() + 25) / Parameter.size] == -2) {
                if(Parameter.sfx==true){
                  
                      Audio.getIstance().getAudio(Audio.MENU2).play();
              
                }
                Parameter.Map[(int) (getPosY() + 30) / Parameter.size][(int) (getPosX() + 25) / Parameter.size] = 0;
                speed += 0.25;
                speed_a -= 50;
            }
          
            if (speed > max_speed) {
                speed -= 0.25;
            }
            if (speed_a < max_speed_a) {
                speed_a += 50;
            }
        }
    }

    public void vacham_QV() {
     if(gw.count_nqv>0 &&gw.man!=5)
{
        for (int a = 0; a < gw.qv.size(); a++) {
            if (gw.qv.get(a).life == true) {

                if ((int) (getPosY() + 30) / 50 == (int) (gw.qv.get(a).getPosY() +30) / 50 
                        && (int) (getPosX() + 25) / 50 == (int) (gw.qv.get(a).getPosX() +25) / 50 ) {
                    if(Parameter.sfx==true){
                   
                
              
               
                    }
                    life = false;
                    gw.count_nv--;
                }
                
               
            }
        }

}
    }

    public double getPosX() {
        return posX;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }
 public int X() {
        return (int) (getPosX() + 25) / Parameter.size;
    }

    public int Y() {
        return (int) (getPosY() + 40) / Parameter.size;
    }
}
