package ImagePanel;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Justin
 * This class is used to make a text area that will display a welcome screen 
 * explaining the rules to the user.
 */
public class WelcomeScreen 
{   public void welcomeScreen() throws IOException
    {   String welcomeScreen = ""
            + "                                Ghost Labyrinth\n\n"
            + ""
            + "The rules of this game are simple. Reach the end point(*) before dying\n"
            + "to win. You will run into ghosts that will prevent you from moving.\n"
            + "You also have a chance to find an item that can help you or hurt you.\n\n"
            
            + "Controls\n\n"
            + "Movement: W = Up, S = Down, A = Left, D = Right\n"
            + "Other: Q = Quit, Enter = Continue\n\n"      
            
            + "Stats\n\n"
            + "Health: If you run out of this, you die...obviously.\n"
            + "Armor Pieces: Reduces the chance for you to receive critical damage.\n"                   
            + "Heal Crit Chance: Increases your chance to receive a heal twice as\n"
            + "powerful as the original.\n\n"
            
            + "Enjoy!";
            JTextArea text = new JTextArea();
            text.setEditable(false);
            text.setText(welcomeScreen);
            JOptionPane.showMessageDialog(null, text, "Team Orange", JOptionPane.INFORMATION_MESSAGE);
    }
}
