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
    
    public GameController() {
    	FieldGenerator generator = new FieldGenerator();
    	Field field = generator.generate(1);
        fieldHeight = field.height;
        fieldWidth = field.width;
        model = new Model(field);
        snakes = model.snakes;
    }
    
    public void tick() {
    	model.tick();
    }

	public boolean isGameOver(){
		//TODO
        return false;
    }
    

    public ArrayList<FieldObject> getAllObjects()
    {
    	return model.field.allObjects;
    }

/*
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
    }*/
}
