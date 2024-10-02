import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
    Random random = new Random();
    private long id = random.nextLong(1000,10000);
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    public Order(List<Product> products, Customer customer) {
        this.products = products;
        this.customer = customer;
        this.status = "in progress";
        this.orderDate = LocalDate.now();
        this.deliveryDate = LocalDate.now().plusDays(random.nextInt(1,20));
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setProducts(Product product) {
        this.products.add(product);
    }
}
