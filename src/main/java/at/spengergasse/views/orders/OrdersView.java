package at.spengergasse.views.orders;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import at.spengergasse.model.FlowerOrder;
import at.spengergasse.service.FlowerOrderService;
import at.spengergasse.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

@PageTitle("Orders")
@Route(value = "orders", layout = MainLayout.class)
public class OrdersView extends VerticalLayout {

    private final Grid<FlowerOrder> grid =
            new Grid<>(FlowerOrder.class, false);

    private final FlowerOrderService flowerOrderService;

    private final Button buttonRemoveAll =
            new Button("Remove all orders");

    private final Button buttonAdd10 =
            new Button("Add 10 orders");

    private final Button buttonAddWrong =
            new Button("Add WRONG order");

    public OrdersView(FlowerOrderService flowerOrderService) {
        this.flowerOrderService = flowerOrderService;

        setSpacing(true);
        setSizeFull();

        grid.addColumn(FlowerOrder::getOrderId)
                .setHeader("Order ID")
                .setSortable(true);

        grid.addColumn(FlowerOrder::getOrderDate)
                .setHeader("Order Date")
                .setSortable(true);

        Image flowerImage = new Image("images/logo.png", "Flower");
        flowerImage.setWidth("32px");

        grid.addColumn(FlowerOrder::getFlower)
                .setHeader(new HorizontalLayout(
                        flowerImage,
                        new Span("Flower")
                ))
                .setSortable(true);

        grid.addColumn(FlowerOrder::getPrice)
                .setHeader("Price")
                .setSortable(true);

        grid.addColumn(FlowerOrder::getQuantity)
                .setHeader("Quantity")
                .setSortable(true);

        grid.addComponentColumn(order -> {
                    com.vaadin.flow.component.checkbox.Checkbox cb =
                            new com.vaadin.flow.component.checkbox.Checkbox(order.getDelivery());

                    cb.setReadOnly(true);
                    return cb;
                })
                .setHeader("Delivery")
                .setSortable(true)
                .setComparator(FlowerOrder::getDelivery);
        grid.addComponentColumn(order ->
                        new Button("Delete",
                                e -> removeSelected(order.getOrderId())))
                .setHeader("Task")
                .setSortable(false);
        grid.addComponentColumn(order ->
                        new Button("One More",
                                e -> oneMore(order.getOrderId())))
                .setHeader("More")
                .setSortable(false);
        grid.setSizeFull();

        HorizontalLayout buttons =
                new HorizontalLayout(buttonRemoveAll, buttonAdd10, buttonAddWrong);

        buttons.setSpacing(true);

        add(buttons, grid);
        buttonRemoveAll.addClickListener(
                b -> removeAllOrders());

        buttonAdd10.addClickListener(
                b -> add10Orders());

        buttonAddWrong.addClickListener(
                b -> addWrongOrder());

        reload();
    }

    private void reload() {
        grid.setItems(flowerOrderService.findAll());
    }

    private void removeAllOrders() {
        flowerOrderService.removeAll();
        buttonRemoveAll.setEnabled(false);
        reload();
    }

    private void add10Orders() {
        flowerOrderService.addTestOrders();
        buttonRemoveAll.setEnabled(true);
        reload();
    }

    private void addWrongOrder() {
        try {
            flowerOrderService.addWrongOrder();
            reload();
        }
        catch (Exception e) {
            com.vaadin.flow.component.notification.Notification.show(e.getMessage());
        }
    }

    private void removeSelected(Long orderId) {

        flowerOrderService.removeOrder(orderId);

        reload();
    }

    private void oneMore(Long orderId) {
        try {
            flowerOrderService.oneMore(orderId);
            reload();
        }
        catch (Exception e) {
            com.vaadin.flow.component.notification.Notification.show(e.getMessage());
        }
    }
}