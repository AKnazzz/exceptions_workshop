package task_2.exceptions;

public class NotEnoughMaterialException extends Exception {
    public NotEnoughMaterialException(String material) {
        super("Для создания сердцевины палочки не хватает материала: " + material);
    }
}
