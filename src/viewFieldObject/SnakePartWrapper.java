package viewFieldObject;

import fieldObjects.SnakePart;

public class SnakePartWrapper extends FieldObjectWrapper {
    public SnakePartWrapper(SnakePart snakePart) {
        super(snakePart);
    }

    public SnakeHeadWrapper getHead() {
        SnakePart part = (SnakePart) source;
        return (SnakeHeadWrapper)part.getHead().getWrapper();
    }
}
