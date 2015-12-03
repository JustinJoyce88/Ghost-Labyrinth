package Ghost;

import Player.Player;
import java.util.Random;

/**
 *
 * @author Justin
 * When this ghost is picked, it has a 10% chance to kill the player instantly.
 */
public class ExecutionerGhost implements Ghost
{   @Override                                         //Overrides used to ensure this class is called instead of it's parent first.
    public void interact(Player p1)
    {   Random exeghost = new Random();               //Creating random object
        int roll = exeghost.nextInt(100)+1;             //Creating integer variable from 1 to 100
        
        if(roll<=10)
        {   int currentHealth = p1.getHealth(); //Gets current health of player
            p1.remHealth(currentHealth);        //Removes current health of player
            System.out.println("You encountered an Executioner Ghost!\nYou are unable to move.\nExecutioner Ghost hits you for "+currentHealth+" damage! You dead, bro.\n\n"+p1.toString()+"\n");      
        }
        else
        {   System.out.println("You encountered an Executioner Ghost!\nYou are unable to move.\nExecutioner Ghost missed!\n\n"+p1.toString()+"\n");           
        }
    }
    
    @Override
    public String getName()//Method used to get the name of the Ghost, so it can be printed recursively in a list.
    {   return "Executioner Ghost";//Returns the name of the ghost.
    }
}
