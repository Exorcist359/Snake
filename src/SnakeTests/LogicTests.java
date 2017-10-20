package SnakeTests;
import logic.*;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class LogicTests {
    private Field GenerateSimpleField()
    {
        FieldGenerator gen = new FieldGenerator();
        String[] map = {
                "      ",
                "      ",
                "      ",
                "      ",
                "      ",
                "      ",
        };
        return gen.generate(map);
    }
    
    @Test
    public void testPositionAfterMovingInCenter() {
        SnakeDirection[] dirs = {
                SnakeDirection.Up,
                SnakeDirection.Down,
                SnakeDirection.Right,
                SnakeDirection.Left
                };
        Point start = new Point(3,3);
        Point[] finish = {
                new Point(3,4),
                new Point(3,2),
                new Point(4,3),
                new Point(2,3)
                };
        Field field = GenerateSimpleField();
        
        for (int i = 0; i < 4; i++)
        {
        	assertEquals(finish[i], 
        			Logic.getPositionAfterMovement(dirs[i], start, field));
        }
    }
    
    @Test
    public void testPositionAfterMovingInCorners() {
        SnakeDirection[] dirs = {
                SnakeDirection.Up,
                SnakeDirection.Down,
                SnakeDirection.Right,
                SnakeDirection.Left
                };
        Point[] start = {
                new Point(0,0),
                new Point(5,5)
                };
        Point[][] finish = { {
                new Point(0,5),
                new Point(0,1),
                new Point(1,0),
                new Point(5,0)
                }, {
        		new Point(5,4),
                new Point(5,0),
                new Point(0,5),
                new Point(4,5)
                }
        };
        Field field = GenerateSimpleField();
        
        for (int i = 0; i < 2; i++)
        {
        	for (int j = 0; j < 4; j++)
            {        	
                assertEquals(finish[i][j], 
        		    	Logic.getPositionAfterMovement(dirs[j], start[i], field));
            }
        }
    }
}