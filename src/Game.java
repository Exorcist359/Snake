import fieldObjects.*;
import levels.Level;

import java.util.Timer;
import java.util.TimerTask;

//somethings
public class Game {
    private FieldObject[][] field;
    private int height;
    private int width;

    public Game(Level lvl){
        //field = Level.getLevel(seed);//??? Think about Level
        height = 8;//get from Level??
        width = 10;//get from Level too
        startGame();
    }
    
    private static void startGame(){


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
