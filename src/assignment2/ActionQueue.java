package assignment2;

public class ActionQueue extends MyQueue<Direction> {
    private MyStack<String> stackString;

    public ActionQueue () {
        this.stackString = new MyStack<>();
    }
    public void clear() {
        super.clear();
        this.stackString.clear();            //TODO reset the other fields when you make em
    }

    public void loadFromEncodedString(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Invalid input.");
        }
        String multiplier = "";
        String direction = "";
        int numLeftBracket = 0;
        int numRightBracket = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                multiplier += c;
            } else if ((c == 'E') || (c == 'W') || (c == 'S') || (c == 'N')) {
                direction += c;
            } else if ((c == '[')) {
                if (i == 0 || !(Character.isDigit(input.charAt(i-1))) || multiplier.isEmpty()) {
                    throw new IllegalArgumentException("Invalid input.");
                } else {
                    numLeftBracket += 1;
                    this.stackString.push(direction);
                    this.stackString.push(multiplier);
                    multiplier = "";
                    direction = "";
                }
            } else if (c == ']') {
                numRightBracket += 1;
                if (stackString.isEmpty()) {
                    break;
                } else {
                    String firstPop = this.stackString.pop();
                    String secondPop = this.stackString.pop();
                    if (direction.isEmpty()) {
                        throw new IllegalArgumentException("Invalid input.");
                    } else {
                        try {
                            int firstInt = Integer.parseInt(firstPop);
                            direction = direction.repeat(firstInt);
                            direction = secondPop + direction;           //Adding the number to the final string
                        } catch (Exception a) {
                            try {
                                int secondInt = Integer.parseInt(secondPop);
                                direction = direction.repeat(secondInt);
                                direction = secondPop + direction;           //Adding the number to final string
                            } catch (Exception b) {
                                throw new IllegalArgumentException("Invalid input.");
                            }
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("Invalid input.");
            }
        }
        if (numLeftBracket != numRightBracket) {
            throw new IllegalArgumentException ("Invalid input.");
        } else {
             for (int j = 0; j < direction.length(); j++) {
                 char ch = direction.charAt(j);
                 if (ch == 'N') {
                     this.enqueue(Direction.NORTH);
                 } else if (ch == 'S') {
                     this.enqueue(Direction.SOUTH);
                 } else if (ch == 'W') {
                     this.enqueue(Direction.WEST);
                 } else if (ch == 'E') {
                     this.enqueue(Direction.EAST);
                 } else {
                     throw new IllegalArgumentException("Invalid input.");
                 }
             }
             this.stackString.clear();
        }
    }
}



