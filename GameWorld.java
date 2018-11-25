/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyarcade;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Do Tuan Bac
 */
public class GameWorld {

    NhanVat ob;
    NhanVat ob2;

    ArrayList<QuaiVat> qv;

    Text time;
    map Map;
    int man;

    ReadFile rf;
    int count_nqv;
    int count_nv;
    boolean bossing = false;
    boolean soloing = false;
    double diem1, diem2;
    Text di1, di2;
    Text w;
    String win;
 
    public GameWorld(int man,String win, String name1, String name2) {
        
      this.win=win;
      w = new Text();
        di1 = new Text();
        di2 = new Text();
        diem1 = 0;
        diem2 = 0;
        String name3 = "cbn";
        String name4 = "cbl";
        count_nv = 2;
        for (int i = 0; i < Parameter.boom.length; i++) {
            for (int j = 0; j < Parameter.boom[0].length; j++) {
                Parameter.boom[i][j] = new Boom();
            }
        }

        this.man = man;
        rf = new ReadFile();
        Map = new map();

        if (this.man <= 1) {

            Parameter.Map = rf.map("txt/gioithieu.txt");
            count_nqv = 1;

        }

        if (this.man == 2) {
            bossing = true;
            time = new Text(180);

            ob = new NhanVat(1, name1, 500, 850, 0.5, 2, 2, 8, 1, 9, this);

            ob2 = new NhanVat(2, name2, 1020, 700, 0.5, 2, 2, 8, 1, 9, this);

            Parameter.Map = rf.map("txt/map1.txt");

            qv = new ArrayList<QuaiVat>();
            qv.add(new QuaiVat(name3, 100, 850, 1.5));
            qv.add(new QuaiVat(name3, 700, 850, 0.2));
            qv.add(new QuaiVat(name3, 1200, 50, 0.5));
            qv.add(new QuaiVat(name3, 1100, 50, 0.6));
            qv.add(new QuaiVat(name3, 50, 50, 0.7));
            qv.add(new QuaiVat(name3, 150, 200, 0.7));
            qv.add(new QuaiVat(name3, 50, 500, 0.6));
            qv.add(new QuaiVat(name3, 200, 650, 0.5));
            qv.add(new QuaiVat(name3, 200, 400, 0.4));
            qv.add(new QuaiVat(name3, 400, 400, 0.3));
            qv.add(new QuaiVat(name3, 400, 500, 0.2));
            qv.add(new QuaiVat(name3, 700, 400, 0.1));
            count_nqv = qv.size();

        }
        if (this.man == 3) {
            bossing = true;
            time = new Text(180);

            ob = new NhanVat(1, name1, 500, 800, 0.5, 2, 2, 8, 1, 9, this);

            ob2 = new NhanVat(2, name2, 1020, 800, 0.5, 2, 2, 8, 1, 9, this);

            Parameter.Map = rf.map("txt/map2.txt");
            qv = new ArrayList<QuaiVat>();
            qv.add(new QuaiVat(name3, 100, 850, 1.5));
            qv.add(new QuaiVat(name3, 50, 50, 0.5));
            qv.add(new QuaiVat(name3, 1450, 50, 1.5));
            qv.add(new QuaiVat(name3, 1450, 850, 0.5));
            qv.add(new QuaiVat(name4, 550, 650, 1.5));
            qv.add(new QuaiVat(name4, 550, 650, 0.25));
            qv.add(new QuaiVat(name4, 550, 650, 0.5));
            qv.add(new QuaiVat(name4, 550, 650, 1.25));
            qv.add(new QuaiVat(name4, 650, 550, 1.5));
            qv.add(new QuaiVat(name4, 650, 550, 0.5));
            qv.add(new QuaiVat(name4, 650, 550, 0.75));
            qv.add(new QuaiVat(name4, 650, 550, 1));
            qv.add(new QuaiVat(name3, 100, 250, 1.5));
            qv.add(new QuaiVat(name3, 100, 250, 0.5));
            qv.add(new QuaiVat(name3, 100, 250, 0.25));
            qv.add(new QuaiVat(name3, 100, 250, 1.25));
            qv.add(new QuaiVat(name3, 1450, 250, 1.5));
            qv.add(new QuaiVat(name3, 1500, 250, 0.5));
            qv.add(new QuaiVat(name3, 1500, 250, 0.25));
            qv.add(new QuaiVat(name3, 1500, 250, 1.25));

            count_nqv = qv.size();

        }
        if (this.man == 4) {
            bossing = true;
            time = new Text(180);

            ob = new NhanVat(1, name1, 500, 500, 0.5, 2, 2, 8, 1, 9, this);

            ob2 = new NhanVat(2, name2, 1020, 500, 0.5, 2, 2, 8, 1, 9, this);

            Parameter.Map = rf.map("txt/map3.txt");
            qv = new ArrayList<QuaiVat>();
            qv.add(new QuaiVat(name4, 100, 900, 0.5));
            qv.add(new QuaiVat(name4, 300, 900, 0.75));
            qv.add(new QuaiVat(name4, 600, 900, 2));
            qv.add(new QuaiVat(name4, 900, 900, 1.5));
            qv.add(new QuaiVat(name4, 900, 900, 2.5));
            qv.add(new QuaiVat(name4, 900, 900, 2.25));

            qv.add(new QuaiVat(name4, 150, 800, 0.5));
            qv.add(new QuaiVat(name4, 300, 800, 1.5));
            qv.add(new QuaiVat(name4, 450, 800, 0.75));
            qv.add(new QuaiVat(name3, 600, 800, 1.75));

            qv.add(new QuaiVat(name4, 250, 700, 0.5));
            qv.add(new QuaiVat(name4, 350, 700, 0.75));
            qv.add(new QuaiVat(name3, 450, 700, 1.25));
            qv.add(new QuaiVat(name3, 550, 700, 1.5));

            qv.add(new QuaiVat(name4, 350, 600, 0.5));
            qv.add(new QuaiVat(name3, 450, 600, 1.5));
            qv.add(new QuaiVat(name3, 550, 600, 1.25));
            qv.add(new QuaiVat(name3, 650, 600, 0.75));
            count_nqv = qv.size();

        }
        if (this.man == 5) {
            time = new Text(180);

            ob = new NhanVat(1, name1, 200, 150, 0.5, 2, 2, 8, 1, 9, this);

            ob2 = new NhanVat(2, name2, 1400, 800, 0.5, 2, 2, 8, 1, 9, this);

            Parameter.Map = rf.map("txt/map4.txt");
            count_nqv = 1;

        }
        if (name1 == "Bé Bỏng") {
            Map.n1 = 1;
        }
        if (name2 == "Bé Bỏng") {
            Map.n2 = 1;
        }
        if (name1 == "Thịt Mỡ") {
            Map.n1 = 2;
        }
        if (name2 == "Thịt Mỡ") {
            Map.n2 = 2;
        }
        if (name1 == "Mắt Xanh") {
            Map.n1 = 3;
        }
        if (name2 == "Mắt Xanh") {
            Map.n2 = 3;
        }
        if (name1 == "Khò Khò") {
            Map.n1 = 4;
        }
        if (name2 == "Khò Khò") {
            Map.n2 = 4;
        }

    }

