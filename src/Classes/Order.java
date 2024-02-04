package Classes;

import java.util.ArrayList;

/**
 * Класс Заказ. Список из продуктов, заказанных Покупателем
 */
public class Order {
    private ArrayList<Product> order;

    public Order(ArrayList<Product> order) {
        this.order = order;
    }

    public ArrayList<Product> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Product> order) {
        this.order = order;
    }

    public String toString3() {
        return order.toString();
    }
}
