
package heap.array;

public class HeapArrayTests {
    public static void main(String[] args) {
        // Criando um Heap com capacidade para 5 elementos
        HeapArray heap = new HeapArray(5);

        System.out.println("--- Início dos Testes do TAD Fila de Prioridade ---");

        // 1. Teste de IsEmpty() e Size() iniciais
        System.out.println("O heap está vazio? " + heap.isEmpty());
        System.out.println("Tamanho inicial: " + heap.size());

        try {
            // 2. Testes de Inserção com exibição do Array interno
            System.out.println("\n--- Testando Inserções (Min-Heap) ---");

            System.out.println("Inserindo '25'...");
            heap.insert(25);
            heap.showArray();

            System.out.println("Inserindo '12' (deve virar a nova raiz no índice 1)...");
            heap.insert(12);
            heap.showArray();

            System.out.println("Inserindo '40'...");
            heap.insert(40);
            heap.showArray();

            System.out.println("Inserindo '5' (deve subir para a raiz no índice 1)...");
            heap.insert(5);
            heap.showArray();

            System.out.println("Inserindo '18'...");
            heap.insert(18);
            heap.showArray();

            // 3. Testes de Consulta ao Mínimo e Estado Atual
            System.out.println("\n--- Testando Consultas de Estado ---");
            System.out.println("Elemento mínimo atual (na raiz): " + heap.min());
            System.out.println("Tamanho atual: " + heap.size());
            System.out.println("O heap está vazio? " + heap.isEmpty());

            // 4. Testes para Remoções Sucessivas
            System.out.println("\n--- Testando Remoções Sucessivas (Ordenação) ---");

            while (!heap.isEmpty()) {
                System.out.println("Removendo o mínimo: " + heap.removeMin());
                heap.showArray();
                if (!heap.isEmpty()) {
                    System.out.println("Próximo mínimo na raiz: " + heap.min());
                }
            }

            // 5. Verificação após esvaziar
            System.out.println("\n--- Verificando Estado Pós-Remoções ---");
            System.out.println("Tamanho final: " + heap.size());
            System.out.println("O heap está vazio? " + heap.isEmpty());

            // 6. Testando caso de erro de Heap Vazia (Underflow)
            System.out.println("\n--- Testando Caso de Erro (Underflow) ---");
            System.out.println("Tentando remover de um heap vazio de propósito...");
            heap.removeMin(); // Deve disparar a ArrayException

        } catch (ArrayException e) {
            System.out.println("Erro na Fila de Prioridade: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }

        System.out.println("\n--- Fim dos Testes ---");
    }
}
