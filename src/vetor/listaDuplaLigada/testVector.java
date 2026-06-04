package vetor.listaDuplaLigada;

public class testVector {
    public static void main(String[] args) {
        doublyLinkedVector vector = new doublyLinkedVector();

        System.out.println("--- Início dos Testes de Vetor com Lista Duplamente Ligada ---");

        // 1. Teste de IsEmpty() e Size() iniciais
        System.out.println("O vetor está vazio? " + vector.isEmpty());
        System.out.println("Tamanho inicial: " + vector.size());

        try {
            // 2. Testes para insertAtRank(int r, Object o)
            System.out.println("\n--- Testando Inserções ---");

            System.out.println("Inserindo '25' no rank 0...");
            vector.insertAtRank(0, 25);
            for (int i = 0; i < vector.size(); i++) {
                System.out.print(vector.elemAtRank(i) + " ");
            }
            System.out.println("]");

            System.out.println("Inserindo '12' no rank 0...");
            vector.insertAtRank(0, 12);
            for (int i = 0; i < vector.size(); i++) {
                System.out.print(vector.elemAtRank(i) + " ");
            }
            System.out.println("]");

            // 3. Testes para elemAtRank(int r) e replaceAtRank(int r, Object o)
            System.out.println("\n--- Testando Acesso ao elemento e Substituição ---");

            Object element = vector.elemAtRank(0);
            System.out.println("Elemento no rank 0: " + element);

            Object replacedElement = vector.replaceAtRank(0, "Z");
            System.out.println("'A' substituído por 'Z'. A: " + replacedElement);

            // 4. Teste para removeAtRank(int r)
            System.out.println("\n--- Testando Remoção ---");

            Object removedElement = vector.removeAtRank(0);
            System.out.println("Elemento removido do rank 0: " + removedElement);
            System.out.println("Novo tamanho: " + vector.size());

        } catch (IndexOutOfBoundsException e) {
            System.err.println("Erro de Índice: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }

        System.out.println("\n--- Fim dos Testes ---");
    }
}
