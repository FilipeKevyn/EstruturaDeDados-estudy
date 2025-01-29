import list.LinkedCircleList;
import list.LinkedList;
import list.Node;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.addEnd("A");
        list.addEnd("B");
        list.addEnd("C");
        list.addEnd("D");
        list.addEnd("E");

        for (int i = 0; i < list.getLength(); i++) {
            System.out.println(list.get(i).getValue());
        }

        list.remove("C");

        System.out.println("Removendo...");

        for (int i = 0; i < list.getLength(); i++) {
            System.out.println(list.get(i).getValue());
        }


    }
}
