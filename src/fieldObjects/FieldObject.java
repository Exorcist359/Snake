package fieldObjects;
import logic.Model;
import logic.Point;

public abstract class FieldObject{
    public int x;
    public int y;
    public Point position;

    public abstract boolean isWalkable();
    public abstract boolean isActive();
    
    public FieldObject(int x, int y){
        this.x = x;
        this.y = y;
        position = new Point(x,y);
    }
    
    public FieldObject(Point position){
        this.x = position.x;
        this.y = position.y;
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
