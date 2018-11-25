package crazyarcade;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    GamePanel GP;

    public GameFrame() {
        Toolkit toolkit = this.getToolkit();               //Lấy size của màn hình
        Dimension dimension = toolkit.getScreenSize();       //Lưu 1 cặp giá trị
        this.setBounds(0, 0, Parameter.SCREEN_WIDTH, Parameter.SCREEN_HEIGHT);  //Hiện cửa sổ

        GP = new GamePanel();
        add(GP);
        this.addKeyListener(GP);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setVisible(true);
        GP.setDoubleBuffered(true);

        Image image = toolkit.getImage("map/khung/mouse.png");
        Cursor c = toolkit.createCustomCursor(image, new Point(this.getX()+18,
                this.getY()), "img");
        this.setCursor(c);
    }

    public void StartGame() {
        GP.Start();
    }

}
