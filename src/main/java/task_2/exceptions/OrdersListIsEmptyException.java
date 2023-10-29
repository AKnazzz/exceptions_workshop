package task_2.exceptions;

public class OrdersListIsEmptyException extends Exception{
    public OrdersListIsEmptyException(String message) {
        super(message);
    }
}
