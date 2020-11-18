package Connect4;

import javax.swing.*;

public class Frame extends JFrame{

    private JLabel backgroundImage;
    private JFrame frame;
    public Frame()
    {
        //creating the frame and setting the title
        frame = new JFrame("Connect Four");
        //setting the size
        frame.setSize(750,430);
        //setting what happens when the window closes
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //I wanted a nice background image just for fun :D had to look up code to put it in. The code came from this video https://www.youtube.com/watch?v=fqYFiLW71zc&ab_channel=samuelowino 16/11/20
        //The image was taken from here https://www.google.com/search?q=background+image+imagesize:700x500&tbm=isch&hl=en-GB&chips=q:background,g_1:design:NRzzYO0YbIk%3D,g_1:blue:qcdZTVkBW2s%3D&sa=X&ved=2ahUKEwjAjteemYftAhXcQRUIHaErDfkQ4lYoB3oECAEQJQ&biw=1903&bih=880#imgrc=4MgWAWd-fMLsdM&imgdii=5pwVLvsYGlQT_M
        //The image was resized to fit the frame and both the code and the image were used on the 16/11/20
        //The code instantiates a JLabel object which requires an ImageIcon argument which retrieves the image file in the package
        //the boundaries are then set and the JLabel is added to the frame. The video did not have the get width and height accessors. I put them in incase I had to change the image.

        //adding the shapes for the grid to the board
        frame.add(new DrawShapes(frame.getSize()));

        backgroundImage = new JLabel(new ImageIcon(getClass().getResource("Connect4Background.jpg")));
        backgroundImage.setBounds(0,0, frame.getWidth(), frame.getHeight());
        frame.add(backgroundImage);

        //puts the window into the middle of the screen
        frame.setLocationRelativeTo(null);
        //stops from changing frame window
        frame.setResizable(false);
        //turns on the window
        frame.setVisible(true);

    }
}
