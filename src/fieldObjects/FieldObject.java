package fieldObjects;

abstract class FieldObject{
    public final int coloumn;
    public final int row;

    public FieldObject(int coloumn, int row){
        this.coloumn = coloumn;
        this.row = row;
    }

    abstract void interactWithSnake();

}
