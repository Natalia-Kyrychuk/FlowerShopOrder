package at.spengergasse.service;

import at.spengergasse.model.FlowerOrder;
import at.spengergasse.repository.FlowerOrderRepository;
import org.springframework.stereotype.Service;

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
}