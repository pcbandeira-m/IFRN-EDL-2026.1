package arvore.binariapesquisa;

public class Node {
    private Node parent;
    private Node leftChild;
    private Node rightChild;
    private Object key;

    public Node (Node node, Object b) {
        parent = node;
        key = b;

    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Node getParent() {
        return parent;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public Object getKey() {
        return key;
    }

    public boolean isExternal() {
        return this.isExternal();
    }
}
