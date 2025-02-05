package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {

    public int countTwo(List<Integer> list){
        if (list.isEmpty()) {
            return 0;
        }
        else {
            if (list.get(0) == 2){
                list.remove(0);
                return 1 + countTwo(list);
            }
            else{
                list.remove(0);
                return countTwo(list);
            }
        }
    }

    public int factorial(int num){
        if (num == 1){
            return num;
        }
        else {
            return num * factorial(num - 1);
        }
    }

    public static void pares(int num){
        if (num == 0){
            System.out.println(0);
            return;
        }
        else {
            if (num % 2 == 0) {
                pares(num - 2);
                System.out.println(num);
            }
            else {
                pares(num - 1);
            }
        }
    }

    public boolean findNumber(List<Integer> list, int num){
        if (list.size() == 1){
            if (list.get(0) == num){
                return true;
            }
            else
                return false;
        }
        int t = list.size();
        return findNumberIterator(list.subList(0,(t/2)), num) || findNumberIterator(list.subList((t/2 + 1), t), num);
    }

    // Iterator

    public boolean findNumberIterator(List<Integer> list, int num) {
        for (int i = 0; i <= list.size(); i++) {
            if (list.get(i) == num) {
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        Recursion recursividade = new Recursion();
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(recursividade.findNumberIterator(list, 5));
    }
}

