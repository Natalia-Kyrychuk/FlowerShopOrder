package at.spengergasse.views.sortiment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortimentViewTest {

    @Test
    void sortimentViewShouldBeCreated() {

        SortimentView view = new SortimentView();

        assertNotNull(view);
    }

    @Test
    void sortimentViewShouldContainComponents() {

        SortimentView view = new SortimentView();

        assertTrue(view.getComponentCount() > 0);
    }
}