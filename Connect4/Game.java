package Connect4;

import javax.swing.*;

public class Game {
    public static void main(String[] args) {
        int gameTurn=0;

        //This is simple code to see who goes first Red or yellow and this assigns the player number to
        //the colour of the counter that is going first the counters are also generated at this point
        //This can be used to see who went first. By default red is player one and yellow is player two
        GameGridBoard board = new GameGridBoard();

        int playerTurn =playerPositionGenerator();
        Counter red =new Counter("Red",playerTurn);
        Counter yellow = new Counter("yellow",secondPlayerTurn(playerTurn));

        System.out.println(red.toString() +"\n");
        System.out.println(yellow.toString());
        displayWhoGoesFirst(red);

    }

    public static int playerPositionGenerator()
    {
        return (int)((Math.random()*2)+1);
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

}
