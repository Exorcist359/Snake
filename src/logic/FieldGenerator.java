package logic;

import java.util.ArrayList;
import java.util.HashMap;
import fieldObjects.*;


public class FieldGenerator {
    private static HashMap<Integer, String[]> maps;
    private int height;
    private int width;
    
    public FieldGenerator(){
        //here will be working with seeds for maps, maybe levels will be from txt files
        //What do this class: upload seed.txt, parsing data, put to FieldObject[][], set fieldWidth and fieldHeight
        maps = new HashMap<Integer, String[]>();
        maps.put(1, new String[] {
                "##########",
                "#        #",
                "#        #",
                "#        #",
                "#        #",
                "#        #",
                "#   A    #",
                "##########"
        });
        maps.put(2, new String[] {
                "####################",
                "#   >              #",
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
        maps.put(3, new String[] {
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
                "#                   <  #",
                "########################"
        });
        maps.put(4, new String[] {
                "                        ",
                "                        ",
                "                        ",
                "                        ",
                "                        ",
                "                        ",
                "                        ",
                "              >         ",
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
        maps.put(5, new String[] {
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "                                    ",
                "               A                    ",
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

    private Field parseMaps(String[] map) {
        ArrayList<FieldObject> all = new ArrayList<>();
        Field field = new Field(height, width);
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                char currentSymb = map[i].charAt(j);
                switch (currentSymb) {
                    case '#':
                        all.add(new Wall(j, i));
                        break;
                    case '<':
                        all.add(new SnakeHead(j, i, SnakeDirection.Left, field));
                        break;
                    case '>':
                        all.add(new SnakeHead(j, i, SnakeDirection.Right, field));
                        break;
                    case 'A':
                        all.add(new SnakeHead(j, i, SnakeDirection.Up, field));
                        break;
                    case 'V':
                        all.add(new SnakeHead(j, i, SnakeDirection.Down, field));
                        break;
                }
            }
        field.setAllObjects(all);
        return field;
    }

    public Field generate(int seed) {
        String[] map = maps.get(seed);

        height = map.length;
        if (height > 0)
            width = map[0].length();
        else
            width = 0;
        return parseMaps(map);
    }
    
    public Field generate(String[] map){
        height = map.length;
        if (height > 0)
            width = map[0].length();
        else
            width = 0;
        return parseMaps(map);
    }
}
