package Item;

import Player.Player;

/**
 *
 * @author Justin
 * This item increases the players critical heal chance by 10%
 */
public class Painkillers implements Item
{   @Override
    public void getSpecialEffect(Player p1)
    {   p1.increaseHealCritChance(10);  //Increases players critical heal chance by 10%  
        System.out.println("You found Pain Killers!\nCritical heal chance increased by 10%"+p1.healCritIncrease(p1)+"\n\n"+p1.toString()+"\n");
    }
}