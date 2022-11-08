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
    private ListIterator listIterator;

    public ListIteratorTest() throws OperationNotSupportedException {
    }

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

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNullValue() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void move() {
        Assert.assertTrue(listIterator.move());

        for (int i = 0; i < elements.length; i++) {
            listIterator.move();
        }

        Assert.assertFalse(listIterator.move());
    }

    @Test
    public void testHasNext() {
        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void testHasNotNext() {
        for (int i = 0; i < elements.length; i++) {
            listIterator.move();
        }
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintWithNullValues() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }


}