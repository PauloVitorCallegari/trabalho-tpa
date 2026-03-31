
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import estruturas.IColecao;
import estruturas.ListaEncadeada;
import dominio.Aluno;
import estruturas.ListaEncadeadaArrayList;
import estruturas.ListaEncadeadaLinkedList;

public class ProgramaTestesDesempenho {

    public static void main(String[] args) {

        String nomeArquivo = "src/dados/dados_400k.txt";

        //IColecao<Aluno> lista = new ListaEncadeada<>();
        //IColecao<Aluno> lista = new ListaEncadeadaArrayList<>();
        IColecao<Aluno> lista = new ListaEncadeadaLinkedList<>();
        int idUltimo = -1; // Para guardar o ID do último elemento inserido

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            // A primeira linha do arquivo é o número de registros
            int numRegistros = Integer.parseInt(reader.readLine().trim());
            System.out.println("Iniciando testes para: " + numRegistros + " registros.");

            String linha;
            long inicio, fim;
            double tempoMs;

            // =================================================================
            // TESTE 1: LER ARQUIVO E INSERIR TODOS
            // =================================================================
            inicio = System.nanoTime();
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                // tira a virgula
                int nota = (int) Float.parseFloat(partes[2].replace(",", "."));

                Aluno a = new Aluno(id, nome, nota);
                lista.adicionar(a);
                idUltimo = id; // Atualiza sempre, no final terá o ID do último
            }
            fim = System.nanoTime();
            tempoMs = (fim - inicio) / 1_000_000.0;
            System.out.printf("1. Tempo para ler e inserir todos: %.3f ms%n", tempoMs);

            // =================================================================
            // TESTE 2: PESQUISAR ÚLTIMO ELEMENTO
            // =================================================================
            Aluno alunoUltimo = new Aluno(idUltimo, "", 0);
            inicio = System.nanoTime();
            lista.pesquisar(alunoUltimo);
            fim = System.nanoTime();
            tempoMs = (fim - inicio) / 1_000_000.0;
            System.out.printf("2. Tempo para pesquisar o ÚLTIMO elemento: %.3f ms%n", tempoMs);

            // =================================================================
            // TESTE 3: PESQUISAR ELEMENTO INEXISTENTE
            // =================================================================
            Aluno alunoInexistente = new Aluno(-999, "", 0);
            inicio = System.nanoTime();
            lista.pesquisar(alunoInexistente);
            fim = System.nanoTime();
            tempoMs = (fim - inicio) / 1_000_000.0;
            System.out.printf("3. Tempo para pesquisar elemento INEXISTENTE: %.3f ms%n", tempoMs);

            // =================================================================
            // TESTE 4: REMOVER ÚLTIMO ELEMENTO
            // =================================================================
            inicio = System.nanoTime();
            lista.remover(alunoUltimo);
            fim = System.nanoTime();
            tempoMs = (fim - inicio) / 1_000_000.0;
            System.out.printf("4. Tempo para remover o ÚLTIMO elemento: %.3f ms%n", tempoMs);

            // =================================================================
            // TESTE 5: QUANTIDADE DE NÓS
            // =================================================================
            inicio = System.nanoTime();
            int qtd = lista.quantidadeNos();
            fim = System.nanoTime();
            tempoMs = (fim - inicio) / 1_000_000.0;
            System.out.printf("5. Tempo para exibir quantidadeNos (%d nós): %.5f ms%n", qtd, tempoMs);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}