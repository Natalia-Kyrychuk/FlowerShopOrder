package at.spengergasse.repository;
import at.spengergasse.model.FlowerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerOrderRepository
        extends JpaRepository<FlowerOrder, Long> {

}
