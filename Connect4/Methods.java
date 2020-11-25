package Connect4;

import javax.swing.*;
import java.awt.*;

import static Connect4.Game.*;
import static Connect4.GameBoard.*;

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

    public static void displayWinner()
    {
        gamesPlayed++;

        if(red.getPlayerTurn()%2==0)
        {
                JOptionPane.showMessageDialog(null,"Yellow wins","Winner",JOptionPane.INFORMATION_MESSAGE);
                yellow.setGamesWon(getYellow().getGamesWon()+1);
        }
        else
        {
                JOptionPane.showMessageDialog(null,"Red wins","Winner",JOptionPane.INFORMATION_MESSAGE);
                red.setGamesWon(getRed().getGamesWon()+1);
        }
    }

    public static int freeSpaceChecker(int xPosition, int rows,Color[][] grid)
    {
        int yPosition=0;

            //As long as the Counter as the top row is not equal to either red or yellow do this else return -1 which will indicate that the Column is full
            if (!grid[yPosition][xPosition].equals(new Color(200, 255, 0)) || !grid[yPosition][xPosition].equals(new Color(255, 0, 0))) {
                //I say rows -1 here because rows returns 6 but my position will go from 0 to 5 so i only need to loop until 5
                for (yPosition = 0; yPosition <= rows - 1; yPosition++) {
                    //if its yellow or red break
                    if (grid[yPosition][xPosition].equals(new Color(200, 255, 0)) || grid[yPosition][xPosition].equals(new Color(255, 0, 0))) {
                        break;
                    }

                }
                return yPosition - 1;

            }
            else {
                //Column is full
                return -1;
            }
    }

    public static boolean hasThePlayerWon(int currentRow, int currentColumn,Color playerColour,Color[][] gridColour)
    {
        //Checking to the south of the current position
        // I set count to 1 because one counter is guaranteed to be in position
        int count=1;
        //check the counter below the currently placed counter
        int nextCounterSouth=currentRow+1;
        while(nextCounterSouth< gridColour.length)
        {
            //if that is the same as the counter the player has then increase the count checker other wise break as there could be a counter
            //belong to the other player in between a connect 4 and still be valid if I dont break
            if(gridColour[nextCounterSouth][currentColumn].equals(playerColour))
            {
                count++;
            }
            else
            {
                break;
            }

            if(count==4)
            {
                return true;
            }

            nextCounterSouth++;
        }

        //Checking to the East of the current position
        //reset count
        count=1;
        int nextCounterEast=currentColumn+1;
        // the length of the array
        while(nextCounterEast< gridColour.length+1)
        {
            //row is whatever e.g 5, and the first counter goes in at row 5 column 7 if a counter goes into row 5 column 6 then
            //the counter at row 5 column 7 will increment the count
            if(gridColour[currentRow][nextCounterEast].equals(playerColour))
            {
                count++;
            }
            else
            {
                break;
            }

            if(count==4)
            {
                return true;
            }

            nextCounterEast++;
        }

        //Checking to the West of the current position
        //reset count
        count=1;
        int nextCounterWest=currentColumn-1;
        //has to be less than or equal to zero because zero is the first column and must be included
        while(nextCounterWest>=0)
        {
            //row is whatever e.g 5, and the first counter goes in at row 5 column 7 if a counter goes into row 5 column 6 then
            //the counter at row 5 column 7 will increment the count
            if(gridColour[currentRow][nextCounterWest].equals(playerColour))
            {
                count++;
            }
            else
            {
                break;
            }

            if(count==4)
            {
                return true;
            }

            nextCounterWest--;
        }
        //this is the code i used for testing columns and rows I was going to delete it but i decided to
        //leave it in so you could see the process on how I determined where to check next
        //This code was altered and used for the other directions including diagonals where i also included
        // a print line for the row to see where the next counter was checking
//        System.out.println("\nRow " +currentRow);
//        System.out.println("Column " +currentColumn);
//        System.out.println("Next column " +nextCounterWest);
//        System.out.println("Count " +count);


        //check North East of the current position
        count=1;
        nextCounterEast=currentColumn+1;
        int nextCounterNorth=currentRow-1;
        while(nextCounterEast<gridColour.length+1 && nextCounterNorth>=0)
        {
            if(gridColour[nextCounterNorth][nextCounterEast].equals(playerColour))
            {
                count++;
            }
            else
            {
                break;
            }

            if(count==4)
            {
                return true;
            }

            nextCounterEast++;
            nextCounterNorth--;
        }

        //check North West of the current position
        count=1;
        nextCounterWest=currentColumn-1;
        nextCounterNorth=currentRow-1;
        while(nextCounterWest>=0 && nextCounterNorth>=0)
        {
            if(gridColour[nextCounterNorth][nextCounterWest].equals(playerColour))
            {
                count++;
            }
            else
            {
                break;
            }

            if(count==4)
            {
                return true;
            }

            nextCounterWest--;
            nextCounterNorth--;
        }

        //check South West of the current position
        count=1;
        nextCounterWest=currentColumn-1;
        nextCounterSouth=currentRow+1;
        while(nextCounterWest>=0 && nextCounterSouth<gridColour.length)
        {
            if(gridColour[nextCounterSouth][nextCounterWest].equals(playerColour))
            {
                count++;
            }
            else
            {
                break;
            }

            if(count==4)
            {
                return true;
            }

            nextCounterWest--;
            nextCounterSouth++;
        }

        //check South East of the current position
        count=1;
        nextCounterEast=currentColumn+1;
        nextCounterSouth=currentRow+1;
        while(nextCounterEast< gridColour.length+1 && nextCounterSouth<gridColour.length)
        {
            if(gridColour[nextCounterSouth][nextCounterEast].equals(playerColour))
            {
                count++;
            }
            else
            {
                break;
            }

            if(count==4)
            {
                return true;
            }

            nextCounterEast++;
            nextCounterSouth++;
        }

        return false;
    }
}
