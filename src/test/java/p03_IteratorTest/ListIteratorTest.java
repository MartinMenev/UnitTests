package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import javax.naming.OperationNotSupportedException;

import java.util.DuplicateFormatFlagsException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    String[] elements;
    ListIterator listIterator;
    @Before
    public void setUp() throws Exception {
        elements = new String[]{"Ivan", "Pesho", "Assen"};
        listIterator = new ListIterator(elements);
    }

    @Test
    public void testConstructor() {
        for (String element : elements) {
            Assert.assertEquals(element, listIterator.print());
            listIterator.move();
        }
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorWithNullValue() throws OperationNotSupportedException {
        ListIterator listIterator1 = new ListIterator(null);
    }

    @Test
    public void move() {
        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void testHasNext() {
        Assert.assertTrue(listIterator.move());
    }

    @Test
    public void testPrint() throws OperationNotSupportedException {
        try {
            ListIterator listIterator1 = new ListIterator((String) null);
            listIterator1.print();
        } catch (IllegalStateException ex){
            Assert.assertEquals("Invalid Operation!", ex.getMessage());
        }
    }
}