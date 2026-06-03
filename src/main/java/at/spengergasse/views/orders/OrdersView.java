package at.spengergasse.views.orders;

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
            new Grid<>(FlowerOrder.class, true);

    private final FlowerOrderService flowerOrderService;

    private final Button buttonRemoveAll =
            new Button("Remove all orders");

    private final Button buttonAdd10 =
            new Button("Add 10 orders");

    public OrdersView(FlowerOrderService flowerOrderService) {
        this.flowerOrderService = flowerOrderService;

        setSpacing(true);
        setSizeFull();

        grid.setSizeFull();

        HorizontalLayout buttons =
                new HorizontalLayout(buttonRemoveAll, buttonAdd10);

        buttons.setSpacing(true);

        add(buttons, grid);
        buttonRemoveAll.addClickListener(
                b -> removeAllOrders());

        buttonAdd10.addClickListener(
                b -> add10Orders());

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
}