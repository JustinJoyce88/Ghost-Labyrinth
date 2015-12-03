package Item;

import Player.Player;
import java.util.Random;

public class ItemRandomizer
{
    /**
     *
     * @author Justin
     * This method randomizes all of the items to be picked when you move.
     */
    public void itemRandomizer(Player p1)
    {   Random itemRand = new Random();    //Creating random object
        int roll = itemRand.nextInt(23);   // Variable that randomizes 0-23. 25%
        
        switch(roll)   //Takes in the random integer from variable itemR
        {   //These are calling getSpecialEffect method from each item class 
            //depending on number itemR chooses.
            //Created object only as needed
            case 0: new SpiderBite().getSpecialEffect(p1); break;    
            case 1: new Potion().getSpecialEffect(p1); break;
            case 2: new SnakePit().getSpecialEffect(p1); break;
            case 3: new TurkeyLeg().getSpecialEffect(p1); break;
            case 4: new Painkillers().getSpecialEffect(p1); break;
            case 5: new Twinkie().getSpecialEffect(p1); break;
            case 6: new PieceOfArmor().getSpecialEffect(p1); break;
            //There is no default because the other numbers give it the % drop rate
        }
    }
}
