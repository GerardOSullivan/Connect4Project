package Connect4;

public class Game {
    public static void main(String[] args) {

        System.out.println(whoGoesFirst());
        System.out.println(whoGoesFirst());
        System.out.println(whoGoesFirst());
        System.out.println(whoGoesFirst());
        System.out.println(whoGoesFirst());
    }

    public static int whoGoesFirst()
    {
        return (int)(Math.random()*2)+1;
    }
}
