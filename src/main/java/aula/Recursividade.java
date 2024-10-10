package aula;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursividade {
    List<Integer> list = new ArrayList();
    public int findTwo(List<Integer> lista){
        int count;
        if (lista.get(0) == 2){
            count++;
            lista.remove(0);
        }
        else {
            lista.remove(0);
            findTwo(lista);
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,5,2,6,8,2));
        Recursividade recursividade = new Recursividade();
        System.out.println(recursividade.findTwo(list1));
    }
}

