package logic;

import java.util.ArrayList;
import java.util.Random;

import fieldObjects.*;

public class Model {
	private Field field;
	public ArrayList<Snake> snakes;
	public ArrayList<SnakeHead> snakeHeads;

	public Model(Field field, ArrayList<Snake> snakes) {
		this.snakes = snakes;
		this.field = field;
	}

	public void tick() {
		field.allObjects.forEach(fieldObject -> fieldObject.tick());
		
		snakeHeads.forEach(head -> {
			field.allObjects.forEach(obj -> {
				if (head != obj)
					obj.interactWithSnake(head, this);
			});
		});
		
		field.allObjects.removeIf(obj -> !obj.isActive());
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
		Point position = Logic.getRandomFreePosition(field);
		field.allObjects.add(new Apple(position));
	}
	
	public void increaseSnake(SnakeHead snakeHead) {
		SnakePart tail = getLastSnakePart(snakeHead);
		SnakePart newPart = new SnakePart(tail.position, tail);
		tail.next = newPart;
		field.allObjects.add(newPart);
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
