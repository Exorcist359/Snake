package logic;

import fieldObjects.SnakeHead;

public class Snake {
    private SnakeHead snakeHead;
    public Snake(SnakeHead snakeHead){
        this.snakeHead = snakeHead;
    }

    private static boolean isOppositeDirection(SnakeDirection first_dir, SnakeDirection second_dir){
        return (first_dir == SnakeDirection.Down && second_dir == SnakeDirection.Up) ||
                (first_dir == SnakeDirection.Up && second_dir == SnakeDirection.Down)||
                (first_dir == SnakeDirection.Right && second_dir == SnakeDirection.Left)||
                (first_dir == SnakeDirection.Left && second_dir == SnakeDirection.Right);
    }

    public boolean tryChangeSnakeDirection(SnakeDirection dir){
        if (!isOppositeDirection(snakeHead.direction, dir)){
            snakeHead.direction = dir;
            return true;
        }
        return false;
    }
}
