
package sequencia;

public class SequenceTests {
    public static void main(String[] args) {
        Sequence seq = new Sequence();

        System.out.println("--- Início dos Testes do TAD Sequência ---");

        // 1. Teste de IsEmpty() e Size() iniciais
        System.out.println("A sequência está vazia? " + seq.isEmpty());
        System.out.println("Tamanho inicial: " + seq.size());

        try {
            // 2. Testes de Métodos de Vetor (Inserções por Rank)
            System.out.println("\n--- Testando Inserções por Rank (Vetor) ---");

            System.out.println("Inserindo '25' no rank 0...");
            seq.insertAtRank(0, 25);
            imprimirSequencia(seq);

            System.out.println("Inserindo '12' no rank 0...");
            seq.insertAtRank(0, 12);
            imprimirSequencia(seq);

            System.out.println("Inserindo '40' no rank 2 (fim)...");
            seq.insertAtRank(2, 40);
            imprimirSequencia(seq);

            // 3. Testes de Métodos de Lista (insertFirst / insertLast)
            System.out.println("\n--- Testando Métodos de Lista (Início/Fim) ---");
            System.out.println("Inserindo '5' no início (insertFirst)...");
            seq.insertFirst(5);
            imprimirSequencia(seq);

            System.out.println("Inserindo '100' no fim (insertLast)...");
            seq.insertLast(100);
            imprimirSequencia(seq);

            // 4. Testes de Acesso e Modificação
            System.out.println("\n--- Testando Acesso e Substituição ---");
            System.out.println("Primeiro elemento: " + seq.first());
            System.out.println("Último elemento: " + seq.last());
            System.out.println("Elemento no rank 2: " + seq.elemAtRank(2));
            System.out.println("Elemento antes do rank 2: " + seq.before(2));
            System.out.println("Elemento depois do rank 2: " + seq.after(2));

            System.out.println("Substituindo elemento do rank 2 por 'Z'...");
            seq.replaceAtRank(2, "Z");
            imprimirSequencia(seq);

            // 5. Testando Métodos Ponte e Troca (Swap)
            System.out.println("\n--- Testando Métodos Ponte e Swap ---");
            Node noNoRank1 = seq.atRank(1);
            System.out.println("Valor do nó obtido no rank 1: " + noNoRank1.getElement());
            System.out.println("Rank detectado a partir deste nó: " + seq.rankOf(noNoRank1));
            System.out.println("O nó do rank 1 é o primeiro? " + seq.isFirst(noNoRank1));

            System.out.println("Trocando os elementos do rank 1 e rank 3...");
            seq.swapElements(1, 3);
            imprimirSequencia(seq);

            // 6. Testes para Remoções
            System.out.println("\n--- Testando Remoções ---");
            Object removidoRank = seq.removeAtRank(0);
            System.out.println("Removido do rank 0: " + removidoRank);
            imprimirSequencia(seq);

            Node noParaRemover = seq.atRank(2);
            System.out.println("Removendo o nó de valor '" + noParaRemover.getElement() + "' diretamente...");
            seq.remove(noParaRemover);
            imprimirSequencia(seq);

            System.out.println("Tamanho final: " + seq.size());
            System.out.println("A sequência está vazia? " + seq.isEmpty());

        } catch (SequenceException e) {
            System.err.println("Erro na Sequência: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }

        System.out.println("\n--- Fim dos Testes ---");
    }

    // Metodo auxiliar para exibir a sequência de forma limpa na tela
    private static void imprimirSequencia(Sequence seq) throws SequenceException {
        System.out.print("Sequência atual [tamanho=" + seq.size() + "]: [ ");
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.elemAtRank(i) + " ");
        }
        System.out.println("]");
    }
}
