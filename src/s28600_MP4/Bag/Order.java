package s28600_MP4.Bag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private static List<Order> extent = new ArrayList<>();
    private Client client;
    private Product product;
    private int quantity;

    public Order(Client client, Product product, int quantity) {
        setClient(client);
        setProduct(product);
        setQuantity(quantity);

        client.addExistingOrder(this);
        product.addExistingOrder(this);

        extent.add(this);
    }

    public static List<Order> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public Client getClient() {
        return client;
    }

    private void setClient(Client client) {
        if (client == null)
            throw new IllegalArgumentException("Client cannot be null");
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    private void setProduct(Product product) {
        if (product == null)
            throw new IllegalArgumentException("Product cannot be null");
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    private void setQuantity(int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity has to be greater that zero");
        this.quantity = quantity;
    }

    public void remove(){
        if (client != null){
            client.removeOrder(this);
            client = null;
        }
        if (product != null){
            product.removeOrder(this);
            product = null;
        }
        extent.remove(this);
    }
}
