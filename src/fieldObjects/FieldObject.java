package fieldObjects;
import logic.GameModel;
import logic.Point;
import viewFieldObject.FieldObjectView;

public abstract class FieldObject {
    protected Point position;
    protected FieldObjectView wrapper;

    public FieldObject(Point position) {
        this.position = position;
        wrapper = CreateWrapper();
    }

    public abstract boolean isWalkable();
    public abstract boolean isActive();

    public Point getPosition() {
        return position;
    }

    public FieldObjectView getWrapper() {
        return wrapper;
    }

    public void interactWithSnake(SnakeHead snakeHead, GameModel gameModel) {
        if (!isWalkable()) {
            gameModel.killSnake(snakeHead);
        }
    }
    
    public abstract void tick();
    protected abstract FieldObjectView CreateWrapper();
}
