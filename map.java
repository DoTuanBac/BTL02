/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyarcade;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Do Tuan Bac
 */
public class map {

    private int titleSize;          //Độ lớn ô vuông dài và rộng bằng nhau

    boolean exit = false;
    boolean play = false;
    boolean playing = false;
    boolean left = false;
    boolean right = false;
    boolean home = false;
    boolean back = false;
    boolean next = false;
    boolean pause = false;
    boolean play2 = false;
    boolean sanboss = false;
    boolean solo = false;
    boolean bkhokho = false;
    boolean bthitmo = false;
    boolean bmatxanh = false;
    boolean bbebong = false;
    boolean chonxong = false;
    int n1 = 0;
    int n2 = 0;
    Image khung = null;
    Image khung2 = null;
    Image khungtime = null;
    Image map0 = null;
    Image map01 = null;
    Image map1 = null;
    Image map2 = null;
    Image map3 = null;
    Image map4 = null;

    BufferedImage than = null;
    BufferedImage dau = null;
    BufferedImage boss = null;
    BufferedImage bossdau = null;
    Image bom = null;
    Image nuoc = null;
    Image giay = null;
    BufferedImage brush = null;
    BufferedImage tree = null;
    BufferedImage tree2 = null;
    BufferedImage tree_k = null;
    BufferedImage tree_k2 = null;
    BufferedImage tree_t = null;
    BufferedImage tree_t2 = null;

    BufferedImage box1 = null;
    BufferedImage box11 = null;
    BufferedImage box2 = null;
    BufferedImage box22 = null;
    BufferedImage box3 = null;
    BufferedImage box33 = null;

    BufferedImage i_exit = null;
    BufferedImage i_play = null;
    BufferedImage im_exit = null;
    BufferedImage im_play = null;
    BufferedImage i_left = null;
    BufferedImage i_right = null;
    BufferedImage im_left = null;
    BufferedImage im_right = null;

    BufferedImage i_home = null;
    BufferedImage i_play2 = null;
    BufferedImage im_home = null;
    BufferedImage im_play2 = null;
    BufferedImage i_pause = null;
    BufferedImage i_next = null;
    BufferedImage im_pause = null;
    BufferedImage im_next = null;
    BufferedImage i_back = null;
    BufferedImage im_back = null;
    BufferedImage i_sfx = null;
    BufferedImage i_sfx2 = null;

    BufferedImage i_sanboss = null;
    BufferedImage i_solo = null;
    BufferedImage im_sanboss = null;
    BufferedImage im_solo = null;

    BufferedImage matxanh = null;
    BufferedImage bebong = null;
    BufferedImage thitmo = null;
    BufferedImage khokho = null;
    BufferedImage matxanh2 = null;
    BufferedImage bebong2 = null;
    BufferedImage thitmo2 = null;
    BufferedImage khokho2 = null;
    BufferedImage Acc_khung = null;

    BufferedImage bb = null;
    BufferedImage tm = null;
    BufferedImage kk = null;
    BufferedImage mx = null;

    BufferedImage i30 = null;
    BufferedImage i31 = null;
    BufferedImage i32 = null;
    BufferedImage i33 = null;

