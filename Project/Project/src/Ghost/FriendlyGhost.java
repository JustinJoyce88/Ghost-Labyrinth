package Ghost;

import Player.Player;
import java.util.Random;

/**
 *
 * @author Justin
 * This ghost adds +10 health to the player. Additionally, has a chance to critical heal for +20 health.
 */
public class FriendlyGhost implements Ghost //Implementing Ghost, meaning it has to use the methods in the Ghost interface in order to work.
{   @Override                               //Overrides used to ensure this class is called instead of it's parent first.
    public void interact(Player p1) 
    {   Random critHeal = new Random(); //Creating random object.
        int roll = critHeal.nextInt(100)+1;

        if (roll <= p1.getHealCritChance()) //Gives the friendly ghost's heal a chance to crit for double health. Value starts at 10%
        {   p1.addHealth(20);  //Adds 20 health to player1              
            System.out.println("You encountered a Friendly Ghost!\nYou are unable to move.\nFriendly Ghost critical heals you for 20 health!"+p1.maxHealth(p1)+"\n\n"+p1.toString()+"\n");         
        } 
        else 
        {   p1.addHealth(10);//Adds 10 health from player1
            System.out.println("You encountered a Friendly Ghost!\nYou are unable to move.\nFriendly Ghost heals you for 10 health!"+p1.maxHealth(p1)+"\n\n"+p1.toString()+"\n");           
        }
    }

    @Override
    public String getName() //Method used to get the name of the Ghost, so it can be printed recursively in a list.
    {   return "Friendly Ghost";//Returns the name of the ghost.
    }
}
