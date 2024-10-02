import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Random ran = new Random();
        List<Product> allProducts = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            int randomCat = ran.nextInt(1, 5);
            Categories category = switch (randomCat){
                case 1 -> Categories.BABY;
                case 2 -> Categories.BOYS;
                case 3 -> Categories.BOOK;
                case 4 -> Categories.FOOD;
                case 5 -> Categories.ELECTRONIC;
                default -> Categories.JEWELRY;
            };
            allProducts.add(new Product(faker.pokemon().name(),category,ran.nextDouble(20, 300)));
        }
        List<Customer> allCustomers = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            allCustomers.add(new Customer(faker.harryPotter().character(), ran.nextInt(1,5)));
        }
        List<Order> allOrders = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            List<Product> productsOrdered = new ArrayList<>();
            for (int j = 0; j < ran.nextInt(1,5); j++) {
                productsOrdered.add(allProducts.get(ran.nextInt(0, allProducts.size() - 1)));
            }
            allOrders.add(new Order(productsOrdered, allCustomers.get(ran.nextInt(0, allCustomers.size() - 1))));
        }
        System.out.println(allCustomers);
        System.out.println(allOrders);
        System.out.println(allProducts);
        System.out.println("-----------------Expensive books--------------------");
        List<Product> expensiveBooks = allProducts.stream().filter(product -> product.getCategory() == Categories.BOOK && product.getPrice() > 100).toList();
        expensiveBooks.forEach(System.out::println);
        System.out.println("----------------------Baby order--------------------");
        List<Order> babyOrder = allOrders.stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory() == Categories.BABY)).toList();
        babyOrder.forEach(System.out::println);
        System.out.println("----------------------Boys 10%--------------------");
        List<Product> boysDiscount = allProducts.stream().filter(product -> product.getCategory() == Categories.BOYS).peek(product -> product.setPrice(product.getPrice()*((double) 9 /10))).toList();
        boysDiscount.forEach(System.out::println);
        System.out.println("----------------------Tier 2 Old--------------------");
        HashSet<Product> tier2OldProduct = new HashSet<>();
        allOrders.stream()
                .filter(order -> order.getCustomer().getTier() == 2 && order.getOrderDate()
                        .isAfter(LocalDate.of(2021,2,1)) && order.getOrderDate().isBefore(LocalDate.of(2021,4,1)))
                .map(Order::getProducts).forEach(products -> products.stream().forEach(product -> tier2OldProduct.add(product)));
        tier2OldProduct.forEach(System.out::println);
    }




}