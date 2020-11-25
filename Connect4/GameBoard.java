package Connect4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Connect4.Game.*;
import static Connect4.Methods.*;

public class GameBoard extends JPanel implements MouseListener{
    private Image newGameButton =Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("NEW_GAME.png"));
    public static int gamesPlayed=0;
    public static boolean gameOver=false;
    private static boolean clicked=false;
    public static int currentTurn=0;
    private final int circleWidth=50;
    private final int gap=8;
    public int columns=7;
    public int rows=6;


    //I learned of 2D Grid arrays from https://stackoverflow.com/questions/26327579/java-2d-array-grid to handle the rows and columns(This example was minesweeper but the concept is the same for how I will Implement it)16/11/20
    public Color[][] grid = new Color[rows][columns];

    //I got the dimension class from https://docs.oracle.com/javase/7/docs/api/java/awt/Dimension.html to get the height and width of the frame. 16/11/20
    public GameBoard(Dimension frameSize)
    {
        //sets the canvas to the same size as the JFrame
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

        //I ended up having to look up the code for how to draw the background image. I originally added the Background image on the JFrame however this did not work
        //as when I incremented any piece of text and redrew it the text would paint over itself because of this i needed to repaint the background
        //every time something changed on the canvas e.g when turn incremented the background would paint over the old value and only the latest information would be displayed
        //The coded i used for for painting the image came from https://examples.javacodegeeks.com/desktop-java/awt/drawing-an-image-example/ on 23/11/20
        //The image came from https://www.google.com/search?q=background+image+imagesize:700x500&tbm=isch&hl=en-GB&chips=q:background,g_1:design:NRzzYO0YbIk%3D,g_1:blue:qcdZTVkBW2s%3D&sa=X&ved=2ahUKEwjAjteemYftAhXcQRUIHaErDfkQ4lYoB3oECAEQJQ&biw=1903&bih=880#imgrc=4MgWAWd-fMLsdM&imgdii=5pwVLvsYGlQT_M 16/11/20
        //also used a method which gets the file locally rather than using the image url which would not work on another computer
        //I got this method from https://stackoverflow.com/questions/17902161/how-to-reference-a-local-image-in-java on 24/11/20
        //This was for an image icon but it worked for what i needed it for as well
        Image backgroundImage =Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Connect4Background.jpg"));
        g2.drawImage(backgroundImage, 0, 0, this);

        g2.setColor(new Color(38, 65, 141));
        g2.fillRect(0,0,420,getSize.height);
        int startXAxis=8;
        int startYAxis=8;

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


                          //ScoreBoard
        //setting a simple title in the scorecard :)
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        g2.setColor(new Color(179, 102, 6));
        g2.drawString("Connect Four", 440, 50);
        //this is just an underline no specifics i just kinda messed around with the values :D
        g2.drawLine(440,52,680,52);

        //setting type and size and colour for all font to be drawn on
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));

        g2.setColor(new Color(255, 255, 255));
        g2.drawString("Current turn: " + currentTurn, 440, 100);
        g2.drawString("Red wins : " + getRed().getGamesWon(), 440, 150);
        g2.drawString("Yellow wins : " + getYellow().getGamesWon(), 440, 200);
        g2.drawString("Games Played : " + gamesPlayed, 440, 250);


        //new game button
        if(!clicked)
        {
            newGameButton =Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("NEW_GAME.png"));
            g2.drawImage(newGameButton, 440, 300, 280,60, this);
        }
        else
        {
            newGameButton =Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("NEW_GAME_CLICKED.png"));
            g2.drawImage(newGameButton, 440, 300, 280,60, this);
        }

        if(currentTurn!=0) {
            if (!gameOver) {
                if (getRed().getPlayerTurn() % 2 == 0) {
                    g2.setColor(new Color(200, 255, 0));
                    g2.drawString("Yellows Turn", 120, 385);
                } else {
                    if (getYellow().getPlayerTurn() % 2 == 0) {
                        //I made this red slightly lighter in colour just for aesthetics
                        g2.setColor(new Color(255, 93, 93));
                        g2.drawString("Reds Turn", 130, 385);
                    }
                }
            } else {
                g2.setColor(new Color(255, 255, 255));
                g2.drawString("Game Over", 140, 385);
            }
        }
        else
        {
            g2.setColor(new Color(255, 255, 255));
            g2.drawString("Click New Game to begin!", 40, 385);
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

        //code for new button click
        if(xAxis>=440 && xAxis<=690 && yAxis>=300 && yAxis<=350)
        {
            clicked=true;
            repaint();
            int userInput=JOptionPane.showConfirmDialog(null,"Would you like to start a new game","New Game",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
            if(userInput==0)
            {
                for(int row=0; row < grid.length;row++)
                {
                    //If i say grid.length instead of grid.length + 1 then the grid will have 6 columns instead of 7
                    for(int column=0; column< grid.length+1; column++)
                    {

                        grid[row][column] = new Color(255, 255, 255);

                    }
                }
                displayWhoGoesFirst(red);
                gameOver=false;
                currentTurn=1;
            }

            clicked=false;
            repaint();
        }

        //This checks to see if the game has been won
        if(!gameOver && currentTurn>0) {

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

                    repaint();
                    currentTurn++;
                    getRed().setPlayerTurn(getRed().getPlayerTurn() + 1);
                    getYellow().setPlayerTurn(getYellow().getPlayerTurn() + 1);

                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clicked=false;
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
