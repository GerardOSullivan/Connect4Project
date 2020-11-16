package Connect4;
/* This is my attempt at making the game connect 4
I intend to make a 6x7 grid with a scoreboard to keep track of the amount of games won
The program begins with a method which randomly generators which player will go first
a second method will determine who goes second a third method will display the results of who goes first

Day2:I am considering changing my counter class as I am beginning to thing that i will need to create multiple instances of that class so I might need
to separate the player class and the counter and assign a counter to a player. I am going to start the grid to give me a chance to think about it.
After messing with the grid i am not too happy with it. I need to come up with a sketch and a layout and a simple plan on how it will work
(to be continued.....)
 */

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
