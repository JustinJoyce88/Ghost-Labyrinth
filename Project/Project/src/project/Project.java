package project;

import Board.Board;
import ImagePanel.WelcomeScreen;
import javax.swing.JOptionPane;

/**
 * @author Justin Joyce jjoyc002@fiu.edu
 */

public class Project
{   public static void main(String[] args)
    {   {   
            try
            {   WelcomeScreen ws = new WelcomeScreen();           
                ws.welcomeScreen();
            }
            catch (Exception e)
            {   System.out.println(e);
            }
            
            //Prints the board on the console
            Board b = new Board();
            b.printBoard();
            

            String askMove = null;
            while ( (askMove == null) 
                    || !(askMove.equalsIgnoreCase("w")
                    || askMove.equalsIgnoreCase("s")
                    || askMove.equalsIgnoreCase("a") 
                    || askMove.equalsIgnoreCase("d")
                    || askMove.equalsIgnoreCase("q")) )
            {   askMove = JOptionPane.showInputDialog(null, "               Make your move\n"
                    + "(s=down, w=up, a=left"
                    + ", d=right, q=quit)", "Input required"
                    , JOptionPane.QUESTION_MESSAGE);
                    
                if ( (askMove == null) 
                        || !(askMove.equalsIgnoreCase("w")
                        || askMove.equalsIgnoreCase("s")
                        || askMove.equalsIgnoreCase("a") 
                        || askMove.equalsIgnoreCase("d")
                        || askMove.equalsIgnoreCase("q")))
                {   System.out.println("Invalid response. Please try again.");
                } 
                else 
                {   b.movePiece(askMove);
                    askMove = null;
                }
            }                  
        }
    }
}
