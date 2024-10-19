package search;

public class BinarySearch {
    // Iterativa

    // retorna a posição de num no array
    public static int search(int[] array, int num){
        int mid;
        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            mid = (low + high) / 2;
            if (array[mid] == num){
                return mid;
            }
            else if (array[mid] < num) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};

        System.out.println(search(array, 5));
    }
}
