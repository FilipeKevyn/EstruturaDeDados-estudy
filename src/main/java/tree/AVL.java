package tree;

class Nodo {
    int valor;
    Nodo esquerda, direita;
    int altura;

    public Nodo(int valor) {
        this.valor = valor;
        this.altura = 1;
    }
}

class ArvoreAVL {
    private Nodo raiz;

    private int altura(Nodo nodo) {
        return (nodo == null) ? 0 : nodo.altura;
    }

    private int FB(Nodo nodo) {
        return (nodo == null) ? 0 : altura(nodo.esquerda) - altura(nodo.direita);
    }

    private Nodo RotEsq(Nodo y) {
        Nodo x = y.direita;
        Nodo T2 = x.esquerda;

        x.esquerda = y;
        y.direita = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private Nodo RotDir(Nodo x) {
        Nodo y = x.esquerda;
        Nodo T2 = y.direita;

        y.direita = x;
        x.esquerda = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    private Nodo Balanceamento(Nodo nodo) {
        int fb = FB(nodo);

        if (fb > 1 && FB(nodo.esquerda) >= 0) {
            return RotDir(nodo);
        }

        if (fb < -1 && FB(nodo.direita) <= 0) {
            return RotEsq(nodo);
        }

        if (fb > 1 && FB(nodo.esquerda) < 0) {
            nodo.esquerda = RotEsq(nodo.esquerda);
            return RotDir(nodo);
        }

        if (fb < -1 && FB(nodo.direita) > 0) {
            nodo.direita = RotDir(nodo.direita);
            return RotEsq(nodo);
        }

        return nodo;
    }
}

