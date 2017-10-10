import fieldObjects.*;
import levels.Level;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;

public class Game {

    //public FieldObject[][] field;
    public final int height;
    public final int width;
    private ArrayList<Wall> walls;
    private ArrayList<SnakePart> snake;
    private SnakeDirection direction;
	private SnakeHead head;
	private Apple apple;
	private boolean gameOver = false;
    
    public Game(Level level) throws Exception{
        //field = level.field;
        height = level.height;
        width = level.width;
        if (height < 2 || width < 2)
        	throw new Exception("Field is too small");
        walls = level.field;
        putSnake();
        putApple();
    }
    
    public void tick() {
        moveSnake();
    }

	public void turn(SnakeDirection dir) {
    	direction = dir;
    }
	
	public ArrayList<FieldObject> getAllObjects() {
		ArrayList<FieldObject> all = new ArrayList<FieldObject>(walls);
		all.addAll(snake);
		all.add(apple);
		return all;
	}
	
	private boolean isPositionFree(Point pos) {
		ArrayList<FieldObject> all = getAllObjects();
		for (int i = 0; i < all.size(); i++) {
			FieldObject obj = all.get(i);
			if (obj.row == pos.y && obj.column == pos.x)
			{
				return false;
			}
		}
		return true;
	}
	
    private Point generateFreePosition()
    {
		Random rnd = new Random();
    	while (true)
    	{
    		int row = rnd.nextInt(height);
    		int column = rnd.nextInt(width);
    		Point point = new Point(column, row);
    		if (isPositionFree(point))
    		{	
    			return point;
    		}
    	}
	}
    
    private void putSnake() {
		Point newPos = generateFreePosition();
    	if (newPos.x > width - newPos.x + 1)
			direction = SnakeDirection.Right;
		else
			direction = SnakeDirection.Left;
		head = new SnakeHead(newPos.x, newPos.y);
		snake.add(head);
	}
    
    private void moveSnake() {
    	Point newHeadPos = getPositionAfterMovement(
    			direction, new Point(head.column, head.row));
    	if (isAppleOnPosition(newHeadPos))
    	{
    		eatApple();
    	}
    	head.column = newHeadPos.x;
    	head.row = newHeadPos.y;
    	moveSnakeSteply();	
    }

    private Point getPositionAfterMovement(SnakeDirection direction, Point from)
    {
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

    private void moveSnakeSteply() {
		for (int i = snake.size() - 1; i > 0; i++)
    	{
    		snake.get(i).row = snake.get(i - 1).row;
    		snake.get(i).column = snake.get(i - 1).column;
    	}
	}

	private boolean isAppleOnPosition(Point newPos) {
		return newPos.x == apple.column && newPos.y == apple.row; 
	}

	private void eatApple() {
		snake.add(new SnakePart(
				snake.get(snake.size()-1).column, 
				snake.get(snake.size()-1).row));
		putApple();
	}

	private void putApple() {
		Point newPos = generateFreePosition();
		apple = new Apple(newPos.x, newPos.y);
	}
    
	public boolean isGameOver(){
        return gameOver;
    }
    
    public int getPoints() {
    	return snake.size() - 1;
    }

    public ArrayList<SnakePart> getSnake()
    {
    	return snake;
    }

    public Apple getApple() {
    	return apple;
    }
    
    public SnakeHead getSnakeHead() {
    	return head;
    }
    
    public ArrayList<Wall> getWalls() {
    	return walls;
    }
}
