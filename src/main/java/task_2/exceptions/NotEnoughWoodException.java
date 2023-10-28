package task_2.exceptions;

public class NotEnoughWoodException extends Exception{
    public NotEnoughWoodException(String wood) {
        super("Для создания  палочки не хватает дерева: " + wood);
    }
}
