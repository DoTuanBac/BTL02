
package boom;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class GameFrame extends JFrame  {
    
    GamePanel gamePanel = new GamePanel();;
    
    public GameFrame(){
        
        Toolkit toolkit = this.getToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(0, 0, dimension.width, dimension.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(gamePanel);
        gamePanel.startGame();
        addKeyListener(gamePanel);  
        
    }
 
    public static void main(String args[]){
        
        GameFrame gameFrame = new GameFrame();
        gameFrame.setVisible(true);    
       
    }
    
}
