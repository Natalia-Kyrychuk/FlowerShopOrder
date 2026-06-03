package at.spengergasse;

import at.spengergasse.model.FlowerOrder;
import at.spengergasse.repository.FlowerOrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner
{
    private final FlowerOrderRepository flowerOrderRepository;

    public DataInitializer(FlowerOrderRepository flowerOrderRepository) {
        this.flowerOrderRepository = flowerOrderRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        FlowerOrder order1 = new FlowerOrder();

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

        flowerOrderRepository.save(order1);
        flowerOrderRepository.save(order2);
        flowerOrderRepository.save(order3);

        System.out.println("Orders saved");

        System.out.println("Alle Bestellungen:");

        flowerOrderRepository.findAll()
                .forEach(System.out::println);
    }
}