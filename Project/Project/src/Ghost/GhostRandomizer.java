package Ghost;

import Player.Player;
import java.util.Random;

public class GhostRandomizer 
{
    /**
     *
     * @author Justin
     * This method randomizes all the ghosts to be picked when you move.
     */
    public void ghostRandomizer(Player p1)
    {   Random ghostRandom = new Random(); //Creating random object
        int roll = ghostRandom.nextInt(5);  // Variable that randomizes 0-5
        
        switch(roll)  //Takes in the random integer from variable ghostR
        {   //Creates appropriate ghost and calls the interact() on the player
            //Adds Ghost to LinkedList
            case 0: new FriendlyGhost().interact(p1); break; 
            case 1: new MoodyGhost().interact(p1); break;
            case 2: new ScaryGhost().interact(p1); break;
            case 3: new BrawlerGhost().interact(p1); break;
            default: new ExecutionerGhost().interact(p1);
        }
    }   
}