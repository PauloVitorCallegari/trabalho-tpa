# 📊 Análise de Complexidade em Estruturas de Listas

**Disciplina:** Técnicas de Programação Avançada (TPA)  
**Objetivo:** Implementação de uma Lista Encadeada Genérica customizada e análise empírica de complexidade de algoritmos (Big-O), comparando seu desempenho em operações de estresse contra as estruturas nativas do Java (`ArrayList` e `LinkedList`).

---

## 📂 Organização do Código

A arquitetura do projeto foi estruturada para separar claramente os dados de teste, as regras de domínio e as lógicas de estrutura de dados. O código fonte está contido no diretório `src/`:

* **`dados/`**: Contém as massas de dados geradas para os testes de estresse (arquivos `.txt` com 100 mil, 200 mil e 400 mil registros de alunos simulados).
* **`dominio/`**: 
  * `Aluno.java`: Classe que mapeia a entidade de negócio, implementando a sobrescrita dos métodos `equals()` (utilizando a matrícula como identificador único) e `toString()`.
* **`estruturas/`**: Contém a nossa biblioteca de Coleções.
  * `IColecao.java`: Interface base genérica.
  * `No.java`: Classe que representa os nós da lista encadeada.
  * `ListaEncadeada.java`: Nossa implementação customizada e otimizada de uma Lista Simplesmente Encadeada.
  * `ListaEncadeadaArrayList.java` e `ListaEncadeadaLinkedList.java`: Classes *Wrappers* que encapsulam as coleções nativas do Java para testes comparativos usando a mesma interface.
* **Raiz do `src/` (Pacote Padrão):**
  * `ProgramaInterativo.java`: Interface via console para testar operações básicas do dia a dia (Adicionar, Pesquisar, Remover e Imprimir).
  * `ProgramaTestesDesempenho.java`: Motor de testes empíricos que utiliza `System.nanoTime()` para medir o tempo de inserção, buscas e remoções no pior caso teórico O(n).

---

## 🚀 Como Executar o Projeto

Este projeto não possui dependências externas (bibliotecas de terceiros), utilizando apenas os recursos nativos do Java (*Java Collections Framework* e `java.io`).

### Opção 1: Rodando via IntelliJ IDEA (Recomendado)
1. Clone o repositório para a sua máquina:
   ```bash
   git clone <URL_DO_SEU_REPOSITORIO>
   ```
2. Abra o IntelliJ IDEA e selecione **Open**.
3. Navegue até a pasta raiz do projeto clonado e clique em OK.
4. No painel da esquerda (Project), expanda a pasta `src`.
5. **Para o Menu Interativo:** Clique com o botão direito em `ProgramaInterativo.java` e selecione **Run 'ProgramaInterativo.main()'**.
6. **Para os Testes de Desempenho:** Clique com o botão direito em `ProgramaTestesDesempenho.java` e selecione **Run 'ProgramaTestesDesempenho.main()'**.
   * *Nota:* Para alterar a massa de dados testada (100k, 200k ou 400k) ou a estrutura alvo (sua lista, ArrayList ou LinkedList), basta editar as variáveis iniciais dentro do método `main` desta classe antes de rodar.

### Opção 2: Rodando via Terminal
Caso deseje compilar e executar diretamente pelo terminal da sua máquina, siga os passos abaixo partindo da pasta raiz do projeto:

**1. Compilando os arquivos:**
```bash
javac -d out src/dominio/*.java src/estruturas/*.java src/*.java
```

**2. Executando o Programa Interativo:**
```bash
java -cp out ProgramaInterativo
```

**3. Executando os Testes de Desempenho:**
```bash
java -cp out ProgramaTestesDesempenho
```
