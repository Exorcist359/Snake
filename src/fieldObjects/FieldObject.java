package fieldObjects;

public abstract class FieldObject{
    public int x;
    public int y;
    public Point position;

    public FieldObject(int x, int y){
        this.x = x;
        this.y = y;
        position = new Point(x,y);
    }

    public abstract void interactWithSnake();
    
    public abstract void tick();

}
