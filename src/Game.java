import fieldObjects.*;
import levels.Level;

import java.util.Timer;
import java.util.TimerTask;

//somethings
public class Game {
    private FieldObject[][] field;
    private int height;
    private int width;

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
                System.out.println("GG");//for del
                tick();
                if(gameOver() == true)
                    t.cancel();

            }
        }, 0 , 1*1000);
    }

    public void tick() {
        //something

    }
    
    public void turn(SnakeDirection dir) {
    	
    }

    public boolean gameOver(){
        return false;
    }
}
