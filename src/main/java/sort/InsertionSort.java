package sort;

public class InsertionSort {
    public static int[] sort(int[] vetor){
         int aux;
        for (int i = 1; i < vetor.length; i++) {
            aux = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > aux){
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = aux;
        }
        return vetor;
    }

    public static void main(String[] args) {
        int[] vetor = new int[] {9,5,15,1,2,4};
        int[] newVetor = sort(vetor);
        for (int i = 0; i < newVetor.length; i++) {
            System.out.println(newVetor[i]);
        };
    }
}
