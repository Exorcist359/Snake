package fieldObjects;

public abstract class FieldObject{
    public int x;
    public int y;
    public Point position;

    public abstract boolean isWalkable();
    
    public FieldObject(int x, int y){
        this.x = x;
        this.y = y;
        position = new Point(x,y);
    }

    public void interactWithSnake(SnakeHead snakeHead)
    {
    	if (!isWalkable())
    	{
    		snakeHead.die();
    	}
    }
    
    public abstract void tick();

}
