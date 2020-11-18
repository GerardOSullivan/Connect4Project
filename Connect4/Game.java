package Connect4;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game{
    public static int playerTurn =playerPositionGenerator();
    public static Counter red =new Counter("Red",playerTurn);
    public static Counter yellow = new Counter("yellow",secondPlayerTurn(playerTurn));

    public static void main(String[] args) {

        //This is simple code to see who goes first Red or yellow and this assigns the player number to
        //the colour of the counter that is going first the counters are also generated at this point
        //This can be used to see who went first. By default red is player one and yellow is player two
        Frame board = new Frame();

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

    public static Counter getRed() {
        return red;
    }

    public static Counter getYellow() {
        return yellow;
    }
}
