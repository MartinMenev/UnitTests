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
        database = new Database(NUMBERS);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfConstructorAcceptedZeroValues () throws OperationNotSupportedException {
        Database database = new Database ();
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfConstructorAcceptedMoreThan16Values() throws OperationNotSupportedException {
        Integer[] testArray = new Integer[17];
        Database database = new Database (testArray);
    }

    @Test
    public void testIfConstructorSetCorrectElementsCount() throws OperationNotSupportedException {
        int numberOfInputIntegers = NUMBERS.length;
        Assert.assertEquals(numberOfInputIntegers, Arrays.stream(database.getElements()).count());
        Assert.assertArrayEquals(NUMBERS, database.getElements());
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
        int lastElementFromDB = database.getElements()[database.getElements().length -1];

        Assert.assertEquals(testValue, lastElementFromDB);
        Assert.assertEquals(initialSize + 1, database.getElements().length);
    }

    @Test
    public void testIfGetElementsReturnsElementsArray() throws OperationNotSupportedException {
        Assert.assertArrayEquals(NUMBERS, database.getElements());
    }

    @Test
    public void testRemoveElement () throws OperationNotSupportedException {
        database.remove();
        Integer expectedInteger = NUMBERS[NUMBERS.length -2];
        Assert.assertEquals(NUMBERS.length -1, database.getElements().length);
        Assert.assertEquals(expectedInteger, database.getElements()[database.getElements().length -1]);
    }
    @Test (expected = OperationNotSupportedException.class)
    public void testForExceptionIfRemovingElementFromEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }
}