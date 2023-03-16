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
                if (i == 0 || !(direction.isEmpty())) {      //TODO second condition
                    throw new IllegalArgumentException("Invalid input.");
                } else {
                    numLeftBracket += 1;
                    this.stackString.push(direction);
                    this.stackString.push(multiplier);
                    multiplier = "";
                    direction = "";
                }
            } else if ((c == ']')) {                          //TODO what if your input is only ], popsecond wont work
                if (stackString.isEmpty()) {                    //TODO also check if direction and num are NOT empty?
                    break;
                } else {
                    numRightBracket += 1;
                    String popFirst = this.stackString.pop();
                    String popSecond = this.stackString.pop();
                    if (direction.isEmpty()) {
                        throw new IllegalArgumentException("Invalid input.");
                    } else {
                        try {
                            int popFirstInt = Integer.parseInt(popFirst);
                            direction = direction.repeat(popFirstInt);
                            direction = popSecond + direction;           //Adding the number to the final string
                        } catch (Exception e) {
                            try {
                                int popSecondInt = Integer.parseInt(popSecond);
                                direction = direction.repeat(popSecondInt);
                                direction = popFirst + direction;           //Adding the number to final string
                            } catch (Exception g) {
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



