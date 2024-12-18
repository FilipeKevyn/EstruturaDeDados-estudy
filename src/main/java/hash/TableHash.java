package hash;

import list.LinkedList;

public class TableHash {
    private LinkedList<Aluno>[] tabela;

    public TableHash(int size) {
        tabela = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            tabela[i] = new LinkedList<Aluno>();
        }
    }

    public int hash(int key){
        return key % tabela.length;
    }

    public void insert(int key, String value){
        int hashIndex = hash(key);
        if (tabela[hashIndex] == null) {
            tabela[hashIndex] = new LinkedList<Aluno>();
        }
        tabela[hashIndex].add(new Aluno(value, key));
    }

    public Aluno getValue(int key){
        LinkedList<Aluno> alunos = tabela[hash(key)];
        for (int i = 0; i < alunos.getLength(); i++) {
            if (alunos.get(i).getValue().getMatricula() == key){
                return alunos.get(i).getValue();
            }
        }
        return null;
    }

    public void remove(int key){
        int hashIndex = hash(key);
        if (tabela[hash(key)] != null){
            Aluno aluno = getValue(key);
            if (aluno != null){
                tabela[hashIndex].remove(aluno);
            }
        };
    }

    public LinkedList<Aluno>[] getTabela() {
        return tabela;
    }

    public static void main(String[] args) {
        TableHash table = new TableHash(5);

        // Teste de Inserção
        table.insert(123, "João");
        table.insert(234, "Maria");
        table.insert(345, "Pedro");
        table.insert(456, "Ana");

        // Teste de Busca
        System.out.println(table.getValue(234));

        // Teste de Remoção
        table.remove(234);
        System.out.println(table.getValue(234));


    }

}
