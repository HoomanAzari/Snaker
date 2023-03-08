package assignment2;

public interface MyList<E> extends Iterable<E> {            //E stands for element
    public int getSize();

    public boolean isEmpty();

    public boolean add(E elmnt);                // adds element e

    public void clear();

    public E remove();                      // removes the last elmnt and returns it
}




