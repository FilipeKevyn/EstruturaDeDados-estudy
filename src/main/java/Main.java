import list.LinkedCircleList;
import list.LinkedList;
import list.Node;

public class Main {
    public static void main(String[] args) {
        LinkedCircleList list = new LinkedCircleList();
        // adicionar no final
        list.addEnd("D");
        list.addEnd("E");
        list.addEnd("F");
        list.addEnd("G");
        list.addEnd("H");
        list.addEnd("I");
        // adicionar no começo
        list.addBeginning("C");
        list.addBeginning("B");
        list.addBeginning("A");
        list.addBeginning("0");

        // adicionar na posição
        list.add("2",3);
        System.out.println("Tamanho: " + list.getLength());
        System.out.println("Primeiro: " + list.getFirst().getValue());
        System.out.println("Último: " + list.getLast().getValue());
        for (int i = 0; i < list.getLength(); i++) {
            if (i == 0){
                System.out.println(list.get(i).getPrevious().getValue());
            }
            System.out.println(list.get(i).getValue());
        }

    }
}
