
package at.spengergasse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import java.util.Arrays;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "orderId")
@Entity
public class FlowerOrder
{
    @Id
    private Long orderId;
    private LocalDate orderDate;
    private String flower;
    private Integer quantity;
    private Double price;
    private Boolean delivery;

    private static Long nextId = 1000L;

    private static final String[] flowers = {
            "Rose",
            "Tulip",
            "Lily",
            "Sunflower",
            "Orchid"
    };

    public FlowerOrder() {
    }

    public FlowerOrder(
            Long orderId,
            LocalDate orderDate,
            String flower,
            Integer quantity,
            Double price,
            Boolean delivery) {

        setOrderId(orderId);
        setOrderDate(orderDate);
        setFlower(flower);
        setQuantity(quantity);
        setPrice(price);
        setDelivery(delivery);
    }

    public FlowerOrder(
            LocalDate orderDate,
            String flower,
            Integer quantity,
            Double price,
            Boolean delivery) {

        setOrderId();
        setOrderDate(orderDate);
        setFlower(flower);
        setQuantity(quantity);
        setPrice(price);
        setDelivery(delivery);
    }

    public void setOrderId() {
        this.orderId = nextId++;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setPrice(Double price) {
        if (price < 1) {
            throw new FlowerOrderException("Price must be at least 1.00 Euro");
        }

        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        if (quantity < 1) {
            throw new FlowerOrderException("Quantity must be at least 1");
        }

        this.quantity = quantity;
    }

    public void setFlower(String flower) {

        if (Arrays.asList(flowers).contains(flower) == false) {
            throw new FlowerOrderException(
                    "Flower must be one of: " + Arrays.toString(flowers)
            );
        }

        this.flower = flower;
    }



}
