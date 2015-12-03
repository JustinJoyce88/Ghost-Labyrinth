package Item;
/**
 *
 * @author Justin
 * This item removes 15 health from the player.
 */
import Player.Player;

public class SnakePit implements Item 
{   @Override
     public void getSpecialEffect(Player p1)
     {   p1.remHealth(20);//Snakepit removes 20 energy from the player health
         p1.healthAtZero(p1);//Calls a method that prevents health from displaying as a negative number.
         System.out.println("You fell into a Snake Pit! Inflicts 20 damage!\n\n"+p1.toString()+"\n");               
     }
}