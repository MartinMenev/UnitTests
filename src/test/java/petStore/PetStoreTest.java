package petStore;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PetStoreTest {
    Animal cat;
    Animal dog;
    PetStore petStore;

    @Before
    public void setup() {
        cat = new Animal("cat", 5, 200);
        dog = new Animal("dog", 10, 150);
        petStore = new PetStore();
    }

    @Test
    public void testConstructorCreateStore() {
        assertEquals(0, petStore.getCount());
    }

    @Test
    public void testAddingAnimalsSuccessfully() {
        petStore.addAnimal(cat);
        petStore.addAnimal(dog);
        assertEquals(2, petStore.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddingAnimalsWithNullValue() {
        petStore.addAnimal(null);
    }

    @Test
    public void testToGetListAnimals() {
        List<Animal> expectedList = new ArrayList<>();
        expectedList.add(cat);
        expectedList.add(dog);

        petStore.addAnimal(cat);
        petStore.addAnimal(dog);

        assertArrayEquals(expectedList.toArray(), petStore.getAnimals().toArray());
    }

    @Test
    public void testFindAnimalsWithMaxKg() {
        petStore.addAnimal(cat);
        petStore.addAnimal(dog);
        List<Animal> expectedList = new ArrayList<>();
        expectedList.add(dog);

        assertArrayEquals(expectedList.toArray(),
                petStore.findAllAnimalsWithMaxKilograms(5).toArray());
    }

    @Test
    public void testGetMostExpensiveAnimal() {
        petStore.addAnimal(cat);
        petStore.addAnimal(dog);
        Animal expectedAnimal = cat;
        assertEquals(expectedAnimal, petStore.getTheMostExpensiveAnimal());
    }

    @Test
    public void testFindAllBySpecie() {
        petStore.addAnimal(cat);
        petStore.addAnimal(dog);
        List<Animal> expectedList = new ArrayList<>();
        expectedList.add(dog);

        assertArrayEquals(expectedList.toArray(),
                petStore.findAllAnimalBySpecie("dog").toArray());
    }
}