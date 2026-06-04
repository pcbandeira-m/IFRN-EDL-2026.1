package pilha.comum;

public interface Pilha {
    int size();
    boolean isEmpty();
    Object top() throws EmptyStackException;
    void push(Object o);
    Object pop() throws EmptyStackException;
}
