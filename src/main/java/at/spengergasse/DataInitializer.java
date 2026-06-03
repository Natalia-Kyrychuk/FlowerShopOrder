package at.spengergasse;

import at.spengergasse.model.FlowerOrder;
import at.spengergasse.service.FlowerOrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final FlowerOrderService flowerOrderService;

    public DataInitializer(FlowerOrderService flowerOrderService) {
        this.flowerOrderService = flowerOrderService;
    }

    @Override
    public void run(String... args) throws Exception {

        FlowerOrder order1 = new FlowerOrder(
                1000L,
                LocalDate.now(),
                "Rose",
                1,
                3.50,
                false
        );

        FlowerOrder order2 = new FlowerOrder(
                1001L,
                LocalDate.now(),
                "Tulip",
                3,
                7.50,
                true
        );

        FlowerOrder order3 = new FlowerOrder(
                1002L,
                LocalDate.now(),
                "Lily",
                5,
                20.00,
                false
        );

        flowerOrderService.save(order1);
        flowerOrderService.save(order2);
        flowerOrderService.save(order3);

        System.out.println("Orders saved");

        System.out.println("Alle Bestellungen:");

        flowerOrderService.findAll()
                .forEach(System.out::println);
    }
}