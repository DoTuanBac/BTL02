/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyarcade;

import java.awt.event.KeyEvent;

/**
 *
 * @author Do Tuan Bac
 */
public class InputManager {
    boolean input1=false;
    boolean input2=false;
    boolean input3=false;
    boolean input4=false;
       boolean input5=false;
          boolean input6=false;
          int count=0;
    GamePanel gp;
    int s = 0;
    int i = 0;
    String name1, name2;
   
    public InputManager(GamePanel gp) {
        this.gp = gp;
    }

    public void processKeyPressed(int keyCode) {
        if (i >= 2) {
            switch (keyCode) {

                case KeyEvent.VK_UP:

                    gp.GW.ob.setSpeedY(-gp.GW.ob.getSpeed());
                    gp.GW.ob.vector = 1;
                    gp.GW.ob.setSpeedX(0);

                    break;
                case KeyEvent.VK_DOWN:
                    gp.GW.ob.setSpeedY(gp.GW.ob.getSpeed());
                    gp.GW.ob.vector = 2;
                    gp.GW.ob.setSpeedX(0);
                    break;
                case KeyEvent.VK_LEFT:
                    gp.GW.ob.setSpeedX(-gp.GW.ob.getSpeed());
                    gp.GW.ob.vector = 3;
                    gp.GW.ob.setSpeedY(0);
                    break;
                case KeyEvent.VK_RIGHT:
                    gp.GW.ob.setSpeedX(gp.GW.ob.getSpeed());
                    gp.GW.ob.vector = 4;
                    gp.GW.ob.setSpeedY(0);

                    break;

                case KeyEvent.VK_K:
                    gp.GW.ob.put = true;
                    break;

                case KeyEvent.VK_W:

                    gp.GW.ob2.setSpeedY(-gp.GW.ob2.getSpeed());
                    gp.GW.ob2.vector = 1;
                    gp.GW.ob2.setSpeedX(0);

                    break;
                case KeyEvent.VK_S:
                    gp.GW.ob2.setSpeedY(gp.GW.ob2.getSpeed());
                    gp.GW.ob2.vector = 2;
                    gp.GW.ob2.setSpeedX(0);
                    break;
                case KeyEvent.VK_A:
                    gp.GW.ob2.setSpeedX(-gp.GW.ob2.getSpeed());
                    gp.GW.ob2.vector = 3;
                    gp.GW.ob2.setSpeedY(0);
                    break;
                case KeyEvent.VK_D:
                    gp.GW.ob2.setSpeedX(gp.GW.ob2.getSpeed());
                    gp.GW.ob2.vector = 4;
                    gp.GW.ob2.setSpeedY(0);

                    break;
                case KeyEvent.VK_G:
                    gp.GW.ob2.put = true;
                    break;
            }

        }

    }

    public void processKeyReleased(int keyCode) {
        if (i >= 2) {
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    if (gp.GW.ob.getSpeedY() < 0) {
                        gp.GW.ob.setSpeedY(0);
                        gp.GW.ob.vector = 5;
                    }

                    break;
                case KeyEvent.VK_DOWN:
                    if (gp.GW.ob.getSpeedY() > 0) {
                        gp.GW.ob.setSpeedY(0);
                        gp.GW.ob.vector = 6;
                    }

                    break;
                case KeyEvent.VK_LEFT:
                    if (gp.GW.ob.getSpeedX() < 0) {
                        gp.GW.ob.setSpeedX(0);
                        gp.GW.ob.vector = 7;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (gp.GW.ob.getSpeedX() > 0) {
                        gp.GW.ob.setSpeedX(0);
                        gp.GW.ob.vector = 8;
                    }
                    break;
                case KeyEvent.VK_W:
                    if (gp.GW.ob2.getSpeedY() < 0) {
                        gp.GW.ob2.setSpeedY(0);
                        gp.GW.ob2.vector = 5;
                    }

                    break;
                case KeyEvent.VK_S:
                    if (gp.GW.ob2.getSpeedY() > 0) {
                        gp.GW.ob2.setSpeedY(0);
                        gp.GW.ob2.vector = 6;
                    }

                    break;
                case KeyEvent.VK_A:
                    if (gp.GW.ob2.getSpeedX() < 0) {
                        gp.GW.ob2.setSpeedX(0);
                        gp.GW.ob2.vector = 7;
                    }
                    break;
                case KeyEvent.VK_D:
                    if (gp.GW.ob2.getSpeedX() > 0) {
                        gp.GW.ob2.setSpeedX(0);
                        gp.GW.ob2.vector = 8;
                    }
                    break;

            }
        }
    }

