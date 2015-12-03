package Item;

import Player.Player;

public class Potion implements Item 
{   @Override
    public void getSpecialEffect(Player p1)
    {   p1.addHealth(10);// Potion adds 10 energy to the player health
        System.out.println("You found a Potion\nWow, Potion added 10 health!"+p1.maxHealth(p1)+"\n\n"+p1.toString()+"\n");              
    }
}
