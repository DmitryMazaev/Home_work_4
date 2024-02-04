package Classes;

import java.util.ArrayList;

public class Buyer {
    /**
     * @param Имя покупателя
     */
    private String name;

    public Buyer(String name, Order order) {
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * @param Заказ, сделанный покупателем
     */
    private Order order;


    @Override
    public String toString() {
        return "Покупатель "  + name;
    }

    public String toString2() {
        return "Покупатель "  + name + " купил: "+ order.toString3();
    }

    public String toString3() {
        return "Покупатель "  + name + order.toString();
    }
}
