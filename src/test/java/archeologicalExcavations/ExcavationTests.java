package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExcavationTests {
    Archaeologist archaeologist;

    @Test (expected = IllegalArgumentException.class)
    public void testExcavationWithZeroCapacity() {
        Excavation excavation = new Excavation("Test", -1);
    }

    @Test (expected = NullPointerException.class)
    public void testExcavationWithNullName() {
        Excavation excavation = new Excavation(null, 5);
    }

    @Test (expected = NullPointerException.class)
    public void testExcavationWithoutName() {
        Excavation excavation = new Excavation("", 5);
    }

    @Test
    public void testSuccessfullyExcavation() {
        Excavation excavation = new Excavation("Test", 5);
        assertEquals("Test", excavation.getName());
    }

    @Test
    public void testAddArchaeologist() {
        Excavation excavation = new Excavation("Test", 3);
        archaeologist = new Archaeologist("Pesho", 17);
        excavation.addArchaeologist(archaeologist);
        archaeologist = new Archaeologist("Gosho", 1);
        excavation.addArchaeologist(archaeologist);
        archaeologist = new Archaeologist("Tosho", 10);
        excavation.addArchaeologist(archaeologist);
        assertEquals(3, excavation.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddMoreArchaeologist() {
        Excavation excavation = new Excavation("Test", 1);
        archaeologist = new Archaeologist("Pesho", 17);
        excavation.addArchaeologist(archaeologist);
        archaeologist = new Archaeologist("Gosho", 1);
        excavation.addArchaeologist(archaeologist);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddExistingArchaeologist() {
        Excavation excavation = new Excavation("Test", 2);
        archaeologist = new Archaeologist("Pesho", 17);
        excavation.addArchaeologist(archaeologist);
        archaeologist = new Archaeologist("Pesho", 1);
        excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void testRemoveArchaeologist() {
        Excavation excavation = new Excavation("Test", 2);
        archaeologist = new Archaeologist("Pesho", 17);
        assertFalse(excavation.removeArchaeologist("Pesho"));

        excavation.addArchaeologist(archaeologist);

        assertTrue(excavation.removeArchaeologist("Pesho"));
        assertFalse(excavation.removeArchaeologist("Gosho"));
    }
}
