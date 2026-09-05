
package sequencia;

public class Sequence implements SequenceInterface {

    private final Node head;
    private final Node tail;
    private int length;

    public Sequence() {
        head = new Node(null);
        tail = new Node(null);
        length = 0;

        head.setNext(tail);
        tail.setPrev(head);
    }

    // *------- Métodos Genéricos -------*
    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    // *------- Métodos de Vetor -------*
    @Override
    public Object elemAtRank(int rank) throws SequenceException {
        if(length == 0){
            throw new SequenceException("Sequence is empty.");
        }
        if(rank < 0 || rank > length - 1){
            throw new SequenceException("Rank out of bounds.");
        }

        return atRank(rank).getElement();
    }

    @Override
    public Object removeAtRank(int rank) throws SequenceException {
        if(isEmpty()){
            throw new SequenceException("Sequence is empty.");
        }
        if(rank < 0 || rank > length - 1){
            throw new SequenceException("Rank out of bounds.");
        }

        Node targetNode = atRank(rank);
        Object removedElement = targetNode.getElement();

        Node beforeNode = targetNode.getPrev();
        Node afterNode = targetNode.getNext();

        beforeNode.setNext(afterNode);
        afterNode.setPrev(beforeNode);

        length--;

        return removedElement;
    }

    @Override
    public void replaceAtRank(int rank, Object element) throws SequenceException {
        if(length == 0){
            throw new SequenceException("Sequence is empty.");
        }
        if(rank < 0 || rank > length - 1){
            throw new SequenceException("Rank out of bounds.");
        }

        atRank(rank).setElement(element);
    }

    @Override
    public void insertAtRank(int rank, Object element) throws SequenceException {
        if(rank < 0 || rank > length){
            throw new SequenceException("Rank out of bounds.");
        }

        Node targetNode;
        if (rank == length) {
            targetNode = tail; // Insere antes da sentinela tail
        } else {
            targetNode = atRank(rank); // Insere antes do nó atual da posição
        }

        Node newNode = new Node(element);
        Node beforeNode = targetNode.getPrev();

        newNode.setPrev(beforeNode);
        newNode.setNext(targetNode);
        beforeNode.setNext(newNode);
        targetNode.setPrev(newNode);

        length++;
    }

    // *------- Métodos de Lista -------*
    @Override
    public Object first() throws SequenceException {
        if(length == 0){
            throw new SequenceException("Sequence is empty.");
        }

        return head.getNext().getElement();
    }

    @Override
    public Object last() throws SequenceException {
        if(length == 0){
            throw new SequenceException("Sequence is empty.");
        }

        return tail.getPrev().getElement();
    }

    @Override
    public Object before(int rank) throws SequenceException {
        if(length == 0){
            throw new SequenceException("Sequence is empty.");
        }
        if(rank < 0 || rank > length - 1){
            throw new SequenceException("Rank out of bounds.");
        }

        return atRank(rank).getPrev().getElement();
    }

    @Override
    public Object after(int rank) throws SequenceException {
        if(length == 0){
            throw new SequenceException("Sequence is empty.");
        }
        if(rank < 0 || rank > length - 1){
            throw new SequenceException("Rank out of bounds.");
        }

        return atRank(rank).getNext().getElement();
    }

    @Override
    public boolean isFirst(Node node) throws SequenceException {
        if(length == 0){
            throw new SequenceException("Sequence is empty.");
        }

        return node == head.getNext();
    }

    @Override
    public boolean isLast(Node node) throws SequenceException {
        if(length == 0){
            throw new SequenceException("Sequence is empty.");
        }

        return node == tail.getPrev();
    }

    @Override
    public void replaceElementAtRank(int rank, Object element) throws SequenceException {
        if(length == 0){
            throw new SequenceException("Sequence is empty.");
        }
        if(rank < 0 || rank > length - 1){
            throw new SequenceException("Rank out of bounds.");
        }

        atRank(rank).setElement(element);
    }

    @Override
    public void swapElements(int rank1, int rank2) throws SequenceException {
        if(length == 0){
            throw new SequenceException("Sequence is empty.");
        }
        if(rank1 < 0 || rank1 > length - 1){
            throw new SequenceException(String.format("%d out of bounds.", rank1));
        }
        if(rank2 < 0 || rank2 > length - 1){
            throw new SequenceException(String.format("%d out of bounds.", rank2));
        }

        Node node1 = atRank(rank1);
        Node node2 = atRank(rank2);

        Object auxElement = node1.getElement();
        node1.setElement(node2.getElement());
        node2.setElement(auxElement);
    }

    @Override
    public void insertBeforeRank(int rank, Object element) throws SequenceException {
        if(length == 0){
            throw new SequenceException("Sequence is empty.");
        }
        if(rank < 0 || rank > length - 1){
            throw new SequenceException("Rank out of bounds.");
        }

        Node targetNode = atRank(rank);
        Node newNode = new Node(element);
        Node beforeNode = targetNode.getPrev();

        newNode.setPrev(beforeNode);
        newNode.setNext(targetNode);
        beforeNode.setNext(newNode);
        targetNode.setPrev(newNode);

        length++;
    }

    @Override
    public void insertAfterRank(int rank, Object element) throws SequenceException {
        if(length == 0){
            throw new SequenceException("Sequence is empty.");
        }
        if(rank < 0 || rank > length - 1){
            throw new SequenceException("Rank out of bounds.");
        }

        Node targetNode = atRank(rank);
        Node newNode = new Node(element);
        Node afterNode = targetNode.getNext();

        newNode.setNext(afterNode);
        newNode.setPrev(targetNode);
        targetNode.setNext(newNode);
        afterNode.setPrev(newNode);

        length++;
    }

    @Override
    public void insertFirst(Object element) {
        try {
            insertAtRank(0, element);
        } catch (SequenceException e) {
            throw new IllegalStateException("Erro inesperado ao inserir no início: " + e.getMessage(), e);
        }
    }

    @Override
    public void insertLast(Object element) {
        try {
            insertAtRank(length, element);
        } catch (SequenceException e) {
            throw new IllegalStateException("Erro inesperado ao inserir no fim: " + e.getMessage(), e);
        }
    }

    @Override
    public void remove(Node node) {
        if (isEmpty() || node == head || node == tail || node == null) return;

        Node beforeNode = node.getPrev();
        Node afterNode = node.getNext();

        beforeNode.setNext(afterNode);
        afterNode.setPrev(beforeNode);

        length--;
    }

    @Override
    public Node atRank(int rank) {
        int aux = 0;
        Node targetNode = head.getNext();

        while (aux < rank) {
            targetNode = targetNode.getNext();
            aux++;
        }

        return targetNode;
    }

    @Override
    public int rankOf(Node node) {
        int aux = 0;
        Node searcher = head.getNext();

        while (aux < length) {
            if (searcher.equals(node)) {
                return aux;
            }
            searcher = searcher.getNext();
            aux++;
        }
        throw new SequenceException("Node doesn't exists in the sequence.");
    }
}
