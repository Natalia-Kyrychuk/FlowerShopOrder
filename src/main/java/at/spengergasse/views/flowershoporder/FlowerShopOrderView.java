package at.spengergasse.views.flowershoporder;

import at.spengergasse.views.MainLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Home")
@Route(value = "", layout = MainLayout.class)
public class FlowerShopOrderView extends VerticalLayout {

    public FlowerShopOrderView() {

        setSpacing(false);

        VerticalLayout topHeader = getHeader();

        HorizontalLayout logoText = new HorizontalLayout();

        Image logo = new Image("images/logo.png", "Flower Shop Logo");
        logo.setWidth("500px");

        Paragraph line1 = new Paragraph(
                "Flower Shop Order offers beautiful fresh flowers and elegant bouquets for every occasion. " +
                        "Our shop creates unique floral arrangements for birthdays, weddings, anniversaries and many other special moments. " +
                        "We always focus on quality, creativity and customer satisfaction."
        );

        line1.setWidth("500px");
        line1.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");

        logoText.add(logo, line1);
        logoText.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        Paragraph line2 = new Paragraph(
                "With carefully selected flowers and modern designs, we help our customers express emotions in a special way. " +
                        "We provide friendly service, flexible orders and reliable delivery. " +
                        "Every bouquet is prepared with attention to detail and love for flowers."
        );

        line2.setWidth("500px");
        line2.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");

        Paragraph line3 = new Paragraph(
                "Flower Shop Order is more than just a flower store — it is a place where beauty and emotions come together. " +
                        "Whether you need a romantic bouquet, a festive decoration or a simple gift, we are here to help. " +
                        "Trust our experience and passion for creating unforgettable floral moments."
        );

        line3.setWidth("500px");
        line3.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");

        HorizontalLayout address = new HorizontalLayout();

        H3 shopName = new H3("Flower Shop Order");
        H3 street = new H3("Spengergasse 20");
        H3 city = new H3("1050 Wien");

        address.add(shopName, street, city);

        add(topHeader, logoText, line2, line3, address);

        setWidthFull();
        setMinHeight("100vh");

        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        getStyle()
                .set("text-align", "center")
                .set("background-color", "#ffd6e7");
    }

    public static VerticalLayout getHeader() {

        VerticalLayout header = new VerticalLayout();

        H1 company = new H1("Flower Shop Order");
        company.getStyle()
                .set("font-family", "cursive")
                .set("font-size", "6rem")
                .set("margin", "0");

        H2 subName = new H2("... beautiful flowers for every occasion ...");
        subName.getStyle()
                .set("margin", "0")
                .set("color", "gray");

        header.add(company, subName);
        header.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        return header;
    }
}