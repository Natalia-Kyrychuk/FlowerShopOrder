package at.spengergasse.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.server.menu.MenuConfiguration;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.component.icon.VaadinIcon;

@Layout
@AnonymousAllowed
public class MainLayout extends AppLayout implements AfterNavigationObserver {

    private H1 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);

        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H1();
        viewTitle.addClassNames(
                LumoUtility.FontSize.LARGE,
                LumoUtility.Margin.NONE
        );

        addToNavbar(true, toggle, viewTitle);

        getElement().executeJs(
                "this.shadowRoot.querySelector('[part=\"navbar\"]').style.backgroundColor = '#ff69b4';"
        );
    }

    private void addDrawerContent() {
        Span appName = new Span("Flower Shop");
        appName.addClassNames(
                LumoUtility.FontWeight.SEMIBOLD,
                LumoUtility.FontSize.LARGE
        );

        Header header = new Header(appName);
        header.getStyle()
                .set("background-color", "#ff69b4")
                .set("padding", "20px");

        Scroller scroller = new Scroller(createNavigation());
        scroller.getStyle()
                .set("background-color", "#ffb6c1");

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        nav.addItem(
                new SideNavItem(
                        "Home",
                        "",
                        VaadinIcon.HOME.create()
                )
        );

        nav.addItem(
                new SideNavItem(
                        "Preise",
                        "preise",
                        VaadinIcon.MONEY.create()
                )
        );

        nav.addItem(
                new SideNavItem(
                        "Sortiment",
                        "sortiment",
                        VaadinIcon.PACKAGE.create()
                )
        );

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();
        layout.getStyle()
                .set("background-color", "#ffb6c1");
        return layout;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        return MenuConfiguration.getPageHeader(getContent()).orElse("");
    }
}