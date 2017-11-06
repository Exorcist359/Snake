package logic;

import fieldObjects.Apple;
import java.util.ArrayList;
import java.util.Random;

public class SnakeBot{

    public SnakeBot(int x, int y, Field field) {

    }

    private SnakeDirection getRandomDirection(){
        Random random = new Random();
        int i = random.nextInt(SnakeDirection.values().length);
        return SnakeDirection.values()[i];
    }


    private SnakeDirection getNextDirection(){
        //Change for situation: if apple's count will be more then 1
        //It's very simple snake's direction choicer, and TODO Snake need BFS
        ArrayList<Apple> apples = new ArrayList<>();
        field.getAllObjects().forEach(obj -> {
            if(obj instanceof  Apple)
                apples.add((Apple) obj);
        });
        //May be do choice more best apple
        Point applePoint = apples.get(0).getPosition(); //here will be choice
        SnakeDirection nextDirection;
        if (this.position.x > applePoint.x)
            nextDirection = SnakeDirection.Left;
        else if (this.position.x < applePoint.x)
            nextDirection = SnakeDirection.Right;
        else if (this.position.y > applePoint.y)
            nextDirection = SnakeDirection.Up;
        else
            nextDirection = SnakeDirection.Down;
        return  nextDirection;
        //nextDirection.isOppositeDirection(this.direction) ? getRandomDirection() : nextDirection; //may be opposite
    }

    @Override
    public void tick() {
        previousPosition = position;
        SnakeDirection direction = getNextDirection();
        position = field.getPositionAfterMovement(direction, position);
    }
}
