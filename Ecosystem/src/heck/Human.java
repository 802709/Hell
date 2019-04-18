/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heck;

import java.util.ArrayList;

/**
 *
 * @author 802709
 */
public class Human extends Entity {
    
    public Human(){
        super();
    }
    public Human (int x, int y) {
        super(x, y, "/images/human.gif");
    }   
    
    private static boolean hasSoul;
    static int morality;
    private static int power;
    public ArrayList<Demon> demons;
    public ArrayList<Incubus> incubi;
    
    public void summon(){
      if (morality >= 1)  {
          spawnDemons();
      }
      else if(morality <=20){
        spawnIncubi();
    }
    }
    
    public void soulPact(){
        
       soulCount -= 1;  
    }

    
    
    
    
    public static boolean isHasSoul() {
        return hasSoul;
    }

    public static void setHasSoul(boolean hasSoul) {
        Human.hasSoul = hasSoul;
    }

    public static int getMorality() {
        return morality;
    }

    public static void setMorality(int morality) {
        Human.morality = morality;
    }

    public static int getPower() {
        return power;
    }

    public static void setPower(int power) {
        Human.power = power;
    }
    
     private void spawnDemons() {
    for(int i = 0; i<1; i++){
    demons.add(new Demon(25+50*i,100));
    }
    }
     private void spawnIncubi() {
    for(int i = 0; i<1; i++){
    incubi.add(new Incubus(25+50*i,100));
    }
    }
    
    
}
