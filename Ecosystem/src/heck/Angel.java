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
public class Angel extends Entity {
    public Angel(){
        super();
    }
    
    public Angel(int x, int y) {
        super(x, y, "/images/ghost.gif");
    }  
    // @Override
    public void heal(Entity e) {
       e.health += 30; 
    }

    //@Override
    public void saveSoul() {
      Human.morality +=30;  
    }
}
