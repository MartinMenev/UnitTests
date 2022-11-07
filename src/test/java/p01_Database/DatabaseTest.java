package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DatabaseTest {
        private Database database;
        private final static Integer [] NUMBERS = {1,2,3,4,5};

    @Before
    public void setUp() throws Exception {
        database = new Database();
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testForExceptionIfSizeNot16 () throws OperationNotSupportedException {

        assertEquals(16, database.getElements().length);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testForExceptionIfAddedElementIsNull () throws OperationNotSupportedException {

        database.add(null);
    }

    @Test
    public void testAdd () throws OperationNotSupportedException {
        Database database = new Database(NUMBERS);
        int testValue = 3;
        int initialSize = database.getElements().length;

        database.add(testValue);
        int lastElementFromDB = database.getElements().length - 1;

        Assert.assertEquals(testValue, lastElementFromDB);
        Assert.assertEquals(initialSize + 1, database.getElements().length);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testForExceptionIfRemovingElementFromEmptyDatabase() throws OperationNotSupportedException {
        Database database = new Database();
        database.remove();
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfConstructorAcceptedZeroValues () throws OperationNotSupportedException {

        Database database = new Database ();
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfConstructorAcceptedMoreThan16Values () throws OperationNotSupportedException {
        Integer[] testArray = new Integer[17];
        Database database = new Database (testArray);
    }

    @Test
    public void testIfConstructorSetCorrectElementsCount () throws OperationNotSupportedException {

        Database database = new Database (1,2,3,4,5);
        Assert.assertEquals(5, Arrays.stream(database.getElements()).count());
    }


    @Test
    public void testIfGetElementsReturnsElementsArray() throws OperationNotSupportedException {
        Database database = new Database(1, 2, 4);
        Integer[] array = database.getElements();
        Assert.assertArrayEquals(array, database.getElements());
    }

    @Test
    public void testRemoveElement () throws OperationNotSupportedException {
        Database database = new Database(1, 2, 4);
        database.remove();
        Assert.assertEquals(2, database.getElements().length);
    }

    @Test
    public void testCreateBase () throws OperationNotSupportedException {
        Integer[] numbers = {5, 8, 21, 68, -5};
        Database database = new Database(numbers);
        Assert.assertEquals(numbers.length, database.getElements().length);
        Assert.assertEquals(numbers.length -1, database.getElements().length -1);
        Assert.assertArrayEquals(numbers, database.getElements());
    }
}