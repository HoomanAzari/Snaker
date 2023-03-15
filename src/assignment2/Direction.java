package assignment2;

public enum Direction {
    NORTH('N'),
    SOUTH('S'),
    WEST('W'),
    EAST('E');
    final char letter;
    Direction(char letter) {
        this.letter = letter;
    }

}
