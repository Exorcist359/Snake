package logic;

import fieldObjects.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    public final int height;
    public final int width;
    private ArrayList<Wall> walls;
    private ArrayList<SnakePart> snake;
    private SnakeDirection direction;
	private SnakeHead head;
	private Apple apple;
	private boolean gameOver = false;
	private int SEED = 4;
    
    public Game(LevelGenerator generator) throws Exception{
    	Level level = generator.generate(SEED);
        height = level.height;
        width = level.width;
        if (height < 2 || width < 2)
        	throw new Exception("Field is too small");
        walls = level.field.getWalls();
    }
    
    public void tick() {
        moveSnake();
    }

	private ArrayList<FieldObject> getAllObjects() {
		ArrayList<FieldObject> all = new ArrayList<FieldObject>(walls);
		all.addAll(snake);
		//если добавить объекты будет много if(obj==null)
		if (apple != null)
			all.add(apple);
		return all;
	}

	private boolean isPositionFree(Point pos) {
		ArrayList<FieldObject> all = getAllObjects();
		for (int i = 0; i < all.size(); i++) {
			FieldObject obj = all.get(i);
			if (obj.y == pos.y && obj.x == pos.x)
			{
				return false;
			}
		}
		return true;
	}
	//TODO
    private Point getRandomFreePosition()
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
 	//Завязан только со змеей comment

    private void moveSnake() {
    	Point newHeadPos = getPositionAfterMovement(
    			direction, new Point(head.x, head.y));
    	moveSnakeSteply();
    	if (!isPositionFree(newHeadPos)) {
    		if (isAppleOnPosition(newHeadPos))
    		{
    			eatApple();
    		}
    		else
    		{
    			gameOver = true;
    		}
    	}
    	head.x = newHeadPos.x;
    	head.y = newHeadPos.y;
    }

    private void moveSnakeSteply() {
		for (int i = snake.size() - 1; i > 0; i--)
    	{
    		snake.get(i).y = snake.get(i - 1).y;
    		snake.get(i).x = snake.get(i - 1).x;
    	}
	}

	private boolean isAppleOnPosition(Point newPos) {
		return newPos.x == apple.x && newPos.y == apple.y; 
	}

	private void eatApple() {
		snake.add(new SnakePart(
				snake.get(snake.size()-1).x, 
				snake.get(snake.size()-1).y,snake.get(snake.size()-1)));
		putApple();
	}

	private void putApple() {
		Point newPos = getRandomFreePosition();
		apple = new Apple(newPos.x, newPos.y);
	}
    
	public boolean isGameOver(){
        return gameOver;
    }
    
    public int getScore() {
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
