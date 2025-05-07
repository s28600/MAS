package s28600_MP4.Bag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Product {
    private static List<Product> extent = new ArrayList<>();
    private String name;
    private List<Order> orders = new ArrayList<>();

    public Product(String name) {
        setName(name);
        extent.add(this);
    }

    public static List<Product> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or blank");
        this.name = name;
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    public void addNewOrder(Client client, int quantity) {
        if (client == null)
            throw new IllegalArgumentException("Client cannot be null");
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity has to be greater that zero");
        new Order(client, this, quantity);
    }

    public void addExistingOrder(Order order) {
        if (order == null)
            throw new IllegalArgumentException("Order cannot be null");
        if (!orders.contains(order)){
            orders.add(order);
        }
    }

    public void removeOrder(Order order) {
        if (order == null)
            throw new IllegalArgumentException("Order cannot be null");
        if (orders.contains(order)){
            orders.remove(order);
            order.remove();
        }
    }

    public void remove(){
        while (!orders.isEmpty())
            orders.getFirst().remove();
        extent.remove(this);
    }
}
