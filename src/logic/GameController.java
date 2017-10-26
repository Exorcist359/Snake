package logic;

import fieldObjects.*;

import java.util.ArrayList;

public class GameController {
    public final int fieldHeight;
    public final int fieldWidth;
    public final ArrayList<Snake> snakes;
    private GameModel gameModel;
    private int SEED = 4;
    
    public GameController() {
        FieldGenerator generator = new FieldGenerator();
        Field field = generator.generate(SEED);
        fieldHeight = field.height;
        fieldWidth = field.width;
        gameModel = new GameModel(field);
        snakes = gameModel.getSnakes();
    }
    
    public void tick() {
        gameModel.tick();
    }

    public boolean isGameOver() {
        return gameModel.getSnakes().get(0).isDead();
    }
    

    public ArrayList<FieldObject> getAllObjects() {
        return new ArrayList<FieldObject>(gameModel.getField().getAllObjects());
    }

    public ArrayList<Wall> getWalls() {
        ArrayList<Wall> walls = new ArrayList<>();
        gameModel.getField().getAllObjects().forEach(fieldObject -> {
            if (fieldObject instanceof Wall) walls.add((Wall) fieldObject);
        });
        return walls;
    }

    public ArrayList<Apple> getApples() {
        ArrayList<Apple> apples = new ArrayList<>();
        gameModel.getField().getAllObjects().forEach(fieldObject -> {
            if (fieldObject instanceof Apple) apples.add((Apple) fieldObject);
        });
        return apples;
    }

    public ArrayList<SnakePart> getSnakeParts() {
        ArrayList<SnakePart> snakeParts = new ArrayList<>();
        gameModel.getField().getAllObjects().forEach(fieldObject -> {
            if (fieldObject instanceof SnakePart) snakeParts.add((SnakePart) fieldObject);
        });
        return snakeParts;
    }

    public ArrayList<SnakeHead> getSnakeHeads() {
        ArrayList<SnakeHead> snakeHeads = new ArrayList<>();
        gameModel.getField().getAllObjects().forEach(fieldObject -> {
            if (fieldObject instanceof SnakeHead) snakeHeads.add((SnakeHead) fieldObject);
        });
        return snakeHeads;
    }
}
