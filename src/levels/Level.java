package levels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fieldObjects.*;

public class Level {    
	private static HashMap<Integer, String[]> maps;
	public final ArrayList<Wall> field;
	public final int height;
	public final int width;
	
    public Level(int seed){
        //here will be working with seeds for maps, maybe levels will be from txt files
        //What do this class: upload seed.txt, parsing data, put to FieldObject[][], set width and height
    	maps = new HashMap<Integer, String[]>();
    	maps.put(1, new String[]{
                "##########",
                "#        #",
                "#        #",
                "#        #",
                "#        #",
                "#        #",
                "#        #",
                "##########"
    	});
    	String[] map = maps.get(seed);
        height = map.length;
        if (height > 0) 
        	width = map[0].length();
        else
        	width = 0;
        field = mapsParser(map);
    }

    private ArrayList<Wall> mapsParser(String[] map){
        //TODO normal parser!!!
        //const should be computing automatically
    	
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                if (map[i].charAt(j) == '#')
                	field.add(new Wall(i, j));
            }
        return field;
    }

}
