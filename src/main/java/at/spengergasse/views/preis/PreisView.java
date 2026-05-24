package at.spengergasse.views.preis;

import at.spengergasse.views.MainLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Prices")
@Route(value = "preise", layout = MainLayout.class)

public class PreisView extends VerticalLayout {

    public PreisView() {

        setSpacing(false);

        H1 title = new H1("Flower Prices");
        title.getStyle()
                .set("font-family", "cursive")
                .set("font-size", "5rem")
                .set("margin", "0")
                .set("color", "#c2185b");

        H2 category1 = new H2("Bouquets");
        Paragraph bouquetSmall = new Paragraph("Small bouquet: 15.00€");
        Paragraph bouquetMedium = new Paragraph("Medium bouquet: 25.00€");
        Paragraph bouquetLarge = new Paragraph("Large bouquet: 40.00€");

        H2 category2 = new H2("Single Flowers");
        Paragraph rose = new Paragraph("Rose: 3.50€");
        Paragraph tulip = new Paragraph("Tulip: 2.50€");
        Paragraph lily = new Paragraph("Lily: 4.00€");
        Paragraph sunflower = new Paragraph("Sunflower: 3.00€");

        H2 category3 = new H2("Special Orders");
        Paragraph wedding = new Paragraph("Wedding bouquet: from 70.00€");
        Paragraph birthday = new Paragraph("Birthday bouquet: from 30.00€");
        Paragraph funeral = new Paragraph("Funeral arrangement: from 60.00€");
        Paragraph decoration = new Paragraph("Table decoration: from 35.00€");

        H2 category4 = new H2("Delivery");
        Paragraph deliveryVienna = new Paragraph("Delivery in Vienna: 5.00€");
        Paragraph expressDelivery = new Paragraph("Express delivery: 10.00€");
        Paragraph pickup = new Paragraph("Pickup in shop: free");

        H2 category5 = new H2("Gift Extras");

        Paragraph card = new Paragraph("Greeting card: 4.00€");
        Paragraph chocolate = new Paragraph("Chocolate box: 12.00€");
        Paragraph teddy = new Paragraph("Teddy bear: 18.00€");
        Paragraph vase = new Paragraph("Glass vase: 15.00€");

        add(
                title,

                category1,
                bouquetSmall,
                bouquetMedium,
                bouquetLarge,

                category2,
                rose,
                tulip,
                lily,
                sunflower,

                category3,
                wedding,
                birthday,
                funeral,
                decoration,

                category4,
                deliveryVienna,
                expressDelivery,
                pickup,

                category5,
                card,
                chocolate,
                teddy,
                vase
        );

        setWidthFull();

        setDefaultHorizontalComponentAlignment(
                FlexComponent.Alignment.CENTER
        );

        getStyle()
                .set("text-align", "center")
                .set("background-color", "#ffd6e7");
    }
}