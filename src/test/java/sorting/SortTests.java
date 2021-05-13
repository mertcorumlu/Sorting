package sorting;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class SortTests {

    private Main<Integer> sorter = new Main<>();
    private int seed = 1;
    private Random rand;

    @Test
    public void test1Selection() {
        rand = new Random(seed);
        for (int i = 0; i < 1000; i++) {
            long size = rand.nextInt(300) + 20;
            Integer[] testArray = Arrays.stream(rand.ints(size).toArray()).boxed().toArray(Integer[]::new);
            Integer[] sorted = Arrays.stream(testArray).sorted().toArray(Integer[]::new);
            sorter.selectionSort(testArray);

            assertArrayEquals(testArray, sorted);
        }
    }

    @Test
    public void test2Insertion() {
        rand = new Random(seed);
        for (int i = 0; i < 1000; i++) {
            long size = rand.nextInt(300) + 20;
            Integer[] testArray = Arrays.stream(rand.ints(size).toArray()).boxed().toArray(Integer[]::new);
            Integer[] sorted = Arrays.stream(testArray).sorted().toArray(Integer[]::new);
            sorter.insertionSort(testArray);

            assertArrayEquals(testArray, sorted);
        }
    }

    @Test
    public void test3Merge() {
        rand = new Random(seed);
        for (int i = 0; i < 1000; i++) {
            long size = rand.nextInt(300) + 20;
            Integer[] testArray = Arrays.stream(rand.ints(size).toArray()).boxed().toArray(Integer[]::new);
            Integer[] sorted = Arrays.stream(testArray).sorted().toArray(Integer[]::new);
            sorter.mergeSort(testArray);

            assertArrayEquals(testArray, sorted);
        }
    }

    @Test
    public void test4Quick() {
        rand = new Random(seed);
        for (int i = 0; i < 1000; i++) {
            long size = rand.nextInt(300) + 20;
            Integer[] testArray = Arrays.stream(rand.ints(size).toArray()).boxed().toArray(Integer[]::new);
            Integer[] sorted = Arrays.stream(testArray).sorted().toArray(Integer[]::new);
            sorter.quickSort(testArray);

            assertArrayEquals(testArray, sorted);
        }
    }
}
