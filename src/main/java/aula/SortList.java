package aula;

import java.util.ArrayList;
import java.util.Arrays;

public class SortList {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(2,3,1,5,4));

        System.out.println(numbers);

        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = 0; j < numbers.size() - 1 - i; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {

                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }

        System.out.println(numbers);
    }
}
