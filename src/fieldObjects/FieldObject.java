package fieldObjects;
import logic.Field;

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

    public void interactWithSnake(SnakeHead snakeHead, Field field)
    {
    	if (!isWalkable())
    	{
    		field.killSnake(snakeHead);
    	}
    }
    
    public abstract void tick();

}
