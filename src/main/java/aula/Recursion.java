package aula;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursividade {

    public int findTwo(List<Integer> list){
        if (list.isEmpty()) {
            return 0;
        }
        else {
            if (list.get(0) == 2){
                list.remove(0);
                return 1 + findTwo(list);
            }
            else{
                list.remove(0);
                return findTwo(list);
            }
        }
    }


    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,2));
        Recursividade recursividade = new Recursividade();
        System.out.println(recursividade.findTwo(list1));
    }
}

