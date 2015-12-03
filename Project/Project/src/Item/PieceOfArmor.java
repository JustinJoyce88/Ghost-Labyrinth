package Item;

import Player.Player;

/**
 *
 * @author Justin
 * This item reduces the enemies chance to do a critical hit.
 */
public class PieceOfArmor implements Item
{   @Override
    public void getSpecialEffect(Player p1)
    {   p1.decreaseDmgCritChance(5);   //Decreases enemies critical hit chance by 10%   
        System.out.println("You found an Armor Piece!\nChance to receive critical hit reduced by 5%"+p1.dmgCritDecrease(p1)+"\n\n"+p1.toString()+"\n");
    }
}
