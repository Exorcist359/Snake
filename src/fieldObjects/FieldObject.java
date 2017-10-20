package fieldObjects;
import logic.Model;
import logic.Point;

public abstract class FieldObject{

    public Point position;

    public abstract boolean isWalkable();
    public abstract boolean isActive();
    
    public FieldObject(Point position){
        this.position = position;
    }

    public void interactWithSnake(SnakeHead snakeHead, Model model)
    {
    	if (!isWalkable())
    	{
    		model.killSnake(snakeHead);
    	}
    }
    
    public abstract void tick();

}
