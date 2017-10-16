import java.util.ArrayList;
import fieldObjects.*;

public class Field {
	private ArrayList<ArrayList<FieldObject>> all;
	private ArrayList<Wall> walls;
	private ArrayList<Apple> apples;
	private ArrayList<SnakePart> snakeParts;
	private ArrayList<SnakeHead> snakeHeads;
	
	public Field() {
		
	}
	
	public void tick() {
		all.forEach(list -> {
			list.forEach(fieldObject -> fieldObject.tick());
		});
	}	
	
	public void setWalls(ArrayList<Wall> walls)
	{
		this.walls = walls;
		all.add(walls);
	}

	public void setApples(ArrayList<Apple> apples)
	{
		this.apples = apples;
		all.add(apples);
	}
	
	public void setSnakeParts(ArrayList<SnakePart> snakeParts)
	{
		this.snakeParts = snakeParts;
		all.add(snakeParts);
	}
	
	public void setSnakeHeads(ArrayList<SnakeHead> snakeHeads)
	{
		this.snakeHeads = snakeHeads;
		all.add(snakeHeads);
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
