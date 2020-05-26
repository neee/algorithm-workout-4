import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 6, 1, 2, 9, 1, 0};
        int[] result = sort(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sort(int[] arr) {
        long start = System.currentTimeMillis();
        for (int i = arr.length / 2; i > 0; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                int temp = arr[j];
                int f = j;
                while (f >= i && arr[f - i] > temp) {
                    arr[f] = arr[f - i];
                    f -= i;
                }
                arr[f] = temp;
            }
        }
        System.out.println(String.format("  size: %7s time: %s", arr.length, System.currentTimeMillis() - start));
        return arr;
    }
}
