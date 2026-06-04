package pilha.comum;

public class TestePilha {

    public static void main(String[] args) {
        Pilha pilhaArray = new PilhaComumArray(1, 0);

        System.out.println("Inserindo valores...");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " ");
            pilhaArray.push(i);
        }

        System.out.println();
        System.out.println("Pilha atual: " + pilhaArray);

        System.out.println();
        System.out.println("Retirando valores...");
        for (int i = 9; i >= 0; i--) {
            System.out.println("Índice: " + i + "-> Elemento removido: " + pilhaArray.pop());
        }

        System.out.println();
        System.out.println("Pilha atual: " + pilhaArray);

    }
}