    public map() {

        this.titleSize = Parameter.size;
        try {
            khung = new ImageIcon("map/khung/khung.png").getImage();
            khung2 = new ImageIcon("map/khung/khung2.png").getImage();
            khungtime = new ImageIcon("map/khung/time.png").getImage();
            map0 = new ImageIcon("map/map/0.png").getImage();
            map01 = new ImageIcon("map/map/1.png").getImage();
            map1 = new ImageIcon("map/map/map.png").getImage();
            map2 = new ImageIcon("map/map/map2.png").getImage();
            map3 = new ImageIcon("map/map/map3.png").getImage();
            map4 = new ImageIcon("map/map/map4.png").getImage();
            bom = new ImageIcon("map/item/bom.gif").getImage();
            nuoc = new ImageIcon("map/item/nuoc.gif").getImage();
            giay = new ImageIcon("map/item/giay.gif").getImage();

            than = ImageIO.read(new File("map/everything/than.png"));
            dau = ImageIO.read(new File("map/everything/dau.png"));
            boss = ImageIO.read(new File("map/everything/boss.png"));
            bossdau = ImageIO.read(new File("map/everything/bossdau.png"));
            brush = ImageIO.read(new File("map/everything/brush.png"));
            tree = ImageIO.read(new File("map/everything/tree.png"));
            tree2 = ImageIO.read(new File("map/everything/tree2.png"));
            tree_k = ImageIO.read(new File("map/everything/tree_k.png"));
            tree_k2 = ImageIO.read(new File("map/everything/tree_k2.png"));
            tree_t = ImageIO.read(new File("map/everything/tree_t.png"));
            tree_t2 = ImageIO.read(new File("map/everything/tree_t2.png"));
            box1 = ImageIO.read(new File("map/everything/box1.png"));
            box11 = ImageIO.read(new File("map/everything/box11.png"));
            box2 = ImageIO.read(new File("map/everything/box2.png"));
            box22 = ImageIO.read(new File("map/everything/box22.png"));
            box3 = ImageIO.read(new File("map/everything/box3.png"));
            box33 = ImageIO.read(new File("map/everything/box33.png"));

            i_exit = ImageIO.read(new File("map/button/exit.png"));
            i_play = ImageIO.read(new File("map/button/play.png"));
            im_exit = ImageIO.read(new File("map/button/exit_move.png"));
            im_play = ImageIO.read(new File("map/button/play_move.png"));
            i_left = ImageIO.read(new File("map/button/left.png"));
            i_right = ImageIO.read(new File("map/button/right.png"));
            im_right = ImageIO.read(new File("map/button/right_move.png"));
            im_left = ImageIO.read(new File("map/button/left_move.png"));
            i_home = ImageIO.read(new File("map/button/home.png"));
            i_play2 = ImageIO.read(new File("map/button/play2.png"));
            im_home = ImageIO.read(new File("map/button/homemove.png"));
            im_play2 = ImageIO.read(new File("map/button/play2_move.png"));;
            i_pause = ImageIO.read(new File("map/button/pause.png"));;
            i_next = ImageIO.read(new File("map/button/next.png"));;
            im_pause = ImageIO.read(new File("map/button/pause_move.png"));;
            im_next = ImageIO.read(new File("map/button/next_move.png"));;
            i_back = ImageIO.read(new File("map/button/back.png"));;
            im_back = ImageIO.read(new File("map/button/back_move.png"));
            i_sfx = ImageIO.read(new File("map/button/sfx.png"));
            i_sfx2 = ImageIO.read(new File("map/button/sfx2.png"));

            i_sanboss = ImageIO.read(new File("map/button/sanboss.png"));
            i_solo = ImageIO.read(new File("map/button/solo.png"));
            im_sanboss = ImageIO.read(new File("map/button/sanboss_move.png"));
            im_solo = ImageIO.read(new File("map/button/solo_move.png"));

            matxanh = ImageIO.read(new File("map/Character/matxanh.png"));;
            bebong = ImageIO.read(new File("map/Character/bebong.png"));
            khokho = ImageIO.read(new File("map/Character/khokho.png"));
            thitmo = ImageIO.read(new File("map/Character/thitmo.png"));
            matxanh2 = ImageIO.read(new File("map/Character/matxanh2.png"));;
            thitmo2 = ImageIO.read(new File("map/Character/thitmo2.png"));
            khokho2 = ImageIO.read(new File("map/Character/khokho2.png"));
            bebong2 = ImageIO.read(new File("map/Character/bebong2.png"));

            Acc_khung = ImageIO.read(new File("map/Khung/point.png"));

            mx = ImageIO.read(new File("map/khung/matxanh.png"));;
            tm = ImageIO.read(new File("map/khung/thitmo.png"));
            kk = ImageIO.read(new File("map/khung/khokho.png"));
            bb = ImageIO.read(new File("map/khung/bebong.png"));

            i30 = ImageIO.read(new File("map/everything/30.png"));
            i31 = ImageIO.read(new File("map/everything/31.png"));;
            i32 = ImageIO.read(new File("map/everything/32.png"));
            i33 = ImageIO.read(new File("map/everything/33.png"));

        } catch (IOException ex) {
        }

    }

    public int getTitleSize() {
        return titleSize;
    }

    public void setTitleSize(int titleSize) {
        this.titleSize = titleSize;
    }

