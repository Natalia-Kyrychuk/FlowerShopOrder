
package at.spengergasse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import java.util.Arrays;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "orderId")
@Entity
public class FlowerOrder
{
    @Id
    private Long orderId;

    @NotNull(message = "Order date is required")
    private LocalDate orderDate;

    @NotNull(message = "Flower is required")
    @Pattern(
            regexp = "Rose|Tulip|Lily|Sunflower|Orchid",
            message = "Flower must be Rose, Tulip, Lily, Sunflower or Orchid"
    )
    private String flower;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "1.0", message = "Price must be at least 1.00 Euro")
    private Double price;

    @NotNull(message = "Delivery is required")
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
