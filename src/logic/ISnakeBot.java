package logic;

import views.FieldWrapper;

public interface ISnakeBot {
    void SetSnake(Snake snake);
    void getNextDirection(FieldWrapper fieldWrapper);
}
