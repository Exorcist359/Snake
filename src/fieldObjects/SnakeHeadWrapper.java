package fieldObjects;

import logic.Snake;
import logic.SnakeDirection;

public class SnakeHeadWrapper extends SnakePartWrapper {
    public SnakeHeadWrapper(SnakeHead snakeHead) {
        super(snakeHead);
    }

    public SnakeDirection getDirection() {
        SnakeHead head = (SnakeHead)source;
        return head.getDirection();
    }
}
