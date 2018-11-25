/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyarcade;

import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Do Tuan Bac
 */
public class Boom {

    int id;
    Audios au;
    Image no = null;
    private int x, y;
    private int size_bom;
    private int max_size_bom;
    private int n_bom;
    private int max_bom;
    private int random;
    private Random rd;
    GameWorld gw;
    boolean destroyW = true;
    boolean destroyS = true;
    boolean destroyA = true;
    boolean destroyD = true;
    boolean sno = false;

    public boolean isPut() {
        return put;
    }

    public void setPut(boolean put) {
        this.put = put;
    }

    private int tx, ty;
    long time = 0, denta = 0, timeNo = 0, dentaNo = 0;
    private Thread thread;
    boolean dadat = false;
    boolean dano = false;
    boolean noxong = false;

    private BufferedImage image1 = null;
    private BufferedImage image2 = null;
    private BufferedImage image3 = null;
    private BufferedImage image4 = null;
    private BufferedImage image5 = null;
    private BufferedImage image12 = null;
    private BufferedImage image34 = null;
    private boolean put = false;

    Image image = null;

    public Boom() {

    }

    public void draw(Graphics2D g2) {

        if (put == true) {

            put = false;
            if (dadat == false) {

                tx = x;
                ty = y;
                dadat = true;
                time = System.nanoTime() / 1000000;

            }
        }

        if (dano == false) {
            denta = System.nanoTime() / 1000000 - time;
        }
        if (dadat == true) {

            g2.drawImage(image, tx * Parameter.size, ty * Parameter.size, null);
        }

        if (denta >= 3000 && dadat == true) {
            dano = true;
            denta = 3000;
            noxong = true;
            sno = true;
        }
        if (sno == true) {
            if (Parameter.sfx == true) {

                Audio.getIstance().getAudio(Audio.MENU1).play();

            }
            sno = false;
        }

        if (dano == true) {

            timeNo = System.nanoTime() / 1000000;
            dadat = false;
            dano = false;
            noxong = true;

        }
        dentaNo = System.nanoTime() / 1000000 - timeNo;

        if (noxong == true) {

            if (dentaNo > 0 && dentaNo < 250) {
                //Vẽ những thứ ở dưới nhân vật và map

                for (int i = 1; i <= size_bom; i++) {       //nổ xuống dưới
                    if (gw.man != 5) {
                        for (int a = 0; a < gw.qv.size(); a++) {
                            if (ty + i == gw.qv.get(a).Y() && tx == gw.qv.get(a).X()) {

                                if (gw.qv.get(a).life == true) {
                                    gw.qv.get(a).life = false;
                                    gw.count_nqv--;
                                    if (id == 1) {
                                        gw.diem1 += 100;
                                    }
                                    if (id == 2) {
                                        gw.diem2 += 100;
                                    }
                                }

                            }
                        }
                    }
                    if (ty + i == gw.ob.Y() && tx == gw.ob.X()) {

                        if (gw.ob.life == true) {
                            gw.ob.life = false;
                            gw.count_nv--;
                        }

                    }
                    if (ty + i == gw.ob2.Y() && tx == gw.ob2.X()) {

                        if (gw.ob2.life == true) {
                            gw.ob2.life = false;
                            gw.count_nv--;
                        }

                    }

                    if (Parameter.Map[ty + i][tx] == -20 || Parameter.Map[ty + i][tx] == -19) {     //ty tx là vị trí quả bom trong mảng
                        {
                            if (Parameter.boom[ty + i][tx].dadat == true) {

                                Parameter.boom[ty + i][tx].dano = true;
                                destroyS = false;
                                Parameter.boom[ty + i][tx].destroyS = true;
                                Parameter.boom[ty + i][tx].destroyW = false;
                                break;

                            }

                        }
                    } else if (Parameter.Map[ty + i][tx] <= 0 && i != size_bom) {

                        g2.drawImage(image12, tx * Parameter.size, (ty + i) * Parameter.size, null);        //Xuống dưới

                    } else if (Parameter.Map[ty + i][tx] <= 0) {
                        g2.drawImage(image2, tx * Parameter.size, (ty + i) * Parameter.size, null);

                    } else if (Parameter.Map[ty + i][tx] > 0) {

                        g2.drawImage(image2, tx * Parameter.size, (ty + i - 1) * Parameter.size, null);

                        break;
                    }
                }

                for (int i = 1; i <= size_bom; i++) {

                    if (gw.man != 5) {
                        
                        for (int a = 0; a < gw.qv.size(); a++) {
                            if (ty - i == gw.qv.get(a).Y() && tx == gw.qv.get(a).X()) {

                                if (gw.qv.get(a).life == true) {
                                    gw.qv.get(a).life = false;
                                    gw.count_nqv--;
                                    if (id == 1) {
                                        gw.diem1 += 100;
                                    }
                                    if (id == 2) {
                                        gw.diem2 += 100;
                                    }
                                }
                            }
                        }
                    }
                    if (ty - i == gw.ob.Y() && tx == gw.ob.X()) {

                        if (gw.ob.life == true) {
                            gw.ob.life = false;
                            gw.count_nv--;
                        }

                    }
                    if (ty - i == gw.ob2.Y() && tx == gw.ob2.X()) {

                        if (gw.ob2.life == true) {
                            gw.ob2.life = false;
                            gw.count_nv--;
                        }

                    }

                    if (Parameter.Map[ty - i][tx] == -20 || Parameter.Map[ty - i][tx] == -19) {
                        if (Parameter.boom[ty - i][tx].dadat == true) {
                            Parameter.boom[ty - i][tx].dano = true;
                            destroyW = false;
                            Parameter.boom[ty - i][tx].destroyW = true;
                            Parameter.boom[ty - i][tx].destroyS = false;
                            break;

                        }

                    }
                    if (Parameter.Map[ty - i][tx] <= 0 && i != size_bom) {
                        g2.drawImage(image12, tx * Parameter.size, (ty - i) * Parameter.size, null);

                    } else if (Parameter.Map[ty - i][tx] <= 0) {
                        g2.drawImage(image3, tx * Parameter.size, (ty - i) * Parameter.size, null);

                    } else if (Parameter.Map[ty - i][tx] > 0) {
                        g2.drawImage(image3, tx * Parameter.size, (ty - i + 1) * Parameter.size, null);

                        break;
                    }
                }

                for (int i = 1; i <= size_bom; i++) {
                    if (gw.man != 5) {
                        for (int a = 0; a < gw.qv.size(); a++) {
                            if (ty == gw.qv.get(a).Y() && tx + i == gw.qv.get(a).X()) {

                                if (gw.qv.get(a).life == true) {
                                    gw.qv.get(a).life = false;
                                    gw.count_nqv--;
                                    if (id == 1) {
                                        gw.diem1 += 100;
                                    }
                                    if (id == 2) {
                                        gw.diem2 += 100;
                                    }
                                }

                            }
                        }

                    }
                    if (ty == gw.ob.Y() && tx + i == gw.ob.X()) {

                        if (gw.ob.life == true) {
                            gw.ob.life = false;
                            gw.count_nv--;
                        }

                    }
                    if (ty == gw.ob2.Y() && tx + i == gw.ob2.X()) {

                        if (gw.ob2.life == true) {
                            gw.ob2.life = false;
                            gw.count_nv--;
                        }

                    }

                    if (Parameter.Map[ty][tx + i] == -20 || Parameter.Map[ty][tx + i] == -19) {
                        if (Parameter.boom[ty][tx + i].dadat == true) {
                            Parameter.boom[ty][tx + i].dano = true;
                            destroyD = false;
                            Parameter.boom[ty][tx + i].destroyD = true;
                            Parameter.boom[ty][tx + i].destroyA = false;
                            break;
                        }
                    }

                    if (Parameter.Map[ty][tx + i] <= 0 && i != size_bom) {
                        g2.drawImage(image34, (tx + i) * Parameter.size, ty * Parameter.size, null);

                    } else if (Parameter.Map[ty][tx + i] <= 0) {
                        g2.drawImage(image5, (tx + i) * Parameter.size, ty * Parameter.size, null);

                    } else if (Parameter.Map[ty][tx + i] > 0) {
                        g2.drawImage(image5, (tx + i - 1) * Parameter.size, ty * Parameter.size, null);

                        break;
                    }
                }

                for (int i = 1; i <= size_bom; i++) {
                    if (gw.man != 5) {
                        for (int a = 0; a < gw.qv.size(); a++) {
                            if (ty == gw.qv.get(a).Y() && tx - i == gw.qv.get(a).X()) {

                                if (gw.qv.get(a).life == true) {
                                    gw.qv.get(a).life = false;
                                    gw.count_nqv--;
                                    if (id == 1) {
                                        gw.diem1 += 100;
                                    }
                                    if (id == 2) {
                                        gw.diem2 += 100;
                                    }
                                }

                            }
                        }
                    }
                    if (ty == gw.ob.Y() && tx - i == gw.ob.X()) {

                        if (gw.ob.life == true) {
                            gw.ob.life = false;
                            gw.count_nv--;
                        }

                    }
                    if (ty == gw.ob2.Y() && tx - i == gw.ob2.X()) {

                        if (gw.ob2.life == true) {
                            gw.ob2.life = false;
                            gw.count_nv--;
                        }

                    }

                    if (Parameter.Map[ty][tx - i] == -20 || Parameter.Map[ty][tx - i] == -19) {
                        if (Parameter.boom[ty][tx - i].dadat == true) {
                            Parameter.boom[ty][tx - i].dano = true;
                            destroyA = false;
                            Parameter.boom[ty][tx - i].destroyA = true;
                            Parameter.boom[ty][tx - i].destroyD = false;
                            break;

                        }
                    }
                    if (Parameter.Map[ty][tx - i] <= 0 && i != size_bom) {
                        g2.drawImage(image34, (tx - i) * Parameter.size, ty * Parameter.size, null);

                    } else if (Parameter.Map[ty][tx - i] <= 0) {
                        g2.drawImage(image4, (tx - i) * Parameter.size, ty * Parameter.size, null);

                    } else if (Parameter.Map[ty][tx - i] > 0) {
                        g2.drawImage(image4, (tx - i + 1) * Parameter.size, ty * Parameter.size, null);

                        break;
                    }
                }
                  if (gw.man != 5) {
                        for (int a = 0; a < gw.qv.size(); a++) {
                            if (ty == gw.qv.get(a).Y() && tx  == gw.qv.get(a).X()) {

                                if (gw.qv.get(a).life == true) {
                                    gw.qv.get(a).life = false;
                                    gw.count_nqv--;
                                    if (id == 1) {
                                        gw.diem1 += 100;
                                    }
                                    if (id == 2) {
                                        gw.diem2 += 100;
                                    }
                                }

                            }
                        }
                    }
                    if (ty == gw.ob.Y() && tx == gw.ob.X()) {

                        if (gw.ob.life == true) {
                            gw.ob.life = false;
                            gw.count_nv--;
                        }

                    }
                    if (ty == gw.ob2.Y() && tx  == gw.ob2.X()) {

                        if (gw.ob2.life == true) {
                            gw.ob2.life = false;
                            gw.count_nv--;
                        }

                    }
                g2.drawImage(image1, tx * Parameter.size, ty * Parameter.size, null);

            }
            //Phá hủy hộp
            if (dentaNo >= 250) {
                
                if (id == 1) {
                    gw.ob.count_bom--;
                }
                if (id == 2) {
                    gw.ob2.count_bom--;
                }

                for (int i = 1; i <= size_bom; i++) {

                    if (ty + i < 20 && destroyS == true) {

                        if (Parameter.Map[ty + i][tx] <= 0) {

                            Parameter.Map[ty + i][tx] = 0;
                        } else if ((Parameter.Map[ty + i][tx] >= 7 && Parameter.Map[ty + i][tx] <= 8)||(Parameter.Map[ty + i][tx] >= 31 && Parameter.Map[ty + i][tx] <= 33)) {
                            random = -3 + rd.nextInt(4);
                            Parameter.Map[ty + i][tx] = random;
                            break;
                        }
                        if (Parameter.Map[ty + i][tx] > 0) {
                            break;
                        }
                    }

                }

                for (int i = 1; i <= size_bom; i++) {

                    if (ty - i >= 0 && destroyW == true) {

                        if (Parameter.Map[ty - i][tx] <= 0) {
                            Parameter.Map[ty - i][tx] = 0;
                        } else if ((Parameter.Map[ty - i][tx] >= 7 && Parameter.Map[ty - i][tx] <= 8)||(Parameter.Map[ty - i][tx] >= 31 && Parameter.Map[ty - i][tx] <= 33)) {
                            random = -3 + rd.nextInt(4);
                            Parameter.Map[ty - i][tx] = random;
                            break;
                        }
                        if (Parameter.Map[ty - i][tx] > 0) {
                            break;
                        }
                    }

                }

                for (int i = 1; i <= size_bom; i++) {

                    if (tx + i < 33 && destroyD == true) {

                        if (Parameter.Map[ty][tx + i] <= 0) {
                            Parameter.Map[ty][tx + i] = 0;
                        } else if ((Parameter.Map[ty][tx + i] >= 7 && Parameter.Map[ty][tx + i] <= 8)||(Parameter.Map[ty][tx + i] >= 31 && Parameter.Map[ty][tx + i] <= 33)) {
                            random = -3 + rd.nextInt(4);
                            Parameter.Map[ty][tx + i] = random;
                            break;
                        }
                        if (Parameter.Map[ty][tx + i] > 0) {
                            break;
                        }
                    }
                }

                for (int i = 1; i <= size_bom; i++) {

                    if (tx - i >= 0 && destroyA == true) {

                        if (Parameter.Map[ty][tx - i] <= 0) {
                            Parameter.Map[ty][tx - i] = 0;
                        } else if ((Parameter.Map[ty][tx - i] >= 7 && Parameter.Map[ty][tx - i] <= 8)||(Parameter.Map[ty][tx - i] >= 31 && Parameter.Map[ty][tx - i] <= 33)) {
                            random = -3 + rd.nextInt(4);
                            Parameter.Map[ty][tx - i] = random;
                            break;
                        }
                        if (Parameter.Map[ty][tx - i] > 0) {
                            break;
                        }
                    }
                }

                noxong = false;
                Parameter.Map[ty][tx] = 0;

            }
        }

    }

