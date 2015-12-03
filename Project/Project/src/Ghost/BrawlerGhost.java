package Ghost;

import Player.Player;
import java.util.Random;

/**
 *
 * @author Justin
 * This ghost randomizes a number between 1 and 20 and then deducts that number from the player's health. 
 * It has a chance to hit for double that amount.
 */
public class BrawlerGhost implements Ghost  //Implementing Ghost, meaning it has to use the methods in the Ghost interface in order to work.
{   @Override                               //Overrides used to ensure this class is called instead of it's parent first.
    public void interact(Player p1)    // Method that takes in the object player to use the player class.
    {   Random brawlGhost = new Random();   // Creating random object.
        int roll = brawlGhost.nextInt(20)+1;  // Creating an integer variable equal to whatever number the randomizer chooses.
        
        Random critDamage = new Random();   //Creating random object.
        int roll2 = critDamage.nextInt(100)+1;
        
        if(roll2 <= p1.getDmgCritChance())//If random rolls within the range of the critical chance, player will receive critical damage.
            {   p1.remHealth(roll*2);  //Removes the health deducted from the randomizer*2 to player1
                p1.healthAtZero(p1); //Calls a method that prevents health from displaying as a negative number.
                System.out.println("You encountered a Brawler Ghost!\nYou are unable to move.\nBrawler Ghost critical hits you for "+(roll*2)+" damage!\n\n"+p1.toString()+"\n");
                             
            }
            else
            {   p1.remHealth(roll);   //Removes the health deducted from the randomizer to player1.
                p1.healthAtZero(p1);//Calls a method that prevents health from displaying as a negative number.
                System.out.println("You encountered a Brawler Ghost!\nYou are unable to move.\nBrawler Ghost hits you for "+roll+" damage!\n\n"+p1.toString()+"\n");            
            }                     
    }
 
    @Override
    public String getName()                 //Method used to get the name of the Ghost, so it can be printed recursively in a list.
    {   return "Brawler Ghost";             //Returns the name of the ghost.
    }
}
