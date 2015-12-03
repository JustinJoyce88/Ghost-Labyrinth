package Ghost;

import Player.Player;

/**
 *
 * @author Justin
 * Ghost interface.
 *      *Creates interact method that requires player object to be received.
 *      *Creates getName method
 */
public interface Ghost
{   public void interact(Player p1);
    public String getName();
}
