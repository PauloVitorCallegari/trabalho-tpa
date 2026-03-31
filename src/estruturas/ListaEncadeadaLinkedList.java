package estruturas;

import java.util.LinkedList;


public class ListaEncadeadaLinkedList<T> implements IColecao<T> {

    // Atributo interno
    private final LinkedList<T> lista = new LinkedList<>();

    @Override
    public void adicionar(T novoValor) {
        lista.add(novoValor); // Adiciona no final do LinkedList
    }

    @Override
    public T pesquisar(T valor) {
        int index = lista.indexOf(valor);
        if (index != -1) {
            return lista.get(index);
        }
        return null;
    }

    @Override
    public boolean remover(T valor) {
        return lista.remove(valor);
    }

    @Override
    public int quantidadeNos() {
        return lista.size();
    }
}