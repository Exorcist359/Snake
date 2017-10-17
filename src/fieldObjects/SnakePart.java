package fieldObjects;

public class SnakePart extends FieldObject {

	public SnakePart previous;
	public SnakePart next;
	
	public SnakePart(int x, int y, SnakePart previous) {
		super(x, y);
	}

	@Override
    public void interactWithSnake(){
    	//TODO
    }
    
    @Override
    public void tick(){
    	this.position = previous.position;
    }
}
