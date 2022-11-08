package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class DatabaseTest {
    Person[] people;
    Database database;
    Person person1 = new Person(43434343, "Ivan" );
    Person person2 = new Person(123456, "Pesho" );
    @Before
    public void setUp() throws Exception {
        people = new Person[]{person1, person2};
        database = new Database(people);
    }

    @Test
    public void testConstructor() {
        Assert.assertEquals(people.length, database.getElements().length);
        Assert.assertArrayEquals(people, database.getElements());
        Assert.assertEquals(people.length -1, database.getElements().length -1);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorWithElementsAboveLimit () throws OperationNotSupportedException {
        people = new Person[17];
        database = new Database(people);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorWithElementsBelowLimit () throws OperationNotSupportedException {
        database = new Database();
    }

    @Test
    public void testAdd() throws OperationNotSupportedException {
        database.add(person1);
        Assert.assertEquals(people.length + 1, database.getElements().length);
        Assert.assertEquals(person1, database.getElements()[database.getElements().length -1]);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddWithNullValue () throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemove() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(people.length -1, database.getElements().length);
        Assert.assertEquals(people[people.length -2], database.getElements()[database.getElements().length -1]);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveFromEmptyArray () throws OperationNotSupportedException {
        for (int i = 0; i < people.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testToFindByUsername() throws OperationNotSupportedException {
        Assert.assertEquals(person1, database.findByUsername(person1.getUsername()));
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testToFindNotExistingUserName() throws OperationNotSupportedException {
        String randomName = "Martin";
        database.findByUsername(randomName);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testToFindNullUserName() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void testToFindById() throws OperationNotSupportedException {
        Assert.assertEquals(person1, database.findById(person1.getId()));
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testToFindByNotExistingId() throws OperationNotSupportedException {
        Person notExistingPerson = new Person(33333, "Martin");
        Assert.assertEquals(notExistingPerson, database.findById(notExistingPerson.getId()));
    }
}