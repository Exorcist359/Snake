package fieldObjects;

public class Apple extends FieldObject{

	public Apple(int x, int y) {
		super(x, y);
	}

    public void interactWithSnake(){
    	//TODO
    }
	
    @Override
    public boolean isWalkable()
    {
    	return true;
    }
    
    @Override
    public void tick(){
    }
}
