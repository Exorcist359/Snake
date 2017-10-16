package logic;

import java.util.ArrayList;
import java.util.HashMap;
import fieldObjects.*;


public class LevelGenerator {
	private static HashMap<Integer, String[]> maps;
	private int height;
	private int width;
	
    public LevelGenerator(){
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
    	maps.put(2, new String[]{
                "####################",
                "#                  #",
                "#     ######       #",
                "#  ####            #",
                "#  #    ####       #",
                "#  # ####          #",
                "#### #       #######",
                "     #    ####      ",
                "######    #    #####",
                "#         # ####   #",
                "#      #### #      #",
                "#           #      #",
                "#      ######      #",
                "#                  #",
                "####################"
    	});
    	maps.put(3, new String[]{
                "########################",
                "#                      #",
                "#      #######         #",
                "#   ####               #",
                "#   #                  #",
                "#   #     ####         #",
                "#   #  ####            #",
                "#####  #        ########",
                "       #     ####       ",
                "       #     #          ",
                "########     #     #####",
                "#            #  ####   #",
                "#         ####  #      #",
                "#               #      #",
                "#               #      #",
                "#         #######      #",
                "#                      #",
                "########################"
    	});
    	maps.put(4, new String[]{
                "                        ",
                "                        ",
                "                        ",
                "                        ",
                "                        ",
                "                        ",
                "                        ",
                "                        ",
                "                        ",
                "                        ",
                "                        ",
                "                        ",
                "                        ",
                "                        ",
                "                        ",
                "                        ",
                "                        "
    	});
    	maps.put(5, new String[]{
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
    	});
    }

    private Field parseMaps(String[] map){
		ArrayList<ArrayList<FieldObject>> all = new ArrayList<>();
        ArrayList<FieldObject> walls = new ArrayList<>();
        ArrayList<FieldObject> snakesHead = new ArrayList<>();

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
        		char currentSymb = map[i].charAt(j);
        		switch (currentSymb){
					case '#':
						walls.add(new Wall(j, i));
						break;
					case '<':
						snakesHead.add(new SnakeHead(j, i, SnakeDirection.Left));
						break;
					case '>':
						snakesHead.add(new SnakeHead(j, i, SnakeDirection.Right));
						break;
					case 'A':
						snakesHead.add(new SnakeHead(j, i, SnakeDirection.Up));
						break;
					case 'V':
						snakesHead.add(new SnakeHead(j, i, SnakeDirection.Down));
						break;
				}
            }
		all.add(walls);
        all.add(snakesHead);

        return new Field(all);
    }

    public Level generate(int seed){
		String[] map = maps.get(seed);

		height = map.length;
		if (height > 0)
			width = map[0].length();
		else
			width = 0;

		return new Level(parseMaps(map), height, width);
	}
}
