package Ghost;

import Player.Player;
import java.util.Random;

/**
 *
 * @author Justin
 *  This ghost rolls a number between 1 and 2. If the number is 1,adds +5
 *  health to player and additionally, has a chance to critical heal for +10 health. 
 *  If the number is 2, removes -5 health to the player and additionally, has a chance 
 *  to critical hit for -10 health. 
 */
public class MoodyGhost implements Ghost //Implementing Ghost, meaning it has to use the methods in the Ghost interface in order to work.
{   @Override                               //Overrides used to ensure this class is called instead of it's parent first.
    public void interact(Player p1) 
    {   Random moodyRoll = new Random();    //Creating random object.
        int roll = moodyRoll.nextInt(2) + 1;    //Creating an integer variable equal to either 1 or 2.

        if (roll == 1) 
        {   Random critHeal = new Random(); //Creating random object.
            int roll2 = critHeal.nextInt(100)+1;
            
            if (roll2 <= p1.getHealCritChance()) //Gives the moody ghost's heal a chance to heal for double health. Value starts at 0%
            {   p1.addHealth(10);      //Adds 10 health to player1
                System.out.println("You encountered a Moody Ghost!\nYou are unable to move.\nMoody Ghost critical heals you for 10 health!"+p1.maxHealth(p1)+"\n\n"+p1.toString()+"\n");           
            } 
            else 
            {   p1.addHealth(5); //Adds 5 health from player1       
                System.out.println("You encountered a Moody Ghost!\nYou are unable to move.\nMoody Ghost heals you for 5 health!"+p1.maxHealth(p1)+"\n\n"+p1.toString()+"\n");
            }
        } 
        else 
        {   Random critDamage = new Random(); //Creating random object.
            int roll3 = critDamage.nextInt(100)+1;
            
            if(roll3 <= p1.getDmgCritChance())//If random rolls within the range of the critical chance, player will receive critical damage.
            {   p1.remHealth(10);           //Removes 5 health from player1
                p1.healthAtZero(p1);//Calls a method that prevents health from displaying as a negative number.
                System.out.println("You encountered a Moody Ghost!\nYou are unable to move.\nMoody Ghost critical hits you for 10 damage!\n\n"+p1.toString());         
            }
            else
            {   p1.remHealth(5);           //Removes 5 health from player1
                p1.healthAtZero(p1);//Calls a method that prevents health from displaying as a negative number.
                System.out.println("You encountered a Moody Ghost!\nYou are unable to move.\nMoody Ghost hits you for 5 damage!\n\n"+p1.toString()); 
            }
        }
    }

    @Override
    public String getName() //Method used to get the name of the Ghost, so it can be printed recursively in a list.
    {   return "Moody Ghost";//Returns the name of the ghost.
    }
}
