
public class ShellSort implements Sort {

    public int[] sort(int[] arr) {
        int divider = 2;
        for (int i = arr.length / divider; i > 0; i /= divider) {
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
        return arr;

    }
}
