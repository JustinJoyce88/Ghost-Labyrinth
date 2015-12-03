package Item;

import Player.Player;

/**
 *
 * @author Justin
 * This item increases the player's maximum health by 10
 */
public class Twinkie implements Item
{   @Override
    public void getSpecialEffect(Player p1)
    {   p1.increaseMaxHealth(10);//increases players maximum health by 10.
        System.out.println("You found a Twinkie!\nMaximum health increased by 10"+p1.maxHealthCap(p1)+"\n\n"+p1.toString()+"\n");      
    }
}
