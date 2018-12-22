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
import java.util.Random;
import java.util.Scanner;
public class VersusGame {

    Games p1 = new Games();
    Games cpu = new Games();
    int player_act;
    int ctr = 1; //round counter
    public static void main(String[] args) {
        // TODO code application logic here
        new VersusGame(); 
    }
    
    public VersusGame(){
        //PLAYER 1
        p1.setLife(20);
        p1.setDefense(5);
        p1.setSpecialAttack(5);
        
        //CPU PLAYER
        cpu.setLife(20);
        cpu.setDefense(5);
        cpu.setSpecialAttack(5);
        
        LoadStatus();
        Random randm = new Random();
        player_act = randm.nextInt(2);
        PlayerOption();
    }
   
    
    private void LoadStatus(){
     System.out.println("ROUND " + ctr);
     System.out.println("*****-----*****-----*****-----*****-----*****-----*****");
     System.out.println("USER:\t\t\t\t\tCOMPUTER:");
     System.out.println("Life: "+ p1.getLife()+"\t\t\t\t\tLife: "+ cpu.getLife());
     System.out.println("Special Attack: "+ p1.getSpecialAttack()+"\t\t\tSpecial Attack: "+ cpu.getSpecialAttack());
     System.out.println("Defense: "+ p1.getDefense()+"\t\t\t\tDefense: "+ cpu.getDefense());
     System.out.println("*****-----*****-----*****-----*****-----*****-----*****");
     System.out.println("");
     ctr++;
     
    }
    private void PlayerOption(){
         Scanner sc = new Scanner(System.in);
         if(player_act==0){
            System.out.println("User Turn");
            System.out.println("1. Attack");
            System.out.println("2. Special Attack");
            System.out.println("3. Defense");
            System.out.print("Enter Moves: ");
            int moves = sc.nextInt();
            switch(moves){
                case 1:
                    System.out.println("");
                    System.out.println("USER USE ATTACK...");
                    System.out.println("");
                     p1.Use_Attack(p1, cpu);
                     break;
                     
                case 2:
                    System.out.println("");
                    System.out.println("USER USE SPECIAL ATTACK...");
                    System.out.println("");
                     p1.Use_SPAttack(p1, cpu);
                     break;
                case 3:
                    System.out.println("");
                    System.out.println("USER USE DEFENSE...");
                    System.out.println("");
                    p1.setUseDefense(true, p1);
                    break;
            }
            player_act=1;
         }else if(player_act == 1){
             System.out.println("Computer Turn");
             Random randm = new Random();
             int skills = randm.nextInt(2);
             switch(skills){
                case 0:
                    System.out.println("");
                    System.out.println("COMPUTER USE ATTACK...");
                    System.out.println("");
                     cpu.Use_Attack(cpu, p1);
                     break;
                     
                case 1:
                    System.out.println("");
                    System.out.println("COMPUTER USE SPECIAL ATTACK...");
                    System.out.println("");
                     cpu.Use_SPAttack(cpu, p1);
                     break;
                case 2:
                    System.out.println("");
                    System.out.println("COMPUTER USE DEFENSE...");
                    System.out.println("");
                    cpu.setUseDefense(true, cpu);
                    break;
             }
             player_act =0;
         }
        LoadStatus();
        if(p1.getLife()<=0){
          System.out.println("\n");
          System.out.println("COMPUTER WINS!!");
        }else if(cpu.getLife()<=0){
        System.out.println("\n");
        System.out.println("USER WINS!!");
        }else{
           PlayerOption();
        }
    }
}
