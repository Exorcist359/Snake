package viewFieldObject;

import fieldObjects.SnakeHead;
import logic.SnakeDirection;

public class SnakeHeadView extends SnakePartView {
    public SnakeHeadView(SnakeHead snakeHead) {
        super(snakeHead);
    }

    public SnakeDirection getDirection() {
        SnakeHead head = (SnakeHead)source;
        return head.getDirection();
    }
}
