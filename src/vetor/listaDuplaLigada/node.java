package vetor.listaDuplaLigada;

public class node {
    private Object element;
    private node prev, next;

    public Object getElement() {
        return this.element;
    }

    public node getNext() {
        return this.next;
    }

    public node getPrev() {
        return this.prev;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public void setNext(node next) {
        this.next = next;
    }

    public void setPrev(node prev) {
        this.prev = prev;
    }

}
