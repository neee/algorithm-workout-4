public class InsertionSort {

    public static int[] sort(int[] arr) {
        long start = System.currentTimeMillis();
        for (int i = 1; i < arr.length ; i++) {
            for (int j = i; j > 0 ; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        System.out.println(String.format("  size: %7s time: %s", arr.length, System.currentTimeMillis() - start));
        return arr;
    }
}
