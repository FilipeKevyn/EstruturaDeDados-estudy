import list.LinkedList;
import list.Node;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println("Tamanho: " + list.getLength());
        System.out.println("Primeiro: " + list.getFirst().getValue());
        System.out.println("Último: " + list.getLast().getValue());
        for (int i = 0; i < list.getLength(); i++) {
            System.out.println(list.get(i).getValue());
        }
        // remover

        list.remove(0);
        System.out.println("Removeu");
        for (int i = 0; i < list.getLength(); i++) {
            System.out.println(list.get(i).getValue());
        }
    }
}
