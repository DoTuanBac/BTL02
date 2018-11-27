
package boom;

import java.awt.event.KeyEvent;


public class InputManager {
    public static void processKeyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                GamePanel.y-=5;

                break;
            case KeyEvent.VK_DOWN:
                GamePanel.y+=5;

                break;
            case KeyEvent.VK_LEFT:
              GamePanel.x-=5;

                break;
            case KeyEvent.VK_RIGHT:
             GamePanel.x+=5;

                break;
            case KeyEvent.VK_SPACE:
            System.out.println("You press Space");
                break;

        }
    }
        public static void processKeyReleased (int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                System.out.println("You Released Up");

                break;
            case KeyEvent.VK_DOWN:
                System.out.println("You Released Down");

                break;
            case KeyEvent.VK_LEFT:
              System.out.println("You Released Left");

                break;
            case KeyEvent.VK_RIGHT:
             System.out.println("You Released Right");

                break;
            case KeyEvent.VK_SPACE:
            System.out.println("You Released Space");
                break;

        }

    }

}
