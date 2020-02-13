package LinkedListTraversal;

public class Node<T> {
    public Node next;
    private T data;

    public Node getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    public Node(T data) {
        this.data = data;
    }
}
