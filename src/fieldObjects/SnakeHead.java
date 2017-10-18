package fieldObjects;

import logic.SnakeDirection;
import logic.Game; // change to static class

public class SnakeHead extends SnakePart {

    public SnakeDirection direction;
    private int width;
    private int height;

    public SnakeHead(int x, int y, SnakeDirection direction, int width, int height) {
		super(x, y);
		this.direction = direction;
		this.width = width;
		this.height = height;
	}

    @Override
    public void interactWithSnake(){
    	//TODO
    }
    
    @Override
    public void tick(){
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
