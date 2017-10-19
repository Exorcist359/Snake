package logic;

import fieldObjects.FieldObject;

import java.util.ArrayList;
import java.util.Random;

public class Logic {

    //to logic ?
    public Point getRandomFreePosition(Field field)
    {
        ArrayList<Point> allPoints = getAllPoints(field);
        ArrayList<Point> freePoints = getFreePoints(allPoints, field);

        Random rnd = new Random();
        int index = rnd.nextInt(freePoints.size());
        return freePoints.get(index);
    }

    public ArrayList<Point> getFreePoints(ArrayList<Point> allPoints, Field field) {
        ArrayList<Point> freePoints = new ArrayList<Point>();
        for (int i = 0; i < allPoints.size(); i++)
        {
            Point point = allPoints.get(i);
            boolean free = true;
            for(int j = 0; j < field.allObjects.size(); j++)
            {
                FieldObject obj = field.allObjects.get(j);
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

    public ArrayList<Point> getAllPoints(Field field)
    {
        ArrayList<Point> allPoints = new ArrayList<Point>();
        for (int x = 0; x < field.width; x++)
        {
            for (int y = 0; y < field.height; y++)
            {
                allPoints.add(new Point(x,y));
            }
        }
        return allPoints;
    }


}
