package viewFieldObject;

import fieldObjects.FieldObject;
import logic.Point;

public abstract class FieldObjectView {
    protected FieldObject source;

    public FieldObjectView(FieldObject obj) {
        source = obj;
    }

    public boolean isWalkable() {
        return source.isWalkable();
    }

    public boolean isActive() {
        return source.isActive();
    }

    public Point getPosition() {
        return source.getPosition();
    }
}