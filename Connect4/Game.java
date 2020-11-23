package Connect4;

import static Connect4.Methods.*;

public class Game{
    public static int playerTurn =playerTurnGenerator();
    public static Counter red =new Counter("Red",playerTurn);
    public static Counter yellow = new Counter("yellow",secondPlayerTurn(playerTurn));

    public static void main(String[] args) {

       Frame board = new Frame();

        displayWhoGoesFirst(red);

    }

    public static Counter getRed() {
        return red;
    }

    public static Counter getYellow() {
        return yellow;
    }
}
