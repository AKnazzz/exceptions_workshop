package task_2;

import task_2.exceptions.NotEnoughMaterialException;
import task_2.exceptions.NotEnoughWoodException;
import task_2.exceptions.ZeroOrdersException;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        try {
            Wand wand1 = new Wand("Сосна", 20, "Перо Феникса", 75);
            WandOrder order1 = new WandOrder("Гарри", wand1, 1);

            Wand wand2 = new Wand("Берёза", 31, "Зуб Василиска", 99);
            WandOrder order2 = new WandOrder("Томас", wand2, 2);

            OlivandersShop olivandersShop = new OlivandersShop(new ArrayList<>(), new HashMap<>(), new HashMap<>());
            olivandersShop.getWoodTypeCount().put("Сосна", 100);
            olivandersShop.getWoodTypeCount().put("Берёза", 100);
            olivandersShop.getCoreMaterialCount().put("Перо Феникса", 100);
            olivandersShop.getCoreMaterialCount().put("Зуб Василиска", 100);
            olivandersShop.placeOrder(order1);
            olivandersShop.placeOrder(order2);

            Wand bestOfTheBest = olivandersShop.findMostPowerfulWand();
            System.out.println("Самая сильная палочка: длина " + bestOfTheBest.getLength() + " из материалов "
                    + bestOfTheBest.getWoodType() + "+" + bestOfTheBest.getCoreMaterial());

        } catch (NotEnoughWoodException | NotEnoughMaterialException | ZeroOrdersException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
