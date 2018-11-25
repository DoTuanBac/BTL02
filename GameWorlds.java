/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyarcade;

import java.awt.Graphics2D;

/**
 *
 * @author Do Tuan Bac
 */
public class GameWorlds {

    Audios audios;
    boolean first_time = true;
    map Map;
    Text au;

    public GameWorlds() {
        audios = new Audios();
        Map = new map();
        au = new Text("......Bấm play để nghe nhạc");

    }

    public void render(Graphics2D g2) {

        Map.drawK(g2);
        au.sound(g2);

    }

}
