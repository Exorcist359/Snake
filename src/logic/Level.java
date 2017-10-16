package logic;

import logic.Field;

public class Level {
    public final Field field;
    public final int height;
    public final int width;
    public Level(Field field, int height, int width){
        this.field = field;
        this.height = height;
        this.width = width;
    }
}
