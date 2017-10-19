package fieldObjects;

import logic.SnakeDirection;
import logic.Game; // change to static class
import logic.Point;

public class SnakeHead extends SnakePart {

    public SnakeDirection direction;
    private int width;
    private int height;

    public SnakeHead(int x, int y, SnakeDirection direction, int height, int width) {
		super(x, y);
		this.direction = direction;
		this.width = width;
		this.height = height;
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
        if (!isDead())
    	    position = getPositionAfterMovement(direction, position);
    }

    private Point getPositionAfterMovement(SnakeDirection direction, Point from)
    {
        int newX = from.x;
        int newY = from.y;
        if (direction == SnakeDirection.Left)
            newX = (newX - 1 + width) % width;
        if (direction == SnakeDirection.Right)
            newX = (newX + 1) % width;
        if (direction == SnakeDirection.Up)
            newY = (newY - 1 + height) % height;
        if (direction == SnakeDirection.Down)
            newY = (newY + 1) % height;
        return new Point(newX, newY);
    }
}