    public void mouseReleased(java.awt.event.MouseEvent me) {
        if (me.getX() >= 160 && me.getX() <= 260 && me.getY() >= 1000 && me.getY() <= 1050) {
            if (i != 1) {
                i = 1;
                count=0;
                gp.GW = new GameWorld(i,null, null, null);
            }
        }

        if (me.getX() >= 50 && me.getX() <= 150 && me.getY() >= 1000 && me.getY() <= 1050) {
            System.exit(0);
        }
        if (me.getX() >= 380 && me.getX() <= 480 && me.getY() >= 1000 && me.getY() <= 1050) {

            if (i > 0 && gp.GW.bossing == true) {
                i--;
                gp.GW = new GameWorld(i,null, name1, name2);
            }
        }
        if (me.getX() >= 490 && me.getX() <= 590 && me.getY() >= 1000 && me.getY() <= 1050) {

            if (i < 4 && gp.GW.bossing == true) {
                i++;
                gp.GW = new GameWorld(i,null, name1, name2);
            }
        }
        if (me.getX() >= 270 && me.getX() <= 370 && me.getY() >= 1000 && me.getY() <= 1050) {
            if (i != 0) {
                i = 0;
                  count=0;
                gp.GW = new GameWorld(i,null, null, null);
            }
        }
        if (me.getX() >= 660 && me.getX() <= 710 && me.getY() >= 1000 && me.getY() <= 1050) {
            if (gp.GWs.Map.playing == true) {
                gp.GWs.audios.pause();
                gp.GWs.Map.playing = false;
                gp.GWs.au = new Text(gp.GWs.audios.name[s]);

            } else {
                if (gp.GWs.first_time == false) {
                    gp.GWs.audios.resume();
                    gp.GWs.au = new Text(gp.GWs.audios.name[s]);
                } else {

                    gp.GWs.audios.play(gp.GWs.audios.name[s]);
                    gp.GWs.first_time = false;
                    gp.GWs.au = new Text(gp.GWs.audios.name[s]);

                }
                gp.GWs.Map.playing = true;
                gp.GWs.au = new Text(gp.GWs.audios.name[s]);
            }

        }
        if (me.getX() >= 610 && me.getX() <= 650 && me.getY() >= 1000 && me.getY() <= 1050) {
            if (s > 0) {
                s--;
            }
            gp.GWs.audios.stop();

            gp.GWs.audios.play(gp.GWs.audios.name[s]);
            gp.GWs.Map.playing = true;
            gp.GWs.au = new Text(gp.GWs.audios.name[s]);
        }
        if (me.getX() >= 720 && me.getX() <= 770 && me.getY() >= 1000 && me.getY() <= 1050) {
            if (s < gp.GWs.audios.name.length - 1) {
                s++;
            }
            gp.GWs.audios.stop();

            gp.GWs.audios.play(gp.GWs.audios.name[s]);
            gp.GWs.Map.playing = true;
            gp.GWs.au = new Text(gp.GWs.audios.name[s]);
        }

        if (me.getX() >= 1200 && me.getX() <= 1300 && me.getY() >= 1000 && me.getY() <= 1050) {
            if (Parameter.sfx == false) {
                Parameter.sfx = true;
            } else {
                Parameter.sfx = false;
            }

        }
        if (gp.GW.man == 1) {
            if (gp.GW.Map.chonxong == true) {

                if (me.getX() >= 300 && me.getX() <= 790 && me.getY() >= 150 && me.getY() <= 450) {
                    Audio.getIstance().getAudio(Audio.MENU).play();
                   if(count==0) 
                   {
                       name1 = "Bé Bỏng";
                       count++;
                   }
                   else if(count==1) 
                   {
                       name2 = "Bé Bỏng";
                       count++;
                   }
                    if( count==2)
                    {
                        gp.GW = new GameWorld(i,null, name1, name2);
                        count=0;
                    }
                }
                if (me.getX() >= 850 && me.getX() <= 1340 && me.getY() >= 150 && me.getY() <= 450) {
                    Audio.getIstance().getAudio(Audio.MENU).play();
                   if(count==0) 
                   {
                       name1 = "Thịt Mỡ";
                       count++;
                   }
                   else if(count==1) 
                   {
                       name2 = "Thịt Mỡ";
                       count++;
                   }
                   if( count==2)
                    {
                        gp.GW = new GameWorld(i,null, name1, name2);
                        count=0;
                    }
                }
                if (me.getX() >= 300 && me.getX() <= 790 && me.getY() >= 550 && me.getY() <= 850) {
                    Audio.getIstance().getAudio(Audio.MENU).play();
                    if(count==0) 
                   {
                       name1 = "Mắt Xanh";
                       count++;
                   }
                    else  if(count==1) 
                   {
                       name2 = "Mắt Xanh";
                       count++;
                   }
                   
                    if( count==2)
                    {
                        gp.GW = new GameWorld(i,null, name1, name2);
                        count=0;
                    }
                }
                if (me.getX() >= 850 && me.getX() <= 1340 && me.getY() >= 550 && me.getY() <= 850) {
                    Audio.getIstance().getAudio(Audio.MENU).play();
                     if(count==0) 
                   {
                       name1 = "Khò Khò";
                       count++;
                   }
                     else if(count==1) 
                   {
                       name2 = "Khò Khò";
                      count++;
                   }
                    if( count==2)
                    {
                        gp.GW = new GameWorld(i,null, name1, name2);
                        count=0;
                    }
                }

            }

            if (gp.GW.Map.chonxong == false) {
                    
                if (me.getX() >= 250 && me.getX() <= 750 && me.getY() >= 400 && me.getY() <= 650) {
                    i = 2;
                    gp.GW.Map.chonxong = true;
                    Audio.getIstance().getAudio(Audio.MENU).play();

                }

                if (me.getX() >= 900 && me.getX() <= 1400 && me.getY() >= 400 && me.getY() <= 650) {
                    i = 5;
                    gp.GW.Map.chonxong = true;
                    Audio.getIstance().getAudio(Audio.MENU).play();
                }

            }

        }

    }

