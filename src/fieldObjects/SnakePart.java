package fieldObjects;

import logic.Point;

public class SnakePart extends FieldObject {

	public SnakePart previous;
	public SnakePart next;
    private boolean isDead = false;
	
	public SnakePart(int x, int y, SnakePart previous) {
		super(x, y);
		this.previous = previous;
	}

	public SnakePart(int x, int y) {
		super(x, y);
	}
	
	public SnakePart(Point position, SnakePart previous) {
		super(position);
		this.previous = previous;
	}

    public boolean isDead()
    {
    	return isDead;
    }

    public void die()
    {
    	isDead = true;
    }
	
	@Override
	public boolean isWalkable()
	 {
		 return false;
	 }
	
	@Override
	public boolean isActive() {
		return true;
	}

    @Override
    public void tick(){
    	if (!isDead)
			this.position = previous.position;
    }
}
