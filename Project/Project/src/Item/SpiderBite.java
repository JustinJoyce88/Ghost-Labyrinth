package Item;

import Player.Player;

/**
 * 
 * @author Justin
 * This item removes 15 health from the player
 */
public class SpiderBite implements Item
{   @Override
    public void getSpecialEffect(Player p1)
     {   p1.remHealth(15);//DragonFur removes 15 energy from the player health
         p1.healthAtZero(p1);//Calls a method that prevents health from displaying as a negative number.
         System.out.println("A Spider bit you! \nit hurts you for 15 damage!\n\n"+p1.toString()+"\n");               
     }  
}
