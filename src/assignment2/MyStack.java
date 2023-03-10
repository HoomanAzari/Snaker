package assignment2;

import java.util.NoSuchElementException;

public class MyStack<E> {
    private MyDoublyLinkedList<E> DLinkedList;

    public MyStack () {
        this.DLinkedList = new MyDoublyLinkedList<E>();          //unsure about this
        this.DLinkedList.size = 0;                               //creates a stack of size 0
    }

    public boolean push (E elmnt) {
        return this.DLinkedList.addFirst(elmnt);
    }

    public E pop() {
        if (this.DLinkedList.size == 0) {
            throw new NoSuchElementException("The stack is empty.");
        }
        else {
            return this.DLinkedList.removeFirst();
        }
    }

    public E peek() {
        if (this.DLinkedList.size == 0) {
            throw new NoSuchElementException("The stack is empty");
        }
        else {
            return this.DLinkedList.peekFirst();
        }
    }

    public boolean isEmpty() {
        return this.DLinkedList.isEmpty();
    }

    public void clear () {
        this.DLinkedList.clear();
    }

    public int getSize() {
        return this.DLinkedList.getSize();
    }
}
