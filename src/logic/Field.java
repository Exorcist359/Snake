package logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import fieldObjects.*;

public class Field {
	private ArrayList<FieldObject> allObjects;
	public ArrayList<Snake> snakes;
	public ArrayList<SnakeHead> snakeHeads;

	public Field(ArrayList<FieldObject> allObjects, ArrayList<Snake> snakes) {
		this.snakes = snakes;
		this.allObjects = allObjects;
	}

	public void tick() {
		allObjects.forEach(fieldObject -> fieldObject.tick());
		
		snakeHeads.forEach(head -> {
			allObjects.forEach(obj -> {
				if (head != obj)
					obj.interactWithSnake(head, this);
			});
		});
		
		allObjects.removeIf(obj -> !obj.isActive());
	}
		
	public ArrayList<Wall> getWalls()
	{
		ArrayList<Wall> walls = new ArrayList<>();
		allObjects.forEach(fieldObject -> {
			if (fieldObject instanceof Wall) walls.add((Wall) fieldObject);
		});
		return walls;
	}

	public ArrayList<Apple> getApples()
	{
		ArrayList<Apple> apples = new ArrayList<>();
		allObjects.forEach(fieldObject -> {
			if (fieldObject instanceof Apple) apples.add((Apple) fieldObject);
		});
		return apples;
	}
	
	public ArrayList<SnakePart> getSnakeParts()
	{
		ArrayList<SnakePart> snakeParts = new ArrayList<>();
		allObjects.forEach(fieldObject -> {
			if (fieldObject instanceof SnakePart) snakeParts.add((SnakePart) fieldObject);
		});
		return snakeParts;
	}
	
	public ArrayList<SnakeHead> getSnakeHeads()
	{
		ArrayList<SnakeHead> snakeHeads = new ArrayList<>();
		allObjects.forEach(fieldObject -> {
			if (fieldObject instanceof SnakeHead) snakeHeads.add((SnakeHead) fieldObject);
		});
		return snakeHeads;
	}

	public void killSnake(SnakeHead snakeHead) {
		killAllSnakePartsFromHead(snakeHead);
	}

	public void generateApple() {
		Point position = getRandomFreePosition();
		allObjects.add(new Apple(position));
	}
	
	 //to logic ?
    private Point getRandomFreePosition()
    {
    	ArrayList<Point> allPoints = getAllPoints();
		ArrayList<Point> freePoints = getFreePoints(allPoints);
    	
    	Random rnd = new Random();
    	int index = rnd.nextInt(freePoints.size());
    	return freePoints.get(index);
	}
	
    private ArrayList<Point> getFreePoints(ArrayList<Point> allPoints) {
    	ArrayList<Point> freePoints = new ArrayList<Point>();
		for (int i = 0; i < allPoints.size(); i++)
		{
			Point point = allPoints.get(i);
			boolean free = true;
			for(int j = 0; j < allObjects.size(); j++)
			{
				FieldObject obj = allObjects.get(j);
				if (obj.equals(point))
				{
					free = false;
					break;
				}
			}
			if (free)
				freePoints.add(point);
		}
		return freePoints;
	}

	private ArrayList<Point> getAllPoints()
    {
    	ArrayList<Point> allPoints = new ArrayList<Point>();
    	for (int x = 0; x < width; x++)
    	{
    		for (int y = 0; y < height; y++)
    		{
    			allPoints.add(new Point(x,y));
    		}
    	}
    	return allPoints;
    }
    
	public void increaseSnake(SnakeHead snakeHead) {
		SnakePart tail = getLastSnakePart(snakeHead);
		SnakePart newPart = new SnakePart(tail.position, tail);
		tail.next = newPart;
		allObjects.add(newPart);
	}
	
	//to Logic
	private SnakePart getLastSnakePart(SnakeHead snakeHead) {
		SnakePart current = snakeHead;
		while(true)
		{
			if (current.next == null)
				return current;
			current = current.next;
		}
	}
	
	private void killAllSnakePartsFromHead(SnakeHead snakeHead) {
		SnakePart current = snakeHead;
		while(true)
		{
			if (current.next == null)
				break;
			current.die();
			current = current.next;
		}
	}
}
