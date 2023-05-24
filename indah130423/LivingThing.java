/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah130423;

/**
 *
 * @author A409FA
 */

public abstract class LivingThing 
{ 
   public void breath(){ 
        System.out.println("Living Thing breathing..."); 
    } 
    
    public void eat(){ 
        System.out.println("Living Thing eating..."); 
    } 
    
    /** 
    * abstract method walk 
    * Kita ingin method ini di-overridden oleh subclasses 
    */ 
    
    public abstract void walk();
    
    public class Human extends LivingThing 
    { 
        public void walk(){ 
            System.out.println("Human walks...");
        } 
    }  
}