    public void drawK(Graphics2D g2) {
        g2.drawImage(khung, 0, 0, null);
        g2.drawImage(khung2, 600, 1000, null);

        if (play == false) {
            g2.drawImage(i_play, 160, 1000, null);
        } else {
            g2.drawImage(im_play, 160, 1000, null);
        }
        if (exit == false) {
            g2.drawImage(i_exit, 50, 1000, null);
        } else {
            g2.drawImage(im_exit, 50, 1000, null);
        }
        if (left == false) {
            g2.drawImage(i_left, 380, 1000, null);
        } else {
            g2.drawImage(im_left, 380, 1000, null);
        }

        if (home == false) {
            g2.drawImage(i_home, 270, 1000, null);
        } else {
            g2.drawImage(im_home, 270, 1000, null);
        }
        if (right == false) {
            g2.drawImage(i_right, 490, 1000, null);
        } else {
            g2.drawImage(im_right, 490, 1000, null);
        }

        if (back == false) {
            g2.drawImage(i_back, 610, 1000, null);
        } else {
            g2.drawImage(im_back, 610, 1000, null);
        }
        if (playing == false) {
            if (play2 == false) {
                g2.drawImage(i_play2, 660, 1000, null);
            } else {
                g2.drawImage(im_play2, 660, 1000, null);
            }
        } else {
            if (pause == false) {
                g2.drawImage(i_pause, 660, 1000, null);
            } else {
                g2.drawImage(im_pause, 660, 1000, null);
            }
        }
        if (next == false) {
            g2.drawImage(i_next, 720, 1000, null);
        } else {
            g2.drawImage(im_next, 720, 1000, null);
        }

        if (Parameter.sfx == true) {
            g2.drawImage(i_sfx2, 1210, 1000, null);
        } else {
            g2.drawImage(i_sfx, 1210, 1000, null);
        }

    }