    public void draw2(Graphics2D g2) {
        //Những thứ vẽ trên nổ bom
         if (noxong == true) {
        if (dentaNo > 0 && dentaNo < 250) {

            for (int i = 1; i <= size_bom; i++) {       //nổ xuống dưới

                if (ty + i < 20 && destroyS == true) {

                    if ((Parameter.Map[ty + i][tx] >= 7 && Parameter.Map[ty + i][tx] <= 8)||(Parameter.Map[ty + i][tx] >= 31 && Parameter.Map[ty + i][tx] <= 33)) {
                        g2.drawImage(no, (tx) * Parameter.size, (ty + i) * Parameter.size, null);
                    }
                    if (Parameter.Map[ty + i][tx] > 0) {
                        break;
                    }
                }

            }

            for (int i = 1; i <= size_bom; i++) {

                if (ty - i >= 0 && destroyW == true) {

                    if ((Parameter.Map[ty - i][tx] >= 7 && Parameter.Map[ty - i][tx] <= 8)||(Parameter.Map[ty - i][tx] >= 31 && Parameter.Map[ty - i][tx] <= 33)) {
                        g2.drawImage(no, (tx) * Parameter.size, (ty - i) * Parameter.size, null);
                    }
                    if (Parameter.Map[ty - i][tx] > 0) {
                        break;
                    }
                }

            }

            for (int i = 1; i <= size_bom; i++) {

                if (tx + i < 33 && destroyD == true) {

                    if ((Parameter.Map[ty][tx + i] >= 7 && Parameter.Map[ty][tx + i] <= 8)||(Parameter.Map[ty][tx + i] >= 31 && Parameter.Map[ty][tx + i] <= 33)) {
                        g2.drawImage(no, (tx + i) * Parameter.size, (ty) * Parameter.size, null);
                    }
                    if (Parameter.Map[ty][tx + i] > 0) {
                        break;
                    }
                }

            }

            for (int i = 1; i <= size_bom; i++) {

                if (tx - i >= 0 && destroyA == true) {

                    if ((Parameter.Map[ty][tx - i] >= 7 && Parameter.Map[ty][tx - i] <= 8)||(Parameter.Map[ty][tx - i] >= 31 && Parameter.Map[ty][tx - i] <= 33)) {
                        g2.drawImage(no, (tx - i) * Parameter.size, (ty) * Parameter.size, null);
                    }
                    if (Parameter.Map[ty][tx - i] > 0) {
                        break;
                    }
                }

            }

        }
    }
    }

    public Boom(int x, int y, int size_bom, int n_bom, int max_size_bom, int max_bom, GameWorld gw, int id) {
        au = new Audios();
        image = new ImageIcon("character/Bong/bong.gif").getImage();
        no = new ImageIcon("character/Bong/no.gif").getImage();
        rd = new Random();
        try {

            image1 = ImageIO.read(new File("character/Bong/tam.png"));
            image2 = ImageIO.read(new File("character/Bong/no1.png"));
            image3 = ImageIO.read(new File("character/Bong/no2.png"));
            image4 = ImageIO.read(new File("character/Bong/no3.png"));
            image5 = ImageIO.read(new File("character/Bong/no4.png"));

            image12 = ImageIO.read(new File("character/Bong/no12.png"));
            image34 = ImageIO.read(new File("character/Bong/no34.png"));

        } catch (IOException ex) {
            Logger.getLogger(Boom.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.id = id;
        this.x = x;
        this.y = y;
        this.x = x;
        this.size_bom = size_bom;
        this.max_size_bom = max_size_bom;
        this.n_bom = n_bom;
        this.max_bom = max_bom;
        this.gw = gw;
    }

}
