package fieldObjects;
import logic.Field;

public class Apple extends FieldObject{

    private boolean isActive = true;

	public Apple(int x, int y) {
		super(x, y);
	}

    public void interactWithSnake(SnakeHead snakeHead, Field field){
        field.generateApple();
        field.increaseSnake(snakeHead);
        isActive = false;
    }
	
    @Override
    public boolean isWalkable()
    {
    	return true;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void tick(){
    }
}
