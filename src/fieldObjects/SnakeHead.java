package fieldObjects;

import logic.SnakeDirection;
import logic.Game; // change to static class

public class SnakeHead extends SnakePart {

    public SnakeDirection direction;

    public SnakeHead(int x, int y, SnakeDirection direction) {
		super(x, y);
		this.direction = direction;
	}

    @Override
    public void interactWithSnake(){
    	//TODO
    }
    
    @Override
    public void tick(){
    	position = Game.getPositionAfterMovement(direction, position);
    }
}
