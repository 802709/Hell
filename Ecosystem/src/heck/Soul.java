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
public class Soul extends Entity{
     public Soul(){
        super();
    }
    public Soul (int x, int y) {
        super(x, y, "/images/soul.gif");
    }   
    
   
//   public void soulDetection(Soul soul, Entity obj2) {
//        if (soul.getBound().intersects(obj2.getBound())) {
//            soul.die();
//            obj2.soulCount += 1;
//        }
//    }
}
