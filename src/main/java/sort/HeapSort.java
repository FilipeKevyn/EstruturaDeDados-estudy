package sort;

public class HeapSort {
    public void sort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;


            heapify(array, i, 0);
        }
    }

    void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest])
            largest = left;
        if (right < n && array[right] > array[largest])
            largest = right;
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];

            array[largest] = swap;

            heapify(array, n, largest);

        }
    }
    // Função para imprimir o array
    static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,5,8,3,9};
        HeapSort hsort = new HeapSort();
        hsort.sort(array);
        printArray(array);
    }
}
