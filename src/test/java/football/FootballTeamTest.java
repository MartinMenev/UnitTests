package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FootballTeamTest {
    FootballTeam footballTeam;
    Footballer footballer;

    @Before
    public void setup() {
        footballTeam = new FootballTeam("Dunav", 1);
    }
    @Test
    public void testConstructor() {
        footballTeam = new FootballTeam("Dunav", 2);

        assertEquals(2, footballTeam.getVacantPositions());
        assertEquals("Dunav", footballTeam.getName());
        assertEquals(0, footballTeam.getCount());
    }

    @Test (expected = NullPointerException.class)
    public void testConstructorThrows() {
        footballTeam = new FootballTeam(null, 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeVacancy() {
        footballTeam = new FootballTeam("Dunav", -1);
    }

    @Test
    public void testAddSuccessfully() {
        footballer = new Footballer("Pesho");
        footballTeam.addFootballer(footballer);
        assertEquals(1, footballTeam.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddingInFullCapacity() {
        footballTeam.addFootballer(new Footballer("Pesho"));
        footballTeam.addFootballer(new Footballer("Dimo"));
    }

    @Test
    public void testRemove() {
        footballer = new Footballer("Pesho");
        footballTeam.addFootballer(footballer);
        assertTrue(footballer.isActive());
        footballTeam.removeFootballer("Pesho");
        assertEquals(0, footballTeam.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveNull() {
        footballTeam.removeFootballer(null);
    }

    @Test
    public void testForSale() {
        footballer = new Footballer("Pesho");
        footballTeam.addFootballer(footballer);
        Footballer forSale = footballTeam.footballerForSale("Pesho");
        assertEquals(footballer, forSale);
        assertFalse(footballer.isActive());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testForSaleNullInput() {
        footballTeam.footballerForSale(null);
    }

    @Test
    public void testStatistics() {
        footballer = new Footballer("Marto");
        footballTeam.addFootballer(footballer);
        String expectedText = "The footballer Marto is in the team Dunav.";
        assertEquals(expectedText, footballTeam.getStatistics());
    }

}