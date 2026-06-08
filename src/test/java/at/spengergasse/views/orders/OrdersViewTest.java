package at.spengergasse.views.orders;

import at.spengergasse.service.FlowerOrderService;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrdersViewTest
{
    @Test
    void ordersViewShouldBeCreated() {

        FlowerOrderService service =
                mock(FlowerOrderService.class);

        OrdersView view =
                new OrdersView(service);

        assertNotNull(view);
    }

    @Test
    void ordersViewShouldContainComponents() {

        FlowerOrderService service =
                mock(FlowerOrderService.class);

        OrdersView view =
                new OrdersView(service);

        assertTrue(view.getComponentCount() >= 2);
    }

    @Test
    void constructorShouldLoadOrders() {

        FlowerOrderService service =
                mock(FlowerOrderService.class);

        when(service.findAll())
                .thenReturn(Collections.emptyList());

        new OrdersView(service);

        verify(service).findAll();
    }

}