    public void mouseMoved(java.awt.event.MouseEvent me) {
         if (gp.GW.man == 1) {
            if (gp.GW.Map.chonxong == true) {
        if (me.getX() >= 300 && me.getX() <= 790 && me.getY() >= 150 && me.getY() <= 450) {

            gp.GW.Map.bbebong = true;
          if(input1==false){Audio.getIstance().getAudio(Audio.MENU3).play();
          input1=true;
          }
          
        } else {
            gp.GW.Map.bbebong = false;
            input1=false;
        }
        
        if (me.getX() >= 850 && me.getX() <= 1340 && me.getY() >= 150 && me.getY() <= 450) {

            gp.GW.Map.bthitmo = true;
              if(input2==false){Audio.getIstance().getAudio(Audio.MENU3).play();
          input2=true;
          }
          
        } else {
            gp.GW.Map.bthitmo = false;
            input2=false;
           
        }
        if (me.getX() >= 300 && me.getX() <= 790 && me.getY() >= 550 && me.getY() <= 850) {
            gp.GW.Map.bmatxanh = true;
              if(input4==false){Audio.getIstance().getAudio(Audio.MENU3).play();
          input4=true;
          }
          
        } else {
            gp.GW.Map.bmatxanh = false;
            input4=false;
             
        }
        if (me.getX() >= 850 && me.getX() <= 1340 && me.getY() >= 550 && me.getY() <= 850) {
            gp.GW.Map.bkhokho = true;
             if(input3==false){Audio.getIstance().getAudio(Audio.MENU3).play();
          input3=true;
          }
           
        } else {
            gp.GW.Map.bkhokho = false;
            input3=false;
              
        }
            }}

           if (gp.GW.man == 1) {
            if (gp.GW.Map.chonxong == false) {
        if (me.getX() >= 250 && me.getX() <= 750 && me.getY() >= 400 && me.getY() <= 650) {
            gp.GW.Map.sanboss = true;
             if(input5==false){Audio.getIstance().getAudio(Audio.MENU3).play();
                input5=true;

        }
        }else {
            gp.GW.Map.sanboss = false;
            input5=false;
            
        }
             
        if (me.getX() >= 900 && me.getX() <= 1400 && me.getY() >= 400 && me.getY() <= 650) {
            gp.GW.Map.solo = true;
             if(input6==false){Audio.getIstance().getAudio(Audio.MENU3).play();
                input6=true;
        }} else {
            gp.GW.Map.solo = false;
            input6=false;
        }
            }}
        
        
        
        
        
        if (me.getX() >= 160 && me.getX() <= 260 && me.getY() >= 1000 && me.getY() <= 1050) {
            gp.GWs.Map.play = true;
        } else {
            gp.GWs.Map.play = false;
        }

        

        if (me.getX() >= 50 && me.getX() <= 150 && me.getY() >= 1000 && me.getY() <= 1050) {
            gp.GWs.Map.exit = true;
        } else {
            gp.GWs.Map.exit = false;
        }

        if (me.getX() >= 380 && me.getX() <= 480 && me.getY() >= 1000 && me.getY() <= 1050) {
            gp.GWs.Map.left = true;
        } else {
            gp.GWs.Map.left = false;
        }
        if (me.getX() >= 490 && me.getX() <= 590 && me.getY() >= 1000 && me.getY() <= 1050) {
            gp.GWs.Map.right = true;
        } else {
            gp.GWs.Map.right = false;
        }
        if (me.getX() >= 270 && me.getX() <= 370 && me.getY() >= 1000 && me.getY() <= 1050) {
            gp.GWs.Map.home = true;
        } else {
            gp.GWs.Map.home = false;
        }

        if (me.getX() >= 610 && me.getX() <= 650 && me.getY() >= 1000 && me.getY() <= 1050) {
            gp.GWs.Map.back = true;
        } else {
            gp.GWs.Map.back = false;
        }
        if (me.getX() >= 720 && me.getX() <= 770 && me.getY() >= 1000 && me.getY() <= 1050) {
            gp.GWs.Map.next = true;
        } else {
            gp.GWs.Map.next = false;
        }
        if (gp.GWs.Map.playing == false) {
            if (me.getX() >= 660 && me.getX() <= 710 && me.getY() >= 1000 && me.getY() <= 1050) {
                gp.GWs.Map.play2 = true;
            } else {
                gp.GWs.Map.play2 = false;
            }
        } else {
            if (me.getX() >= 660 && me.getX() <= 710 && me.getY() >= 1000 && me.getY() <= 1050) {
                gp.GWs.Map.pause = true;
            } else {
                gp.GWs.Map.pause = false;
            }
        }
    }
}
