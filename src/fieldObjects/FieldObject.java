package fieldObjects;

<<<<<<< HEAD
public interface FieldObject {
    void interactWithSnake();
}

abstract class FieldObject_{
    private int x;
    private int y;
=======
public abstract class FieldObject{
    public int column;
    public int row;
>>>>>>> new_br

    public FieldObject(int column, int row){
        this.column = column;
        this.row = row;
    }

    abstract void interactWithSnake();

}
