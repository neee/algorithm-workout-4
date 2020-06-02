import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

class SortTest {

    private static final List<String> dataTypes = List.of("0.random", "1.digits", "2.sorted", "3.revers");

    private static final List<TestCase> testCases = List.of(
        TestCase.of(new BubbleSort(), 6),
        TestCase.of(new InsertionSort(), 6),
        TestCase.of(new SelectionSort(), 6),
        TestCase.of(new HeapSort(), 8),
        TestCase.of(new ShellSort(), 8),
        TestCase.of(new ShellSort10(), 8)
    );

    @Test
    public void testSorts() throws IOException {
        for (TestCase testCase : testCases) {
            Sort sortType = testCase.sortType;
            int numCase = testCase.numCase;
            System.out.println(sortType.getClass().getName());

            for (String data : dataTypes) {
                System.out.println("data: " + data);
                for (int i = 0; i < numCase; i++) {
                    long start = System.currentTimeMillis();
                    Pair<Integer, int[]> in = in(data, i);
                    int[] out = out(data, i);
                    int[] result = sortType.sort(in.getValue());
                    Assertions.assertArrayEquals(out, result);
                    System.out.println(String.format("  size: %7s time: %s", in.getValue().length, System.currentTimeMillis() - start));
                }
            }
        }
        System.out.println("---------------------------");
    }

    private int getTestCase(Sort sortType) {
        int testCase = 8;
        if ((sortType instanceof BubbleSort) ||
            (sortType instanceof InsertionSort) ||
            (sortType instanceof SelectionSort)) {
            testCase = 6;
        }
        return testCase;
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

    private static class TestCase {

        private final Sort sortType;
        private final int numCase;

        private TestCase(Sort sortType, int numCase) {
            this.sortType = sortType;
            this.numCase = numCase;
        }

        public static TestCase of(Sort sortType, int numCase) {
            return new TestCase(sortType, numCase);
        }
    }
}