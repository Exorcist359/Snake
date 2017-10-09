package fieldObjects;

abstract class FieldObject{
    public final int column;
    public final int row;

    public FieldObject(int column, int row){
        this.column = column;
        this.row = row;
    }

    abstract void interactWithSnake();

}
