package Connect4;

public class Counter {
    private String colour;
    private int playerTurn;
    private int playerNumber;
    private int numberSequence=1;
    private int gamesWon=0;

    public Counter(String colour)
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

    public int getGamesWon() { return gamesWon; }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber=playerNumber;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void setGamesWon(int gamesWon) { this.gamesWon = gamesWon; }

    //never used but wanted to keep it in
    @Override
    public String toString() {
        return "Player Number: " + getPlayerNumber() +
                "\nColour: " + getColour() +
                "\nPlayer Turn: " + getPlayerTurn() +
                "\nGames won: " + getGamesWon();
    }
}
