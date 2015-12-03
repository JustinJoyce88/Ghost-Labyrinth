package Player;

/**
 * @author Danny
 */
public class Player 
{   private String name;
    private int health = 100;
    private int healCritChance=10;
    private int dmgCritChance = 30;
    private int maxHealth = 100;
    private int armorPieces = 0;
    
    public Player()
    {   
    }
    
    public String getName()
    { return name;        
    }
    
    public void setName(String n)
    {   name = n;        
    }
    
    /*  Get health from player
     *  returns current player health
     */
    public int getHealth()
    {   return health;        
    }
    
    /*  add or remove health
     *  
     */
    public void setHealth(int h)
    { health = h;
    }
    
    /*  If the friendly ghost is faced or item is used
     *  add health to remaining health
     *  @param h factor to take into account when adding to the current health
     */
    public void addHealth(int h)
    {   health = health + h; 
    }
    
    /*  Depending on what ghost is faced, health will
     *  be taken off from the remaining health
     *  @param h factor to take into account when removing from current health
     */
    public void remHealth(int h)
    {   health = health - h;
    }
    
    /* increases your chance to receive a heal twice as 
     * powerful as the original.Return the chances of the 
     *  heal.
     */
    public int getHealCritChance() 
    {   return healCritChance;
    }

    /*  Apply the item found that can increase the players heal chances
     *  @param hCrit item that is found to increase the healing power. 
     * 
     */
    public void setHealCritChance(int hCrit)
    {   healCritChance = hCrit;
    }
    
    /*  Method to increase the current healing power.
     *  @param hCrit item that is found and apply its healing power.
     * 
     */
    public void increaseHealCritChance(int hCrit)
    {   healCritChance+= hCrit;
    }
     
    /*  
     * 
     *  
     */
    public int getDmgCritChance() 
    {   return dmgCritChance;
    }

    /*  
     * 
     * 
     */
    public void setDmgCritChance(int dCrit) 
    {   dmgCritChance = dCrit;
    }
    
    /*  
     * 
     *  @param dcrit item that can be found to lessen opponents hits
     */
    public void decreaseDmgCritChance(int dcrit)
    {   dmgCritChance-= dcrit;      
        armorPieces++;              //add to armor pieces counter
    }
     
    /*  Get the players maximum health, return the maximum health possible.
     * 
     */
    public int getMaxHealth() 
    {   return maxHealth;
    }

    /*
     * 
     * 
     */
    public void setMaxHealth(int maxH) 
    {   maxHealth = maxH;
    }
    
    /*  if item is found that increases the maximum health, increase the 
     *  max health.
     *  @param maxH factor that will increase the maximum health.
     */
    public void increaseMaxHealth(int maxH)
    {   maxHealth+= maxH;
    }     
    
    /*  Get the players current health, if players health is exceeds the maximum
     *  set players health to maximum health.
     */
    public String maxHealth(Player p1)
    {   if (getHealth() > getMaxHealth()) //prevents health from going over maxHealth.
        {   setHealth(getMaxHealth());         //Resets health if it goes over maxHealth.  
            return("\nYou are over healed and health is set to "+getMaxHealth()+"!");
        }
        return "";
    }  
    
   /*   The maximum health that player can reach taking into considerations 
    *   the items that can increase the max health. If more health than
    *   max health is reached, reset to max health
    * 
    */
    public String maxHealthCap(Player p1)
    {   if(getMaxHealth()>150)//prevents maxHealth from going over maxHealth.
        {   setMaxHealth(150);//Resets maxHealth if it goes over maxHealth.
            return(", but\nyou are already at the maximum health cap.");
        }
        return "";
    }
    
    /*  if player receives an item that increase it's critical heal chance
     *  it will be added. The maximum the player can get is 30. If more than
     *  maximum is found, reset critical heal to maximum health.
     * 
     */
    public String healCritIncrease(Player p1)
    {   if(getHealCritChance()>30)//prevents healing critical chance from going over it's cap(30).
        {   setHealCritChance(30);//Resets healing critical chance if it goes over maxHealth.
            return(", but\nyou are already at the critical heal cap.");
        }
        return "";
    }
       
    /*
     * 
     * 
     */
    public String dmgCritDecrease(Player p1)
    {   if(getDmgCritChance()<10)//prevents damage critical chance from going over.
        {   setDmgCritChance(10);//Resets damage critical chance if it goes over maxHealth.
            return(",but\nyou cannot wear anymore armor.");
        }
        return "";
    }
      
    /*  This method makes sure that the players health does not go into 
     *  negative, if players health is less than zero reset to zero.
     */
    public void healthAtZero(Player p1)
    {   if (getHealth() < 0) //If statement prevents health from going below zero.
        {   setHealth(0);         //Resets health if health goes below zero.  
        }       
    }
    
    /*  Display players name, the players current health under maximum health,
     *  how many armor pieces were found, and the critical heal chance.
     */
    
    @Override
    public String toString()
    {   return(name+"\nHealth: "+health+"/"+maxHealth+"\nArmor pieces: "+armorPieces+"\nHeal Crit Chance: "+healCritChance+"%");
    }
}
