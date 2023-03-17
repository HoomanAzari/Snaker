package assignment2;

public class Caterpillar extends MyDoublyLinkedList<Position> {

    public Caterpillar() {
        super();
        Position head = new Position(7, 7);
        add(head);
    }
    public Position getHead() {
        return peekFirst();
    }

    public void eat(Position pos) {
        if ((getHead().getDistance(pos)) != 1) {
            throw new IllegalArgumentException("Not orthogonally adjacent to the head.");
        }
        addFirst(pos);
    }

    public void move(Position pos) {
        if ((getHead().getDistance(pos)) != 1) {
            throw new IllegalArgumentException("Not orthogonally adjacent to the head.");
        }
        addFirst(pos);
        removeLast();
    }

    public boolean selfCollision(Position pos) {
        for (Position elmnt : this) {
            if (elmnt.equals(pos)) {
                return true;
            }
        }
        return false;
    }
}