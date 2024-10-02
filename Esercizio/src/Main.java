import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Random ran = new Random();
        List<Product> allProducts = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int randomCat = ran.nextInt(1, 5);
            Categories category = switch (randomCat){
                case 1 -> Categories.BABY;
                case 2 -> Categories.BOYS;
                case 3 -> Categories.BOOK;
                case 4 -> Categories.FOOD;
                case 5 -> Categories.ELECTRONIC;
                default -> Categories.JEWELRY;
            };
            allProducts.add(new Product(faker.commerce().productName(),category,Integer.parseInt(faker.commerce().price())));
        }
        System.out.println(allProducts);

    }




}