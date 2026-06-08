package at.spengergasse.views.flowershoporder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerShopOrderViewTest {

    @Test
    void homeViewShouldBeCreated() {

        FlowerShopOrderView view = new FlowerShopOrderView();

        assertNotNull(view);
    }

    @Test
    void homeViewShouldContainComponents() {

        FlowerShopOrderView view = new FlowerShopOrderView();

        assertTrue(view.getComponentCount() > 0);
    }
}