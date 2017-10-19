package fieldObjects;

import logic.SnakeDirection;
import logic.Point;
import logic.Logic;
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
    public boolean isWalkable()
    {
    	return false;
    }

    @Override
    public boolean isActive() {
        return true;
    }    

    @Override
    public void tick(){
    	position = Logic.getPositionAfterMovement(direction, position, field);
    }

    
}
