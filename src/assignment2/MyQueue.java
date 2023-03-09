package assignment2;

public class MyQueue<E> {
    private MyDoublyLinkedList<E> DList;

    public MyQueue() {
        DList = new MyDoublyLinkedList<E>();
        DList.size = 0;
    }

    public boolean enqueue(E elmnt) {
        return DList.addLast(elmnt);
    }

    public E dequeue() {
        return DList.removeFirst();
    }

    public boolean isEmpty() {
        return DList.isEmpty();
    }

    public void clear() {
        DList.clear();
    }

    public boolean equals(Object obj) {
        return ((obj instanceof MyQueue) && (DList.equals(obj)));
    }

}


