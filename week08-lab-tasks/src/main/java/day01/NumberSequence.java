package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSequence {
    private List<Integer> numbers;

    public NumberSequence(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public NumberSequence(int size, int min, int max) {
        Random random = new Random();
        numbers = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            numbers.add(random.nextInt(min, max + 1));
        }
    }

    public List<Integer> closeToAverage(int value) {
        double avg = getAverage();
        List<Integer> result = new ArrayList<>();
        for (int number : numbers) {
            if (Math.abs(avg - number) <= value + 1e-5) {
                result.add(number);
            }
        }
        return result;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private double getAverage() {
        return (double) getSum() / numbers.size();
    }

    private int getSum() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
