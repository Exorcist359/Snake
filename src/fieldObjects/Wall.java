package fieldObjects;

import logic.Point;
import viewFieldObject.WallView;

public class Wall extends FieldObject {
    public Wall(int x, int y) {
        super(new Point(x, y));
    }

    @Override
    protected WallView CreateWrapper() {
        return new WallView(this);
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
