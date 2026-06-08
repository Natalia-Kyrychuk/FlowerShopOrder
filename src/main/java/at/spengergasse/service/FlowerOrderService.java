package at.spengergasse.service;

import at.spengergasse.model.FlowerOrder;
import at.spengergasse.repository.FlowerOrderRepository;
import org.springframework.stereotype.Service;
import at.spengergasse.model.FlowerOrderException;
import java.util.List;

@Service
public class FlowerOrderService {

    private final FlowerOrderRepository repository;

    public FlowerOrderService(FlowerOrderRepository repository) {
        this.repository = repository;
    }

    public List<FlowerOrder> findAll() {
        return repository.findAll();
    }

    public FlowerOrder save(FlowerOrder order) {
        return repository.save(order);
    }

    public void removeAll() {
        repository.deleteAll();
    }

    public void addTestOrders() {

        FlowerOrder order1 = new FlowerOrder(
                2001L,
                java.time.LocalDate.now(),
                "Rose",
                2,
                7.00,
                false
        );

        FlowerOrder order2 = new FlowerOrder(
                2002L,
                java.time.LocalDate.now(),
                "Tulip",
                4,
                10.00,
                true
        );

        FlowerOrder order3 = new FlowerOrder(
                2003L,
                java.time.LocalDate.now(),
                "Lily",
                1,
                5.00,
                false
        );

        repository.save(order1);
        repository.save(order2);
        repository.save(order3);
    }

    public void addWrongOrder() {
        FlowerOrder order = new FlowerOrder(
                3001L,
                java.time.LocalDate.now(),
                "Rose",
                1,
                -20.00,
                true
        );

        repository.save(order);
    }

    public void removeOrder(Long orderId) {

        repository.deleteById(orderId);
    }

    public void oneMore(Long orderId) {

        if (orderId == null) {
            throw new FlowerOrderException("No Order ID!");
        }

        FlowerOrder order =
                repository.findById(orderId)
                        .orElseThrow(() ->
                                new FlowerOrderException(
                                        "Order with the ID " + orderId + " not found!"
                                )
                        );

        order.setQuantity(order.getQuantity() + 1);

        repository.save(order);
    }
}