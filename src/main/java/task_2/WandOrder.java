package task_2;

public class WandOrder {
    private String customerName; //имя клиента, заказавшего палочку
    private Wand wand; //экземпляр класса Wand, представляющий выбранную палочку
    private int quantity; //количество заказанных палочек

    public WandOrder(String customerName, Wand wand, int quantity) {

        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("Значение customerName должно быть заполнено.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Значение quantity должно быть больше 0.");
        }

        this.customerName = customerName;
        this.wand = wand;
        this.quantity = quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
