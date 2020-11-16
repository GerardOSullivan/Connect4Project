package Connect4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameGridBoard extends JFrame implements MouseListener {
    private JLabel jLabels[];
    private int clickEventCounter;
    private int result=-1;
    private boolean gameOver=false;
    private Color defaultColour = getBackground();

    public GameGridBoard()
    {
       /* JFrame gameBoard = new JFrame();
        gameBoard.setSize(750,650);
        gameBoard.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameBoard.setPreferredSize(gameBoard.getSize());*/


        //Create a Grid object with the first value = to the amount of rows the second value is columns
        //the 3rd value is the horizontal gap and the 4th value is the vertical gap in the object
        GridLayout gridlayout= new GridLayout(7,7,0,0);
        FlowLayout flowLayout= new FlowLayout();
        setLayout(gridlayout);

        jLabels = new JLabel[49];

        for(int i=0;i<jLabels.length;i++)
        {
            jLabels[i] = new JLabel("" +(i+1),SwingConstants.CENTER);
            jLabels[i].setBorder(BorderFactory.createLineBorder(Color.BLUE, 7));
            add(jLabels[i]);
            jLabels[i].addMouseListener(this);
        }

        setSize(650,650);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

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
