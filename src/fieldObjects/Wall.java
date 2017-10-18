package fieldObjects;

public class Wall extends FieldObject {

    public Wall(int x, int y) {
		super(x, y);
	}

    @Override
    public boolean isWalkable()
    {
    	return false;
    }

    @Override
    public void tick(){
    }
}
