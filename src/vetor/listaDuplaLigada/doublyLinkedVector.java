package vetor.listaDuplaLigada;

public class doublyLinkedVector implements vector {

    private node header, tail;
    private int size;

    public doublyLinkedVector(){
        this.size = 0;
        this.header = null;
        this.tail = null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object elemAtRank(int r) throws IndexOutOfBoundsException {
        node node = nodeAtRank(r);
        return node.getElement();
        }


    public node nodeAtRank(int r) throws IndexOutOfBoundsException {
        node node;
        if (r < 0 || r > size()) throw new IndexOutOfBoundsException("Rank inválido. Escolha outro.");

        if (size() == 1) {
            return header;
        }

        if (r <= size()/2) {
            node = header;
            for (int i = 0; i < r; i++) {
                node = node.getNext();
            }
        } else {
            node = tail;
            for (int i = 0; i < size()-r-1; i++) {
                node = node.getPrev();
            }
        }

        return node;
    }

    @Override
    public Object replaceAtRank(int r, Object o) throws IndexOutOfBoundsException, emptyVector {
        if (isEmpty()) throw new emptyVector("Vetor vazio. Nada para remover.");

        node target = nodeAtRank(r);
        Object replacedElement = target.getElement();

        target.setElement(o);
        return replacedElement;
    }

    @Override
    public Object removeAtRank(int r) throws IndexOutOfBoundsException, emptyVector {
        if (isEmpty()) throw new emptyVector("Vetor vazio. Nada para remover.");

        node target = nodeAtRank(r);
        Object removedElement = target.getElement();

        if (r == 0) {
            target.getNext().setPrev(null);
            target.setNext(null);
        } else if (r == size()-1) {
            target.getPrev().setNext(null);
            target.setPrev(null);
        } else {
            target.getPrev().setNext(target.getNext());
            target.getNext().setPrev(target.getPrev());
        }

        size--;
        return removedElement;
    }

    @Override
    public void insertAtRank(int r, Object o) throws IndexOutOfBoundsException {
        if (r < 0 || r > size()) throw new ArrayIndexOutOfBoundsException();

        node newNode = new node();
        newNode.setElement(o);

        if (size() == 0) {
            this.header = newNode;
            this.tail = newNode;
            newNode.setPrev(null);
            newNode.setNext(null);
            size++;
            return;
        }
        node target = nodeAtRank(r);
        if (r == 0) {
            newNode.setPrev(null);
            newNode.setNext(target);
            target.setPrev(newNode);
            header = newNode;
        } else if (r == size()-1) {
            newNode.setNext(null);
            newNode.setPrev(target);
            target.setNext(newNode);
            tail = newNode;
        } else {
            newNode.setPrev(target.getPrev());
            newNode.setNext(target);
            target.getPrev().setNext(newNode);
            target.setPrev(newNode);
        }

        size++;
    }

}