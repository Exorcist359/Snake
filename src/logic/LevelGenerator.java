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
        //What do this class: upload seed.txt, parsing data, put to FieldObject[][], set fieldWidth and fieldHeight
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

    private void createSnake(SnakeHead snakeHead, ArrayList<FieldObject> all, ArrayList<Snake> snakes){
    	all.add(snakeHead);
    	snakes.add(new Snake(snakeHead));
	}

    private Field parseMaps(String[] map){
		ArrayList<FieldObject> all = new ArrayList<>();
		ArrayList<Snake> snakes = new ArrayList<>();

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
        		char currentSymb = map[i].charAt(j);
        		switch (currentSymb){
					case '#':
						all.add(new Wall(j, i));
						break;
					case '<':
						createSnake(new SnakeHead(j, i, SnakeDirection.Left, height, width), all, snakes);
						break;
					case '>':
						createSnake(new SnakeHead(j, i, SnakeDirection.Right, height, width), all, snakes);
						break;
					case 'A':
						createSnake(new SnakeHead(j, i, SnakeDirection.Up, height, width), all, snakes);
						break;
					case 'V':
						createSnake(new SnakeHead(j, i, SnakeDirection.Down, height, width), all, snakes);
						break;
				}
            }

        return new Field(all, snakes);
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
