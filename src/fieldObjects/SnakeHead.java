package fieldObjects;

import logic.GameModel;
import logic.SnakeDirection;
import logic.Field;
import viewFieldObject.SnakeHeadView;

public class SnakeHead extends SnakePart {
    private SnakeDirection direction;
    private Field field;

    public SnakeHead(int x, int y, SnakeDirection direction, Field field) {
        super(x, y);
        this.direction = direction;
        this.field = field;
    }
    
    public SnakeDirection getDirection() {
        return direction;
    }
    
    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    @Override
    protected SnakeHeadView CreateWrapper() {
        return new SnakeHeadView(this);
    }

    @Override
    public boolean isWalkable() {
        return false;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void tick() {
        if (!isDead()) {
            previousPosition = position;
            position = field.getPositionAfterMovement(direction, position);
        }
    }

    @Override
    public void interactWithSnake(SnakeHead snakeHead, GameModel gameModel) {
        gameModel.killSnake(this);
        gameModel.killSnake(snakeHead);
    }
}
