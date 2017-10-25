package logic;

public class Logic {
    public static boolean isOppositeDirection(SnakeDirection first_dir, SnakeDirection second_dir){
        return (first_dir == SnakeDirection.Down && second_dir == SnakeDirection.Up) ||
                (first_dir == SnakeDirection.Up && second_dir == SnakeDirection.Down)||
                (first_dir == SnakeDirection.Right && second_dir == SnakeDirection.Left)||
                (first_dir == SnakeDirection.Left && second_dir == SnakeDirection.Right);
    }

    public static Point getPositionAfterMovement(SnakeDirection direction, Point from, Field field)
    {
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
