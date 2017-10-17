package logic;

import java.util.ArrayList;
import fieldObjects.*;

public class Field {
	private ArrayList<FieldObject> allObjects;
	
	public Field(ArrayList<FieldObject> allObjects) {
		this.allObjects = allObjects;
	}
	
	public void tick() {
		allObjects.forEach(fieldObject -> fieldObject.tick());
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

}