package list;

public class Iterator<T> {
    private Node<T> node;

    public Iterator(Node<T> current){
        this.node = current;
    }

    public boolean hasNext(){
        if (node.getNext() == null){
            return false;
        }
        return true;
    }

    public Node<T> getNext(){
        node = node.getNext();
        return node;
    }
}
