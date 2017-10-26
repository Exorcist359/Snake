package logic;

import fieldObjects.SnakeHead;

public class Snake {
    private SnakeHead snakeHead;
    public Snake(SnakeHead snakeHead) {
        this.snakeHead = snakeHead;
    }

    public boolean isDead() {
        return snakeHead.isDead();
    }

    public int getScore() {
        //TODO
        return 1;
    }
    
    public boolean tryChangeSnakeDirection(SnakeDirection dir) {
        if (!SnakeDirection.isOppositeDirection(snakeHead.getDirection(), dir)) {
            snakeHead.setDirection(dir);
            return true;
        }
        return false;
    }

}
