package fieldObjects;

import logic.Point;

public class SnakePart extends FieldObject {
    private SnakePart previous;
    private SnakePart next;
    private boolean isDead = false;
    public Point previousPosition;

    public SnakePart(int x, int y) {
        super(new Point(x, y));
    }
    
    public SnakePart(Point position, SnakePart previous) {
        super(position);
        this.previous = previous;
    }
    
    public SnakePart getNext() {
        return next;
    }
    
    public void setNext(SnakePart next) {
        this.next = next;
    }
    
    public SnakePart getPrevious() {
        return previous;
    }

    public void setPrevious(SnakePart previous) {
        this.previous = previous;
    }
    
    public boolean isDead() {
        return isDead;
    }

    public void die() {
        isDead = true;
    }
    
    @Override
    public boolean isWalkable() {
        return false;
    }
    
    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void tick() {
        if (!isDead) {
            previousPosition = position;
            this.position = previous.previousPosition;
        }
    }
}