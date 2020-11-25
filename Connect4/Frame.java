package Connect4;

import javax.swing.*;

public class Frame {
    public static JPanel newGame = new JPanel();
    public Frame()
    {
        //creating the frame and setting the title
        JFrame frame = new JFrame("Connect Four");
        //setting the size
        frame.setSize(750,430);
        //setting what happens when the window closes
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //adding the shapes for the grid to the board
        frame.add(new GameBoard(frame.getSize()));
//        JButton newGameButton = new JButton("NEW GAME");
//        newGame.add(newGameButton);
//        frame.add(newGameButton);
        //puts the window into the middle of the screen
        frame.setLocationRelativeTo(null);
        //stops from changing frame window
        frame.setResizable(false);
        //turns on the window
        frame.setVisible(true);

    }
}
