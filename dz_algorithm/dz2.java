public class dz2 {

    public static void main(String[] args) {
        int n = 10;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = (int) (Math.random() * 100);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        sortArray(arr);
        System.out.print("\n");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sortArray(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapSort(array, array.length, i);

        for (int i = array.length - 1; i >= 0; i--) {
            int step = array[0];
            array[0] = array[i];
            array[i] = step;

            heapSort(array, i, 0);
        }
    }

    private static void heapSort(int[] array, int size, int root) {
        int max = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < size && array[left] > array[max])
            max = left;

        if (right < size && array[right] > array[max])
            max = right;

        if (max != root) {
            int step = array[root];
            array[root] = array[max];
            array[max] = step;

            heapSort(array, size, max);
        }
    }
}