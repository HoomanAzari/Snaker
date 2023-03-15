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
        String K = "";
        String D = "";
        for(int i = 0; i < input.length() - 1; i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                K += c;
            }
            else if ((c == 'N') || (c == 'S') || (c == 'W') || (c == 'E')) {                   //TODO trying to see if it's in Direction
                D = String.valueOf(c);             //is this good?
            }
            else if ((c == '[')) {
                if (!(this.stackString.isEmpty()) || !(D.isEmpty()) || !(K.isEmpty())) {
                    throw new IllegalArgumentException("Invalid input.");
                } else {
                    this.stackString.push(K);
                    this.stackString.push(D);
                }
            }
            else if ((c == ']'){

            }
        }
    }
}

