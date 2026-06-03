package at.spengergasse.views.orders;

import at.spengergasse.model.FlowerOrder;
import at.spengergasse.service.FlowerOrderService;
import at.spengergasse.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Orders")
@Route(value = "orders", layout = MainLayout.class)
public class OrdersView extends VerticalLayout {

    private final Grid<FlowerOrder> grid =
            new Grid<>(FlowerOrder.class, true);

    private final FlowerOrderService flowerOrderService;

    public OrdersView(FlowerOrderService flowerOrderService) {
        this.flowerOrderService = flowerOrderService;

        setSpacing(true);
        setSizeFull();

        grid.setSizeFull();

        add(grid);

        reload();
    }

    private void reload() {
        grid.setItems(flowerOrderService.findAll());
    }
}