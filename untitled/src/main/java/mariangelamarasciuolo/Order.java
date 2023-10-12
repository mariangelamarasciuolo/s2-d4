package mariangelamarasciuolo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
    Long id;
    String status;
    LocalDate orderDate;
    LocalDate deliveryDate;
    List<Product> products;
    Customer customer;

    public Order(Long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
    public static Order creaOrd(List<Product> productsList, Customer customer) {
        Random rndm = new Random();
        List<Product> listaProd = new ArrayList<>();
        for (int i = 0; i < rndm.nextInt(1, 5); i++) {
            listaProd.add(productsList.get(rndm.nextInt(0 , productsList.size())));
        }
        int month = rndm.nextInt(1, 7);
        int day;
        if (month == 2)
            day= rndm.nextInt(1, 28);
        else if (month == 11 || month == 4 || month == 6 || month == 9) {
            day = rndm.nextInt(1,31);
        } else day= rndm.nextInt(1, 32);
        int year = rndm.nextInt(2021, 2022);
         return new Order((long) Math.abs(rndm.nextInt()), "spedito", LocalDate.of(year,month, day),  );
    };
}
