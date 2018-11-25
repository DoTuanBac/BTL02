/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyarcade;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Do Tuan Bac
 */
public class Text {

    double time;
    double denta;
    double max;
    String name;

    public Text() {
    }
   
    
    Text(double max) {
        this.max = max;
        time = System.nanoTime();
    }
      Text(String name) {
        this.name = name;
    }

   
      

    public void time(Graphics g) {
        int fontSize = 35;
        g.setFont(new Font("Arial", Font.BOLD, fontSize));
           g.setColor(new java.awt.Color(255, 255, 255));

       
            denta = max - (System.nanoTime() - time) / 1000000000;
        
         if (denta >= 0) {
             int temp=(int)denta/60;
              String t2=null;
             int temp2=(int)denta%60;
             String t =Integer.toString(temp);      //Phut
              if(temp2>=10)
              t2 = Integer.toString(temp2);     //Giay
              else   t2 = "0"+Integer.toString(temp2);     //Giay

              g.drawString(t + ":"+t2, 1720, 165);
         }
         else
         {
               g.drawString("0.0s", 1720, 165);
         }
    }
      public void sound(Graphics g) 
      {
           String temp=null;
           int fontSize = 20;
          temp=name.substring(6);
        g.setFont(new Font("times new roman", Font.PLAIN, fontSize));
        g.setColor(new java.awt.Color(0,0,0));
     
           if(temp.length()<=40) g.drawString(temp, 780, 1030);
           else
           {
              
              g.drawString(temp.substring(0, 40)+"...", 780, 1030);
           }
       
      }
      public void point(double diem,Graphics g) {
        int fontSize = 35;

        String di = Double.toString(diem);
        g.setFont(new Font("Arial", Font.BOLD, fontSize));
        g.setColor(new java.awt.Color(255, 255, 255));
        g.drawString(di, 1720, 300);

    }
       public void point2(double diem,Graphics g) {
        int fontSize = 35;

        String di = Double.toString(diem);
        g.setFont(new Font("Arial", Font.BOLD, fontSize));
        g.setColor(new java.awt.Color(255, 255, 255));
        g.drawString(di, 1720, 400);

    }
       public void win(String di,Graphics g) {
        int fontSize = 100;
        g.setFont(new Font("Arial", Font.BOLD, fontSize));
        g.setColor(new java.awt.Color(255, 255, 255));
        g.drawString(di, 450, 300);

    }

}
