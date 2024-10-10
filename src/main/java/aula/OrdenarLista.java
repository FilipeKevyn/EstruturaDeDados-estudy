package aula;

import java.util.ArrayList;

public class OrdenarLista {
    // TODO: refatorar -> NameClass, Content
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(3);
        numeros.add(1);
        numeros.add(5);
        numeros.add(4);


        System.out.println(numeros);

        for (int i = 0; i < numeros.size() - 1; i++) {
            for (int j = 0; j < numeros.size() - 1 - i; j++) {
                if (numeros.get(j) > numeros.get(j + 1)) {

                    int temp = numeros.get(j);
                    numeros.set(j, numeros.get(j + 1));
                    numeros.set(j + 1, temp);
                }
            }
        }

        System.out.println(numeros);
    }
}
