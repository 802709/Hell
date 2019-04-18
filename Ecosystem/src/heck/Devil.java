/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heck;

/**
 *
 * @author 802709
 */
public class Devil extends Entity implements Denizen{
        public Devil(){
        super();
    }
    
    public Devil(int x, int y) {
        super(x, y, "/images/devil.gif");
    } 
    @Override
    public void collectSoul() {
       soulCount += 1;  
    }

    @Override
    public void taintSoul() {
        Human.morality -= 50;
    }

    @Override
    public void fly() {
        vy+=1;
    }

    public void commandDemons(Demon demon){
        demon.setDx(vx);
        demon.setDy(vy);
    }
    public void commandIncubi(Incubus i){
        i.setDx(vx);
        i.setDy(vy);
    }
    
   public void moveToSoul(Soul soul, Devil d) {
       if(soul.getX() > d.getX()){
           d.setDx(-5);
    }
      if(soul.getX() < d.getX()){
           d.setDx(5);
    }  
    }
}
