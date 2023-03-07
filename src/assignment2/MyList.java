package assignment2;

public interface MyList<E> extends Iterable<E> {            //E stands for element
    public int getSize();
    public boolean isEmpty();
    public boolean add();
    public void clear();
    public E remove();                      // returns an element of type E

    }


