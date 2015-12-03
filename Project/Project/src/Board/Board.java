package Board;

import Ghost.GhostRandomizer;
import Item.ItemRandomizer;
import Player.Player;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Board
{   private static final int rows = 7;              //rows in the bi-di array
    private static final int columns = 10;           //columns in the bi-di array
    private static final char empty = ' ';          //empty spots in the array
    private static final char piece = 'X';          //current player position
    private static final char endPos = '*';         //end position
    
    //generate a random row for the player to start in, greater than 2
    //this helps avoid a really short game
    private static final int endX = (new Random().nextInt(rows - 2) + 2);
    
    //generate a random column for the player to start in, greater than 2
    //this helps avoid a really short game
    private static final int endY = (new Random().nextInt(columns - 2) + 2);  
    private char table[][]; 
    private int moveCount = 0;
    private ItemRandomizer ir = new ItemRandomizer();
    private GhostRandomizer gr = new GhostRandomizer();
    private Player p1 = new Player();
    private JFrame f = new JFrame();
    
    /**
     * Constructs a new Board object
     */
    public Board()
                      
    {   table = new char[rows][columns];    //create new Board object of type char
                                            //with rows # of rows, and columns
                                            //# of columns
        for(int i = 0; i < table.length; i++)         //traverse all columns
        {   for(int j = 0; j < table[0].length; j++)  //traverse all rows
            {   table[i][j] = empty;                  //set to ' '
            }
        } 
        table[0][0] = piece;                        //set piece to start point
        table[endX][endY] = endPos;                 // set end point
        
        String playerName="";
        while ((playerName == null) || (playerName.equals(""))) 
        {   playerName = JOptionPane.showInputDialog(f, "What is your "
                + "name?", "Input required", JOptionPane.QUESTION_MESSAGE);
        }
        p1.setName(playerName);
    }
            
    /**
     * This method prints the board to the System.out
     */
    public void printBoard()
    {   for (int i = 0; i < table.length; i++)         //traverse all columns
        {   for (int j = 0; j < table[0].length; j++)  //traverse all rows
            {   //print ' ' and two spaces  
                System.out.print(" " + table[i][j] + " "); 
                if (j != columns)                   
                {  System.out.print("|");  // print |'s for column separators
                }
            }
            if (i != rows)                              
            {   //print row separators
                System.out.print("\n----------------------------------------\n");           
            }
        }      
        System.out.print("\n");
    }
    
    /**
     * Determines what direction the player wants to move in, if it's a valid
     * move or not, and then moves them.
     * @param direction The short-handed direction that the player wants to 
     *                  move.
     */
    public void movePiece(String direction)
    {   //get the players current position
        int x = getPlayerRow(), y = getPlayerColumn();
        
        //if they want to move down
        if (direction.equalsIgnoreCase("s"))
        {   //current row + 1 a valid move?
            if (!validMove(x + 1, y))
            {   //if not, let them know
                System.out.println("Invalid move. Try again.");
            }
            else
            {   Random r = new Random();
                int roll = r.nextInt(5);
                //If roll is 0 or 1, move free, don't randomize ghost, increment move count.
                if(roll==0 || roll==1)
                {   //if valid, set current row + 1 to the piece
                    table[x + 1][y] = piece;
                    //mark previous position as empty
                    table[x][y] = empty;
                    moveFree(p1);
                    isWin();
                    ir.itemRandomizer(p1);//randomizes the item classes interact method
                    isDead();//checks to see if players health hit zero after possibly finding item
                    moveCount++;//increases move count
                    System.out.println("Total moves: "+moveCount);//displays move count right above board
                    printBoard();//prints board
                }
                else
                {   //If roll is 3,4 or 5, randomize ghost, don't move, don't increment moveCount
                    gr.ghostRandomizer(p1);//randomizes the ghost classes interact methods
                    isDead();//checks to see if players health hit zero
                    ir.itemRandomizer(p1);//randomizes the item classes interact method
                    isDead();//checks to see if players health hit zero after possibly finding item
                    System.out.println("Total moves: "+moveCount);//displays move count right above board
                    printBoard();//prints board
                }
            }
        }
        if (direction.equalsIgnoreCase("d"))
        {   if (!validMove(x, y + 1))
            {   System.out.println("Invalid move. Try again.");
            }
            else
            {   Random r = new Random();
                int roll = r.nextInt(5);
                //If roll is 0 or 1, move free, don't randomize ghost, increment move count.
                if(roll==0 || roll==1)
                {   //if valid, set current row + 1 to the piece
                    table[x][y + 1] = piece;
                    //mark previous position as empty
                    table[x][y] = empty;
                    moveFree(p1);
                    isWin();
                    ir.itemRandomizer(p1);//randomizes the item classes interact method
                    isDead();//checks to see if players health hit zero after possibly finding item
                    moveCount++;//increases move count
                    System.out.println("Total moves: "+moveCount);//displays move count right above board
                    printBoard();//prints board
                }
                else
                {   //If roll is 3,4 or 5, randomize ghost, don't move, don't increment moveCount
                    gr.ghostRandomizer(p1);//randomizes the ghost classes interact methods
                    isDead();//checks to see if players health hit zero
                    ir.itemRandomizer(p1);//randomizes the item classes interact method
                    isDead();//checks to see if players health hit zero after possibly finding item
                    System.out.println("Total moves: "+moveCount);//displays move count right above board
                    printBoard();//prints board
                }
            }
        }
        if (direction.equalsIgnoreCase("a"))
        {   if (!validMove(x, y - 1))
            {   System.out.println("Invalid move. Try again.");
            }
            else
            {   Random r = new Random();
                int roll = r.nextInt(5);
                //If roll is 0 or 1, move free, don't randomize ghost, increment move count.
                if(roll==0 || roll==1)
                {   //if valid, set current row + 1 to the piece
                    table[x][y - 1] = piece;
                    //mark previous position as empty
                    table[x][y] = empty;
                    moveFree(p1);
                    isWin();
                    ir.itemRandomizer(p1);//randomizes the item classes interact method
                    isDead();//checks to see if players health hit zero after possibly finding item
                    moveCount++;//increases move count
                    System.out.println("Total moves: "+moveCount);//displays move count right above board
                    printBoard();//prints board
                }
                else
                {   //If roll is 3,4 or 5, randomize ghost, don't move, don't increment moveCount
                    gr.ghostRandomizer(p1);//randomizes the ghost classes interact methods
                    isDead();//checks to see if players health hit zero
                    ir.itemRandomizer(p1);//randomizes the item classes interact method
                    isDead();//checks to see if players health hit zero after possibly finding item
                    System.out.println("Total moves: "+moveCount);//displays move count right above board
                    printBoard();//prints board
                }
            }
        }
        if (direction.equalsIgnoreCase("w"))
        {   if (!validMove(x - 1, y))
            {   System.out.println("Invalid move. Try again.");
            }
            else
            {   Random r = new Random();
                int roll = r.nextInt(5);
                //If roll is 0 or 1, move free, don't randomize ghost, increment move count.
                if(roll==0 || roll==1)
                {   //if valid, set current row + 1 to the piece
                    table[x - 1][y] = piece;
                    //mark previous position as empty
                    table[x][y] = empty;
                    moveFree(p1);
                    isWin();
                    ir.itemRandomizer(p1);//randomizes the item classes interact method
                    isDead();//checks to see if players health hit zero after possibly finding item
                    moveCount++;//increases move count
                    System.out.println("Total moves: "+moveCount);//displays move count right above board
                    printBoard();//prints board
                }
                else
                {   //If roll is 3,4 or 5, randomize ghost, don't move, don't increment moveCount
                    gr.ghostRandomizer(p1);//randomizes the ghost classes interact methods
                    isDead();//checks to see if players health hit zero
                    ir.itemRandomizer(p1);//randomizes the item classes interact method
                    isDead();//checks to see if players health hit zero after possibly finding item
                    System.out.println("Total moves: "+moveCount);//displays move count right above board
                    printBoard();//prints board
                }        
            }
        }
        if (direction.equalsIgnoreCase("q"))
                {   JOptionPane.showMessageDialog(null, "I knew you didn't have it "
                    + "in you...quitter.", "You momma's boy!"
                    , JOptionPane.INFORMATION_MESSAGE);
                    p1.setHealth(0);
                    isDead();
                    System.exit(0);
                }
    }
    
    public boolean validMove(int x, int y)
    {   if((x>=0) && (x<rows) && (y>=0) && (y<columns)
                && ( (table[x][y] == empty)
                || ( table[x][y] == endPos)) )
        {   return true;
        }
        return false;
    }   
    
    public int getPlayerRow()
    {   for (int i = 0; i < table[0].length; i++)
        {   for (int j = 0; j< table[0].length; j++)
            {   if (table[i][j] == piece)
                {   return i;
                }
            }
        }
        return -1;
    }
    
    public int getPlayerColumn()
    {   for (int i = 0; i < table.length; i++)
        {   for (int j = 0; j< table[0].length; j++)
            {   if (table[i][j] == piece)
                {   return j;
                }
            }
        }
        return -1;
    }
    
    public void isDead()
    {   if(p1.getHealth() <= 0)
        {   System.out.println("\nYou died!\n\n"+p1.toString()+"\n");
            moveCount++;
            System.out.println("Total moves: "+moveCount);
            printBoard();   
            System.exit(0);
        }
    }
        
    public void isWin()
    {   if (getPlayerRow() == endX && getPlayerColumn() == endY)
        {   System.out.println("\nYou Survived to see another day\nand hopefully got a hat or two out of it!\n\n"+p1.toString()+"\n");
            moveCount++;
            System.out.println("Total moves: "+moveCount);
            printBoard();
            System.exit(0);
        }
    }              
      
    public void moveFree(Player p1)
    {   System.out.println("You did not encounter any ghosts!\n\n"+p1.toString()+"\n");        
    }
}
