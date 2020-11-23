package Connect4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Connect4.Game.*;
import static Connect4.Methods.*;

public class DrawShapes extends JPanel implements MouseListener{
    public static boolean gameOver=false;
    public static int currentTurn=1;
    private final int circleWidth=50;
    private final int gap=8;
    public int columns=7;
    public int rows=6;


    //I learned of 2D Grid arrays from https://stackoverflow.com/questions/26327579/java-2d-array-grid to handle the rows and columns(This example was minesweeper but the concept is the same for how I will Implement it)16/11/20
    public Color[][] grid = new Color[rows][columns];

    //I got the dimension class from https://docs.oracle.com/javase/7/docs/api/java/awt/Dimension.html to get the height and width of the frame. 16/11/20
    public DrawShapes(Dimension frameSize)
    {
        //sets the canvas to the same size as the Jframe
        setSize(frameSize);
        addMouseListener(this);

        //instantiates a grid
        for(int row=0; row < grid.length;row++)
        {
            //If i say grid.length instead of grid.length + 1 then the grid will have 6 columns instead of 7
            for(int column=0; column< grid.length+1; column++)
            {

                grid[row][column] = new Color(255, 255, 255);

            }
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Dimension getSize=getSize();
        g2.setColor(new Color(38, 65, 141));
        g2.fillRect(0,0,420,getSize.height);
        int startXAxis=8;
        int startYAxis=8;

        int number=0;
        //paints and sorts Grid
        for(int row=0; row < grid.length;row++)
        {
            for(int column=0; column< grid.length+1; column++)
            {
                    //paints all the ovals(circles) on top of each other with the colour determined when the grid was instantiated
                    g2.setColor(grid[row][column]);
                    //draws the circles starting position as well as length and width of the circles
                    g2.fillOval(startXAxis,startYAxis,circleWidth,circleWidth);

                    //this takes the circles and draws out each circle individually and as the loop increments the circles starting position will be the current position + the width of a circle + a gap
                    startXAxis+=circleWidth+gap;

            }

            // this resets the starting point of the X-Axis and draws another circle on the same row
            startXAxis=8;

            //resets y starting position so that the rows can display vertically
            startYAxis+=circleWidth +gap;
        }
        //setting type and size and colour for all font to be drawn on
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));

        if(!gameOver) {
            if (getRed().getPlayerTurn() % 2 == 0 && currentTurn > 0) {
                g2.setColor(new Color(200, 255, 0));
                g2.drawString("Yellows Turn", 120, 385);
            } else {
                if (getYellow().getPlayerTurn() % 2 == 0 && currentTurn > 0) {
                    //I made this red slightly lighter in colour just for aesthetics
                    g2.setColor(new Color(255, 93, 93));
                    g2.drawString("Reds Turn", 130, 385);
                }
            }
        }
        else
        {
            g2.setColor(new Color(255, 255, 255));
            g2.drawString("Game Over", 140, 385);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int xAxis = e.getX();
        int yAxis = e.getY();
        int xPosition = xAxis/(circleWidth + gap);
        //tool for debugging this is when clicking on a space it decides to change colours :)
        //System.out.println("The xAxis :" + xAxis + " divided by the circle width " + circleWidth + " plus the gap " + gap +" is equal to " + xAxis +"/58 =" +xAxis/(circleWidth + gap));

        //This checks to see if the game has been won
        if(!gameOver) {

            //This IF statement checks to see if the clicks are within the grid array if not it will do nothing
            if (yAxis < ((circleWidth + gap) * grid.length) && xAxis < ((circleWidth + gap) * (grid.length + 1))) {

                //change the Y axis spot according to if there is a colour there or not
                int yPosition = freeSpaceChecker(xPosition, rows, grid);

                //This statement checks to see if the column is full
                if (yPosition == -1) {
                    JOptionPane.showMessageDialog(null, "This Column is full !!! \nPlease select another Column", "Full Column", JOptionPane.ERROR_MESSAGE);
                } else {

                    if (getRed().getPlayerTurn() % 2 == 0) {
                        grid[yPosition][xPosition] = new Color(200, 255, 0);
                    } else {
                        grid[yPosition][xPosition] = new Color(255, 0, 0);
                    }

                    repaint();

                    Color playerColour =grid[yPosition][xPosition];

                    if(hasThePlayerWon(yPosition,xPosition,playerColour,grid))
                    {
                        gameOver=true;
                        displayWinner();
                    }

                    currentTurn++;
                    getRed().setPlayerTurn(getRed().getPlayerTurn() + 1);
                    getYellow().setPlayerTurn(getYellow().getPlayerTurn() + 1);
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
