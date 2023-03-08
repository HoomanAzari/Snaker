package assignment2;

import java.util.NoSuchElementException;

public class MyStack<E> {
    private MyDoublyLinkedList DLinkedList;

    public MyStack () {
        this.DLinkedList = new MyDoublyLinkedList<E>();          //unsure about this
        this.DLinkedList.size = 0;                               //creates a stack of size 0
    }

    public boolean push (E elmnt) {
        return this.DLinkedList.addFirst(elmnt);
    }

    public E pop() {
        if (this.DLinkedList.size == 0) {                                   //TODO ask if i can get rid of this since I call it already in DLinked
            throw new NoSuchElementException("The stack is empty.");
        }
        else {
            return (E)this.DLinkedList.removeFirst();    //TODO Ask why I have to typecast to E, when removeFirst already returns E
        }
    }

    public E peek() {
        if (this.DLinkedList.size == 0) {               //TODO can i get rid of this
            throw new NoSuchElementException("The stack is empty");
        }
        else {
            return (E)this.DLinkedList.peekFirst();
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
