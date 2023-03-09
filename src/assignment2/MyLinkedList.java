package assignment2;

public abstract class MyLinkedList<E> implements MyList<E> {                //Why abstract?

    protected int size;

    public MyLinkedList(){                          //Constructor doesn't need the <E>
        this.size = 0;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    public int getSize() {
        return this.size;
    }
}

