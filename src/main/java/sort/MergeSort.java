package sort;

public class MergeSort {
    public static int[] mergeSort(int[] array, int first, int last){
        if (first < last){
            int mid = (first + last) / 2;
            mergeSort(array, first, mid);
            mergeSort(array, mid + 1, last);
            merge(array, first, mid, last);
        }
    }

    public static int[] merge(int[] array, int first, int mid, int last) {
        int n1 = mid - first + 1;
        int n2 = last - mid;

        int[] l = new int[n1+1];
        int[] r = new int[n2+1];
    }

}
