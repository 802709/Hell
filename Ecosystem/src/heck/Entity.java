/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heck;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author 802709
 */
public abstract class Entity {
    
    //Fields
    private static int size;
    static int x;
    static int y;
    static int vx;
    static  int vy;
    static boolean isDead;
    private static  ImageIcon ii;
    private static Image img;
    int health;
    int soulCount;
    private ArrayList<Entity> entities;
    private Rectangle bound;

    

    public Entity() {
        x = 100;
        y = 100;
        vx = 3;
        vy = 3;
        size = 50;
        health = 100;
        isDead = false;
    }
    
    //Constructor
    public Entity(int x, int y,String imgSrc) {
        this.x = x;
        this.y = y;
        this.vx = 3;
        this.vy = 3;
        this.size = 50;
        this.health = 100;
        this.isDead = false;
        this.ii = new ImageIcon(getClass().getResource(imgSrc));
        this.img = ii.getImage();
    }

     public void draw(Graphics g){
         g.drawImage(img, x, y, size, size, null);
    }
    
  
    
    public void update() {
        move();
        gravity();
        bound = new Rectangle(this.x, this.y, this.size, this.size);
        if(health == 0){
            die();
        }
    }
    public void update(Entity e){
        bound = new Rectangle(this.x, this.y, this.size, this.size);
        e.getBound();
    }
    
    public void allCollisions(Entity e){
        collide(e);
        collisionDetection(e,e);
        wallCollisions(e);
    }
      
    public Rectangle getBound() {
        return bound;
    }
    
    public void move() {
        x += vx;
        y += vy;
    }
     public void gravity(){
       vy += 2;
    }
    
    public void die(){
          x = -3000;
        y = -3000;
        vx = 0;
        vy = 0;
        health = 0;
        isDead = true;
    }
    
    public void takeDamage(){
        health -= 10;
    }
    
    public void affectMorality(){
        Human.morality += 10;
    }
    
    public void attack(Entity e){
        e.health -=20;
    }
    
    public void collide(Entity e){
           if (e.getX() == e.getX()){
               e.reverseX();
           }
    }

    
   
    
    
    
    
     public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
 
    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return vx;
    }

    public void setDx(int vx) {
        this.vx = vx;
    }

    public int getDy() {
        return vy;
    }

    public void setDy(int vy) {
        this.vy = vy;
    }
    
    
    public void move(int vx, int vy){
        x += vx * 5;
           
    }
    public void reverseX(){
        
        vx = - vx;
        move(2 * vx, vy);
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
    
  private void wallCollisions(Entity e) {
        //walls - this.getWidth(), this.getHeight(), 
        //where the hero is - hero.getX(), hero.getY()
        if (e.getX() <= 0 || e.getX() + 30 >= 1200){
            e.reverseX();
        }
//           }
}
}
