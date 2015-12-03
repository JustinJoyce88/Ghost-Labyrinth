package Ghost;

import Player.Player;
import java.util.Random;

/**
 *
 * @author Justin
 * This ghost removes -10 health from the player.
 */
public class ScaryGhost implements Ghost    //Implementing Ghost, meaning it has to use the methods in the Ghost interface in order to work.
{   @Override                               //Overrides used to ensure this class is called instead of it's parent first.
    public void interact(Player p1)
    {   Random critDamage = new Random(); //Creating random object.
        int roll = critDamage.nextInt(100)+1;       
        if(roll <= p1.getDmgCritChance())//If random rolls within the range of the critical chance, player will receive critical damage.
            {   p1.remHealth(20);           //Removes 20 health from player1
                p1.healthAtZero(p1);//Calls a method that prevents health from displaying as a negative number.
                System.out.println("You encountered a Scary Ghost!\nYou are unable to move.\nScary Ghost critical hits you for 20 damage!\n\n"+p1.toString()+"\n");        
            }
            else
            {   p1.remHealth(10);              //Removes 10 health from player1 
                p1.healthAtZero(p1);//Calls a method that prevents health from displaying as a negative number.
                System.out.println("You encountered a Scary Ghost!\nYou are unable to move.\nScary Ghost hits you for 10 damage!\n\n"+p1.toString()+"\n");      
            }
    }
 
    @Override
    public String getName()                 //Method used to get the name of the Ghost, so it can be printed recursively in a list.
    {   return "Scary Ghost";//Returns the name of the ghost.
    }
}
