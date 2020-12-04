package Connect4;

import javax.swing.*;

public class Frame extends JFrame{
    public Frame()
    {
        //creating the frame and setting the title
        super("Connect Four");
        //setting the size
        setSize(750,430);
        //setting what happens when the window closes
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //adding the shapes for the grid to the board
        add(new GameBoard(getSize()));
        //puts the window into the middle of the screen
        setLocationRelativeTo(null);
        //stops from changing frame window
        setResizable(false);
        //turns on the window
        setVisible(true);

    }
}
