package at.spengergasse.service;

import at.spengergasse.model.FlowerOrder;
import at.spengergasse.model.FlowerOrderException;
import at.spengergasse.repository.FlowerOrderRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FlowerOrderServiceTest {

    @Test
    void findAllShouldReturnAllOrders() {
        FlowerOrderRepository repository = mock(FlowerOrderRepository.class);
        FlowerOrderService service = new FlowerOrderService(repository);

        FlowerOrder order = new FlowerOrder(
                1L,
                LocalDate.now(),
                "Rose",
                2,
                7.00,
                false
        );

        when(repository.findAll()).thenReturn(List.of(order));

        List<FlowerOrder> result = service.findAll();

        assertEquals(1, result.size());
        assertEquals("Rose", result.get(0).getFlower());
        verify(repository).findAll();
    }

    @Test
    void saveShouldCallRepositorySave() {
        FlowerOrderRepository repository = mock(FlowerOrderRepository.class);
        FlowerOrderService service = new FlowerOrderService(repository);

        FlowerOrder order = new FlowerOrder(
                1L,
                LocalDate.now(),
                "Tulip",
                4,
                10.00,
                true
        );

        when(repository.save(order)).thenReturn(order);

        FlowerOrder result = service.save(order);

        assertEquals(order, result);
        verify(repository).save(order);
    }

    @Test
    void removeAllShouldCallRepositoryDeleteAll() {
        FlowerOrderRepository repository = mock(FlowerOrderRepository.class);
        FlowerOrderService service = new FlowerOrderService(repository);

        service.removeAll();

        verify(repository).deleteAll();
    }

    @Test
    void addTestOrdersShouldSaveThreeOrders() {
        FlowerOrderRepository repository = mock(FlowerOrderRepository.class);
        FlowerOrderService service = new FlowerOrderService(repository);

        service.addTestOrders();

        verify(repository, times(3)).save(any(FlowerOrder.class));
    }

    @Test
    void addWrongOrderShouldThrowException() {
        FlowerOrderRepository repository = mock(FlowerOrderRepository.class);
        FlowerOrderService service = new FlowerOrderService(repository);

        assertThrows(
                FlowerOrderException.class,
                service::addWrongOrder
        );

        verify(repository, never()).save(any(FlowerOrder.class));
    }

    @Test
    void removeOrderShouldCallRepositoryDeleteById() {

        FlowerOrderRepository repository =
                mock(FlowerOrderRepository.class);

        FlowerOrderService service =
                new FlowerOrderService(repository);

        service.removeOrder(2001L);

        verify(repository).deleteById(2001L);
    }
}