package logic;

import fieldObjects.*;

import java.util.ArrayList;

public class GameController {
    private FieldWrapper wrapper;
    public final ArrayList<Snake> snakes;
    private GameModel gameModel;
    private int SEED = 5;

    public GameController() {
        FieldGenerator generator = new FieldGenerator();
        Field field = generator.generate(SEED);
        wrapper = new FieldWrapper(field);
        gameModel = new GameModel(field);
        snakes = gameModel.getSnakes();
    }

    public void tick() {
        gameModel.tick();
    }

    public boolean isGameOver() {
        return gameModel.getSnakes().get(0).isDead();
    }

    public FieldWrapper getFieldWrapper() {
        return wrapper;
    }
}