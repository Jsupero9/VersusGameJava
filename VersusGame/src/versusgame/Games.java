/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package versusgame;

/**
 *
 * @author James Supero
 */
public class Games {
    
    //--VariableName--//
    private int life;
    private int defense;
    private int specialattack;
    private boolean usedefense;
    private boolean usesp;
    
    
    //--MUTATOR--//
    public void setLife(int life){
    this.life = life;
    }
    
    public void setSpecialAttack(int specialattack){
    this.specialattack = specialattack;
    }
    
    public void setDefense(int defense){
    this.defense = defense;
    }
    
    //--ACCESSORS--//
    public int getLife(){
     return life;
    }
    
    public int getDefense(){
    return defense;
    }
    
    public int getSpecialAttack(){
    return specialattack;
    }
    public void Use_Attack(Games player1,Games player2){
        if(player2.usedefense == false){
              player2.life -=1;
        }
        else{
              player2.usedefense = false;
        }
    }
    
    public void Use_SPAttack(Games player1, Games player2){
    if(player1.specialattack > 0){
        player1.specialattack -=1;
    if(player2.usedefense == true){
      player2.life -=1;
      player2.usedefense = false;
      }
    else if(player2.usedefense == false){
      player2.life -=2;
      player2.usedefense = false;
      }
    }else{
    player1.usesp = false;
    System.out.println("Oops! You don't have enough Special Attack! = Loss Turn");
    }
    
    
    }
    
    
    public void setUseDefense(boolean usedefense, Games player){
       if(player.defense > 0){
       player.defense -=1;
       }
       else{
       this.usedefense = usedefense;    
       player.usedefense = false;
       System.out.println("Oops! You don't have enough Defense! = Loss Turn");
       }
      
    }
    
    public void setSpecialAttack(boolean usesp, Games player){
       player.specialattack -=1;
       this.usesp = usesp;
    }
    
}
