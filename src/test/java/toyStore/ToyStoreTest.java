package toyStore;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ToyStoreTest {
    Toy toy;
    ToyStore toyStore;

    @Before
    public void setUp() throws Exception {
        toy = new Toy("TestManufacturer","123");
        toyStore = new ToyStore();
    }
    @Test
    public void testToyConstructor() {
        assertEquals(7, toyStore.getToyShelf().size());
        assertEquals("TestManufacturer", toy.getManufacturer());
    }

    @Test
    public void testAddToySuccessfully() throws OperationNotSupportedException {
        assertEquals("Toy:123 placed successfully!",toyStore.addToy("A", toy));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddToyThrowsWithInvalidShelf() throws OperationNotSupportedException {
        toyStore.addToy("Z", toy);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddToyThrowsWithTakenShelf() throws OperationNotSupportedException {
        toyStore.addToy("A", toy);
        toyStore.addToy("A", toy);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddToyThrowsWithAlreadyTakenToy() throws OperationNotSupportedException {
        toyStore.addToy("A", toy);
        toyStore.addToy("B", toy);
    }

    @Test
    public void testRemoveToySuccessfully() throws OperationNotSupportedException {
        toyStore.addToy("A", toy);
        assertEquals("Remove toy:123 successfully!", toyStore.removeToy("A", toy));
        Map<String, String> testMap = new LinkedHashMap<>();
        assertNull(toyStore.getToyShelf().get("A"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveToyFromWrongShelfThrows() throws OperationNotSupportedException {
        toyStore.addToy("A", toy);
        toyStore.removeToy("B", toy);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveToyFromMissingShelfThrows() throws OperationNotSupportedException {
        toyStore.addToy("A", toy);
        toyStore.removeToy("Z", toy);
    }




}