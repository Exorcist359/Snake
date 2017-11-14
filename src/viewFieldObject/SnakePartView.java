package viewFieldObject;

import fieldObjects.SnakePart;

public class SnakePartView extends FieldObjectView {
    public SnakePartView(SnakePart snakePart) {
        super(snakePart);
    }

    public SnakeHeadView getHead() {
        SnakePart part = (SnakePart) source;
        return (SnakeHeadView)part.getHead().getWrapper();
    }
}
