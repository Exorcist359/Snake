package logic;

import fieldObjects.*;
import viewFieldObject.*;

import java.util.ArrayList;

public class FieldView {
    private Field field;

    public FieldView(Field field) {
        this.field = field;
    }

    public int getWidth() {
        return field.width;
    }

    public int getHeight() {
        return field.height;
    }

    public ArrayList<FieldObjectView> getAllObjects() {
        ArrayList<FieldObjectView> wrappers = new ArrayList<>();
        field.getAllObjects().forEach(fieldObject -> {
            wrappers.add(fieldObject.getWrapper());
        });
        return wrappers;
    }

    public ArrayList<WallView> getWalls() {
        ArrayList<WallView> walls = new ArrayList<>();
        field.getAllObjects().forEach(fieldObject -> {
            if (fieldObject instanceof Wall) walls.add((WallView) fieldObject.getWrapper());
        });
        return walls;
    }

    public ArrayList<AppleView> getApples() {
        ArrayList<AppleView> apples = new ArrayList<>();
        field.getAllObjects().forEach(fieldObject -> {
            if (fieldObject instanceof Apple) apples.add((AppleView) fieldObject.getWrapper());
        });
        return apples;
    }

    public ArrayList<SnakePartView> getSnakeParts() {
        ArrayList<SnakePartView> snakeParts = new ArrayList<>();
        field.getAllObjects().forEach(fieldObject -> {
            if (fieldObject instanceof SnakePart) snakeParts.add((SnakePartView) fieldObject.getWrapper());
        });
        return snakeParts;
    }

    public ArrayList<SnakeHeadView> getSnakeHeads() {
        ArrayList<SnakeHeadView> snakeHeads = new ArrayList<>();
        field.getAllObjects().forEach(fieldObject -> {
            if (fieldObject instanceof SnakeHead) snakeHeads.add((SnakeHeadView) fieldObject.getWrapper());
        });
        return snakeHeads;
    }
}