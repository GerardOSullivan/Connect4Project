package Connect4;

public class Game{
    public static Counter red =new Counter("Red");
    public static Counter yellow = new Counter("yellow");

    public static void main(String[] args) {

       Frame board = new Frame();
       Audio backgroundMusic=new Audio();
       backgroundMusic.playAudio("C:\\Users\\Gerard\\IdeaProjects\\Connect4Project\\Connect4\\Sounds\\BackgroundMusic.wav");
    }

    public static Counter getRed() {
        return red;
    }

    public static Counter getYellow() {
        return yellow;
    }
}
