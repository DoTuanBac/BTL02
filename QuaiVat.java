/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyarcade;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Do Tuan Bac
 */
public class QuaiVat {

    double x, y, speedX, speedY, speed;
    String name;
    FrameImage i2;
    FrameImage i3;

    FrameImage i5;
    FrameImage i6;

    FrameImage i8;
    FrameImage i9;

    FrameImage i11;
    FrameImage i12;
    BufferedImage image1 = null;
    BufferedImage image2 = null;
    BufferedImage image3 = null;
    BufferedImage image4 = null;

    private int tempx, tempy;
    boolean life = true;

    QuaiVat(String name,int x, int y, double speed) {
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.name=name;
         speedY = speed;
        tempx = (int) (getPosX() + 45) / Parameter.size;
        tempy = (int) (getPosY() + 25) / Parameter.size;
        try {
            if(name=="cbn")
            {
            image1 = ImageIO.read(new File("character/quaivat/1.png"));
            image2 = ImageIO.read(new File("character/quaivat/2.png"));
            image3 = ImageIO.read(new File("character/quaivat/3.png"));
            image4 = ImageIO.read(new File("character/quaivat/4.png"));
            }
              if(name=="cbl")
            {
            image1 = ImageIO.read(new File("character/quaivat/5.png"));
            image2 = ImageIO.read(new File("character/quaivat/6.png"));
            image3 = ImageIO.read(new File("character/quaivat/7.png"));
            image4 = ImageIO.read(new File("character/quaivat/8.png"));
            }
        } catch (IOException ex) {
           
        }

       
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void update() {

        if (life == true) {

            x = x + speedX;
            y = y + speedY;
            vacham();
            vacham2();

        }

    }

    public int X() {
        return (int) (getPosX() + 25) / Parameter.size;
    }

    public int Y() {
        return (int) (getPosY() + 40) / Parameter.size;
    }

    public void render(Graphics2D g2) {
        if (life == true) {
            if(name=="cbn" ||name=="cbl")
            {
            if (speedY > 0) {
                g2.drawImage(image1, (int) x + 5, (int) y, null);
            }
            if (speedY < 0) {
                g2.drawImage(image4, (int) x + 5, (int) y, null);
            }
            if (speedX > 0) {
                g2.drawImage(image3, (int) x + 5, (int) y, null);
            }
            if (speedX < 0) {
                g2.drawImage(image2, (int) x + 5, (int) y, null);
            }

        }
        }
    }

    public double getPosX() {
        return x;
    }

    public void setPosX(double x) {
        this.x = x;
    }

    public double getPosY() {
        return y;
    }

    public void setPosY(double y) {
        this.y = y;
    }

    public double getSpeedY() {
        return speedY;
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public void vacham() {

        //Sang trai 
        if (Parameter.Map[(int) ((getPosY() + Parameter.saiso ) / Parameter.size)][(int) (getPosX() + Parameter.saiso + speedX) / Parameter.size] > 0
                || Parameter.Map[(int) ((getPosY() + Parameter.saiso ) / Parameter.size)][(int) (getPosX() + Parameter.saiso + speedX) / Parameter.size] == -20
                || Parameter.Map[(int) ((getPosY() + Parameter.saiso ) / Parameter.size)][(int) (getPosX() + Parameter.saiso + speedX) / Parameter.size] == -19) {

            setSpeedX(0);
            setSpeedY(getSpeed());

        }
        //sang phai
        if (Parameter.Map[(int) ((getPosY() + Parameter.saiso ) / Parameter.size)][(int) (getPosX() - Parameter.saiso + speedX) / Parameter.size + 1] > 0
                || Parameter.Map[(int) ((getPosY() + Parameter.saiso ) / Parameter.size)][(int) (getPosX() - Parameter.saiso + speedX) / Parameter.size + 1] == -20
                || Parameter.Map[(int) ((getPosY() + Parameter.saiso ) / Parameter.size)][(int) (getPosX() - Parameter.saiso + speedX) / Parameter.size + 1] == -19) {

            setSpeedX(0);
            setSpeedY(-getSpeed());

        }
        ////Len tren
        if (Parameter.Map[(int) (getPosY() + Parameter.saiso  + speedY) / Parameter.size][(int) (getPosX() + Parameter.saiso) / Parameter.size] > 0
                || Parameter.Map[(int) (getPosY() + Parameter.saiso  + speedY) / Parameter.size][(int) (getPosX() + Parameter.saiso) / Parameter.size] == -20
                || Parameter.Map[(int) (getPosY() + Parameter.saiso  + speedY) / Parameter.size][(int) (getPosX() + Parameter.saiso) / Parameter.size] == -19) {

            setSpeedY(0);
            setSpeedX(-getSpeed());

        }
        //Xuong duoi
        if (Parameter.Map[(int) (getPosY() - Parameter.saiso  + speedY) / Parameter.size + 1][(int) (getPosX() + Parameter.saiso) / Parameter.size] > 0
                || Parameter.Map[(int) (getPosY() - Parameter.saiso  + speedY) / Parameter.size + 1][(int) (getPosX() + Parameter.saiso) / Parameter.size] == -20
                || Parameter.Map[(int) (getPosY() - Parameter.saiso  + speedY) / Parameter.size + 1][(int) (getPosX() + Parameter.saiso) / Parameter.size] == -19) {

            setSpeedY(0);
            setSpeedX(getSpeed());

        }
        //Sang trai
        if (Parameter.Map[(int) ((getPosY() - Parameter.saiso ) / Parameter.size + 1)][(int) (getPosX() + Parameter.saiso + speedX) / Parameter.size] > 0
                || Parameter.Map[(int) ((getPosY() - Parameter.saiso ) / Parameter.size + 1)][(int) (getPosX() + Parameter.saiso + speedX) / Parameter.size] == -20
                || Parameter.Map[(int) ((getPosY() - Parameter.saiso ) / Parameter.size + 1)][(int) (getPosX() + Parameter.saiso + speedX) / Parameter.size] == -19) {

            setSpeedX(0);
            setSpeedY(getSpeed());

        }
        //Sang phai
        if (Parameter.Map[(int) ((getPosY() - Parameter.saiso ) / Parameter.size + 1)][(int) (getPosX() - Parameter.saiso + speedX) / Parameter.size + 1] > 0
                || Parameter.Map[(int) ((getPosY() - Parameter.saiso ) / Parameter.size + 1)][(int) (getPosX() - Parameter.saiso + speedX) / Parameter.size + 1] == -20
                || Parameter.Map[(int) ((getPosY() - Parameter.saiso ) / Parameter.size + 1)][(int) (getPosX() - Parameter.saiso + speedX) / Parameter.size + 1] == -19) {

            setSpeedX(0);
            setSpeedY(-getSpeed());

        }
        //Len tren
        if (Parameter.Map[(int) (getPosY() + Parameter.saiso  + speedY) / Parameter.size][(int) (getPosX() - Parameter.saiso) / Parameter.size + 1] > 0
                || Parameter.Map[(int) (getPosY() + Parameter.saiso  + speedY) / Parameter.size][(int) (getPosX() - Parameter.saiso) / Parameter.size + 1] == -20
                || Parameter.Map[(int) (getPosY() + Parameter.saiso  + speedY) / Parameter.size][(int) (getPosX() - Parameter.saiso) / Parameter.size + 1] == -19) {

            setSpeedY(0);
            setSpeedX(-getSpeed());

        }
        //Xuong duoi
        if (Parameter.Map[(int) (getPosY() - Parameter.saiso  + speedY) / Parameter.size + 1][(int) (getPosX() - Parameter.saiso) / Parameter.size + 1] > 0
                || Parameter.Map[(int) (getPosY() - Parameter.saiso  + speedY) / Parameter.size + 1][(int) (getPosX() - Parameter.saiso) / Parameter.size + 1] == -20
                || Parameter.Map[(int) (getPosY() - Parameter.saiso  + speedY) / Parameter.size + 1][(int) (getPosX() - Parameter.saiso) / Parameter.size + 1] == -19) {

            setSpeedY(getSpeed());
            setSpeedX(0);

        }

    }
     public void vacham2() {

        //Sang trai 
        if ( Parameter.Map[(int) ((getPosY() + Parameter.saiso ) / Parameter.size)][(int) (getPosX() + Parameter.saiso + speedX) / Parameter.size] == -20
                || Parameter.Map[(int) ((getPosY() + Parameter.saiso ) / Parameter.size)][(int) (getPosX() + Parameter.saiso + speedX) / Parameter.size] == -19) {

            setSpeedX(0);
            setSpeedY(getSpeed());

        }
        //sang phai
        if ( Parameter.Map[(int) ((getPosY() + Parameter.saiso ) / Parameter.size)][(int) (getPosX() - Parameter.saiso + speedX) / Parameter.size + 1] == -20
                || Parameter.Map[(int) ((getPosY() + Parameter.saiso ) / Parameter.size)][(int) (getPosX() - Parameter.saiso + speedX) / Parameter.size + 1] == -19) {

            setSpeedX(0);
            setSpeedY(-getSpeed());

        }
        ////Len tren
        if ( Parameter.Map[(int) (getPosY() + Parameter.saiso  + speedY) / Parameter.size][(int) (getPosX() + Parameter.saiso) / Parameter.size] == -20
                || Parameter.Map[(int) (getPosY() + Parameter.saiso  + speedY) / Parameter.size][(int) (getPosX() + Parameter.saiso) / Parameter.size] == -19) {

            setSpeedY(0);
            setSpeedX(-getSpeed());

        }
        //Xuong duoi
        if ( Parameter.Map[(int) (getPosY() - Parameter.saiso  + speedY) / Parameter.size + 1][(int) (getPosX() + Parameter.saiso) / Parameter.size] == -20
                || Parameter.Map[(int) (getPosY() - Parameter.saiso  + speedY) / Parameter.size + 1][(int) (getPosX() + Parameter.saiso) / Parameter.size] == -19) {

            setSpeedY(0);
            setSpeedX(getSpeed());

        }
        //Sang trai
        if ( Parameter.Map[(int) ((getPosY() - Parameter.saiso ) / Parameter.size + 1)][(int) (getPosX() + Parameter.saiso + speedX) / Parameter.size] == -20
                || Parameter.Map[(int) ((getPosY() - Parameter.saiso ) / Parameter.size + 1)][(int) (getPosX() + Parameter.saiso + speedX) / Parameter.size] == -19) {

            setSpeedX(0);
            setSpeedY(getSpeed());

        }
        //Sang phai
        if ( Parameter.Map[(int) ((getPosY() - Parameter.saiso ) / Parameter.size + 1)][(int) (getPosX() - Parameter.saiso + speedX) / Parameter.size + 1] == -20
                || Parameter.Map[(int) ((getPosY() - Parameter.saiso ) / Parameter.size + 1)][(int) (getPosX() - Parameter.saiso + speedX) / Parameter.size + 1] == -19) {

            setSpeedX(0);
            setSpeedY(-getSpeed());

        }
        //Len tren
        if ( Parameter.Map[(int) (getPosY() + Parameter.saiso  + speedY) / Parameter.size][(int) (getPosX() - Parameter.saiso) / Parameter.size + 1] == -20
                || Parameter.Map[(int) (getPosY() + Parameter.saiso  + speedY) / Parameter.size][(int) (getPosX() - Parameter.saiso) / Parameter.size + 1] == -19) {

            setSpeedY(0);
            setSpeedX(-getSpeed());

        }
        //Xuong duoi
        if ( Parameter.Map[(int) (getPosY() - Parameter.saiso  + speedY) / Parameter.size + 1][(int) (getPosX() - Parameter.saiso) / Parameter.size + 1] == -20
                || Parameter.Map[(int) (getPosY() - Parameter.saiso  + speedY) / Parameter.size + 1][(int) (getPosX() - Parameter.saiso) / Parameter.size + 1] == -19) {

            setSpeedY(getSpeed());
            setSpeedX(0);

        }

    }

}
