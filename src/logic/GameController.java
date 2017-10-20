package logic;

import fieldObjects.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class GameController {
    public final int fieldHeight;
    public final int fieldWidth;
	public final ArrayList<Snake> snakes;
    private Model model;
    private int SEED = 4;
    
    public GameController() {
    	FieldGenerator generator = new FieldGenerator();
    	Field field = generator.generate(SEED);
        fieldHeight = field.height;
        fieldWidth = field.width;
        model = new Model(field);
        snakes = model.snakes;
    }
    
    public void tick() {
    	model.tick();
    }

	public boolean isGameOver(){
        return model.snakes.get(0).isDead();
    }
    

    public ArrayList<FieldObject> getAllObjects()
    {
    	return new ArrayList<FieldObject>(model.field.allObjects);
    }

    public ArrayList<Wall> getWalls()
    {
        ArrayList<Wall> walls = new ArrayList<>();
        model.field.allObjects.forEach(fieldObject -> {
            if (fieldObject instanceof Wall) walls.add((Wall) fieldObject);
        });
        return walls;
    }

    public ArrayList<Apple> getApples()
    {
        ArrayList<Apple> apples = new ArrayList<>();
        model.field.allObjects.forEach(fieldObject -> {
            if (fieldObject instanceof Apple) apples.add((Apple) fieldObject);
        });
        return apples;
    }

    public ArrayList<SnakePart> getSnakeParts()
    {
        ArrayList<SnakePart> snakeParts = new ArrayList<>();
        model.field.allObjects.forEach(fieldObject -> {
            if (fieldObject instanceof SnakePart) snakeParts.add((SnakePart) fieldObject);
        });
        return snakeParts;
    }

    public ArrayList<SnakeHead> getSnakeHeads()
    {
        ArrayList<SnakeHead> snakeHeads = new ArrayList<>();
        model.field.allObjects.forEach(fieldObject -> {
            if (fieldObject instanceof SnakeHead) snakeHeads.add((SnakeHead) fieldObject);
        });
        return snakeHeads;
    }
}
