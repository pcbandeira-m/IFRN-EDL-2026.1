package vetor.listaDuplaLigada;

public interface vector {
    int size();
    boolean isEmpty();
    Object elemAtRank(int r) throws IndexOutOfBoundsException, emptyVector;
    Object replaceAtRank(int r, Object o) throws IndexOutOfBoundsException, emptyVector;
    Object removeAtRank(int r)  throws IndexOutOfBoundsException, emptyVector;
    void insertAtRank(int r, Object o)  throws IndexOutOfBoundsException;
}