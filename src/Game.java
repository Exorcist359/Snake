import fieldObjects.*;
import levels.Level;

import java.util.Timer;
import java.util.TimerTask;

//somethings
public class Game {
    private FieldObject[][] field;
    private int height;
    private int width;

    public Game(Level level){
        field = level.field;//??? Think about Level
        height = level.height;//get from Level??
        width = level.width;//get from Level too
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
