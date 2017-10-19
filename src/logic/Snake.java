package logic;

import fieldObjects.SnakeHead;

public class Snake {
    private SnakeHead snakeHead;
    public Snake(SnakeHead snakeHead){
        this.snakeHead = snakeHead;
    }

    public int getScore() {
    	//TODO
    	return 1;
    }
    
    public boolean tryChangeSnakeDirection(SnakeDirection dir){
        if (!Logic.isOppositeDirection(snakeHead.direction, dir)){
            snakeHead.direction = dir;
            return true;
        }
        return false;
    }

}
