public class BubbleSort implements Sort {

    public int[] sort(int[] arr) {
        for (int i = arr.length; i > 0; i--){
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }
}
