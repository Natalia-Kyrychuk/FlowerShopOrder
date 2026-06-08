package at.spengergasse.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FlowerOrderTest {

    @Test
    void constructorWithIdShouldSetAllValues() {

        FlowerOrder order = new FlowerOrder(
                1L,
                LocalDate.of(2026, 6, 8),
                "Rose",
                2,
                7.00,
                true
        );

        assertEquals(1L, order.getOrderId());
        assertEquals(LocalDate.of(2026, 6, 8), order.getOrderDate());
        assertEquals("Rose", order.getFlower());
        assertEquals(2, order.getQuantity());
        assertEquals(7.00, order.getPrice());
        assertTrue(order.getDelivery());
    }

    @Test
    void constructorWithoutIdShouldGenerateId() {

        FlowerOrder order = new FlowerOrder(
                LocalDate.now(),
                "Tulip",
                3,
                10.00,
                false
        );

        assertNotNull(order.getOrderId());
        assertTrue(order.getOrderId() >= 1000);
    }

    @Test
    void setValidFlowerShouldWork() {

        FlowerOrder order = new FlowerOrder();

        order.setFlower("Orchid");

        assertEquals("Orchid", order.getFlower());
    }

    @Test
    void invalidFlowerShouldThrowException() {

        FlowerOrder order = new FlowerOrder();

        assertThrows(
                FlowerOrderException.class,
                () -> order.setFlower("Apple")
        );
    }

    @Test
    void invalidPriceShouldThrowException() {

        FlowerOrder order = new FlowerOrder();

        assertThrows(
                FlowerOrderException.class,
                () -> order.setPrice(0.0)
        );
    }

    @Test
    void validPriceShouldBeStored() {

        FlowerOrder order = new FlowerOrder();

        order.setPrice(5.50);

        assertEquals(5.50, order.getPrice());
    }

    @Test
    void invalidQuantityShouldThrowException() {

        FlowerOrder order = new FlowerOrder();

        assertThrows(
                FlowerOrderException.class,
                () -> order.setQuantity(0)
        );
    }

    @Test
    void validQuantityShouldBeStored() {

        FlowerOrder order = new FlowerOrder();

        order.setQuantity(4);

        assertEquals(4, order.getQuantity());
    }

    @Test
    void equalsShouldCompareOrderId() {

        FlowerOrder order1 = new FlowerOrder(
                100L,
                LocalDate.now(),
                "Rose",
                1,
                3.50,
                false
        );

        FlowerOrder order2 = new FlowerOrder(
                100L,
                LocalDate.now(),
                "Tulip",
                5,
                20.00,
                true
        );

        assertEquals(order1, order2);
    }
}