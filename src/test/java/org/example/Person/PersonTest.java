package org.example.Person;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PersonTest {

    Person personMock = Mockito.mock(Person.class);

    @Before
    public void setup() {

    }

    @Test
    public void testIfAgeHasIncreased() {
        Person person = new Person(27);

        Assert.assertEquals(30, person.changeAge(3));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIfExceptionWillBeThrownWithNegativeAgeChange() {
        Person person = new Person (10);
        person.changeAge(-3);
    }
}