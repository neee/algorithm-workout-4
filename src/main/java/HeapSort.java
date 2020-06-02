import java.util.Arrays;

public class HeapSort implements Sort {

    public int[] sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            down(i, arr.length, arr);
        }
        for (int i = arr.length - 1; i >= 0 ; i--) {
            swap(0, i, arr);
            down(0, i, arr);
        }
        return arr;
    }

    public static void down(int root, int size, int[] arr) {
        int l = 2 * root + 1;
        int r = l + 1;

        int x = root;
        if (l < size && arr[x] < arr[l])
            x = l;
        if (r < size && arr[x] < arr[r])
            x = r;

        if (x == root)
            return;
        swap(x, root, arr);
        down(x, size, arr);
    }

    private static void swap(int a, int b, int[] arr) {
        int x = arr[a];
        arr[a] = arr[b];
        arr[b] = x;
    }
}
