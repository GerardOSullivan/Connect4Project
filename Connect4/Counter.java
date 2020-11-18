package Connect4;

import javax.swing.*;
import java.awt.*;

public class Counter {
    private String colour;
    private int playerTurn;
    private int playerNumber;
    private static int numberSequence=1;

    public Counter(String colour,int playerTurn)
    {
        setColour(colour);
        setPlayerTurn(playerTurn);
        setPlayerNumber(numberSequence);
        numberSequence++;
    }

    public String getColour() {
        return colour;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber=playerNumber;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    @Override
    public String toString() {
        return "Player Number: " + getPlayerNumber() +
                "\nColour: " + getColour() +
                "\nPlayer Turn: " + getPlayerTurn();
    }
}
