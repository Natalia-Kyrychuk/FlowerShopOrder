package at.spengergasse.views.preis;

import at.spengergasse.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Preise")
@Route(value = "preise", layout = MainLayout.class)

public class PreisView extends VerticalLayout {

    public PreisView() {

        setSpacing(false);

        Image img = new Image("images/empty-plant.png", "placeholder plant");
        img.setWidth("200px");

        add(img);

        H2 header = new H2("Preise");

        header.addClassNames(
                Margin.Top.XLARGE,
                Margin.Bottom.MEDIUM
        );

        add(header);

        add(new Paragraph("Hier kommen später die Preise."));

        setSizeFull();

        setJustifyContentMode(JustifyContentMode.CENTER);

        setDefaultHorizontalComponentAlignment(
                Alignment.CENTER
        );

        getStyle().set("text-align", "center");
    }
}