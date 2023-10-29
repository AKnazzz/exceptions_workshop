package task_2;

import lombok.extern.slf4j.Slf4j;
import task_2.exceptions.NotEnoughMaterialException;
import task_2.exceptions.NotEnoughWoodException;
import task_2.exceptions.OrdersListIsEmptyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class Main {
    public static void main(String[] args) throws NotEnoughWoodException, NotEnoughMaterialException {


        Map<String, Integer> woodTypeCount = new HashMap<>();
        Map<String, Integer> coreMaterialCount = new HashMap<>();
        List<WandOrder> orders = new ArrayList<>();

        woodTypeCount.put("Acacia", 5);
        woodTypeCount.put("English Oak", 10);
        woodTypeCount.put("Hawthorn", 2);
        woodTypeCount.put("Elder", 4);
        woodTypeCount.put("Beech", 19);
        woodTypeCount.put("Vine", 17);

        coreMaterialCount.put("Phoenix feather", 5);
        coreMaterialCount.put("Unicorn hair", 22);
        coreMaterialCount.put("Dragon heartstring", 15);

        OlivandersShop shop = new OlivandersShop(woodTypeCount, coreMaterialCount, orders);


        try {
            shop.findMostPowerfulWand();
        } catch (OrdersListIsEmptyException e) {
            log.error("Try to find most powerful wand: {}", e.getMessage());
        }

        try {
            shop.findMostPowerfulWand();
        } catch (OrdersListIsEmptyException e) {
            log.error("Try to find wand: {}", e.getMessage());
        }

        try {
            new Wand(null, 0, null, 0);
        } catch (IllegalArgumentException | NotEnoughWoodException | NotEnoughMaterialException e) {
            log.error("Wrong arguments wand creation: {}", e.getMessage());
        }

        Wand wand1 = new Wand("Acacia", 8, "Phoenix feather", 4);
        Wand wand2 = new Wand("English Oak", 9, "Unicorn hair", 5);
        Wand wand3 = new Wand("Hawthorn", 10, "Dragon heartstring", 9);
        Wand wand4 = new Wand("Elder", 12, "Phoenix feather", 8);
        Wand wand5 = new Wand("Beech", 15, "Phoenix feather", 10);

        try {
            new WandOrder(null, wand5, 0);
        } catch (IllegalArgumentException e) {
            log.error("Wrong arguments WandOrder creation: {}", e.getMessage());
        }

        WandOrder wandOrder1 = new WandOrder("Lord Voldemort", wand1, 1);
        WandOrder wandOrder2 = new WandOrder("Harry Potter", wand2, 2);
        WandOrder wandOrder3 = new WandOrder("Ron Weasley", wand3, 3);
        WandOrder wandOrder4 = new WandOrder("Hermione Jean Granger", wand4, 5);
        WandOrder wandOrder5 = new WandOrder("Harry Potter", wand5, 5);

        shop.placeOrder(wandOrder1);
        shop.placeOrder(wandOrder2);
        try {
            shop.placeOrder(wandOrder3);
        } catch (Exception e) {
            log.error("Order placing exception: {}", e.getMessage());
        }

        try {
            shop.placeOrder(wandOrder4);
        } catch (Exception e) {
            log.error("Order placing exception : {}", e.getMessage());
        }

        try {
            shop.placeOrder(wandOrder5);
        } catch (Exception e) {
            log.error("Order placing exception : {}", e.getMessage());
        }

        try {
            Wand mostPowerfulWand = shop.findMostPowerfulWand();
            log.info("Most powerful wand is: {}", mostPowerfulWand.toString());
        } catch (OrdersListIsEmptyException e) {
            log.error("Try to find most powerful wand: {}", e.getMessage());
        }
    }
}
