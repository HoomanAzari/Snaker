package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> extends MyLinkedList<E> {

    private DNode head;
    private DNode tail;


    public boolean add(E elmnt) {
        if (elmnt == null) {
            return false;
        }
        DNode newNode = new DNode();
        newNode.element = elmnt;

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;                       //both head and tail point at the new node
            this.size += 1;
            return true;
        }
        else if(this.size > 0) {
            DNode temp = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
            this.tail.prev = temp;
            this.size += 1;
            return true;
        }return false;
    }
    public E remove() {
        if (isEmpty()) {                                   //Edge case if list is empty
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
            E elmnt = this.tail.element;
            this.tail = this.tail.prev;
            this.tail.next.element = null;
            this.tail.next.prev = null;
            this.tail.next = null;
            this.size -= 1;
            return elmnt;
        }
    }

    public boolean addFirst(E elmnt) {
        if (elmnt.equals(null)) {
            return false;
        }
        DNode newNode = new DNode();
        newNode.element = elmnt;
        if (isEmpty()) {                //Edge case if list is empty
            this.tail = newNode;
            this.head = newNode;
            this.head.next = this.tail;
            this.tail.prev = this.head;
            this.size += 1;
            return true;
        }
        DNode temp = this.head;
        this.head.prev = newNode;
        this.head = newNode;
        this.head.next = temp;
        this.size += 1;
        return true;
    }

    public boolean addLast(E elmnt) {
        if (elmnt.equals(null)) {
            return false;
        } else {
            DNode newNode = new DNode();
            newNode.element = elmnt;

            if (isEmpty()) {
                this.head = newNode;
                this.tail = newNode;                       //both head and tail point at the new node
                this.head.next = this.tail;
                this.tail.prev = this.head;
                this.size += 1;
                return true;
            }
            else if(this.size > 0) {
                DNode temp = this.tail;
                this.tail.next = newNode;
                this.tail = newNode;
                this.tail.prev = temp;
                this.size += 1;
                return true;
            }
            return false;
        }
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty.");
        }
        else if (this.size == 1) {
            E elmnt = this.tail.element;
            this.tail.element = null;
            this.tail.prev = null;          //TODO is this needed
            this.head.next = null;          //TODO is this needed
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

    public E removeLast() {
        return remove();
    }

    public E peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty.");
        }
        else {
            return this.head.element;
        }
    }

    public E peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty.");
        }
        else {
            return this.tail.element;
        }
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        }

    public boolean equals(Object obj) {
        if ((obj == null) || !(obj instanceof MyDoublyLinkedList)) {
            return false;
        }
        MyDoublyLinkedList<E> other = (MyDoublyLinkedList<E>) obj;        //type casting
        Iterator<E> mainIterator = this.iterator();
        Iterator<E> otherIterator = other.iterator();
        if (this.size != other.size) {
            return false;
        }
        while(mainIterator.hasNext() && otherIterator.hasNext()) {
            E mainElement = mainIterator.next();                           //The next method returns an E element
            E otherElement = otherIterator.next();
            if (!(mainElement.equals(otherElement))) {                      //Check whether the two elements are the same
                return false;
            }
        }return true;
    }

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
