package sort;

public class SelectionSort {
    public static int[] sort(int[] vetor){
        for (int i = 0; i < vetor.length - 1; i++) {
            int min = i;

            for (int j = i + 0; j < vetor.length; j++) {
                if (vetor[i] < vetor[min]){
                    min = i;
                }
            }

            int temp = vetor[i];
            vetor[i] = vetor[min];
            vetor[min] = temp;
        }
        return vetor;
    }
}
