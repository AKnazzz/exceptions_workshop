package task_2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
@NoArgsConstructor
public class WandOrder {
    private String customerName; //имя клиента, заказавшего палочку
    private Wand wand; //экземпляр класса Wand, представляющий выбранную палочку
    private int quantity; //количество заказанных палочек

    public WandOrder(String customerName, Wand wand, int quantity) {

        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("The customerName value must be filled in.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("The quantity value must be greater than 0.");
        }

        this.customerName = customerName;
        this.wand = wand;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "From: " + customerName + " for " + quantity + "pc(s)";
    }

}