    public void draw(int n, Graphics2D g2) {

        if (n == 0) {
            g2.drawImage(map0, 50, 50, null);
        }
        if(n<=0)
        {
              g2.drawImage(map01, 50, 50, null);
        }
        if (n == 1) {
            g2.drawImage(map01, 50, 50, null);

            if (chonxong == false) {
                if (sanboss == false) {
                    g2.drawImage(i_sanboss, 250, 400, null);
                } else {
                    g2.drawImage(im_sanboss, 250, 400, null);
                }
                if (solo == false) {
                    g2.drawImage(i_solo, 900, 400, null);
                } else {
                    g2.drawImage(im_solo, 900, 400, null);
                }
            } else {
                if (bbebong == false) {
                    g2.drawImage(bebong, 300, 150, null);
                } else {
                    g2.drawImage(bebong2, 300, 150, null);
                }

                if (bthitmo == false) {
                    g2.drawImage(thitmo, 850, 150, null);
                } else {
                    g2.drawImage(thitmo2, 850, 150, null);
                }

                if (bmatxanh == false) {
                    g2.drawImage(matxanh, 300, 550, null);
                } else {
                    g2.drawImage(matxanh2, 300, 550, null);
                }

                if (bkhokho == false) {
                    g2.drawImage(khokho, 850, 550, null);
                } else {
                    g2.drawImage(khokho2, 850, 550, null);
                }
            }

        }
        if (n >= 2 && n <= 4) {
            if (n1 == 1) {
                g2.drawImage(bb, 1643, 353, null);
            }
            if (n2 == 1) {
                g2.drawImage(bb, 1643, 253, null);
            }
            if (n1 == 2) {
                g2.drawImage(tm, 1643, 353, null);
            }
            if (n2 == 2) {
                g2.drawImage(tm, 1643, 253, null);
            }
            if (n1 == 3) {
                g2.drawImage(mx, 1643, 353, null);
            }
            if (n2 == 3) {
                g2.drawImage(mx, 1643, 253, null);
            }
            if (n1 == 4) {
                g2.drawImage(kk, 1643, 353, null);
            }
            if (n2 == 4) {
                g2.drawImage(kk, 1643, 253, null);
            }
            g2.drawImage(Acc_khung, 1640, 250, null);
            g2.drawImage(Acc_khung, 1640, 350, null);
            g2.drawImage(khungtime, 1680, 115, null);

            if (n == 2) {

                g2.drawImage(map1, 50, 50, null);

            }
            if (n == 3) {

                g2.drawImage(map2, 50, 50, null);
            }
            if (n == 4) {

                g2.drawImage(map3, 50, 50, null);
            }
        }
        if (n == 5) {

            g2.drawImage(khungtime, 1680, 115, null);
            g2.drawImage(map4, 50, 50, null);
        }

        for (int i = 0; i < Parameter.Map.length; i++) {
            for (int j = 0; j < Parameter.Map[0].length; j++) {

                if (Parameter.Map[i][j] == 0) {
                    continue;
                }
                if (Parameter.Map[i][j] == 2) {
                    g2.drawImage(than, j * 50, i * 50 - 30, null);
                }
                if (Parameter.Map[i][j] == 4) {
                    g2.drawImage(boss, j * 50 - 30, i * 50 - 30, null);
                }

                if (Parameter.Map[i][j] == 6) {
                    g2.drawImage(tree, j * 50 - 15, i * 50 - 88, null);
                }
                if (Parameter.Map[i][j] == 9) {
                    g2.drawImage(tree_k, j * 50 - 20, i * 50 - 70, null);
                }
                if (Parameter.Map[i][j] == 10) {
                    g2.drawImage(tree_t, j * 50 - 7, i * 50 - 40, null);
                }
                if (Parameter.Map[i][j] == 11) {
                    g2.drawImage(brush, j * 50, i * 50, null);
                }

                if (Parameter.Map[i][j] == -1) {
                    g2.drawImage(bom, j * 50, i * 50 - 10, null);
                }
                if (Parameter.Map[i][j] == -2) {
                    g2.drawImage(giay, j * 50, i * 50 - 10, null);
                }
                if (Parameter.Map[i][j] == -3) {
                    g2.drawImage(nuoc, j * 50, i * 50 - 10, null);
                }

                if (Parameter.Map[i][j] == 7) {
                    g2.drawImage(box2, j * 50, i * 50 - 8, null);
                }
                if (Parameter.Map[i][j] == 8) {
                    g2.drawImage(box3, j * 50, i * 50 - 8, null);
                }
                if (Parameter.Map[i][j] == 5) {
                    g2.drawImage(box1, j * 50, i * 50 - 8, null);
                }

                if (Parameter.Map[i][j] == 30) {
                    g2.drawImage(i30, j * 50, i * 50-25, null);
                }
                if (Parameter.Map[i][j] == 31) {
                    g2.drawImage(i31, j * 50, i * 50, null);
                }
                if (Parameter.Map[i][j] == 32) {
                    g2.drawImage(i32, j * 50, i * 50, null);
                }
                if (Parameter.Map[i][j] == 33) {
                    g2.drawImage(i33, j * 50, i * 50, null);
                }

            }

        }

    }

    public void draw2(Graphics2D g2) {

        for (int i = 0; i < Parameter.Map.length; i++) {
            for (int j = 0; j < Parameter.Map[0].length; j++) {
                if (Parameter.Map[i][j] == 0) {
                    continue;
                }

                if (Parameter.Map[i][j] == 2) {
                    g2.drawImage(dau, j * 50, i * 50 - 30, null);
                }
                if (Parameter.Map[i][j] == 4) {
                    g2.drawImage(bossdau, j * 50 - 30, i * 50 - 30, null);
                }
                if (Parameter.Map[i][j] == 6) {
                    g2.drawImage(tree2, j * 50 - 15, i * 50 - 88, null);
                }
                if (Parameter.Map[i][j] == 9) {
                    g2.drawImage(tree_k2, j * 50 - 20, i * 50 - 70, null);
                }
                if (Parameter.Map[i][j] == 10) {
                    g2.drawImage(tree_t2, j * 50 - 7, i * 50 - 40, null);
                }
                if (Parameter.Map[i][j] == 7) {
                    g2.drawImage(box22, j * 50, i * 50 - 8, null);
                }
                if (Parameter.Map[i][j] == 5) {
                    g2.drawImage(box11, j * 50, i * 50 - 8, null);
                }
                if (Parameter.Map[i][j] == 8) {
                    g2.drawImage(box33, j * 50, i * 50 - 8, null);
                }
            }

        }

    }

}
