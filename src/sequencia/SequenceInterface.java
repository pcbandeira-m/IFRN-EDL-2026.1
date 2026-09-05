
package sequencia;

public interface SequenceInterface {
    // *------- Métodos Genéricos -------*
    public int size();
    public boolean isEmpty();

    // *------- Métodos de Vetor -------*
    public Object elemAtRank(int rank) throws SequenceException;
    public Object removeAtRank(int rank)  throws SequenceException;
    public void replaceAtRank(int rank, Object element)  throws SequenceException;
    public void insertAtRank(int rank, Object element)   throws SequenceException;

    // *------- Métodos de Lista -------*
    public Object first() throws SequenceException;
    public Object last() throws SequenceException;
    public Object before(int rank) throws SequenceException;
    public Object after(int rank) throws SequenceException;
    public boolean isFirst(Node node) throws SequenceException;
    public boolean isLast(Node node) throws SequenceException;
    public void replaceElementAtRank(int rank, Object element) throws SequenceException;
    public void swapElements(int rank1, int rank2) throws SequenceException;
    public void insertBeforeRank(int rank, Object element) throws SequenceException;
    public void insertAfterRank(int rank, Object element) throws SequenceException;
    public void insertFirst(Object element) throws SequenceException, IllegalStateException;
    public void insertLast(Object element) throws SequenceException, IllegalStateException;
    public void remove(Node node);

    // *------- Métodos "ponte" -------*
    public Node atRank(int rank);
    public int rankOf(Node node) throws SequenceException;

}
