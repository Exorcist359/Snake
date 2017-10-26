package fieldObjects;
import logic.GameModel;
import logic.Point;

public class Apple extends FieldObject{

    private boolean isActive = true;

    public Apple(int x, int y) {
        super(new Point(x, y));
    }

    public Apple(Point position) {
        super(position);
    }
    
    public void interactWithSnake(SnakeHead snakeHead, GameModel gameModel) {
        gameModel.generateApple();
        gameModel.increaseSnake(snakeHead);
        isActive = false;
    }
    
    @Override
    public boolean isWalkable() {
        return true;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void tick(){
    }
}
