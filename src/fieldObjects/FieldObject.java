package fieldObjects;

public abstract class FieldObject{
    public int column;
    public int row;

    public FieldObject(int column, int row){
        this.column = column;
        this.row = row;
    }

    abstract void interactWithSnake();

}
