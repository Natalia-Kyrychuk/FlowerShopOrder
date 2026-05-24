package at.spengergasse.views.preis;

import at.spengergasse.views.MainLayout;
import at.spengergasse.views.flowershoporder.FlowerShopOrderView;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Prices")
@Route(value = "preise", layout = MainLayout.class)
public class PreisView extends VerticalLayout {

    public PreisView() {

        setSpacing(false);

        VerticalLayout header = FlowerShopOrderView.getHeader();

        H1 title = new H1("Flower Prices");
        title.getStyle()
                .set("font-family", "cursive")
                .set("font-size", "5rem")
                .set("margin", "0")
                .set("color", "#c2185b");

        FlexLayout categories = new FlexLayout();

        VerticalLayout category1 = getCard(
                "Bouquets",
                "Small bouquet: 15.00€",
                "Medium bouquet: 25.00€",
                "Large bouquet: 40.00€"
        );

        VerticalLayout category2 = getCard(
                "Single Flowers",
                "Rose: 3.50€",
                "Tulip: 2.50€",
                "Lily: 4.00€",
                "Sunflower: 3.00€"
        );

        VerticalLayout category3 = getCard(
                "Special Orders",
                "Wedding bouquet: from 70.00€",
                "Birthday bouquet: from 30.00€",
                "Funeral arrangement: from 60.00€",
                "Table decoration: from 35.00€"
        );

        VerticalLayout category4 = getCard(
                "Delivery",
                "Delivery in Vienna: 6.00€",
                "Express delivery: 10.00€",
                "Pickup in shop: free"
        );

        VerticalLayout category5 = getCard(
                "Gift Extras",
                "Greeting card: 4.00€",
                "Chocolate box: 12.00€",
                "Teddy bear: 18.00€",
                "Glass vase: 15.00€"
        );

        categories.add(category1, category2, category3, category4, category5);
        categories.setWidthFull();
        categories.setJustifyContentMode(JustifyContentMode.CENTER);
        categories.setFlexWrap(FlexLayout.FlexWrap.WRAP);

        Paragraph info = new Paragraph("Inklusive Steuern.");

        add(header, title, categories, info);

        setWidthFull();
        setMinHeight("100vh");

        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        getStyle()
                .set("text-align", "center")
                .set("background-color", "#ffd6e7");
    }

    public VerticalLayout getCard(String categoryName, String price1, String price2, String price3) {

        VerticalLayout category = new VerticalLayout();

        H2 categoryTitle = new H2(categoryName);
        Paragraph paragraph1 = new Paragraph(price1);
        Paragraph paragraph2 = new Paragraph(price2);
        Paragraph paragraph3 = new Paragraph(price3);

        category.add(categoryTitle, paragraph1, paragraph2, paragraph3);

        category.setWidth("350px");
        category.setPadding(true);
        category.setSpacing(false);
        category.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        category.getStyle()
                .set("border", "1px solid lightgray")
                .set("border-radius", "10px")
                .set("margin", "10px")
                .set("background-color", "white");

        return category;
    }

    public VerticalLayout getCard(String categoryName, String price1, String price2, String price3, String price4) {

        VerticalLayout category = new VerticalLayout();

        H2 categoryTitle = new H2(categoryName);
        Paragraph paragraph1 = new Paragraph(price1);
        Paragraph paragraph2 = new Paragraph(price2);
        Paragraph paragraph3 = new Paragraph(price3);
        Paragraph paragraph4 = new Paragraph(price4);

        category.add(categoryTitle, paragraph1, paragraph2, paragraph3, paragraph4);

        category.setWidth("350px");
        category.setPadding(true);
        category.setSpacing(false);
        category.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        category.getStyle()
                .set("border", "1px solid lightgray")
                .set("border-radius", "10px")
                .set("margin", "10px")
                .set("background-color", "white");

        return category;
    }
}