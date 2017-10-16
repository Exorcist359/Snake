package logic;

import java.util.ArrayList;
import fieldObjects.*;

public class Field {
	private ArrayList<ArrayList<FieldObject>> allObjects;
	private ArrayList<Wall> walls;
	private ArrayList<Apple> apples;
	private ArrayList<SnakePart> snakeParts;
	private ArrayList<SnakeHead> snakeHeads;
	
	public Field(ArrayList<ArrayList<FieldObject>> allObjects) {
		this.allObjects = allObjects;
	}
	
	public void tick() {
		allObjects.forEach(list -> {
			list.forEach(fieldObject -> fieldObject.tick());
		});
	}	
		
	public ArrayList<Wall> getWalls()
	{
		return walls;
	}

	public ArrayList<Apple> getApples()
	{
		return apples;
	}
	
	public ArrayList<SnakePart> getSnakeParts()
	{
		return snakeParts;
	}
	
	public ArrayList<SnakeHead> getSnakeHeads()
	{
		return snakeHeads;
	}

}
