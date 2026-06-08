package at.spengergasse.views.preis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreisViewTest {

    @Test
    void preisViewShouldBeCreated() {
        PreisView view = new PreisView();

        assertNotNull(view);
    }

    @Test
    void preisViewShouldContainComponents() {

        PreisView view = new PreisView();

        assertTrue(view.getComponentCount() > 0);
    }
}