package Connect4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawShapes extends JPanel{
    public int columns=7;
    public int rows=6;

    //I learned of 2D Grid arrays from https://stackoverflow.com/questions/26327579/java-2d-array-grid to handle the rows and columns(This example was minesweeper but the concept is the same for how I will Implement it)16/11/20
    Color[][] grid = new Color[rows][columns];

    //I got the dimension class from https://docs.oracle.com/javase/7/docs/api/java/awt/Dimension.html to get the height and width of the frame. 16/11/20
    public DrawShapes(Dimension frameSize)
    {
        //sets the canvas to the same size as the Jframe
        setSize(frameSize);

        //instantiates a grid
        for(int row=0; row < grid.length;row++)
        {
            for(int column=0; column< grid[0].length; column++)
            {
                grid[row][column] = new Color(255, 255, 255);
            }
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        Dimension getSize=getSize();
        g2.setColor(new Color(38, 65, 141));
        g2.fillRect(0,0,350,getSize.height);
        int circleWidth=40;
        int gap=8;
        int startXAxis=8;
        int startYAxis=8;

        for(int row=0; row < grid.length;row++)
        {
            for(int column=0; column< grid[0].length; column++)
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
        g2.setColor(new Color(255, 255, 255, 255));
        //test
        //g2.drawString("Red's Turn",370,40);
    }
}
