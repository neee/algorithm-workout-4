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

    private static final List<Sort> sortTypes = List.of(
        new BubbleSort(),
        new HeapSort(),
        new InsertionSort(),
        new SelectionSort(),
        new ShellSort(),
        new ShellSort10()
    );

    @Test
    public void testSorts() throws IOException {
        for (Sort sortType : sortTypes) {
            System.out.println(sortType.getClass().getName());
            for (String data : dataTypes) {
                System.out.println("data: " + data);
                for (int i = 0; i < 7; i++) {
                    long start = System.currentTimeMillis();
                    Pair<Integer, int[]> in = in(data, i);
                    int[] out = out(data, i);
                    int[] result = sortType.sort(in.getValue());
                    Assertions.assertArrayEquals(out, result);
                    System.out.println(String.format("  size: %7s time: %s", in.getValue().length, System.currentTimeMillis() - start));
                }
            }
            System.out.println("---------------------------");
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