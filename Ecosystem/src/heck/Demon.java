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
public class Demon extends Entity implements Denizen {
    
      public Demon(){
        super();
    }
    
    public Demon(int x, int y) {
        super(x, y, "/images/demon.gif");
    } 
    
    
    @Override
    public void collectSoul() {
      soulCount += 1;  
    }

    @Override
    public void taintSoul() {
      Human.morality -=20;  
    }

    @Override
    public void fly() {
        vy +=1;
    }

    public void moveToSoul(Soul soul, Demon demon) {
       if(soul.getX() > demon.getX()){
           demon.setDx(-5);
    }
      if(soul.getX() < demon.getX()){
           demon.setDx(5);
    }  
    }
}
