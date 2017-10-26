package logic;

import java.util.ArrayList;
import java.util.Random;

import fieldObjects.*;

public class GameModel {
    public Field field;
    public ArrayList<Snake> snakes;
    private ArrayList<FieldObject> addedNewObj;

    public GameModel(Field field) {
        this.field = field;
        snakes = new ArrayList<Snake>();
        field.allObjects.forEach(obj -> {
            if (obj instanceof SnakeHead)
                snakes.add(new Snake((SnakeHead)obj));
        });
        addedNewObj = new ArrayList<>();
        generateApple();
        field.allObjects.addAll(addedNewObj);
        addedNewObj.clear();
    }

    public void tick() {
        field.allObjects.forEach(FieldObject::tick);
        field.allObjects.forEach(fieldObject -> {
            if (fieldObject instanceof SnakeHead) {
                SnakeHead head = (SnakeHead)fieldObject;
                field.allObjects.forEach(obj -> {
                    if (head != obj && head.position.equals(obj.position))
                        obj.interactWithSnake(head, this);
                });
            }
        });
        field.allObjects.removeIf(obj -> !obj.isActive());
        field.allObjects.addAll(addedNewObj);
        addedNewObj.clear();
    }

    public void killSnake(SnakeHead snakeHead) {
        killAllSnakePartsFromHead(snakeHead);
    }

    public void generateApple() {
        Point position = field.getRandomFreePosition();
        addedNewObj.add(new Apple(position));
    }
    
    public void increaseSnake(SnakeHead snakeHead) {
        SnakePart tail = getLastSnakePart(snakeHead);
        SnakePart newPart = new SnakePart(tail.position, tail);
        tail.next = newPart;
        addedNewObj.add(newPart);
    }
    
    private SnakePart getLastSnakePart(SnakeHead snakeHead) {
        SnakePart current = snakeHead;
        while(current.next != null) {
            current = current.next;
        }
        return current;
    }
    
    private void killAllSnakePartsFromHead(SnakeHead snakeHead) {
        for(SnakePart current = snakeHead; current != null; current = current.next){
            current.die();
        }
    }
}
