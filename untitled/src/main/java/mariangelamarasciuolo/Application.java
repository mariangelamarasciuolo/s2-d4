package mariangelamarasciuolo;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) {

        List<Customer> customersList =  new ArrayList<>();
        Supplier<Customer> customerSupplier= () -> {
        Faker faker = new Faker(Locale.ITALY);
            Random rndm =  new Random();
            return new Customer((long) Math.abs(rndm.nextInt()), faker.name().firstName(),rndm.nextInt(1, 5) );
        };
        for (int i = 0; i < 5; i++) {
          customersList.add(customerSupplier.get());
        }
        System.out.println(customersList);

        List<Product> productsList =  new ArrayList<>();
        Supplier<Product> productsSupplier= () -> {
            Faker faker = new Faker(Locale.ITALY);
            Random rndm =  new Random();
            return new Product((long) Math.abs(rndm.nextInt()), faker.commerce().productName(),faker.commerce().material(), rndm.nextDouble(10,  600));
        };
        for (int i = 0; i < 50; i++) {
            productsList.add(productsSupplier.get());
        }
        System.out.println(productsList);

    }
}
