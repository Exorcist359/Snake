package fieldObjects;

public interface FieldObject {
    static void interactWithSnake() {
    }
}

abstract class FieldObject_{
    private int x;
    private int y;

    public FieldObject_(int x, int y){
        this.x = x;
        this.y = y;
    }

    static void interactWithSnake(){}

}