    public void update() {

        if (man > 1 && man < 5) {
            if (ob != null) {
                ob.update();
            }
            if (ob2 != null) {
                ob2.update();
            }
            for (int i = 0; i < qv.size(); i++) {
                qv.get(i).update();
            }

        }

        if (man == 5) {
            if (ob != null) {
                ob.update();
            }
            if (ob2 != null) {
                ob2.update();
            }
        }

    }

    public void render(Graphics2D g2) {

        if (man > 1 && man <= 5) {

            Map.draw(man, g2);
            for (int i = 0; i < Parameter.boom.length; i++) {
                for (int j = 0; j < Parameter.boom[0].length; j++) {

                    Parameter.boom[i][j].draw(g2);

                }
            }
            if (ob != null) {
                ob.draw(g2);
            }
            if (ob2 != null) {
                ob2.draw(g2);
            }
            if (man != 5) {
                for (int i = 0; i < qv.size(); i++) {
                    qv.get(i).render(g2);

                }
                di1.point2(diem1, g2);
                di2.point(diem2, g2);
            }

            Map.draw2(g2);
            for (int i = 0; i < Parameter.boom.length; i++) {
                for (int j = 0; j < Parameter.boom[0].length; j++) {

                    Parameter.boom[i][j].draw2(g2);

                }
            }

            time.time(g2);

        }

        if (man <= 1) {
            Map.draw(man, g2);
            
            if (man == -1) {
                w.win(win, g2);
            }
        }

    }

}
