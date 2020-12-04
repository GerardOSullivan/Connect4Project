package Connect4;

import java.io.*;
import java.util.Scanner;

import static Connect4.GameBoard.gamesPlayed;

public class Game {
    public static Counter red =new Counter("Red");
    public static Counter yellow = new Counter("yellow");

    public static void main(String[] args) throws IOException {

        //Load the save data Line one is reds wins Line two is yellows wins and the third line is the amount of games played
        File counterData = new File("Connect4\\counterData.txt");
        Scanner fileScanner = new Scanner(counterData);
        red.setGamesWon(Integer.parseInt(fileScanner.nextLine()));
        yellow.setGamesWon(Integer.parseInt(fileScanner.nextLine()));
        gamesPlayed=Integer.parseInt(fileScanner.nextLine());


        new Frame();
        Audio.playAudio("Connect4\\Sounds\\BackgroundMusic.wav");

    }

    public static Counter getRed() {
        return red;
    }

    public static Counter getYellow() {
        return yellow;
    }
}
