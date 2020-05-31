import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

class SortTest {

    private static final List<String> types = List.of("0.random", "1.digits", "2.sorted", "3.revers");

    @Test
    public void bubbleSort() throws IOException {
        System.out.println("Bubble sort");
        for (String type : types) {
            System.out.println("type: " + type);
            for (int i = 0; i < 7; i++) {
                Pair<Integer, int[]> in = in(type, i);
                int[] out = out(type, i);
                int[] result = BubbleSort.sort(in.getValue());
                Assertions.assertArrayEquals(out, result);
            }
        }
    }

    @Test
    public void selectionSort() throws IOException {
        System.out.println("Selection sort");
        for (String type : types) {
            System.out.println("type: " + type);
            for (int i = 0; i < 7; i++) {
                Pair<Integer, int[]> in = in(type, i);
                int[] out = out(type, i);
                int[] result = SelectionSort.sort(in.getValue());
                Assertions.assertArrayEquals(out, result);
            }
        }
    }

    @Test
    public void insertionSort() throws IOException {
        System.out.println("Insertion sort");
        for (String type : types) {
            System.out.println("type: " + type);
            for (int i = 0; i < 7; i++) {
                Pair<Integer, int[]> in = in(type, i);
                int[] out = out(type, i);
                int[] result = InsertionSort.sort(in.getValue());
                Assertions.assertArrayEquals(out, result);
            }
        }
    }

    @Test
    public void shellSort() throws IOException {
        System.out.println("Shell sort");
        for (String type : types) {
            System.out.println("type: " + type);
            for (int i = 0; i < 8; i++) {
                Pair<Integer, int[]> in = in(type, i);
                int[] out = out(type, i);
                int[] result = ShellSort.sort(in.getValue());
                Assertions.assertArrayEquals(out, result);
            }
        }
    }

    @Test
    public void shellSort10() throws IOException {
        System.out.println("Shell sort");
        for (String type : types) {
            System.out.println("type: " + type);
            for (int i = 0; i < 8; i++) {
                Pair<Integer, int[]> in = in(type, i);
                int[] out = out(type, i);
                int[] result = ShellSort.sort(in.getValue(), 10);
                Assertions.assertArrayEquals(out, result);
            }
        }
    }

    @Test
    public void heapSort() throws IOException {
        System.out.println("Heap sort");
        for (String type : types) {
            System.out.println("type: " + type);
            for (int i = 0; i < 8; i++) {
                Pair<Integer, int[]> in = in(type, i);
                int[] out = out(type, i);
                int[] result = HeapSort.sort(in.getValue());
                Assertions.assertArrayEquals(out, result);
            }
        }
    }

    public static Pair<Integer, int[]> in(String type, int num) throws IOException {
        String path = ClassLoader.getSystemResource("sorting-tests").getPath();
        List<String> args = Files.readAllLines(Path.of(path + "/" + type + "/" + "test." + num + ".in"));
        var arraySize = Integer.parseInt(args.get(0));
        var array = Arrays.stream(args.get(1).split(" ")).mapToInt(Integer::parseInt).toArray();
        return Pair.of(arraySize, array);
    }

    public static int[] out(String type, int num) throws IOException {
        String path = ClassLoader.getSystemResource("sorting-tests").getPath();
        List<String> args = Files.readAllLines(Path.of(path + "/" + type + "/" + "test." + num + ".out"));
        return Arrays.stream(args.get(0).split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}