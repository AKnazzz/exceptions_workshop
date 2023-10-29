package task_2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import task_2.exceptions.NotEnoughMaterialException;
import task_2.exceptions.NotEnoughWoodException;
import task_2.exceptions.OrdersListIsEmptyException;

import java.util.List;
import java.util.Map;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OlivandersShop {

    private Map<String, Integer> woodTypeCount; // тип дерева / количество палочек на сколько хватит
    private Map<String, Integer> coreMaterialCount; // материал сердца палочки/ количество палочек на сколько хватит
    private List<WandOrder> orders;

    public void placeOrder(WandOrder order) throws NotEnoughWoodException, NotEnoughMaterialException {

        if (order == null) {
            throw new IllegalArgumentException("please check you order");
        }

        String woodType = order.getWand().getWoodType();
        String coreMaterial = order.getWand().getCoreMaterial();
        Integer wtc = woodTypeCount.get(woodType);
        Integer cmc = coreMaterialCount.get(coreMaterial);
        Integer quantity = order.getQuantity();

        if (wtc == null || wtc < quantity) {
            log.warn("Order {} wasn't placed", order);
            throw new NotEnoughWoodException("Not enough " + woodType + " in the store");
        } else if (cmc == null || cmc < quantity) {
            log.warn("Order {} wasn't placed", order);
            throw new NotEnoughMaterialException("Not enough " + coreMaterial + " in the store");
        } else {
            orders.add(order);
            woodTypeCount.replace(woodType, wtc - quantity);
            coreMaterialCount.replace(coreMaterial, cmc - quantity);
            log.info("Order {} was placed", order);
        }

    }

    public Wand findMostPowerfulWand() throws OrdersListIsEmptyException { //для поиска самой мощной палочки среди заказанных

        if(orders.isEmpty()){
            throw new OrdersListIsEmptyException("Order list is empty.");
        }

        Wand bestWand = orders.get(0).getWand();
        int maxPowerLevel = bestWand.getPowerLevel();

        for (WandOrder order : orders) {
            if (order.getWand().getPowerLevel() > maxPowerLevel) {
                bestWand = order.getWand();
                maxPowerLevel = bestWand.getPowerLevel();
            }
        }
        return bestWand;
    }

}
