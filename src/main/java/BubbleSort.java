public class BubbleSort {

    public static int[] sort(int[] arr) {
        long start = System.currentTimeMillis();
        for (int i = arr.length; i > 0; i--){
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        System.out.println(String.format("  size: %7s time: %s", arr.length, System.currentTimeMillis() - start));
        return arr;
    }
}
