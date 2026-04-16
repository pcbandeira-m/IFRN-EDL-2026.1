package fila.encadeada;

public class EmptyLineException extends RuntimeException { // todas as classes de exceções precisam extender o RunTimeException
    public EmptyLineException(String message) {
        super(message); // traz a mensagem informada no parâmetro e o "super" faz referência à superclasse RunTimeException
    }
}
