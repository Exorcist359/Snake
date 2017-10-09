package levels;

import fieldObjects.FieldObject;
import fieldObjects.Wall;

public class Level {


    public Level(int seed){
        //here will be working with seeds for maps, maybe levels will be from txt files
        //What do this class: upload seed.txt, parsing data, put to FieldObject[][], set width and height
        String[][] map = getMap(seed);
        FieldObject[][] field = mapsParser(map);
    }

    public static FieldObject[][] getLevel(int seed){
        String[][] map = getMap(seed);
        FieldObject[][] field = mapsParser(map);
        return field;
    }

    private static String[][] getMap(int seed){
        //reading from txt file
        return new String[][]{
                {"##########"},
                {"#        #"},
                {"#        #"},
                {"#        #"},
                {"#  @     #"},
                {"#        #"},
                {"#        #"},
                {"##########"}
        };
    }

    private static FieldObject[][] mapsParser(String[][] map){
        //TODO normal parser!!!
        //const should be computing automatically
        int height = 8;
        int width = 10;

        FieldObject[][] field = new FieldObject[height][width];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == height - 1 || j == width - 1)
                    field[i][j] = new Wall(j, i);
            }

        return field;
    }

}
