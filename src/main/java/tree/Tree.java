package tree;

public class Tree {
    Node raiz;

    void insert(int value) {
        raiz = inserirRec(raiz, value);
    }

    private Node inserirRec(Node atual, int value) {
        if (atual == null) {
            return new Node(value);
        }
        if (value < atual.getValor()) {
            atual.setEsq(inserirRec(atual.getEsq(), value));
        } else if (value > atual.getValor()) {
            atual.setDir(inserirRec(atual.getDir(), value));
        }
        return atual;
    }

    void remove(int value) {
        raiz = removerRec(raiz, value);
    }

    private Node removerRec(Node atual, int value) {
        if (atual == null) {
            return null;
        }
        if (value < atual.getValor()) {
            atual.setEsq(removerRec(atual.getEsq(), value));
        } else if (value > atual.getValor()) {
            atual.setDir(removerRec(atual.getDir(), value));
        } else {
            if (atual.getEsq() == null) {
                return atual.getDir();
            } else if (atual.getDir() == null) {
                return atual.getEsq();
            }
            Node menorValor = encontrarMenorValor(atual.getDir());
            atual.setValor(menorValor.getValor());
            atual.setDir(removerRec(atual.getDir(), menorValor.getValor()));
        }
        return atual;
    }

    private Node encontrarMenorValor(Node node) {
        while (node.getEsq() != null) {
            node = node.getEsq();
        }
        return node;
    }

    boolean search(int value) {
        return buscarRec(raiz, value);
    }

    private boolean buscarRec(Node atual, int value) {
        if (atual == null) {
            return false;
        }
        if (value == atual.getValor()) {
            return true;
        }
        return value < atual.getValor()
                ? buscarRec(atual.getEsq(), value)
                : buscarRec(atual.getDir(), value);
    }
}

class Node {
    private int valor;
    private Node esq;

    private Node dir;

    public Node(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Node getEsq() {
        return esq;
    }

    public void setEsq(Node esq) {
        this.esq = esq;
    }

    public Node getDir() {
        return dir;
    }
    public void setDir(Node dir) {
        this.dir = dir;
    }
}
