/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AllEnemies;

import mortalkombatbversion.Player;

/**
 *
 * @author Мария
 */
public class ShaoKahn extends Player{
    
    public ShaoKahn(int level, int health, int  damage, int attack){
        super (level, health, damage, attack);
    }
    
    @Override
    public String getName(){
        return "Shao Kahn";
    }
    
     public void changeHealthAttemptRes(int a, int possibleDamage) {
        
        if(a==0){
            System.out.println("recovery");
         //   System.out.println("current health = " + this.getHealth());
            int expectedHealth =(int) (this.getHealth() + (this.getMaxHealth() -  this.getHealth()) * 0.1);
           // System.out.println("expectedHealth = " + expectedHealth);
            this.setNewHealth(expectedHealth);  
        }
        
        if(a==1){
            // получаем двойной damage
            System.out.println("получаем двойной damage");
        //    System.out.println("possible damage = " + possibleDamage);
            int expectedHealth = this.getHealth() - possibleDamage*2;
        //    System.out.println(this.getHealth());
        //    System.out.println(expectedHealth);
            if(expectedHealth >= 0){
                this.setNewHealth(expectedHealth);
            }else{this.setNewHealth(0);}
        
        
        
    
    }
        
    }
    
}
