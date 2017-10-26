package fieldObjects;
import logic.GameModel;
import logic.Point;

public abstract class FieldObject{

    public Point position;

    public abstract boolean isWalkable();
    public abstract boolean isActive();
    
    public FieldObject(Point position) {
        this.position = position;
    }

    public void interactWithSnake(SnakeHead snakeHead, GameModel gameModel) {
        if (!isWalkable()) {
            gameModel.killSnake(snakeHead);
        }
    }
    
    public abstract void tick();

}
