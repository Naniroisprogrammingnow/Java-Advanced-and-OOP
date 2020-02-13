package LinkedListTraversal;

import java.util.Iterator;
import java.util.function.Consumer;

public class CustomLinkedList<T> implements Iterable {
    private Node head;

    public void add(T data){
        if (head == null){
            this.head = new Node(data);
            return;
        }
        Node current = this.head;
        while (current.next!= null){
            current = current.getNext();
        }
        current.next = new Node(data);
    }

    public boolean remove(T data){
        if (head.getData()==data){
            head = head.next;
            return true;
        }
        Node current = this.head;
        if (current.next==null){
            return false;
        }
        while (current.next.getData()!=data){
            current = current.next;
            if (current.next == null){
                return false;
            }
        }

        current.next = current.next.next;
        return true;
    }

    public int getSize(){
        if (head==null){
            return 0;
        }
        int size = 1;
        Node current = head;
        while (current.next!=null){
            size++;
            current = current.next;
        }
        return size;
    }


    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node current = head;
            @Override
            public boolean hasNext() {
                return current!=null;
            }


            @Override
            public Object next() {
                T res = (T)current.getData();
                current = current.next;
                return res;
            }
        };
    }

    @Override
    public void forEach(Consumer action) {

    }
}
