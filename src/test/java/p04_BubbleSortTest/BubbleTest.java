package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testSort() {
        int[] numbers = {8, -1, 0};
        int[] expectedResult = {-1, 0, 8};
        Bubble.sort(numbers);
        assertArrayEquals(expectedResult, numbers);
    }

}