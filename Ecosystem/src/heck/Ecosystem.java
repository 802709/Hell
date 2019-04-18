/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heck;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author 802709
 */
public class Ecosystem extends JPanel {

    private Timer timer;
    private Devil satan;
    
 public ArrayList<Demon> demons;
 public ArrayList<Incubus> incubi;
 private ArrayList<Human> humans;
 //private ArrayList<Angel> angels;
 //private ArrayList<Fire> fires;
 //private ArrayList<Brimstone> brims;
 private ArrayList<Soul> souls;

   //private int ticks;
   
    
    public Ecosystem() {
        super();
        setSize(1200, 960);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 3000, 1000/24);

        satan = new Devil();

   demons = new ArrayList<>();
   incubi = new ArrayList<>();
   //angels = new ArrayList<>();
   humans = new ArrayList<>();
  // fires = new ArrayList<>();
   //brims = new ArrayList<>();
   souls = new ArrayList<>();
   //ticks = 0;
}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Soul soul : souls) {
            if (soul != null) {
                soul.draw(g);
            }
        }
        satan.draw(g);
        
        for (Demon demon : demons) {
            demon.draw(g);
        }
//        for (Angel angel : angels) {
//            angel.draw(g);
//        }
           for (Incubus incubus : incubi) {
            incubus.draw(g);
        }
        for (Human human : humans) {
            human.draw(g);
        }
//        for (Fire fire : fires) {
//            fire.draw(g);
//        }
//        for (Brimstone brim : brims) {
//            brim.draw(g);
//        }
       
   this.setBackground(Color.BLACK);  
    }

    private void spawnSoul2() {
             souls.add(new Soul(500,500));
    }
    
    private class ScheduleTask extends TimerTask {
    
        @Override
        public void run() {
           //ticks++;
////while (ticks  == 100){
spawnDemons();
spawnIncubi();
///spawnAngels();
//spawnFire();
//spawnBrim();
spawnHumans();
///}

///while (ticks >=0) {
    
//One group versus itself
for (int i = 0; i < demons.size(); i++) {
for (int j = i + 1; j < demons.size(); j++) {
collisionDetection((Demon)demons.get(i), (Demon)demons.get(j));
}
}
for (int i = 0; i < humans.size(); i++) {
for (int j = i + 1; j < humans.size(); j++) {
collisionDetection((Human)humans.get(i), (Human)humans.get(j));
}
}
for (int i = 0; i < incubi.size(); i++) {
for (int j = i + 1; j < incubi.size(); j++) {
collisionDetection((Incubus)incubi.get(i), (Incubus)incubi.get(j));
}
}
//for (int i = 0; i < angels.size(); i++) {
//for (int j = i + 1; j < angels.size(); j++) {
//collisionDetection((Angel)angels.get(i), (Angel)angels.get(j));
//}
//}



for (Human human : humans){
    for (Demon demon : demons){
        collisionDetection(human, demon);
    }
}
for (Demon demon : demons){
    for (Human human : humans){
        collisionDetection(demon, human);
    }
}

//for (Angel angel : angels){
//    for (Demon demon : demons){
//        collisionDetection(angel, demon);
//    }
//}
//for (Demon demon : demons){
//    for (Angel angel : angels){
//        collisionDetection(demon,angel);
//    }
//}

for (Incubus incubus : incubi){
    for (Demon demon : demons){
        collisionDetection(incubus, demon);
    }
}
for (Demon demon : demons){
    for (Incubus incubus : incubi){
        collisionDetection(demon,incubus);
    }
}



//for (Incubus incubus : incubi){
//    for (Angel angel : angels){
//        collisionDetection(incubus,angel);
//    }
//}
//for (Angel angel : angels){
//    for (Incubus incubus : incubi){
//        collisionDetection(angel,incubus);
//    }
//}
for (Incubus incubus : incubi){
    for (Human human : humans){
        collisionDetection(incubus,human);
    }
}
for (Human human : humans){
    for (Incubus incubus : incubi){
        collisionDetection(human,incubus);
    }
}
//for (Angel angel : angels){
//    for (Human human : humans){
//        collisionDetection(angel,human);
//    }
//}
//for (Human human : humans){
//    for (Angel angel : angels){
//        collisionDetection(human,angel);
//    }
//}


///}

            satan.update();
            satan.update(satan);
          

            for (Demon demon : demons){
            demon.update();
            demon.update(demon);
            collisionDetection(satan, demon);
            wallCollisions(demon);
            //demon.allCollisions(demon);
                if (demon.health == 0){
                    demon.die();
                }
            for (Soul soul : souls){
                     // soul.soulDetection(soul, demon);
                      if (soul != null) {
                          soul.update();
                          soul.update(soul); 
                          wallCollisions(soul);
                demon.moveToSoul(soul, demon);
            }       
                }

            }
            for (Incubus incubus : incubi){
            incubus.update();
            incubus.update(incubus);
            wallCollisions(incubus);
            collisionDetection(satan, incubus);
             if (incubus.health == 0){
                    incubus.die();
                }
             for (Soul soul : souls){
                     // soul.soulDetection(soul, incubus);
                      if (soul != null) {
                incubus.moveToSoul(soul, incubus);
            }       
                }
            }
            
            
            for (Human human : humans){
            human.update();
            human.update(human);
            wallCollisions(human);
            collisionDetection(satan, human);
             if (human.health == 0){
                    human.die();
                    spawnSoul(human);
                }
            }
                  
            
//            for (Angel angel : angels){
//            angel.update();
//wallCollisions(angel);
//            collisionDetection(satan, angel);
//             if (angel.health == 0){
//                    angel.die();
//                }
//            }
                  
//            for (Fire fire : fires){
//            fire.update();
//            collisionDetection(satan, fire);
//            }
//            for (Brimstone brim : brims){
//            brim.update();
//            collisionDetection(satan, brim);
//            }
            for (Soul soul : souls){
                soul.update();
                //soul.soulDetection(soul, satan);
            }
            
            repaint();
        }

        private void spawnSoul(Human human) {
             souls.add(new Soul(human.getX(),human.getY()));
        }
       
        
        
private void spawnDemons() {
    for(int i = 0; i<1; i++){
demons.add(new Demon(25+50*i,100));
    }
}
private void spawnIncubi() {
     for(int i = 0; i<1; i++){
incubi.add(new Incubus(25+50*i,200));
    }
}

//private void spawnAngels() {
//     for(int i = 0; i<1; i++){
//angels.add(new Angel(25+50*i,300));
//    }
//}
private void spawnHumans() {
     for(int i = 0; i<2; i++){
humans.add(new Human(25+50*i,400));
    }
}
//private void spawnFire() {
//    for(int i = 0; i<1; i++){
//fires.add(new Fire(25+50*i,400));
//    }
//}
//private void spawnBrim() {
//     for(int i = 0; i<1; i++){
//brims.add(new Brimstone(25+50*i,400));
//    }
//}
 
    }

       
         
    public void keyPressed(KeyEvent e) {
    int SPEED = 5;
    for(Human h: humans)
if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
   // satan.setDx(SPEED);
    h.setDx(SPEED);
}
else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
     // satan.setDx(-SPEED);
      h.setDx(-SPEED);     
}
else if (e.getKeyCode() == KeyEvent.VK_UP) {
//satan.setDy(-SPEED);
 h.setDy(-SPEED);
}
else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//satan.setDy(SPEED);
h.setDy(SPEED);
}
    if (e.getKeyCode()==KeyEvent.VK_SPACE){
//souls.add(new Soul(satan.getX(),satan.getY()));
spawnSoul2();
}   

