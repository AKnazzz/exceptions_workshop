package task_2;

import task_2.exceptions.NotEnoughMaterialException;
import task_2.exceptions.NotEnoughWoodException;
import task_2.exceptions.ZeroOrdersException;

import java.util.List;
import java.util.Map;

public class OlivandersShop {
    private List<WandOrder> orders;

    private Map<String, Integer> woodTypeCount;
    // где ключ - тип дерева, а значение - количество палочек, на изготовление которых хватит конкретного типа дерева
    private Map<String, Integer> coreMaterialCount;
    // где ключ - материал сердца палочки, а значение - количество палочек, на изготовление которых хватит конкретного материала сердца палочки


    public OlivandersShop(List<WandOrder> orders, Map<String, Integer> woodTypeCount,
            Map<String, Integer> coreMaterialCount) {
        this.orders = orders;
        this.woodTypeCount = woodTypeCount;
        this.coreMaterialCount = coreMaterialCount;
    }

    public void placeOrder(WandOrder order) throws NotEnoughWoodException, NotEnoughMaterialException { // для размещения заказа
        String woodType = order.getWand().getWoodType();
        int requiredWoodCount = order.getQuantity();

        if (woodTypeCount.containsKey(woodType)) {
            int availableWoodCount = woodTypeCount.get(woodType);
            if (availableWoodCount < requiredWoodCount) {
                throw new NotEnoughWoodException(woodType);
            }
            woodTypeCount.put(woodType, availableWoodCount - requiredWoodCount);
        } else {
            throw new NotEnoughWoodException(woodType);
        }

        String coreMaterial = order.getWand().getCoreMaterial();
        int requiredMaterialCount = order.getQuantity();

        if (coreMaterialCount.containsKey(coreMaterial)) {
            int availableMaterialCount = coreMaterialCount.get(coreMaterial);
            if (availableMaterialCount < requiredMaterialCount) {
                throw new NotEnoughMaterialException(coreMaterial);
            }
            coreMaterialCount.put(coreMaterial, availableMaterialCount - requiredMaterialCount);
        } else {
            throw new NotEnoughMaterialException(coreMaterial);
        }

        orders.add(order);
    }

    public Wand findMostPowerfulWand() throws ZeroOrdersException { //для поиска самой мощной палочки среди заказанных
        if(orders.isEmpty()){
            throw new ZeroOrdersException("Ещё не было сделано ни одного заказа.");
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

    public List<WandOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<WandOrder> orders) {
        this.orders = orders;
    }

    public Map<String, Integer> getWoodTypeCount() {
        return woodTypeCount;
    }

    public void setWoodTypeCount(Map<String, Integer> woodTypeCount) {
        this.woodTypeCount = woodTypeCount;
    }

    public Map<String, Integer> getCoreMaterialCount() {
        return coreMaterialCount;
    }

    public void setCoreMaterialCount(Map<String, Integer> coreMaterialCount) {
        this.coreMaterialCount = coreMaterialCount;
    }
}
