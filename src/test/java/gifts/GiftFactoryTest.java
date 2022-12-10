package gifts;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class GiftFactoryTest {
    private GiftFactory giftFactory;
    private Gift book;

    @Before
    public void setup() {
        giftFactory = new GiftFactory();
        book = new Gift("Book", 12.5);
    }

    @Test
    public void testConstructor() {
        giftFactory = new GiftFactory();
        assertEquals(0, giftFactory.getCount());
    }

    @Test
    public void testCreateGift() {

        giftFactory.createGift(book);
        assertEquals(book, giftFactory.getPresent("Book"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCreateGiftThrowsIfGiftAlreadyExists() {
        giftFactory.createGift(book);
        book = new Gift("Book", 2.5);
        giftFactory.createGift(book);
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveShouldThrowIfNullName() {
        giftFactory.removeGift(null);
    }

    @Test
    public void testRemove() {
        giftFactory.createGift(book);
        assertTrue(giftFactory.removeGift("Book"));
    }

    @Test
    public void testGetPresents() {
        Gift book2 = new Gift("My book", 32.5);
        Gift smartphone = new Gift("Smart", 100);
        giftFactory.createGift(book);
        giftFactory.createGift(book2);
        giftFactory.createGift(smartphone);
        List<Gift> giftList = List.of(book, book2, smartphone);

        assertEquals(book2, giftFactory.getPresent("My book"));

        assertArrayEquals(giftList.toArray(), giftFactory.getPresents().toArray());
        assertEquals(3, giftFactory.getCount());
    }

    @Test
    public void testGetPresentWithLeastMagic() {
        Gift book2 = new Gift("My book", 32.5);
        giftFactory.createGift(book);
        giftFactory.createGift(book2);
        assertEquals(book, giftFactory.getPresentWithLeastMagic());
    }
}