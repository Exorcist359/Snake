package fieldObjects;
import logic.Model;
import logic.Point;

public class Apple extends FieldObject{

    private boolean isActive = true;

	public Apple(int x, int y) {
		super(x, y);
	}

	public Apple(Point position) {
		super(position);
	}
	
    public void interactWithSnake(SnakeHead snakeHead, Model model){
        model.generateApple();
        model.increaseSnake(snakeHead);
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
