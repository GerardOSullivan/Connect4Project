package Connect4;

import javax.swing.*;
import java.awt.*;

public class Methods {
    public static int playerTurnGenerator()
    {
        return (int)((Math.random()*2)+1);
    }

    public static void displayWhoGoesFirst(Counter red)
    {
        if(red.getPlayerTurn()==1)
        {
            JOptionPane.showMessageDialog(null,"Red Goes First!!!","Red first to Play",JOptionPane.PLAIN_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Yellow Goes First!!!","Yellow first to Play",JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static int secondPlayerTurn(int playerOne)
    {
        if(playerOne==1)
        {
            return 2;
        }
        else
            return 1;
    }

    public static int freeSpaceChecker(int xPosition, int rows,Color[][] grid)
    {
        int yPosition=0;

        //As long as the Counter as the top row is not equal to either red or yellow do this else return -1 which will indicate that the Column is full
        if(!grid[yPosition][xPosition].equals(new Color(200, 255, 0)) || !grid[yPosition][xPosition].equals(new Color(255, 0, 0)))
        {
            //I say rows -1 here because rows returns 6 but my position will go from 0 to 5 so i only need to loop until 5
            for(yPosition=0;yPosition<=rows-1;yPosition++)
            {
                //if its yellow or red break
                if(grid[yPosition][xPosition].equals(new Color(200, 255, 0)) || grid[yPosition][xPosition].equals(new Color(255, 0, 0)))
                {
                    break;
                }

            }
                return yPosition-1;

        }
        else
        {
            //Column is full
            return -1;
        }
    }
}
