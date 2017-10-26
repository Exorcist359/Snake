package fieldObjects;

import logic.SnakeDirection;
import logic.MovementLogic;
import logic.Field;

public class SnakeHead extends SnakePart {
    public SnakeDirection direction;
    private Field field;

    public SnakeHead(int x, int y, SnakeDirection direction, Field field) {
        super(x, y);
        this.direction = direction;
        this.field = field;
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
        previousPosition = position;
        position = MovementLogic.getPositionAfterMovement(direction, position, field);
    }

}
