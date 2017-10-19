package logic;

import java.util.ArrayList;
import java.util.Random;

import fieldObjects.*;

public class Model {
	public Field field;
	public ArrayList<Snake> snakes;
	public ArrayList<SnakeHead> snakeHeads;

	public Model(Field field) {
		this.field = field;
		snakes = new ArrayList<Snake>();
		ArrayList<FieldObject> all;
		field.allObjects.forEach(obj -> 
		{
			if (obj instanceof SnakeHead)
				snakes.add(new Snake((SnakeHead)obj));
		});
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

	public void killSnake(SnakeHead snakeHead) {
		killAllSnakePartsFromHead(snakeHead);
	}

	public void generateApple() {
		Point position = field.getRandomFreePosition();
		field.allObjects.add(new Apple(position));
	}
	
	public void increaseSnake(SnakeHead snakeHead) {
		SnakePart tail = getLastSnakePart(snakeHead);
		SnakePart newPart = new SnakePart(tail.position, tail);
		tail.next = newPart;
		field.allObjects.add(newPart);
	}
	
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