if (e.getKeyCode()==KeyEvent.VK_C || e.getKeyCode()==KeyEvent.VK_X){
    for (Demon demon : demons){
    satan.commandDemons(demon);
}
}
if (e.getKeyCode()==KeyEvent.VK_C || e.getKeyCode()==KeyEvent.VK_Z){
    for (Incubus incubus : incubi){
    satan.commandIncubi(incubus);
}
}

}

public void keyReleased(KeyEvent e) {
 for (Human h : humans){
if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    // satan.setDx(0);
   h.setDx(0);
if (e.getKeyCode() == KeyEvent.VK_LEFT)
//satan.setDx(0);
h.setDx(0);
if (e.getKeyCode() == KeyEvent.VK_UP)
//satan.setDy(0);
h.setDy(0);
if (e.getKeyCode() == KeyEvent.VK_DOWN){
   // satan.setDy(0);
    h.setDy(0);
}
 }

    } 

private void wallCollisions(Entity e) {
        //walls - this.getWidth(), this.getHeight(), 
        //where the hero is - hero.getX(), hero.getY()
        if (e.getX() <= 0 || e.getX() + 30 >= 1200){
            e.reverseX();
        }
}
private void collisionDetection(Entity c1, Entity c2) {
if (c1.getX() + c1.getSize() > c2.getX() 
&& c1.getX() < c2.getX() + c2.getSize()
&& c1.getY() + c1.getSize()> c2.getY()
&& c1.getY() < c2.getY() + c2.getSize()) {

//Characters bounce in oposite directions
int tempVx = c1.getDx();
int tempVy = c1.getDy();
c1.setDx(c2.getDx());
c1.setDy(c2.getDy());
c2.setDx(tempVx);
c2.setDy(tempVy);
c1.move();
c2.move(); 
///and take damage
c1.takeDamage();
c2.takeDamage();
}
}
}


