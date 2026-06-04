package lista.listaDuplaLigada;

public class testList {
    public static void main(String[] args) {
        doublyLinkedList list = new doublyLinkedList();

        System.out.println("--- Início dos Testes de Lista Duplamente Ligada ---");

        // 1. isEmpty() e size() iniciais
        System.out.println("A lista está vazia? " + list.isEmpty());
        System.out.println("Tamanho inicial: " + list.size());

        try {
            // insertFirst e insertLast
            System.out.println("\n--- Testando Inserções Iniciais ---");

            System.out.println("Inserindo 5 no insertFirst...");
            list.insertFirst(5);

            System.out.println("Inserindo 9 no insertLast...");
            list.insertLast(9);

            System.out.println("Inserindo 2 no insertFirst...");
            list.insertFirst(2);

            // Estado atual da lista
            printList(list);
            System.out.println("Tamanho atual: " + list.size());

            // 3. first, last, before, after
            System.out.println("\n--- Testando Navegação entre Nós ---");
            node firstNode = list.first();
            node lastNode = list.last();

            System.out.println("Primeiro elemento: " + firstNode.getElement());
            System.out.println("Último elemento: " + lastNode.getElement());

            System.out.println("O primeiro nó é o 'first'? " + list.isFirst(firstNode));

            node middleNode = list.after(firstNode);
            System.out.println("Nó depois do primeiro: " + middleNode.getElement());
            System.out.println("Nó antes do último: " + list.before(lastNode).getElement());

            // 4. insertBefore e insertAfter
            System.out.println("\n--- Testando Inserções com Referência de Nós ---");

            System.out.println("Inserindo 3 antes do 5...");
            list.insertBefore(middleNode, 3);

            System.out.println("Inserindo 1 após o 2...");
            list.insertAfter(firstNode, 1);

            printList(list);

            // 5. replaceElement e swapElements
            System.out.println("\n--- Testando Substituição e Troca ---");

            System.out.println("Elemento substituído: " + middleNode.getElement());
            Object replaced = list.replaceElement(middleNode, "6");
            System.out.println("Substituindo o elemento por 6: ");
            printList(list);

            System.out.println("Trocando o primeiro com o último...");
            list.swapElements(list.first(), list.last());

            printList(list);

            // 6. Testando Remoções
            System.out.println("\n--- Testando Remoções ---");

            node nodeToRemove = list.first().getNext();
            System.out.println("Removendo o nó: " + nodeToRemove.getElement());
            list.remove(nodeToRemove);

            printList(list);
            System.out.println("Tamanho final: " + list.size());

            // 7. Testando Tratamento de Exceções Esperadas
            System.out.println("\n--- Testando Exceções ---");
            try {
                System.out.println("Tentando buscar o nó anterior ao primeiro...");
                list.before(list.first());
            } catch (IllegalArgumentException e) {
                System.out.println("Capturada com sucesso: " + e.getMessage());
            }

        } catch (emptyList e) {
            System.err.println("Erro de lista vazia: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Erro de argumento inválido: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }

        System.out.println("\n--- Fim dos Testes ---");
    }

     // Metodo auxiliar utilizado para percorrer e imprimir os elementos da lista na tela.

    private static void printList(doublyLinkedList list) {
        System.out.print("Estado atual da lista: [ ");
        node current = list.first();
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println("]");
    }
}