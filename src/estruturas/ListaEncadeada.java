package estruturas;


public class ListaEncadeada<T> implements IColecao<T> {

    private No<T> prim, ult;
    private int quant;

    // Construtor padrão sem parâmetros
    public ListaEncadeada() {
        this.prim = null;
        this.ult = null;
        this.quant = 0;
    }

    @Override
    public void adicionar(T novoValor) {
        No<T> novo = new No<T>(novoValor);

        // Se a lista está vazia
        if (this.prim == null) {
            this.prim = novo;
            this.ult = novo;
        } else {
            // Se não estiver, coloca o elemento no fim da Lista usando o ponteiro ult
            this.ult.setProx(novo);
            this.ult = novo;
        }
        this.quant++;
    }

    @Override
    public T pesquisar(T valor) {
        No<T> aux = this.prim;

        while (aux != null) {
            if (aux.getValor().equals(valor)) {
                return aux.getValor(); // Retorna o objeto encontrado
            }
            aux = aux.getProx();
        }
        return null; // Retorna null caso não encontre
    }

    @Override
    public boolean remover(T valor) {
        No<T> aux = this.prim;
        No<T> ant = null;

        while (aux != null) {
            // Se encontrou, remove o elemento
            if (aux.getValor().equals(valor)) {
                // Se for o primeiro elemento
                if (aux == this.prim) {
                    this.prim = this.prim.getProx();
                } else {
                    // Se não é o primeiro, o anterior passa a apontar para o proximo
                    ant.setProx(aux.getProx());
                }
                // Verifica se também é o ult (seja por ser o único ou por estar no fim)
                if (aux == this.ult) {
                    this.ult = ant;
                }

                this.quant--;
                return true;
            }
            // Se não encontrou nesta iteração, ant vai pra aux e aux vai para o proximo
            ant = aux;
            aux = aux.getProx();
        }
        // Se rodou tudo sem encontrar retorna false
        return false;
    }

    @Override
    public int quantidadeNos() {
        return this.quant;
    }

    @Override
    public String toString() {
        if (this.prim == null) {
            return "";
        }

        No<T> aux = this.prim;
        String s = "";

        while (aux != null) {
            s += aux.getValor().toString();
            if (aux != this.ult) {
                s += ",";
            }
            aux = aux.getProx();
        }

        return s;
    }
}