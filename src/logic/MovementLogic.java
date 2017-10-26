package logic;

public class MovementLogic {
	public static Point getPositionAfterMovement(SnakeDirection direction, Point from, Field field) {
        int height = field.height;
        int width = field.width;
        int newX = from.x;
        int newY = from.y;
        if (direction == SnakeDirection.Left)
            newX = (newX - 1 + width) % width;
        if (direction == SnakeDirection.Right)
            newX = (newX + 1) % width;
        if (direction == SnakeDirection.Up)
            newY = (newY - 1 + height) % height;
        if (direction == SnakeDirection.Down)
            newY = (newY + 1) % height;
        return new Point(newX, newY);
    }
}
