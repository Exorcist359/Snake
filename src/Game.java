import fieldObjects.*;
import levels.Level;

import java.util.Timer;
import java.util.TimerTask;


public class Game {
    private static FieldObject[][] field;
    private static int height;
    private static int width;

    public Game(int seed){
        field = Level.getLevel(seed);//??? Think about Level
        height = 8;//get from Level??
        width = 10;//get from Level too
        startGame();
    }

    private static void startGame(){
        GUI gui = new GUI();

        Timer t = new Timer();

        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("GG");
                tick();
                if(gameOver() == true)
                    t.cancel();

            }
        }, 0 , 1*1000);
    }

    public static void tick() {
        //something

    }

    public static boolean gameOver(){
        return false;
    }
}
