package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> extends MyLinkedList<E> {

    private DNode head;
    private DNode tail;

    public boolean add(E elmnt) {                      //same add method from MyList?
        DNode newNode = new DNode();
        newNode.element = elmnt;

        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;       //both head and tail point at the new node
            this.size += 1;
            return true;
        }
        else if(this.size > 1) {
            this.tail.next = newNode;
            this.tail = this.tail.next;
            this.size += 1;
            return true;
        }
        return false;
    }
    public E remove() {
        if (this.size == 0) {                                   //Edge case if list is empty
            throw new NoSuchElementException("The list is empty.");
        }
        else if (this.size == 1) {                              //Edge case if list has one element
            E elmnt = this.tail.element;
            this.head = null;
            this.tail.element = null;
            this.tail = null;
            this.size -= 1;
            return elmnt;
        }
        else {
            E elmnt = tail.element;
            this.tail = this.tail.prev;
            this.tail.next.element = null;
            this.tail.next.prev = null;
            this.tail.next = null;
            this.size -= 1;
            return elmnt;
        }
    }

    public boolean addFirst(E elmnt) {
        DNode newNode = new DNode();
        newNode.element = elmnt;
        newNode.next = this.head;
        if (this.head == null) {                //Edge case if list is empty
            this.tail = newNode;
        }
        this.head = newNode;
        this.size += 1;
        return true;                            //TODO how to return false?
    }

    public boolean addLast(E elmnt) {
        DNode newNode = new DNode();
        newNode.element = elmnt;
        if (this.head == null) {                //Edge case if list is empty;
            this.head = newNode;
        }
        this.tail.next = newNode;
        this.tail = newNode;
        this.size += 1;
        return true;                        //TODO how to return false?
    }

    public E removeFirst() {
        if (this.size == 0) {
            throw new NoSuchElementException("The list is empty.");
        }
        else if (this.size == 1) {
            E elmnt = this.tail.element;
            this.head = null;
            this.tail.element = null;
            this.tail = null;
            this.size -= 1;
            return elmnt;
        }
        else {
            E elmnt = this.head.element;
            this.head = this.head.next;
            this.head.prev.element = null;
            this.head.prev.next = null;
            this.head.prev = null;
            this.size -= 1;
            return elmnt;
        }
    }

    public E removeLast() {         //TODO ask if removelast is the same as just remove
        return remove();
    }

    public E peekFirst() {
        if (this.size == 0) {
            throw new NoSuchElementException("The list is empty.");
        }
        else {
            return this.head.element;
        }
    }

    public E peekLast() {
        if (this.size == 0) {
            throw new NoSuchElementException("The list is empty.");
        }
        else {
            return this.tail.element;
        }
    }

    public void clear() {
        while (this.head != null) {
            removeFirst();
        }
    }
    public boolean equals(Object obj) {
        if ((!(obj instanceof MyDoublyLinkedList)) || obj == null) {
            return false;
        }
        MyDoublyLinkedList<E> other = (MyDoublyLinkedList<E>) obj;        //type casting
        Iterator<E> mainIterator = this.iterator();
        Iterator<E> otherIterator = other.iterator();
        while(mainIterator.hasNext() && otherIterator.hasNext()) {
            E mainElement = mainIterator.next();                           //The next method returns an E element
            E otherElement = otherIterator.next();
            if (mainElement != otherElement) {                      //Check whether the two elements are the same
                return false;
            }
        } return true;
    }
    /*
     * ADD YOUR CODE HERE
     */

    private class DNode {
        private E element;
        private DNode next;
        private DNode prev;
    }

    public Iterator<E> iterator() {
        return new DLLIterator();
    }

    private class DLLIterator implements Iterator<E> {
        DNode curr;

        public DLLIterator() {
            this.curr = head;
        }

        public boolean hasNext() {
            return this.curr != null;
        }

        public E next() {
            if (!this.hasNext())
                throw new NoSuchElementException();

            E element = this.curr.element;
            this.curr = this.curr.next;
            return element;
        }
    }
}
