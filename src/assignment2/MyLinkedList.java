package assignment2;

import java.util.Iterator;

public abstract class MyLinkedList<E> implements MyList<E> {                //Why abstract?

    protected int size;

    public abstract MyLinkedList<E>(){
        this.size = 0;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    public int getSize() {
        return this.size;
    }
}

//    public int getSize() {
//        size = 0;
//        for(E element: MyLinkedList<E>) {
//
//        }
//    }
//
//    public boolean isEmpty() {
//
//    }
//    public boolean add(E elmnt) {
//
//    }
//    public void clear() {
//
//    }
//
//    public E remove(int i) {
//
//    }
//
//    @Override
//    public java.util.Iterator<E> iterator() {
//        return java.util.Iterator<E>;       //TODO Fix return type
//    }
//
//    public interface Iterator<E> {
//        boolean hasNext();
//        E next();
//
//    }
}
