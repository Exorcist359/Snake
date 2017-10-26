package fieldObjects;

import logic.Point;

public class Wall extends FieldObject {

    public Wall(int x, int y) {
        super(new Point(x, y));
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
    }
}
