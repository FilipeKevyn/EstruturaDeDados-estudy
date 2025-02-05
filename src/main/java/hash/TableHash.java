package hash;

public class TableHash {
    private Aluno[] tabela;
    private int size;
    private final Aluno REMOVIDO = new Aluno("REMOVIDO", -1);

    public TableHash(int capacidadeInicial) {
        tabela = new Aluno[capacidadeInicial];
        size = 0;
    }
    private int hash(int matricula) {
        return matricula % tabela.length;
    }

    public void insert(int matricula, String nome) {
        if (size >= tabela.length * 0.75) {
            reSize();
        }

        int hashIndex = hash(matricula);
        while (tabela[hashIndex] != null && tabela[hashIndex] != REMOVIDO) {
            hashIndex = (hashIndex + 1) % tabela.length;
        }

        tabela[hashIndex] = new Aluno(nome, matricula);
        size++;
    }

    public String getValue(int matricula) {
        int posicao = hash(matricula);
        while (tabela[posicao] != null) {
            if (tabela[posicao].getMatricula() == matricula) {
                return tabela[posicao].getNome();
            }
            posicao = (posicao + 1) % tabela.length;
        }
        return null;
    }

    public void remove(int matricula) {
        int posicao = hash(matricula);
        while (tabela[posicao] != null) {
            if (tabela[posicao].getMatricula() == matricula) {
                tabela[posicao] = REMOVIDO;
                size--;
                return;
            }
            posicao = (posicao + 1) % tabela.length;
        }
    }

    private void reSize() {
        Aluno[] tabelaAntiga = tabela;
        tabela = new Aluno[tabelaAntiga.length * 2];
        size = 0;

        for (Aluno aluno : tabelaAntiga) {
            if (aluno != null && aluno != REMOVIDO) {
                insert(aluno.getMatricula(), aluno.getNome());
            }
        }
    }
}