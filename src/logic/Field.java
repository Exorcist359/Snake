package logic;

import fieldObjects.Apple;
import fieldObjects.FieldObject;
import fieldObjects.SnakeHead;
import fieldObjects.SnakePart;
import fieldObjects.Wall;

import java.util.ArrayList;
import java.util.Random;

public class Field {
    public ArrayList<FieldObject> allObjects;
    public int height;
    public int width;

    public Field(int height, int width) {
        
    }
    
    public ArrayList<Wall> getWalls()
    {
        ArrayList<Wall> walls = new ArrayList<>();
        allObjects.forEach(fieldObject -> {
            if (fieldObject instanceof Wall) walls.add((Wall) fieldObject);
        });
        return walls;
    }
    
    public ArrayList<Apple> getApples()
    {
        ArrayList<Apple> apples = new ArrayList<>();
        allObjects.forEach(fieldObject -> {
            if (fieldObject instanceof Apple) apples.add((Apple) fieldObject);
        });
        return apples;
    }
    
    public ArrayList<SnakePart> getSnakeParts()
    {
        ArrayList<SnakePart> snakeParts = new ArrayList<>();
        allObjects.forEach(fieldObject -> {
            if (fieldObject instanceof SnakePart) snakeParts.add((SnakePart) fieldObject);
        });
        return snakeParts;
    }
    
    public ArrayList<SnakeHead> getSnakeHeads()
    {
        ArrayList<SnakeHead> snakeHeads = new ArrayList<>();
        allObjects.forEach(fieldObject -> {
            if (fieldObject instanceof SnakeHead) snakeHeads.add((SnakeHead) fieldObject);
        });
        return snakeHeads;
    }
    
    public Point getRandomFreePosition()
    {
        ArrayList<Point> allPoints = getAllPoints();
        ArrayList<Point> freePoints = getFreePoints(allPoints);

        Random rnd = new Random();
        int index = rnd.nextInt(freePoints.size());
        return freePoints.get(index);
    }

    public ArrayList<Point> getAllPoints()
    {
        ArrayList<Point> allPoints = new ArrayList<Point>();
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                allPoints.add(new Point(x,y));
            }
        }
        return allPoints;
    }
    
    public ArrayList<Point> getFreePoints(ArrayList<Point> allPoints) {
        ArrayList<Point> freePoints = new ArrayList<Point>();
        for (int i = 0; i < allPoints.size(); i++)
        {
            Point point = allPoints.get(i);
            boolean free = true;
            for(int j = 0; j < allObjects.size(); j++)
            {
                FieldObject obj = allObjects.get(j);
                if (obj.position.equals(point))
                {
                    free = false;
                    break;
                }
            }
            if (free)
                freePoints.add(point);
        }
        return freePoints;
    }
}
