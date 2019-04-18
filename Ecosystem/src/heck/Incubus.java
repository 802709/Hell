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
public class Incubus extends Entity implements Denizen {
      public Incubus(){
        super();
    }
    
    public Incubus(int x, int y) {
        super(x, y, "/images/inc.png");
    } 

    @Override
    public void collectSoul() {
      soulCount += 1;    
    }

    @Override
    public void taintSoul() {
      Human.morality -= 40;
    }

    @Override
    public void fly() {
       vy+=1;
    }

    public void moveToSoul(Soul soul, Incubus i) {
       if(soul.getX() > i.getX()){
           i.setDx(-5);
    }
      if(soul.getX() < i.getX()){
           i.setDx(5);
    }  
    }
}
