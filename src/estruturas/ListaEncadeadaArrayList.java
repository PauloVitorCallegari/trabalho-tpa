package estruturas;

import java.util.ArrayList;


public class ListaEncadeadaArrayList<T> implements IColecao<T> {

    // Atributo interno
    private final ArrayList<T> lista = new ArrayList<>();

    @Override
    public void adicionar(T novoValor) {
        lista.add(novoValor); // Adiciona no final do ArrayList
    }

    @Override
    public T pesquisar(T valor) {
        // O indexOf usa o método equals() por baixo dos panos
        int index = lista.indexOf(valor);
        if (index != -1) {
            return lista.get(index);
        }
        return null;
    }

    @Override
    public boolean remover(T valor) {
        // O método remove já busca e remove, retornando true ou false
        return lista.remove(valor);
    }

    @Override
    public int quantidadeNos() {
        return lista.size();
    }
}