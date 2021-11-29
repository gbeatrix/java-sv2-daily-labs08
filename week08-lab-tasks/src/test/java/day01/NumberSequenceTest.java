package day01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberSequenceTest {
    @Test
    void test() {
        List<Integer> numbers = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
        NumberSequence ns1 = new NumberSequence(numbers);
        assertEquals(numbers, ns1.closeToAverage(5));

        numbers.remove(9);
        numbers.remove(0);
        assertEquals(numbers, ns1.closeToAverage(4));

        assertEquals(Arrays.asList(4, 5, 6, 7), ns1.closeToAverage(2));
        assertEquals(10, ns1.getNumbers().size());
    }

    @Test
    void testRandom() {
        List<Integer> numbers = new NumberSequence(100, 15, 25).getNumbers();
        assertEquals(100, numbers.size());

        int minValue = numbers.get(0);
        for (int number : numbers) {
            minValue = Math.min(number, minValue);
        }
        assertTrue(15 <= minValue);

        int maxValue = numbers.get(0);
        for (int number : numbers) {
            maxValue = Math.max(number, maxValue);
        }
        assertTrue(25 >= maxValue);

        List<Integer> distincts = new ArrayList<>();
        for (int number : numbers) {
            if (!distincts.contains(number)) {
                distincts.add(number);
            }
        }
        assertTrue(8 <= distincts.size());
        assertTrue(distincts.size() <= 11);
    }
}