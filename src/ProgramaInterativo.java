import java.util.Scanner;
import estruturas.IColecao;
import dominio.Aluno;
import estruturas.ListaEncadeada;

public class ProgramaInterativo {

    public static void main(String[] args) {

        IColecao<Aluno> listaAlunos = new ListaEncadeada<>();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Alunos!");

        while (opcao != 0) {
            System.out.println("\n=================================");
            System.out.println("1 - Adicionar novo aluno");
            System.out.println("2 - Pesquisar aluno");
            System.out.println("3 - Remover aluno");
            System.out.println("4 - Imprimir todos os alunos");
            System.out.println("5 - Ver quantidade de alunos cadastrados");
            System.out.println("0 - Sair");
            System.out.println("=================================");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Digite a matrícula do aluno: ");
                        int mat = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite o nome do aluno: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite a nota do aluno: ");
                        int nota = Integer.parseInt(scanner.nextLine());

                        Aluno novoAluno = new Aluno(mat, nome, nota);
                        listaAlunos.adicionar(novoAluno);
                        System.out.println("✅ Aluno adicionado com sucesso!");
                        break;

                    case 2:
                        System.out.print("Digite a MATRÍCULA do aluno que deseja pesquisar: ");
                        int matPesquisa = Integer.parseInt(scanner.nextLine());

                        // aluno "falso" apenas com a matrícula para o equals encontrar
                        Aluno alunoBuscado = listaAlunos.pesquisar(new Aluno(matPesquisa, "", 0));

                        if (alunoBuscado != null) {
                            System.out.println("✅ Aluno encontrado: " + alunoBuscado.toString());
                        } else {
                            System.out.println("❌ Aluno não encontrado na lista.");
                        }
                        break;

                    case 3:
                        System.out.print("Digite a MATRÍCULA do aluno que deseja remover: ");
                        int matRemover = Integer.parseInt(scanner.nextLine());

                        boolean removido = listaAlunos.remover(new Aluno(matRemover, "", 0));

                        if (removido) {
                            System.out.println("✅ Aluno removido com sucesso!");
                        } else {
                            System.out.println("❌ Aluno não encontrado. Nenhuma remoção foi feita.");
                        }
                        break;

                    case 4:
                        System.out.println("\n--- Lista de Alunos ---");
                        String conteudoLista = listaAlunos.toString();
                        if (conteudoLista.isEmpty()) {
                            System.out.println("A lista está vazia.");
                        } else {
                            System.out.println(conteudoLista);
                        }
                        break;

                    case 5:
                        System.out.println("Quantidade total de nós (alunos): " + listaAlunos.quantidadeNos());
                        break;

                    case 0:
                        System.out.println("Encerrando o programa. Até logo!");
                        break;

                    default:
                        System.out.println("⚠️ Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Erro: Por favor, digite um número válido.");
            } catch (Exception e) {
                System.out.println("⚠️ Ocorreu um erro inesperado: " + e.getMessage());
            }
        }

        scanner.close();
    }
}