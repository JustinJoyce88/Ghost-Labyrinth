package Item;

import Player.Player;
import java.util.Random;

/**
 *
 * @author Justin
 * This item can heal or damage the player for 15 health depending on it's roll.
 */
public class TurkeyLeg implements Item 
{   
    @Override
    public void getSpecialEffect(Player p1)
    {   Random r = new Random();
        int roll = r.nextInt(2)+1;
        
        if(roll==1)
        {   p1.addHealth(15);// TurkeyLeg adds 15 energy to the player health
            System.out.println("You found a Turkey Leg!\nTurkey Leg was fresh! added 15 health!"+p1.maxHealth(p1)+"\n\n"+p1.toString()+"\n");
        }
        else
        {   p1.remHealth(15);// TurkeyLeg removes 15 energy to the player health
            p1.healthAtZero(p1);//Calls a method that prevents health from displaying as a negative number.
            System.out.println("You found a Turkey Leg!\nTurkey Leg was rotten!\nYou feel sick and lose 15 health!\n\n"+p1.toString()+"\n");                   
        }
    }        
}
