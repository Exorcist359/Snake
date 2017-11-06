package logic;

import fieldObjects.*;

import java.util.ArrayList;

public class FieldWrapper {
    private Field field;

    public FieldWrapper(Field field) {
        this.field = field;
    }

    public int getWidth() {
        return  field.width;
    }

    public int getHeight() {
        return  field.height;
    }

    public ArrayList<FieldObject> getAllObjects() {
        return new ArrayList<FieldObject>(field.getAllObjects());
    }

    public ArrayList<Wall> getWalls() {
        ArrayList<Wall> walls = new ArrayList<>();
        field.getAllObjects().forEach(fieldObject -> {
            if (fieldObject instanceof Wall) walls.add((Wall) fieldObject);
        });
        return walls;
    }

    public ArrayList<Apple> getApples() {
        ArrayList<Apple> apples = new ArrayList<>();
        field.getAllObjects().forEach(fieldObject -> {
            if (fieldObject instanceof Apple) apples.add((Apple) fieldObject);
        });
        return apples;
    }

    public ArrayList<SnakePart> getSnakeParts() {
        ArrayList<SnakePart> snakeParts = new ArrayList<>();
        field.getAllObjects().forEach(fieldObject -> {
            if (fieldObject instanceof SnakePart) snakeParts.add((SnakePart) fieldObject);
        });
        return snakeParts;
    }

    public ArrayList<SnakeHead> getSnakeHeads() {
        ArrayList<SnakeHead> snakeHeads = new ArrayList<>();
        field.getAllObjects().forEach(fieldObject -> {
            if (fieldObject instanceof SnakeHead) snakeHeads.add((SnakeHead) fieldObject);
        });
        return snakeHeads;
    }
}